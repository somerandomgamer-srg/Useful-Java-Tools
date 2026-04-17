package UsefulJavaTools;

import java.util.Arrays;

/**
	* A class for binary operations.
	* @see <a href="https://en.wikipedia.org/wiki/Binary_number">Binary</a>
	* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Addition">Binary addition</a>
	* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Subtraction">Binary subtraction</a>
	* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Multiplication">Binary multiplication</a>
	* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Division">Binary division</a>
*/
public class Binary {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
		* @param binary The binary string to convert to its decimal representation.
		* @return The decimal representation of the binary string.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Binary_to_decimal">Binary to Decimal</a>
	*/
	public static long toDecimal(String binary) {
		if (!binary.matches("[01]+")) {
			throw new IllegalArgumentException("Binary strings can only contain 0s and 1s. Given: " + binary);
		}
		return Long.parseLong(binary, 2);
	}

	/**
		* @param decimal The decimal number to convert to its binary representation.
		* @return The binary representation of the decimal number.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Decimal_to_binary">Decimal to Binary</a>
	*/
	public static String fromDecimal(long decimal) {
		if (decimal == 0) {
			return "0";
		}
		if (decimal < 0) {
			throw new IllegalArgumentException("Decimal numbers must be non-negative. Given: " + decimal);
		}
		if (!String.valueOf(decimal).matches("[0-9]+")) {
			throw new IllegalArgumentException("Decimal numbers can only contain digits. Given: " + decimal);
		}
		return Long.toBinaryString(decimal);
	}

	/**
		* @param binary The binary strings to add together.
		* @return The sum of the binary strings.
		* @throws IllegalArgumentException If less than two binary strings are provided.
		* @throws IllegalArgumentException If the binary strings are not the same length.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Addition">Binary addition</a>
	*/
	public static String add(String... binary) {
		if (binary.length < 2) {
			throw new IllegalArgumentException("At least two binary strings are required");
		}

		int maxLength = Arrays.stream(binary).mapToInt(String::length).max().orElse(0);
		for (String b : binary) {
			if (b.length() != maxLength) {
				throw new IllegalArgumentException("All binary strings must be the same length. Given: " + b.length() + " and " + maxLength);
			}
			if (!b.matches("[01]+")) {
				throw new IllegalArgumentException("Binary strings can only contain 0s and 1s. Given: " + b);
			}
		}

		String result = "";
		long carry = 0;

		for (int i = maxLength; i >= 1; i--) {
			long sum = carry;
			for (String b : binary) {
				sum += Character.getNumericValue(b.charAt(i - 1));
			}

			result = (sum % 2) + result;
			carry = sum / 2;
		}

		while (carry > 0) {
			result = carry % 2 + result;
			carry /= 2;
		}

		return result;
	}

	/**
		* Returns negative results with a negative sign prefix.
		* @param binary The binary strings to subtract.
		* @return The difference of the binary strings.
		* @throws IllegalArgumentException If less than two binary strings are provided.
		* @throws IllegalArgumentException If the binary strings are not the same length.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Subtraction">Binary subtraction</a>
	*/
	public static String subtract(String... binary) {
		if (binary.length < 2) {
			throw new IllegalArgumentException("At least two binary strings are required");
		}

		int maxLength = Arrays.stream(binary).mapToInt(String::length).max().orElse(0);
		for (String b : binary) {
			if (b.length() != maxLength) {
				throw new IllegalArgumentException("All binary strings must be the same length. Given: " + b.length() + " and " + maxLength);
			}
			if (!b.matches("[01]+")) {
				throw new IllegalArgumentException("Binary strings can only contain 0s and 1s. Given: " + b);
			}
		}

		long result = toDecimal(binary[0]);
		for (int i = 1; i < binary.length; i++)  {
			result -= toDecimal(binary[i]);
		}

		if (result < 0) {
			return "-" + fromDecimal(Math.abs(result));
		} else if (result == 0) {
			return "0";
		} else {
			return fromDecimal(result);
		}
	}

	/**
		* @param binary The binary strings to multiply.
		* @return The product of the binary strings.
		* @throws IllegalArgumentException If less than two binary strings are provided.
		* @throws IllegalArgumentException If the binary strings are not the same length.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Multiplication">Binary multiplication</a>
	*/
	public static String multiply(String... binary) {
		if (binary.length < 2) {
			throw new IllegalArgumentException("At least two binary strings are required");
		}

		int maxLength = Arrays.stream(binary).mapToInt(String::length).max().orElse(0);
		for (String b : binary) {
			if (b.length() != maxLength) {
				throw new IllegalArgumentException("All binary strings must be the same length. Given: " + b.length() + " and " + maxLength);
			}
			if (!b.matches("[01]+")) {
				throw new IllegalArgumentException("Binary strings can only contain 0s and 1s. Given: " + b);
			}
		}

		long result = toDecimal(binary[0]);
		for (int i = 1; i < binary.length; i++) {
			result *= toDecimal(binary[i]);
		}

		return fromDecimal(result);
	}

	/**
		* @param binary The binary strings to divide.
		* @return The quotient of the binary strings.
		* @throws IllegalArgumentException If less than two binary strings are provided.
		* @throws IllegalArgumentException If the binary strings are not the same length.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Division">Binary division</a>
	*/
	public static String divide(String... binary) {
		if (binary.length < 2) {
			throw new IllegalArgumentException("At least two binary strings are required");
		}

		int maxLength = Arrays.stream(binary).mapToInt(String::length).max().orElse(0);
		for (String b : binary) {
			if (b.length() != maxLength) {
				throw new IllegalArgumentException("All binary strings must be the same length. Given: " + b.length() + " and " + maxLength);
			}
			if (!b.matches("[01]+")) {
				throw new IllegalArgumentException("Binary strings can only contain 0s and 1s. Given: " + b);
			}
		}

		long result = toDecimal(binary[0]);
		for (int i = 1; i < binary.length; i++) {
			long d = toDecimal(binary[i]);
			if (d == 0) {
				throw new ArithmeticException("Division by zero");
			}
			result /= d;
		}
		result = (long)Math.floor(result);

		return fromDecimal(result);
	}

	/**
		* @param binary The binary string to find the square root of.
		* @return The square root of the binary string.
		* @see <a href="https://en.wikipedia.org/wiki/Binary_number#Square_root">Binary square root</a>
	*/
	public static String sqrt(String binary) {
		if (!binary.matches("[01]+")) {
			throw new IllegalArgumentException("Binary strings can only contain 0s and 1s. Given: " + binary);
		}

		long result = (long)Math.sqrt(toDecimal(binary));
		return fromDecimal(result);
	}
}
