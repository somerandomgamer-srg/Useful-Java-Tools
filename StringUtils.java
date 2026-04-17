package UsefulJavaTools;

import java.security.SecureRandom;
import java.awt.Color;

/**
	* Provides methods for generating random numbers and strings.
	* @version 1.0.0
	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html">SecureRandom</a>
	* @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
	* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html">Color</a>
*/
public class RandomUtils {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
		* The random number generator used by the random methods.
		* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html">SecureRandom</a>
	*/
	public static SecureRandom rng = new SecureRandom();

	/**
		* @param min The minimum integer value of the random number.
		* @param max The maximum integer value of the random number.
		* @return A random integer between min and max.
	*/
	public static int randomInt(int min, int max) {
		return rng.nextInt(max - min + 1) + min;
	}

	/**
		* @param min The minimum double value of the random number.
		* @param max The maximum double value of the random number.
		* @param decimals The number of decimal places.
		* @return A random double between min and max.
	*/
	public static double randomDouble(double min, double max, int decimals) {
		double mult = Math.pow(10, decimals);
		return Math.floor((rng.nextDouble() * (max - min) + min) * mult) / mult;
	}

	/**
		* @param min The minimum long value of the random number.
		* @param max The maximum long value of the random number.
		* @return A random long between min and max.
	*/
	public static long randomLong(long min, long max) {
		return rng.nextLong(max - min + 1) + min;
	}

	/**
		* @param min The minimum float value of the random number.
		* @param max The maximum float value of the random number.
		* @param decimals The number of decimal places.
		* @return A random float between min and max.
	*/
	public static float randomFloat(float min, float max, int decimals) {
		float mult = (float)Math.pow(10, decimals);
		return Math.round((rng.nextFloat() * (max - min) + min) * mult) / mult;
	}

	/**
		* @param length The length of the hex string.
		* @return A random hex string of the given length.
		* @see <a href="https://en.wikipedia.org/wiki/Hexadecimal">Hexadecimal</a>
	*/
	public static String randomHex(int length) {
		StringBuilder hex = new StringBuilder(length);

		while (hex.length() < length) {
			hex.append(Integer.toHexString(rng.nextInt(16)));
		}

		return hex.toString();
	}

	/**
		* @return A random color.
		* @see <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html">Color</a>
	*/
	public static Color randomColor() {
		return new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
	}

	/**
		* @param truePossibility The percentage chance that the boolean will be true.
		* @param falsePossibility The percentage chance that the boolean will be false.
		* @return A random boolean.
		* @throws IllegalArgumentException If the sum of truePossibility and falsePossibility is not 100.
	*/
	public static boolean randomBoolean(double truePossibility, double falsePossibility) {
		if (truePossibility + falsePossibility != 100) {
			throw new IllegalArgumentException("The sum of truePossibility and falsePossibility must be 100.");
		}

		return Math.random() * 100 < truePossibility;
	}

	/**
		* @param x The number to randomize the sign of.
		* @param negativePossibility The percentage chance that the number will be negative.
		* @param positivePossibility The percentage chance that the number will be positive.
		* @return The number with a random sign.
		* @throws IllegalArgumentException If the sum of negativePossibility and positivePossibility is not 100.
	*/
	public static double randomSign(double x, double negativePossibility, double positivePossibility) {
		if (negativePossibility + positivePossibility != 100) {
			throw new IllegalArgumentException("The sum of negativePossibility and positivePossibility must be 100.");
		}

		return Math.random() * 100 < negativePossibility ? -x : x;
	}
}
