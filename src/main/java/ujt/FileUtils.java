package ujt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

/**
 * Provides methods for file and directory operations.
 * @version 1.0.0
 * @see <a href="https://en.wikipedia.org/wiki/File_(computing)">File</a>
 * @see <a href="https://en.wikipedia.org/wiki/Path_(computing)">Path</a>
 * @see <a href="https://en.wikipedia.org/wiki/File_extension">File extension</a>
 * @see <a href="https://en.wikipedia.org/wiki/Write_(computing)">Write</a>
 * @see <a href="https://en.wikipedia.org/wiki/Append_(computing)">Append</a>
 * @see <a href="https://en.wikipedia.org/wiki/Directory_(computing)">Directory</a>
 * @see <a href="https://en.wikipedia.org/wiki/File_system">File system</a>
 */
public class FileUtils {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
	 * @param path The path to the file.
	 * @param content The content to write to the file.
	 * @return Whether or not the file was created.
	 */
	public static boolean createFile(String path, String content) {
		try {
			Path filePath = Paths.get(path);
			Path parent = filePath.getParent();
			if (parent != null) {
				Files.createDirectories(parent);
			}
			Files.write(filePath, content.getBytes());
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while creating the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * @param path The path to the file.
	 * @return Whether or not the file was created.
	 */
	public static boolean createFile(String path) {
		return createFile(path, "");
	}

	/**
	 * @param path The path to the file.
	 * @return Whether or not the file was deleted.
	 */
	public static boolean deleteFile(String path) {
		File f = new File(path);
		if (f.exists()) {
			try {
				return f.delete();
			} catch (Exception e) {
				System.err.println("An error occurred while deleting the file: " + e.getMessage());
				return false;
			}
		} else {
			System.err.println("File does not exist at: " + path);
			return false;
		}
	}

	/**
	 * @param path The path to the file.
	 * @return Whether or not the file exists.
	 */
	public static boolean fileExists(String path) {
		return Files.exists(Paths.get(path));
	}

	/**
	 * Reads the entire contents of a file into a single string.
	 * @param path The path to the file.
	 * @return The content of the file, or {@code null} if an error occurred.
	 */
	public static String readFile(String path) {
		try {
			return Files.readString(Paths.get(path));
		} catch (IOException e) {
			System.err.println("An error occurred while reading the file: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Reads a file line by line and returns the lines as a list of strings.
	 * @param path The path to the file.
	 * @return A {@link List} of lines from the file, or {@code null} if an error occurred.
	 */
	public static List<String> readLines(String path) {
		try {
			return Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			System.err.println("An error occurred while reading the file: " + e.getMessage());
			return null;
		}
	}

	/**
	 * @param path The path to the file.
	 * @param content The content to write to the file.
	 * @return Whether or not the file was written to.
	 * @see <a href="https://en.wikipedia.org/wiki/Write_(computing)">Write</a>
	 */
	public static boolean writeFile(String path, String content) {
		try {
			Files.writeString(Paths.get(path), content,
				StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while writing to the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * @param path The path to the file.
	 * @param content The content to append to the file.
	 * @return Whether or not the file was appended to.
	 * @see <a href="https://en.wikipedia.org/wiki/Append_(computing)">Append</a>
	 */
	public static boolean appendFile(String path, String content) {
		try {
			Files.writeString(Paths.get(path), content,
				StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while appending to the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * @param oldPath The path to the file to rename.
	 * @param newPath The new path to the file.
	 * @return Whether or not the file was renamed.
	 */
	public static boolean renameFile(String oldPath, String newPath) {
		try {
			Files.move(Paths.get(oldPath), Paths.get(newPath), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while renaming the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * @param sourcePath The path to the file to copy.
	 * @param destinationPath The path to the destination file.
	 * @return Whether or not the file was copied.
	 */
	public static boolean copyFile(String sourcePath, String destinationPath) {
		try {
			Files.copy(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while copying the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Moves a file from one path to another atomically, overwriting the destination if it exists.
	 * @param sourcePath The path to the file to move.
	 * @param destinationPath The path to the destination file.
	 * @return Whether or not the file was moved.
	 */
	public static boolean moveFile(String sourcePath, String destinationPath) {
		try {
			Files.move(Paths.get(sourcePath), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while moving the file: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Creates a single directory. The parent directory must already exist.
	 * @param path The path of the directory to create.
	 * @return Whether or not the directory was created.
	 * @see <a href="https://en.wikipedia.org/wiki/Directory_(computing)">Directory</a>
	 */
	public static boolean createDirectory(String path) {
		try {
			Path p = Paths.get(path);
			if (Files.exists(p)) return false;
			Files.createDirectory(p);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while creating the directory: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Creates a directory and any missing parent directories along the path.
	 * @param path The path of the directory to create.
	 * @return Whether or not the directory was created.
	 * @see <a href="https://en.wikipedia.org/wiki/Directory_(computing)">Directory</a>
	 */
	public static boolean createDirectories(String path) {
		try {
			Path p = Paths.get(path);
			if (Files.exists(p)) return false;
			Files.createDirectories(p);
			return true;
		} catch (IOException e) {
			System.err.println("An error occurred while creating the directories: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Lists all files and subdirectories directly inside a directory (non-recursive).
	 * @param path The path to the directory.
	 * @return An array of path strings for each entry, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/Directory_(computing)">Directory</a>
	 */
	public static String[] listFiles(String path) {
		try (Stream<Path> stream = Files.list(Paths.get(path))) {
			return stream.map(Path::toString).toArray(String[]::new);
		} catch (IOException e) {
			System.err.println("An error occurred while listing files: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Lists all files directly inside a directory that match a given file extension (non-recursive).
	 * @param path The path to the directory.
	 * @param extension The file extension to filter by (e.g. {@code ".txt"}, {@code ".java"}).
	 * @return An array of matching path strings, or {@code null} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/File_extension">File extension</a>
	 */
	public static String[] listFiles(String path, String extension) {
		try (Stream<Path> stream = Files.list(Paths.get(path))) {
			return stream
				.filter(p -> p.toString().endsWith(extension))
				.map(Path::toString)
				.toArray(String[]::new);
		} catch (IOException e) {
			System.err.println("An error occurred while listing files: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Returns the size of a file in bytes.
	 * @param path The path to the file.
	 * @return The size of the file in bytes, or {@code -1} if an error occurred.
	 * @see <a href="https://en.wikipedia.org/wiki/File_size">File size</a>
	 */
	public static long fileSize(String path) {
		try {
			return Files.size(Paths.get(path));
		} catch (IOException e) {
			System.err.println("An error occurred while getting the file size: " + e.getMessage());
			return -1;
		}
	}

	/**
	 * Checks whether the given path points to a directory.
	 * @param path The path to check.
	 * @return {@code true} if the path is a directory.
	 * @see <a href="https://en.wikipedia.org/wiki/Directory_(computing)">Directory</a>
	 */
	public static boolean isDirectory(String path) {
		return Files.isDirectory(Paths.get(path));
	}

	/**
	 * Checks whether the given path points to a regular file.
	 * @param path The path to check.
	 * @return {@code true} if the path is a regular file.
	 */
	public static boolean isFile(String path) {
		return Files.isRegularFile(Paths.get(path));
	}

	/**
	 * Checks whether a directory is empty (contains no files or subdirectories).
	 * @param path The path to the directory.
	 * @return {@code true} if the directory exists and is empty, {@code false} otherwise.
	 */
	public static boolean isDirectoryEmpty(String path) {
		try (Stream<Path> stream = Files.list(Paths.get(path))) {
			return stream.findFirst().isEmpty();
		} catch (IOException e) {
			System.err.println("An error occurred while checking if directory is empty: " + e.getMessage());
			return false;
		}
	}

	/**
	 * @param path The path to the file.
	 * @return The extension of the file including the dot (e.g. {@code ".txt"}), or {@code ""} if there is none.
	 * @see <a href="https://en.wikipedia.org/wiki/File_extension">File extension</a>
	 */
	public static String getFileExtension(String path) {
		String name = Paths.get(path).getFileName().toString();
		int lastIndex = name.lastIndexOf('.');
		return lastIndex >= 0 ? name.substring(lastIndex) : "";
	}

	/**
	 * @param path The path to the file.
	 * @return The full filename including its extension.
	 */
	public static String getFileName(String path) {
		return Paths.get(path).getFileName().toString();
	}

	/**
	 * @param path The path to the file.
	 * @return The filename without its extension.
	 */
	public static String getFileNameWithoutExtension(String path) {
		String name = Paths.get(path).getFileName().toString();
		int lastIndex = name.lastIndexOf('.');
		return lastIndex >= 0 ? name.substring(0, lastIndex) : name;
	}
}
