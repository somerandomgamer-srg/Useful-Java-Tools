package ujt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for reading, writing, and parsing CSV data.
 * @version 1.0.0
 * @see <a href="https://en.wikipedia.org/wiki/Comma-separated_values">CSV</a>
 */
public class Csv {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
	 * Reads a CSV file and returns its rows as a list of string arrays.
	 * Handles quoted fields containing commas and newlines.
	 * @param path The path to the CSV file.
	 * @return A list of rows, each row being an array of field values.
	 * @throws RuntimeException If the file cannot be read.
	 */
	public static List<String[]> read(String path) {
		return read(path, ',');
	}

	/**
	 * Reads a CSV file with a custom delimiter and returns its rows as a list of string arrays.
	 * @param path The path to the CSV file.
	 * @param delimiter The character used to separate fields.
	 * @return A list of rows, each row being an array of field values.
	 * @throws RuntimeException If the file cannot be read.
	 */
	public static List<String[]> read(String path, char delimiter) {
		try {
			String content = Files.readString(Paths.get(path));
			List<String[]> rows = new ArrayList<>();
			List<String> lines = splitRespectingQuotes(content, '\n');
			for (String line : lines) {
				if (!line.isEmpty()) {
					rows.add(parseLine(line, delimiter));
				}
			}
			return rows;
		} catch (IOException e) {
			throw new RuntimeException("Could not read CSV file: " + path, e);
		}
	}

	/**
	 * Writes a list of rows to a CSV file, overwriting any existing content.
	 * @param path The path to the CSV file.
	 * @param data The rows to write.
	 * @throws RuntimeException If the file cannot be written.
	 */
	public static void write(String path, List<String[]> data) {
		write(path, data, ',');
	}

	/**
	 * Writes a list of rows to a CSV file with a custom delimiter, overwriting any existing content.
	 * @param path The path to the CSV file.
	 * @param data The rows to write.
	 * @param delimiter The character used to separate fields.
	 * @throws RuntimeException If the file cannot be written.
	 */
	public static void write(String path, List<String[]> data, char delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String[] row : data) {
			sb.append(formatLine(row, delimiter)).append("\n");
		}
		try {
			Files.writeString(Paths.get(path), sb.toString(),
				StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("Could not write CSV file: " + path, e);
		}
	}

	/**
	 * Parses a single CSV line into an array of field values using a comma delimiter.
	 * Handles quoted fields that may contain commas.
	 * @param line The CSV line to parse.
	 * @return An array of field values.
	 */
	public static String[] parseLine(String line) {
		return parseLine(line, ',');
	}

	/**
	 * Parses a single CSV line into an array of field values using a custom delimiter.
	 * @param line The CSV line to parse.
	 * @param delimiter The character used to separate fields.
	 * @return An array of field values.
	 */
	public static String[] parseLine(String line, char delimiter) {
		List<String> fields = new ArrayList<>();
		StringBuilder current = new StringBuilder();
		boolean inQuotes = false;

		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);

			if (c == '"') {
				if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
					current.append('"');
					i++;
				} else {
					inQuotes = !inQuotes;
				}
			} else if (c == delimiter && !inQuotes) {
				fields.add(current.toString());
				current.setLength(0);
			} else {
				current.append(c);
			}
		}

		fields.add(current.toString());
		return fields.toArray(new String[0]);
	}

	/**
	 * Formats an array of field values into a single CSV line using a comma delimiter.
	 * Fields containing commas, quotes, or newlines are automatically quoted.
	 * @param fields The field values to format.
	 * @return The formatted CSV line.
	 */
	public static String formatLine(String[] fields) {
		return formatLine(fields, ',');
	}

	/**
	 * Formats an array of field values into a single CSV line using a custom delimiter.
	 * Fields containing the delimiter, quotes, or newlines are automatically quoted.
	 * @param fields The field values to format.
	 * @param delimiter The character used to separate fields.
	 * @return The formatted CSV line.
	 */
	public static String formatLine(String[] fields, char delimiter) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			if (i > 0) {
				sb.append(delimiter);
			}
			String f = fields[i];
			boolean needsQuotes = f.contains(String.valueOf(delimiter)) || f.contains("\"") || f.contains("\n") || f.contains("\r");
			if (needsQuotes) {
				sb.append('"').append(f.replace("\"", "\"\"")).append('"');
			} else {
				sb.append(f);
			}
		}
		return sb.toString();
	}

	private static List<String> splitRespectingQuotes(String content, char separator) {
		List<String> lines = new ArrayList<>();
		StringBuilder current = new StringBuilder();
		boolean inQuotes = false;

		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			if (c == '"') {
				inQuotes = !inQuotes;
				current.append(c);
			} else if (c == separator && !inQuotes) {
				lines.add(current.toString().stripTrailing());
				current.setLength(0);
			} else if (c != '\r') {
				current.append(c);
			}
		}

		if (current.length() > 0) {
			lines.add(current.toString().stripTrailing());
		}
		return lines;
	}
}
