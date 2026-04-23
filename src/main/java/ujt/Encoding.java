package ujt;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

/**
	* Provides methods for encoding and decoding strings.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/ASCII">ASCII</a>
	* @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
	* @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
*/
public class Encoding {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
		* @param str The string to convert to ASCII.
		* @return The ASCII representation of the string.
		* @see <a href="https://en.wikipedia.org/wiki/ASCII">ASCII</a>
	*/
	public static String toAscii(String str) {
		StringBuilder ascii = new StringBuilder();

		for (char c : str.toCharArray()) {
			ascii.append((int) c).append(" ");
		}
		return ascii.toString().trim();
	}

	/**
		* @param ascii The ASCII string to convert to a string.
		* @return The string representation of the ASCII string.
		* @see <a href="https://en.wikipedia.org/wiki/ASCII">ASCII</a>
	*/
	public static String fromAscii(String ascii) {
		StringBuilder str = new StringBuilder();

		for (String s : ascii.split(" ")) {
			str.append((char) Integer.parseInt(s));
		}
		return str.toString();
	}

	/**
		* @param str The string to convert to hexadecimal.
		* @return The hexadecimal representation of the string.
		* @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
	*/
	public static String toHex(String str) {
		StringBuilder hex = new StringBuilder();

		for (char c : str.toCharArray()) {
			hex.append(Integer.toHexString((int) c)).append(" ");
		}
		return hex.toString().trim();
	}

	/**
		* @param hex The hexadecimal string to convert to a string.
		* @return The string representation of the hexadecimal string.
		* @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
	*/
	public static String fromHex(String hex) {
		StringBuilder str = new StringBuilder();

		for (String s : hex.split(" ")) {
			str.append((char) Integer.parseInt(s, 16));
		}
		return str.toString();
	}

	/**
		* @param str The string to convert to binary.
		* @return The binary representation of the string.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary number</a>
	*/
	public static String toBinary(String str) {
		StringBuilder binary = new StringBuilder();

		for (byte b : str.getBytes(StandardCharsets.UTF_8)) {
			binary.append(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0'));
		}
		return binary.toString().trim();
	}

	/**
		* @param str The string to convert to binary.
		* @param bits The amount of bits to use for each character.
		* @return The binary representation of the string.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary number</a>
	*/
	public static String toBinary(String str, int bits) {
		if (bits < 8) {
			throw new IllegalArgumentException("bits must be at least 8");
		}

		if (bits > 32) {
			throw new IllegalArgumentException("bits must be at most 32");
		}
		StringBuilder binary = new StringBuilder();

		for (int i = 0; i < str.length(); ) {
			int codePoint = str.codePointAt(i);

			String b = Integer.toUnsignedString(codePoint, 2);
			binary.append(String.format("%" + bits + "s", b).replace(' ', '0'));

			i += Character.charCount(codePoint);
		}

		return binary.toString().trim();
	}

	/**
		* @param binary The binary string to convert to a string.
		* @return The string representation of the binary string.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary number</a>
	*/
	public static String fromBinary(String binary) {
		if (binary.length() % 8 != 0) {
			throw new IllegalArgumentException("binary must be a multiple of 8 bits. Given: " + binary.length());
		}

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < binary.length(); i += 8) {
			str.appendCodePoint(Integer.parseUnsignedInt(binary.substring(i, i + 8), 2));
		}

		return str.toString();
	}

	/**
		* @param binary The binary string to convert to a string.
		* @param bits The amount of bits to use for each character.
		* @return The string representation of the binary string.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary number</a>
	*/
	public static String fromBinary(String binary, int bits) {
		if (bits < 8) {
			throw new IllegalArgumentException("bits must be at least 8");
		}

		if (bits > 32) {
			throw new IllegalArgumentException("bits must be at most 32");
		}

		if (binary.length() % bits != 0) {
			throw new IllegalArgumentException("binary must be a multiple of " + bits + " bits. Given: " + binary.length());
		}

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < binary.length(); i += bits) {
			str.appendCodePoint(Integer.parseUnsignedInt(binary.substring(i, i + bits), 2));
		}

		return str.toString();
	}

	/**
		* @param str The string to convert to Base64.
		* @return The Base64 representation of the string.
		* @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
	*/
	public static String toBase64(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
	}

	/**
		* @param base64 The Base64 string to convert to a string.
		* @return The string representation of the Base64 string.
		* @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
	*/
	public static String fromBase64(String base64) {
		return new String(Base64.getDecoder().decode(base64));
	}

	/**
		* @param str The string to convert to Base64 URL.
		* @return The Base64 URL representation of the string.
		* @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
	*/
	public static String toBase64Url(String str) {
		return Base64.getUrlEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
	}

	/**
		* @param base64 The Base64 URL string to convert to a string.
		* @return The string representation of the Base64 URL string.
		* @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
	*/
	public static String fromBase64Url(String base64) {
		return new String(Base64.getUrlDecoder().decode(base64));
	}
}
