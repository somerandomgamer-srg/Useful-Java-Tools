package ujt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * Provides methods for encrypting and hashing strings.
 * @version 1.0.0
 * @see <a href="https://en.wikipedia.org/wiki/Cryptography">Cryptography</a>
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
	private static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
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

				s.append((char) (((c - base + shift) % 26 + 26) % 26 + base));
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
	 * @throws RuntimeException If the SHA-256 algorithm is unavailable.
	 * @see <a href="https://en.wikipedia.org/wiki/SHA-256">SHA-256</a>
	 */
	public static byte[] sha256(String str) {
		try {
			return MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			throw new RuntimeException("SHA-256 algorithm unavailable: " + e.getMessage(), e);
		}
	}

	/**
	 * @param str The string to perform sha256 hashing on.
	 * @return The hashed string as a hexadecimal string.
	 * @throws RuntimeException If the SHA-256 algorithm is unavailable.
	 * @see <a href="https://en.wikipedia.org/wiki/SHA-256">SHA-256</a>
	 */
	public static String sha256String(String str) {
		return bytesToHex(sha256(str));
	}

	/**
	 * <b>WARNING: MD5 is not secure and should not be used for cryptographic purposes.</b>
	 * @param str The string to perform md5 hashing on.
	 * @return The hashed string as a byte array.
	 * @throws RuntimeException If the MD5 algorithm is unavailable.
	 * @see <a href="https://en.wikipedia.org/wiki/MD5">MD5</a>
	 */
	public static byte[] md5(String str) {
		try {
			return MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			throw new RuntimeException("MD5 algorithm unavailable: " + e.getMessage(), e);
		}
	}

	/**
	 * @param str The string to perform md5 hashing on.
	 * @return The hashed string as a hexadecimal string.
	 * @throws RuntimeException If the MD5 algorithm is unavailable.
	 * @see <a href="https://en.wikipedia.org/wiki/MD5">MD5</a>
	 */
	public static String md5String(String str) {
		return bytesToHex(md5(str));
	}

	/**
	 * @param str The string to perform sha1 hashing on.
	 * @return The hashed string as a byte array.
	 * @throws RuntimeException If the SHA-1 algorithm is unavailable.
	 * @see <a href="https://en.wikipedia.org/wiki/SHA-1">SHA-1</a>
	 */
	public static byte[] sha1(String str) {
		try {
			return MessageDigest.getInstance("SHA-1").digest(str.getBytes(StandardCharsets.UTF_8));
		} catch (Exception e) {
			throw new RuntimeException("SHA-1 algorithm unavailable: " + e.getMessage(), e);
		}
	}

	/**
	 * @param str The string to perform sha1 hashing on.
	 * @return The hashed string as a hexadecimal string.
	 * @throws RuntimeException If the SHA-1 algorithm is unavailable.
	 * @see <a href="https://en.wikipedia.org/wiki/SHA-1">SHA-1</a>
	 */
	public static String sha1String(String str) {
		return bytesToHex(sha1(str));
	}
}
