package ujt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Provides methods for compressing and decompressing data using ZIP, GZIP and DEFLATE.
 * @version 1.0.0
 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
 * @see <a href="https://en.wikipedia.org/wiki/Gzip">gzip</a>
 * @see <a href="https://en.wikipedia.org/wiki/Deflate">DEFLATE</a>
 */
public class ZipUtils {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	private static final int bufferSize = 8192;

	/**
	 * Compresses a single file into a new ZIP archive.
	 * @param sourceFile The path to the file to compress.
	 * @param zipPath The path of the ZIP archive to create.
	 * @return Whether or not the archive was created successfully.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static boolean zipFile(String sourceFile, String zipPath) {
		Path src = Paths.get(sourceFile);
		if (!Files.isRegularFile(src)) {
			System.err.println("Source is not a regular file: " + sourceFile);
			return false;
		}
		try (
			FileOutputStream fos = new FileOutputStream(zipPath);
			ZipOutputStream zos = new ZipOutputStream(fos)
		) {
			writeFileToZip(src, src.getFileName().toString(), zos);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while creating the ZIP archive: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Compresses a directory (recursively) into a new ZIP archive.
	 * Entry names are stored relative to the source directory.
	 * @param sourceDirectory The path to the directory to compress.
	 * @param zipPath The path of the ZIP archive to create.
	 * @return Whether or not the archive was created successfully.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static boolean zipDirectory(String sourceDirectory, String zipPath) {
		Path root = Paths.get(sourceDirectory);
		if (!Files.isDirectory(root)) {
			System.err.println("Source is not a directory: " + sourceDirectory);
			return false;
		}
		try (
			FileOutputStream fos = new FileOutputStream(zipPath);
			ZipOutputStream zos = new ZipOutputStream(fos);
			Stream<Path> walk = Files.walk(root)
		) {
			List<Path> entries = walk.filter(p -> !p.equals(root)).toList();
			for (Path p : entries) {
				String name = root.relativize(p).toString().replace('\\', '/');
				if (Files.isDirectory(p)) {
					if (!name.endsWith("/")) {
						name += "/";
					}
					zos.putNextEntry(new ZipEntry(name));
					zos.closeEntry();
				} else {
					writeFileToZip(p, name, zos);
				}
			}
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while zipping the directory: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Compresses a list of files into a new ZIP archive. Each file is stored at the root of the archive
	 * using its filename as the entry name.
	 * @param sourceFiles The paths of the files to compress.
	 * @param zipPath The path of the ZIP archive to create.
	 * @return Whether or not the archive was created successfully.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static boolean zipFiles(String[] sourceFiles, String zipPath) {
		try (
			FileOutputStream fos = new FileOutputStream(zipPath);
			ZipOutputStream zos = new ZipOutputStream(fos)
		) {
			for (String s : sourceFiles) {
				Path p = Paths.get(s);
				if (!Files.isRegularFile(p)) {
					System.err.println("Skipping non-regular file: " + s);
					continue;
				}
				writeFileToZip(p, p.getFileName().toString(), zos);
			}
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while creating the ZIP archive: " + e.getMessage());
			return false;
		}
	}

	private static void writeFileToZip(Path file, String entryName, ZipOutputStream zos) throws IOException {
		zos.putNextEntry(new ZipEntry(entryName));
		try (InputStream in = new FileInputStream(file.toFile())) {
			copy(in, zos);
		}
		zos.closeEntry();
	}

	/**
	 * Extracts a ZIP archive into the given destination directory.
	 * The destination directory is created if it does not already exist.
	 * Entries that would escape the destination (Zip Slip) are rejected.
	 * @param zipPath The path to the ZIP archive.
	 * @param destinationDirectory The directory to extract the archive into.
	 * @return Whether or not the archive was extracted successfully.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static boolean unzip(String zipPath, String destinationDirectory) {
		Path destDir = Paths.get(destinationDirectory).toAbsolutePath().normalize();
		try {
			Files.createDirectories(destDir);
			try (FileInputStream fis = new FileInputStream(zipPath); ZipInputStream zis = new ZipInputStream(fis)) {
				ZipEntry entry;
				while ((entry = zis.getNextEntry()) != null) {
					Path resolved = destDir.resolve(entry.getName()).normalize();
					if (!resolved.startsWith(destDir)) {
						throw new IOException("Entry is outside of the destination directory: " + entry.getName());
					}
					if (entry.isDirectory()) {
						Files.createDirectories(resolved);
					} else {
						Path parent = resolved.getParent();
						if (parent != null) {
							Files.createDirectories(parent);
						}
						try (OutputStream out = new FileOutputStream(resolved.toFile())) {
							copy(zis, out);
						}
					}
					zis.closeEntry();
				}
			}
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while extracting the ZIP archive: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Lists the names of every entry in a ZIP archive.
	 * @param zipPath The path to the ZIP archive.
	 * @return An array of entry names, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static String[] listEntries(String zipPath) {
		try (ZipFile zf = new ZipFile(zipPath)) {
			List<String> names = new ArrayList<>();
			Enumeration<? extends ZipEntry> entries = zf.entries();
			while (entries.hasMoreElements()) {
				names.add(entries.nextElement().getName());
			}
			return names.toArray(new String[0]);
		} catch (IOException e) {
			System.err.println("An error occurred while listing ZIP entries: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Returns the number of entries in a ZIP archive.
	 * @param zipPath The path to the ZIP archive.
	 * @return The number of entries, or {@code -1} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static int entryCount(String zipPath) {
		try (ZipFile zf = new ZipFile(zipPath)) {
			return zf.size();
		} catch (IOException e) {
			System.err.println("An error occurred while counting ZIP entries: " + e.getMessage());
			return -1;
		}
	}

	/**
	 * Checks whether a ZIP archive contains an entry with the given name.
	 * @param zipPath The path to the ZIP archive.
	 * @param entryName The entry name to look for.
	 * @return {@code true} if the entry is present.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static boolean containsEntry(String zipPath, String entryName) {
		try (ZipFile zf = new ZipFile(zipPath)) {
			return zf.getEntry(entryName) != null;
		} catch (IOException e) {
			System.err.println("An error occurred while reading the ZIP archive: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Reads a single entry from a ZIP archive into a byte array.
	 * @param zipPath The path to the ZIP archive.
	 * @param entryName The name of the entry to read.
	 * @return The raw bytes of the entry, or {@code null} if the entry was not found or an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static byte[] readEntry(String zipPath, String entryName) {
		try (ZipFile zf = new ZipFile(zipPath)) {
			ZipEntry entry = zf.getEntry(entryName);
			if (entry == null) {
				System.err.println("Entry not found in ZIP archive: " + entryName);
				return null;
			}
			try (InputStream in = zf.getInputStream(entry); ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
				copy(in, baos);
				return baos.toByteArray();
			}
		} catch (IOException e) {
			System.err.println("An error occurred while reading the ZIP entry: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Reads a single entry from a ZIP archive and decodes it as a UTF-8 string.
	 * @param zipPath The path to the ZIP archive.
	 * @param entryName The name of the entry to read.
	 * @return The entry contents as a string, or {@code null} if the entry was not found or an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static String readEntryAsString(String zipPath, String entryName) {
		byte[] bytes = readEntry(zipPath, entryName);
		return bytes == null ? null : new String(bytes, StandardCharsets.UTF_8);
	}

	/**
	 * Compresses a byte array using GZIP.
	 * @param data The data to compress.
	 * @return The GZIP-compressed bytes, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/Gzip">gzip</a>
	 */
	public static byte[] gzip(byte[] data) {
		try (
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gz = new GZIPOutputStream(baos)
		) {
			gz.write(data);
			gz.finish();
			return baos.toByteArray();
		} catch (IOException e) {
			System.err.println("An error occurred while gzipping the data: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Compresses a UTF-8 string using GZIP.
	 * @param str The string to compress.
	 * @return The GZIP-compressed bytes, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/Gzip">gzip</a>
	 */
	public static byte[] gzip(String str) {
		return gzip(str.getBytes(StandardCharsets.UTF_8));
	}

	/**
	 * Decompresses a GZIP-compressed byte array.
	 * @param data The GZIP-compressed bytes.
	 * @return The decompressed bytes, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/Gzip">gzip</a>
	 */
	public static byte[] gunzip(byte[] data) {
		try (
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			GZIPInputStream gz = new GZIPInputStream(bais);
			ByteArrayOutputStream baos = new ByteArrayOutputStream()
		) {
			copy(gz, baos);
			return baos.toByteArray();
		} catch (IOException e) {
			System.err.println("An error occurred while gunzipping the data: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Decompresses GZIP-compressed bytes and decodes the result as a UTF-8 string.
	 * @param data The GZIP-compressed bytes.
	 * @return The decompressed string, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/Gzip">gzip</a>
	 */
	public static String gunzipToString(byte[] data) {
		byte[] out = gunzip(data);
		return out == null ? null : new String(out, StandardCharsets.UTF_8);
	}

	/**
	 * Compresses an entire file using GZIP, writing the output to a new {@code .gz} file.
	 * @param sourceFile The path of the file to compress.
	 * @param destinationFile The path of the {@code .gz} file to create.
	 * @return Whether or not the file was compressed successfully.
	 * @see <a href="https://en.wikipedia.org/wiki/Gzip">gzip</a>
	 */
	public static boolean gzipFile(String sourceFile, String destinationFile) {
		try (
			FileInputStream fis = new FileInputStream(sourceFile);
			FileOutputStream fos = new FileOutputStream(destinationFile);
			GZIPOutputStream gz = new GZIPOutputStream(fos)
		) {
			copy(fis, gz);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while gzipping the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Decompresses a GZIP-compressed file, writing the output to a plain file.
	 * @param sourceFile The path of the {@code .gz} file to decompress.
	 * @param destinationFile The path of the file to write the decompressed data to.
	 * @return Whether or not the file was decompressed successfully.
	 * @see <a href="https://en.wikipedia.org/wiki/Gzip">gzip</a>
	 */
	public static boolean gunzipFile(String sourceFile, String destinationFile) {
		try (
			FileInputStream fis = new FileInputStream(sourceFile);
		  GZIPInputStream gz = new GZIPInputStream(fis);
		  FileOutputStream fos = new FileOutputStream(destinationFile)
		) {
			copy(gz, fos);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while gunzipping the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Compresses a byte array using raw DEFLATE.
	 * @param data The data to compress.
	 * @return The DEFLATE-compressed bytes, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/Deflate">DEFLATE</a>
	 */
	public static byte[] deflate(byte[] data) {
		try (
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  DeflaterOutputStream dos = new DeflaterOutputStream(baos, new Deflater(Deflater.DEFAULT_COMPRESSION, false))
		) {
			dos.write(data);
			dos.finish();
			return baos.toByteArray();
		} catch (IOException e) {
			System.err.println("An error occurred while deflating the data: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Decompresses a DEFLATE-compressed byte array.
	 * @param data The DEFLATE-compressed bytes.
	 * @return The decompressed bytes, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/Deflate">DEFLATE</a>
	 */
	public static byte[] inflate(byte[] data) {
		try (
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
		  InflaterInputStream iis = new InflaterInputStream(bais, new Inflater(false));
		  ByteArrayOutputStream baos = new ByteArrayOutputStream()
		) {
			copy(iis, baos);
			return baos.toByteArray();
		} catch (IOException e) {
			System.err.println("An error occurred while inflating the data: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Checks whether a file is a valid ZIP archive by attempting to open it.
	 * @param zipPath The path to the file to check.
	 * @return {@code true} if the file is a readable ZIP archive.
	 * @see <a href="https://en.wikipedia.org/wiki/ZIP_(file_format)">ZIP</a>
	 */
	public static boolean isValidZip(String zipPath) {
		try (ZipFile zf = new ZipFile(zipPath)) {
			return zf.size() >= 0;
		} catch (IOException e) {
			return false;
		}
	}

	private static void copy(InputStream in, OutputStream out) throws IOException {
		byte[] buf = new byte[bufferSize];
		int n;
		while ((n = in.read(buf)) != -1) {
			out.write(buf, 0, n);
		}
	}
}