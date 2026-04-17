package UsefulJavaTools;

import java.util.Base64;
import java.security.MessageDigest;

/**
	* Provides methods for encrypting and decrypting strings.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/Cryptography">Cryptography</a>
	* @see <a href="https://en.wikipedia.org/wiki/ASCII">ASCII</a>
	* @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
	* @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
	* @see <a href="https://en.wikipedia.org/wiki/Caesar_cipher">Caesar cipher</a>
	* @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Rotate_right">Rotate right</a>
	* @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Rotate_left">Rotate left</a>
	* @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#AND">Bitwise AND</a>
	* @see <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm</a>
	* @see <a href="https://en.wikipedia.org/wiki/XOR_cipher">XOR cipher</a>
	* @see <a href="https://en.wikipedia.org/wiki/Symmetric-key_algorithm">Symmetric-key algorithm</a>
	* @see <a href="https://en.wikipedia.org/wiki/SHA-256">SHA-256</a>
	* @see <a href="https://en.wikipedia.org/wiki/MD5">MD5</a>
	* @see <a href="https://en.wikipedia.org/wiki/SHA-1">SHA-1</a>
*/
public class Cryptography {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
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

		for (byte b : str.getBytes()) {
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
		return Base64.getEncoder().encodeToString(str.getBytes());
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
		return Base64.getUrlEncoder().encodeToString(str.getBytes());
	}

	/**
		* @param base64 The Base64 URL string to convert to a string.
		* @return The string representation of the Base64 URL string.
		* @see <a href="https://en.wikipedia.org/wiki/Base64">Base64</a>
	*/
	public static String fromBase64Url(String base64) {
		return new String(Base64.getUrlDecoder().decode(base64));
	}

	/**
		* @param message The message to encrypt.
		* @param shift The amount of characters to shift the message by.
		* @return The encrypted message.
		* @see <a href="https://en.wikipedia.org/wiki/Caesar_cipher">Caesar cipher</a>
	*/
	public static String caesarCipherEncrypt(String message, int shift) {
		StringBuilder s = new StringBuilder(message.length());

		for (char c : message.toCharArray()) {
			if (Character.isLetter(c)) {
				char base = Character.isLowerCase(c) ? 'a' : 'A';

				s.append((char) ((c - base + shift) % 26 + base));
			} else {
				s.append(c);
			}
		}

		return s.toString();
	}

	/**
		* @param message The message to decrypt.
		* @param shift The amount of characters to shift the message by.
		* @return The decrypted message.
		* @see <a href="https://en.wikipedia.org/wiki/Caesar_cipher">Caesar cipher</a>
	*/
	public static String caesarCipherDecrypt(String message, int shift) {
		return caesarCipherEncrypt(message, 26 - shift);
	}

	/**
		* @param str The string to rotate.
		* @param displacement The amount of bits to rotate the string by.
		* @param bits The amount of bits to rotate the string by.
		* @return The rotated string.
		* @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Rotate_right">Rotate right</a>
	*/
	public static String ror(String str, int displacement, int bits) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			int rotated = ((codePoint >>> displacement) | (codePoint << (bits - displacement))) & (0xFFFFFFFF >>> (32 - bits));
			s.appendCodePoint(rotated);
			i += Character.charCount(codePoint);
		}
		return s.toString();
	}

	/**
		* @param str The string to rotate.
		* @param displacement The amount of bits to rotate the string by.
		* @param bits The amount of bits to rotate the string by.
		* @return The rotated string.
		* @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#Rotate_left">Rotate left</a>
	*/
	public static String rol(String str, int displacement, int bits) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			int rotated = ((codePoint << displacement) | (codePoint >>> (bits - displacement))) & (0xFFFFFFFF >>> (32 - bits));
			s.appendCodePoint(rotated);
			i += Character.charCount(codePoint);
		}
		return s.toString();
	}

	/**
		* @param numbers The numbers to bitwise AND.
		* @return The result of the bitwise AND operation.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation#AND">Bitwise AND</a>
	*/
	public static boolean btest(int... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		int result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			result &= numbers[i];
		}
		return result != 0;
	}

	/**
		* Performs the Luhn algorithm on `x`, an algorithm commonly used for validation of various identification numbers, such as credit card numbers, IMEI numbers, National Provider Identifier numbers in the US, etc.
		* @param x The number to validate.
		* @return Whether or not the number is valid.
		* @see <a href="https://en.wikipedia.org/wiki/Luhn_algorithm">Luhn algorithm</a>
	*/
	public static boolean luhn(long x) {
		String s = Long.toString(x);
		int sum = 0;
		boolean alternate = false;

		for (int i = s.length() - 1; i >= 0; i--) {
			int digit = Character.getNumericValue(s.charAt(i));

			if (alternate) {
				digit *= 2;
				if (digit > 9) {
					digit -= 9;
				}
			}

			sum += digit;
			alternate = !alternate;
		}

		return sum % 10 == 0;
	}

	/**
		* @param str The string to perform sha256 hashing on.
		* @return The hashed string as a byte array.
		* @see <a href="https://en.wikipedia.org/wiki/SHA-256">SHA-256</a>
	*/
	public static byte[] sha256(String str) {
		try {
			return MessageDigest.getInstance("SHA-256").digest(str.getBytes());
		} catch (Exception e) {
			System.out.println("An error occurred while hashing the string: " + e.getMessage());
			return null;
		}
	}

	/**
		* @param str The string to perform sha256 hashing on.
		* @return The hashed string as a hexadecimal string.
		* @see <a href="https://en.wikipedia.org/wiki/SHA-256">SHA-256</a>
	*/
	public static String sha256String(String str) {
		byte[] hash = sha256(str);
		if (hash == null) {
			return null;
		}
		return bytesToHex(hash);
	}

	/**
		* @param str The string to perform md5 hashing on.
		* @return The hashed string as a byte array.
		* @see <a href="https://en.wikipedia.org/wiki/MD5">MD5</a>
	*/
	public static byte[] md5(String str) {
		try {
			return MessageDigest.getInstance("MD5").digest(str.getBytes());
		} catch (Exception e) {
			System.out.println("An error occurred while hashing the string: " + e.getMessage());
			return null;
		}
	}

	/**
		* @param str The string to perform md5 hashing on.
		* @return The hashed string as a hexadecimal string.
		* @see <a href="https://en.wikipedia.org/wiki/MD5">MD5</a>
	*/
	public static String md5String(String str) {
		byte[] hash = md5(str);
		if (hash == null) {
			return null;
		}
		return bytesToHex(hash);
	}

	/**
		* @param str The string to perform sha1 hashing on.
		* @return The hashed string as a byte array.
		* @see <a href="https://en.wikipedia.org/wiki/SHA-1">SHA-1</a>
	*/
	public static byte[] sha1(String str) {
		try {
			return MessageDigest.getInstance("SHA-1").digest(str.getBytes());
		} catch (Exception e) {
			System.out.println("An error occurred while hashing the string: " + e.getMessage());
			return null;
		}
	}

	/**
		* @param str The string to perform sha1 hashing on.
		* @return The hashed string as a hexadecimal string.
		* @see <a href="https://en.wikipedia.org/wiki/SHA-1">SHA-1</a>
	*/
	public static String sha1String(String str) {
		byte[] hash = sha1(str);
		if (hash == null) {
			return null;
		}
		return bytesToHex(hash);
	}
}
