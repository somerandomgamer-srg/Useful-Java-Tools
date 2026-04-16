package UsefulJavaTools;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
	* Provides methods for serializing Java objects to JSON strings and parsing JSON strings
	* back into Java objects. No external dependencies — built entirely on the Java standard library.
	* Parsed objects are returned as {@link Map}, {@link List}, {@link String}, {@link Double},
	* {@link Long}, {@link Boolean}, or {@code null}.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/JSON">JSON</a>
*/
public class Json {
	static {
		Ujt.checkJavaVersion();
	}

	private static String escapeString(String s) {
		return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\b", "\\b").replace("\f", "\\f").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
	}

	private static String prettyPrint(Object value, int depth) {
		String indent = "		".repeat(depth);
		String innerIndent = "		".repeat(depth + 1);

		if (value == null) {
			return "null";
		}
		if (value instanceof Boolean) {
			return value.toString();
		}
		if (value instanceof Number) {
			return value.toString();
		}
		if (value instanceof String) {
			return "\"" + escapeString((String) value) + "\"";
		}
		if (value instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) value;
			if (map.isEmpty()) {
				return "{}";
			}
			StringBuilder sb = new StringBuilder("{\n");
			boolean first = true;
			for (Map.Entry<?, ?> entry : map.entrySet()) {
				if (!first) {
					sb.append(",\n");
				}
				sb.append(innerIndent)
					.append("\"").append(escapeString(entry.getKey().toString())).append("\": ")
					.append(prettyPrint(entry.getValue(), depth + 1));
				first = false;
			}
			return sb.append("\n").append(indent).append("}").toString();
		}
		if (value instanceof List) {
			List<?> list = (List<?>) value;
			if (list.isEmpty()) {
				return "[]";
			}
			StringBuilder sb = new StringBuilder("[\n");
			for (int i = 0; i < list.size(); i++) {
				if (i > 0) {
					sb.append(",\n");
				}
				sb.append(innerIndent).append(prettyPrint(list.get(i), depth + 1));
			}
			return sb.append("\n").append(indent).append("]").toString();
		}
		if (value instanceof Object[]) {
			Object[] arr = (Object[]) value;
			if (arr.length == 0) {
				return "[]";
			}
			StringBuilder sb = new StringBuilder("[\n");
			for (int i = 0; i < arr.length; i++) {
				if (i > 0) {
					sb.append(",\n");
				}
				sb.append(innerIndent).append(prettyPrint(arr[i], depth + 1));
			}
			return sb.append("\n").append(indent).append("]").toString();
		}
		return "\"" + escapeString(value.toString()) + "\"";
	}

	private static class Parser {
		private final String src;
		private int pos;

		Parser(String src) {
			this.src = src;
			this.pos = 0;
		}

		Object parseValue() {
			skipWhitespace();
			if (pos >= src.length()) {
				throw error("Unexpected end of input");
			}
			char c = src.charAt(pos);
			if (c == '{') {
				return parseObject();
			}
			if (c == '[') {
				return parseArray();
			}
			if (c == '"') {
				return parseString();
			}
			if (c == 't' || c == 'f') {
				return parseBoolean();
			}
			if (c == 'n') {
				return parseNull();
			}
			if (c == '-' || Character.isDigit(c)) {
				return parseNumber();
			}
			throw error("Unexpected character: " + c);
		}

		Map<String, Object> parseObject() {
			Map<String, Object> map = new LinkedHashMap<>();
			expect('{');
			skipWhitespace();
			if (peek() == '}') {
				pos++;
				return map;
			}
			while (true) {
				skipWhitespace();
				String key = parseString();
				skipWhitespace();
				expect(':');
				skipWhitespace();
				Object val = parseValue();
				map.put(key, val);
				skipWhitespace();
				if (peek() == '}') {
					pos++;
					break;
				}
				expect(',');
			}
			return map;
		}

		List<Object> parseArray() {
			List<Object> list = new ArrayList<>();
			expect('[');
			skipWhitespace();
			if (peek() == ']') {
				pos++;
				return list;
			}
			while (true) {
				skipWhitespace();
				list.add(parseValue());
				skipWhitespace();
				if (peek() == ']') {
					pos++;
					break;
				}
				expect(',');
			}
			return list;
		}

		String parseString() {
			expect('"');
			StringBuilder sb = new StringBuilder();
			while (pos < src.length()) {
				char c = src.charAt(pos++);
				if (c == '"') {
					return sb.toString();
				}
				if (c == '\\') {
					char esc = src.charAt(pos++);
					switch (esc) {
						case '"':  sb.append('"');  break;
						case '\\': sb.append('\\'); break;
						case '/':  sb.append('/');  break;
						case 'b':  sb.append('\b'); break;
						case 'f':  sb.append('\f'); break;
						case 'n':  sb.append('\n'); break;
						case 'r':  sb.append('\r'); break;
						case 't':  sb.append('\t'); break;
						case 'u':
							String hex = src.substring(pos, pos + 4);
							sb.append((char) Integer.parseInt(hex, 16));
							pos += 4;
							break;
						default:
							throw error("Invalid escape: \\" + esc);
					}
				} else {
					sb.append(c);
				}
			}
			throw error("Unterminated string");
		}

		Number parseNumber() {
			int start = pos;
			if (peek() == '-') {
				pos++;
			}
			while (pos < src.length() && Character.isDigit(src.charAt(pos))) {
				pos++;
			}
			boolean isDecimal = false;
			if (pos < src.length() && src.charAt(pos) == '.') {
				isDecimal = true;
				pos++;
				while (pos < src.length() && Character.isDigit(src.charAt(pos))) {
					pos++;
				}
			}
			if (pos < src.length() && (src.charAt(pos) == 'e' || src.charAt(pos) == 'E')) {
				isDecimal = true;
				pos++;
				if (pos < src.length() && (src.charAt(pos) == '+' || src.charAt(pos) == '-')) {
					pos++;
				}
				while (pos < src.length() && Character.isDigit(src.charAt(pos))) {
					pos++;
				}
			}
			String numStr = src.substring(start, pos);
			return isDecimal ? Double.parseDouble(numStr) : Long.parseLong(numStr);
		}

		Boolean parseBoolean() {
			if (src.startsWith("true", pos)) {
				pos += 4;
				return true;
			}
			if (src.startsWith("false", pos)) {
				pos += 5;
				return false;
			}
			throw error("Invalid boolean");
		}

		Object parseNull() {
			if (src.startsWith("null", pos)) {
				pos += 4;
				return null;
			}
			throw error("Invalid literal");
		}

		void skipWhitespace() {
			while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) {
				pos++;
			}
		}

		void expect(char c) {
			if (pos >= src.length() || src.charAt(pos) != c) {
				throw error("Expected '" + c + "'");
			}
			pos++;
		}

		char peek() {
			return pos < src.length() ? src.charAt(pos) : 0;
		}

		IllegalArgumentException error(String msg) {
			return new IllegalArgumentException(msg + " (at position " + pos + ")");
		}
	}

	/**
		* Serializes a Java object to a compact JSON string.
		* Supports {@link String}, {@link Number}, {@link Boolean}, {@code null},
		* {@link Map}, {@link List}, and arrays.
		* @param value The value to serialize.
		* @return The JSON string.
	*/
	public static String toJson(Object value) {
		if (value == null) {
			return "null";
		}
		if (value instanceof Boolean) {
			return value.toString();
		}
		if (value instanceof Number) {
			return value.toString();
		}
		if (value instanceof String) {
			return "\"" + escapeString((String) value) + "\"";
		}
		if (value instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) value;
			StringBuilder sb = new StringBuilder("{");
			boolean first = true;
			for (Map.Entry<?, ?> entry : map.entrySet()) {
				if (!first) {
					sb.append(",");
				}
				sb.append("\"").append(escapeString(entry.getKey().toString())).append("\":");
				sb.append(toJson(entry.getValue()));
				first = false;
			}
			return sb.append("}").toString();
		}
		if (value instanceof List) {
			List<?> list = (List<?>) value;
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < list.size(); i++) {
				if (i > 0) {
					sb.append(",");
				}
				sb.append(toJson(list.get(i)));
			}
			return sb.append("]").toString();
		}
		if (value instanceof Object[]) {
			Object[] arr = (Object[]) value;
			StringBuilder sb = new StringBuilder("[");
			for (int i = 0; i < arr.length; i++) {
				if (i > 0) {
					sb.append(",");
				}
				sb.append(toJson(arr[i]));
			}
			return sb.append("]").toString();
		}
		return "\"" + escapeString(value.toString()) + "\"";
	}

	/**
		* Serializes a Java object to a pretty-printed (indented) JSON string.
		* @param value The value to serialize.
		* @return The indented JSON string.
	*/
	public static String toPrettyJson(Object value) {
		return prettyPrint(value, 0);
	}

	/**
		* Parses a JSON string into a Java object.
		* Returns a {@link Map} for objects, {@link List} for arrays,
		* {@link String}, {@link Long}, {@link Double}, {@link Boolean}, or {@code null}.
		* @param jsonString The JSON string to parse.
		* @return The parsed Java object.
		* @throws IllegalArgumentException If the JSON is invalid.
	*/
	public static Object parse(String jsonString) {
		Parser p = new Parser(jsonString.strip());
		Object result = p.parseValue();
		p.skipWhitespace();
		if (p.pos < p.src.length()) {
			throw new IllegalArgumentException("Unexpected trailing content at position " + p.pos);
		}
		return result;
	}

	/**
		* Parses a JSON object string into a {@link Map}.
		* @param jsonString The JSON object string.
		* @return The parsed map.
		* @throws IllegalArgumentException If the string is not a valid JSON object.
	*/
	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseObject(String jsonString) {
		Object result = parse(jsonString);
		if (!(result instanceof Map)) {
			throw new IllegalArgumentException("JSON is not an object: " + jsonString);
		}
		return (Map<String, Object>) result;
	}

	/**
		* Parses a JSON array string into a {@link List}.
		* @param jsonString The JSON array string.
		* @return The parsed list.
		* @throws IllegalArgumentException If the string is not a valid JSON array.
	*/
	@SuppressWarnings("unchecked")
	public static List<Object> parseArray(String jsonString) {
		Object result = parse(jsonString);
		if (!(result instanceof List)) {
			throw new IllegalArgumentException("JSON is not an array: " + jsonString);
		}
		return (List<Object>) result;
	}
}
