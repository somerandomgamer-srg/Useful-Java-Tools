package ujt;

import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
	* Provides methods for mathematical operations.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/Mathematics">Mathematics</a>
	* @see <a href="https://en.wikipedia.org/wiki/Average">Average</a>
	* @see <a href="https://en.wikipedia.org/wiki/Range_(statistics)">Range</a>
	* @see <a href="https://en.wikipedia.org/wiki/Standard_deviation">Standard deviation</a>
	* @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest common divisor</a>
	* @see <a href="https://en.wikipedia.org/wiki/Prime_number">Prime number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Least_common_multiple">Least common multiple</a>
	* @see <a href="https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Definitions_in_terms_of_logarithmss">Inverse hyperbolic functions</a>
	* @see <a href="https://en.wikipedia.org/wiki/Fibonacci_sequence">Fibonacci sequence</a>
	* @see <a href="https://en.wikipedia.org/wiki/Whole_number">Whole number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Square_number">Square number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Factorial">Factorial</a>
	* @see <a href="https://en.wikipedia.org/wiki/Permutation">Permutation</a>
	* @see <a href="https://en.wikipedia.org/wiki/Combination">Combination</a>
	* @see <a href="https://en.wikipedia.org/wiki/Perfect_number">Perfect number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Deficient_number">Deficient number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Abundant_number">Abundant number</a>
	* @see <a href="https://en.wikipedia.org/wiki/Standard_score">Standard score</a>
	* @see <a href="https://en.wikipedia.org/wiki/Trigonometric_functions">Trigonometric functions</a>
	* @see <a href="https://en.wikipedia.org/wiki/Inverse_trigonometric_functions">Inverse trigonometric functions</a>
	* @see <a href="https://en.wikipedia.org/wiki/Nth_root">Nth root</a>
	* @see <a href="https://en.wikipedia.org/wiki/Linear_interpolation">Linear interpolation</a>
	* @see <a href="https://en.wikipedia.org/wiki/Distance">Distance</a>
	* @see <a href="https://en.wikipedia.org/wiki/Quadratic_equation">Quadratic equation</a>
	* @see <a href="https://en.wikipedia.org/wiki/Clamp_(function)">Clamping</a>
*/
public class MathUtils {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	private static long sum(long... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		long total = 0;
		for (long x : numbers) {
			total += x;
		}
		return total;
	}

	private static long gcdMain(long a, long b) {
		a = Math.abs(a);
		b = Math.abs(b);
		while (b > 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	/**
		* @param x The number to round.
		* @return The rounded number.
	*/
	public static String round(double x) {
		return String.format("%.0f", Math.floor(x + 0.5));
	}

	/**
		* @param x The number to round.
		* @param precision The amount of decimal places to round to.
		* @return The rounded number.
	*/
	public static String round(double x, long precision) {
		double mult = Math.pow(10, precision);
		return String.format(String.format("%%.%df", precision), Math.floor(x * mult + 0.5) / mult);
	}

	/**
		* @param min The minimum value of the range.
		* @param max The maximum value of the range.
		* @param x The number to check.
		* @return Whether or not the number is in the range.
	*/
	public static boolean inRange(double min, double max, double x) {
		return x <= max && x >= min;
	}

	/**
		* @param numbers The numbers to average.
		* @return The average of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Average">Average</a>
	*/
	public static int average(int... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		int total = 0;

		for (int num : numbers) {
			total += num;
		}

		return total / numbers.length;
	}

	/**
		* @param numbers The numbers to average.
		* @return The average of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Average">Average</a>
	*/
	public static long average(long... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		long total = 0;

		for (long num : numbers) {
			total += num;
		}

		return total / numbers.length;
	}

	/**
		* @param numbers The numbers to average.
		* @return The average of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Average">Average</a>
	*/
	public static float average(float... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		float total = 0;

		for (float num : numbers) {
			total += num;
		}

		return total / numbers.length;
	}

	/**
		* @param numbers The numbers to average.
		* @return The average of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Average">Average</a>
	*/
	public static double average(double... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		double total = 0;

		for (double num : numbers) {
			total += num;
		}

		return total / numbers.length;
	}

	/**
		* @param numbers The numbers to find the median of.
		* @return The median of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Median">Median</a>
	*/
	public static double median(int... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		java.util.Arrays.sort(numbers);

		if (numbers.length % 2 == 0) {
			return (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
		}
		return numbers[numbers.length / 2];
	}

	/**
		* @param numbers The numbers to find the median of.
		* @return The median of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Median">Median</a>
	*/
	public static double median(long... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		java.util.Arrays.sort(numbers);

		if (numbers.length % 2 == 0) {
			return (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
		}
		return numbers[numbers.length / 2];
	}

	/**
		* @param numbers The numbers to find the median of.
		* @return The median of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Median">Median</a>
	*/
	public static double median(float... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		java.util.Arrays.sort(numbers);

		if (numbers.length % 2 == 0) {
			return (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
		}
		return numbers[numbers.length / 2];
	}

	/**
		* @param numbers The numbers to find the median of.
		* @return The median of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Median">Median</a>
	*/
	public static double median(double... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		java.util.Arrays.sort(numbers);

		if (numbers.length % 2 == 0) {
			return (numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]) / 2.0;
		}
		return numbers[numbers.length / 2];
	}

	/**
		* @param numbers The numbers to find the mode of.
		* @return The mode of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Mode_(statistics)">Mode</a>
	*/
	public static int[] mode(int... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		HashMap<Integer, Integer> counts = new HashMap<>();
		for (int n : numbers) {
			counts.merge(n, 1, Integer::sum);
		}
		int maxCount = 0;
		for (int c : counts.values()) {
			if (c > maxCount) maxCount = c;
		}
		List<Integer> modes = new ArrayList<>();
		for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
			if (e.getValue() == maxCount) modes.add(e.getKey());
		}
		return modes.stream().mapToInt(i -> i).toArray();
	}

	/**
		* @param numbers The numbers to find the mode of.
		* @return The mode of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Mode_(statistics)">Mode</a>
	*/
	public static long[] mode(long... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		HashMap<Long, Integer> counts = new HashMap<>();
		for (long n : numbers) {
			counts.merge(n, 1, Integer::sum);
		}
		int maxCount = 0;
		for (int c : counts.values()) {
			if (c > maxCount) maxCount = c;
		}
		List<Long> modes = new ArrayList<>();
		for (Map.Entry<Long, Integer> e : counts.entrySet()) {
			if (e.getValue() == maxCount) modes.add(e.getKey());
		}
		return modes.stream().mapToLong(i -> i).toArray();
	}

	/**
		* @param numbers The numbers to find the mode of.
		* @return The mode of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Mode_(statistics)">Mode</a>
	*/
	public static float[] mode(float... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		HashMap<Float, Integer> counts = new HashMap<>();
		for (float n : numbers) {
			counts.merge(n, 1, Integer::sum);
		}
		int maxCount = 0;
		for (int c : counts.values()) {
			if (c > maxCount) maxCount = c;
		}
		List<Float> modes = new ArrayList<>();
		for (Map.Entry<Float, Integer> e : counts.entrySet()) {
			if (e.getValue() == maxCount) modes.add(e.getKey());
		}
		float[] nums = new float[modes.size()];
		for (int i = 0; i < modes.size(); i++) {
			nums[i] = modes.get(i);
		}
		return nums;
	}

	/**
		* @param numbers The numbers to find the mode of.
		* @return The mode of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Mode_(statistics)">Mode</a>
	*/
	public static double[] mode(double... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		HashMap<Double, Integer> counts = new HashMap<>();
		for (double n : numbers) {
			counts.merge(n, 1, Integer::sum);
		}
		int maxCount = 0;
		for (int c : counts.values()) {
			if (c > maxCount) maxCount = c;
		}
		List<Double> modes = new ArrayList<>();
		for (Map.Entry<Double, Integer> e : counts.entrySet()) {
			if (e.getValue() == maxCount) modes.add(e.getKey());
		}
		return modes.stream().mapToDouble(i -> i).toArray();
	}

	/**
		* @param numbers The numbers to find the range of.
		* @return The range of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Range_(statistics)">Range</a>
	*/
	public static int range(int... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int num : numbers) {
			if (num < min) { min = num; }
			if (num > max) { max = num; }
		}

		return max - min;
	}

	/**
		* @param numbers The numbers to find the range of.
		* @return The range of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Range_(statistics)">Range</a>
	*/
	public static long range(long... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;

		for (long num : numbers) {
			if (num < min) { min = num; }
			if (num > max) { max = num; }
		}

		return max - min;
	}

	/**
		* @param numbers The numbers to find the range of.
		* @return The range of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Range_(statistics)">Range</a>
	*/
	public static float range(float... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		float min = Float.MAX_VALUE;
		float max = -Float.MAX_VALUE;

		for (float num : numbers) {
			if (num < min) { min = num; }
			if (num > max) { max = num; }
		}

		return max - min;
	}

	/**
		* @param numbers The numbers to find the range of.
		* @return The range of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Range_(statistics)">Range</a>
	*/
	public static double range(double... numbers) {
		if (numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required.");
		}

		double min = Double.MAX_VALUE;
		double max = -Double.MAX_VALUE;

		for (double num : numbers) {
			if (num < min) { min = num; }
			if (num > max) { max = num; }
		}

		return max - min;
	}

	/**
		* @param numbers The numbers to find the standard deviation of.
		* @return The standard deviation of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_deviation">Standard deviation</a>
	*/
	public static double standardDeviation(int... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		double dev = 0;
		double avg = average(numbers);

		for (int x : numbers) {
			dev += Math.pow(x - avg, 2);
		}

		return Math.sqrt(dev / numbers.length);
	}

	/**
		* @param numbers The numbers to find the standard deviation of.
		* @return The standard deviation of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_deviation">Standard deviation</a>
	*/
	public static double standardDeviation(long... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		double dev = 0;
		double avg = average(numbers);

		for (long x : numbers) {
			dev += Math.pow(x - avg, 2);
		}

		return Math.sqrt(dev / numbers.length);
	}

	/**
		* @param numbers The numbers to find the standard deviation of.
		* @return The standard deviation of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_deviation">Standard deviation</a>
	*/
	public static double standardDeviation(float... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		double dev = 0;
		double avg = average(numbers);

		for (float x : numbers) {
			dev += Math.pow(x - avg, 2);
		}

		return Math.sqrt(dev / numbers.length);
	}

	/**
		* @param numbers The numbers to find the standard deviation of.
		* @return The standard deviation of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_deviation">Standard deviation</a>
	*/
	public static double standardDeviation(double... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		double dev = 0;
		double avg = average(numbers);

		for (double x : numbers) {
			dev += Math.pow(x - avg, 2);
		}

		return Math.sqrt(dev / numbers.length);
	}

	/**
		* @param numbers The numbers to find the greatest common divisor of.
		* @return The greatest common divisor of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest common divisor</a>
	*/
	public static int gcd(int... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		long result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			result = gcdMain(result, numbers[i]);
		}
		return (int)result;
	}

	/**
		* @param numbers The numbers to find the greatest common divisor of.
		* @return The greatest common divisor of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Greatest_common_divisor">Greatest common divisor</a>
	*/
	public static long gcd(long... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		long result = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			result = gcdMain(result, numbers[i]);
		}
		return result;
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is prime.
		* @see <a href="https://en.wikipedia.org/wiki/Prime_number">Prime number</a>
	*/
	public static boolean isPrime(long x) {
		if (x < 2) {
			return false;
		} else {
			for (int i = 2; i <= Math.sqrt(x); i++) {
				if (x % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
		* @param numbers The numbers to find the least common multiple of.
		* @return The least common multiple of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Least_common_multiple">Least common multiple</a>
	*/
	public static int lcm(int... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		int least = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			least = (int)(least / gcdMain(least, numbers[i]) * numbers[i]);
		}

		return least;
	}

	/**
		* @param numbers The numbers to find the least common multiple of.
		* @return The least common multiple of the numbers.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Least_common_multiple">Least common multiple</a>
	*/
	public static long lcm(long... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		long least = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			least = least / gcdMain(least, numbers[i]) * numbers[i];
		}

		return least;
	}

	/**
		* @param x The number to find the inverse hyperbolic cosine of.
		* @return The inverse hyperbolic cosine of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Definitions_in_terms_of_logarithmss">Inverse hyperbolic functions</a>
	*/
	public static double acosh(double x) {
		return Math.log(x + Math.sqrt(Math.pow(x, 2) - 1));
	}

	/**
		* @param x The number to find the inverse hyperbolic tangent of.
		* @return The inverse hyperbolic tangent of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Definitions_in_terms_of_logarithmss">Inverse hyperbolic functions</a>
	*/
	public static double atanh(double x) {
		return Math.log((1 + x) / (1 - x)) / 2;
	}

	/**
		* @param x The number to find the inverse hyperbolic sin of.
		* @return The inverse hyperbolic sin of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Inverse_hyperbolic_functions#Definitions_in_terms_of_logarithmss">Inverse hyperbolic functions</a>
	*/
	public static double asinh(double x) {
		return Math.log(x + Math.sqrt(Math.pow(x, 2) + 1));
	}

	/**
		* @param nth The nth number in the Fibonacci sequence to find.
		* @return The nth number in the Fibonacci sequence.
		* @see <a href="https://en.wikipedia.org/wiki/Fibonacci_sequence">Fibonacci sequence</a>
	*/
	public static long fibonacci(long nth) {
		if (nth <= 1) {
			return 0;
		} else if (nth == 2) {
			return 1;
		} else {
			long a = 0;
			long b = 1;

			for (int i = 3; i <= nth; i++) {
				long temp = a;
				a = b;
				b += temp;
			}

			return b;
		}
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is a whole number.
		* @see <a href="https://en.wikipedia.org/wiki/Whole_number">Whole number</a>
	*/
	public static boolean isWhole(double x) {
		return x == (int)x;
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is an odd number.
	*/
	public static boolean isOdd(long x) {
		return x % 2 == 1;
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is an even number.
	*/
	public static boolean isEven(long x) {
		return x % 2 == 0;
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is a perfect square.
		* @see <a href="https://en.wikipedia.org/wiki/Square_number">Square number</a>
	*/
	public static boolean isPerfectSquare(long x) {
		if (x < 1) { return false; }
		return Math.sqrt(x) == Math.floor(Math.sqrt(x));
	}

	/**
		* @param x The number to find the factorial of.
		* @return The factorial of the number.
		* @throws IllegalArgumentException If the number is negative.
		* @see <a href="https://en.wikipedia.org/wiki/Factorial">Factorial</a>
	*/
	public static long factorial(long x) {
		if (x == 0) {
			return 1;
		}
		if (x < 0) {
			throw new IllegalArgumentException("x cannot be a negative number, given: " + x);
		}

		long fact = x; 
		for (long i = x - 1; i >= 1; i--) {
			fact *= i;
		}

		return fact;
	}

	/**
		* @param x The number to find the factorial of.
		* @return The factorial of the number.
		* @throws IllegalArgumentException If the number is negative.
		* @see <a href="https://en.wikipedia.org/wiki/Factorial">Factorial</a>
	*/
	public static BigInteger bigFactorial(long x) {
		if (x == 0) {
			return BigInteger.ONE;
		}
		if (x < 0) {
			throw new IllegalArgumentException("x cannot be a negative number, given: " + x);
		}

		BigInteger fact = BigInteger.valueOf(x); 
		for (long i = x - 1; i >= 1; i--) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		return fact;
	}

	/**
		* @param x The number to find the permutation of.
		* @param r The number of items to choose from the number.
		* @return The permutation of the number.
		* @throws IllegalArgumentException If `r` is greater than `x`.
		* @see <a href="https://en.wikipedia.org/wiki/Permutation">Permutation</a>
	*/
	public static long permutation(long x, long r) {
		if (x < r) {
			throw new IllegalArgumentException("'r' cannot be greater than 'x'");
		}

		return factorial(x) / factorial(x - r);
	}

	/**
		* @param x The number to find the combination of.
		* @param r The number of items to choose from the number.
		* @return The combination of the number.
		* @throws IllegalArgumentException If `r` is greater than `x`.
		* @see <a href="https://en.wikipedia.org/wiki/Combination">Combination</a>
	*/
	public static long combination(long x, long r) {
		if (x < r) {
			throw new IllegalArgumentException("'r' cannot be greater than 'x'");
		}

		return factorial(x) / (factorial(r) * factorial(x - r));
	}

	/**
		* @param x The number to find the factors of.
		* @return The factors of the number.
		* @throws IllegalArgumentException If the number is negative.
	*/
	public static long[] factors(long x) {
		if (x < 0) {
			throw new IllegalArgumentException("x cannot be a negative number, given: " + x);
		}

		List<Long> factors = new ArrayList<Long>();
		factors.add((long)1);
		factors.add(x);
		for (long i = 2; i <= x - 1; i++) {
			if (x % i == 0) {
				factors.add(i);
			}
		}

		return factors.stream().mapToLong(i -> i).toArray();
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is a perfect number.
		* @see <a href="https://en.wikipedia.org/wiki/Perfect_number">Perfect number</a>
	*/
	public static boolean isPerfect(long x) {
		return sum(factors(x)) - x == x;
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is a deficient number.
		* @see <a href="https://en.wikipedia.org/wiki/Deficient_number">Deficient number</a>
	*/
	public static boolean isDeficient(long x) {
		return sum(factors(x)) - x < x;
	}

	/**
		* @param x The number to check.
		* @return Whether or not the number is an abundant number.
		* @see <a href="https://en.wikipedia.org/wiki/Abundant_number">Abundant number</a>
	*/
	public static boolean isAbundant(long x) {
		return sum(factors(x)) - x > x;
	}

	/**
		* @param x The number to classify.
		* @return The classification of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Perfect_number">Perfect number</a>
		* @see <a href="https://en.wikipedia.org/wiki/Deficient_number">Deficient number</a>
		* @see <a href="https://en.wikipedia.org/wiki/Abundant_number">Abundant number</a>
	*/
	public static String classifyNumber(long x) {
		if (isPerfect(x)) {
			return "Perfect";
		} else if (isDeficient(x)) {
			return "Deficient";
		} else if (isAbundant(x)) {
			return "Abundant";
		} else {
			return "Unknown";
		}
	}

	/**
		* @param x The number to find the z-score of.
		* @param numbers The numbers to find the z-score of.
		* @return The z-score of the number.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_score">Standard score</a>
	*/
	public static double zScore(double x, int... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		return (x - average(numbers)) / standardDeviation(numbers);
	}

	/**
		* @param x The number to find the z-score of.
		* @param numbers The numbers to find the z-score of.
		* @return The z-score of the number.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_score">Standard score</a>
	*/
	public static double zScore(double x, long... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		return (x - average(numbers)) / standardDeviation(numbers);
	}

	/**
		* @param x The number to find the z-score of.
		* @param numbers The numbers to find the z-score of.
		* @return The z-score of the number.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_score">Standard score</a>
	*/
	public static double zScore(double x, float... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		return (x - average(numbers)) / standardDeviation(numbers);
	}

	/**
		* @param x The number to find the z-score of.
		* @param numbers The numbers to find the z-score of.
		* @return The z-score of the number.
		* @throws IllegalArgumentException If less than two numbers are provided.
		* @see <a href="https://en.wikipedia.org/wiki/Standard_score">Standard score</a>
	*/
	public static double zScore(double x, double... numbers) {
		if (numbers == null || numbers.length < 2) {
			throw new IllegalArgumentException("At least two numbers are required");
		}

		return (x - average(numbers)) / standardDeviation(numbers);
	}

	/**
		* @param x The number to find the secant of.
		* @return The secant of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Trigonometric_functions">Trigonometric functions</a>
	*/
	public static double secant(double x) {
		return 1 / Math.cos(x);
	}

	/**
		* @param x The number to find the cosecant of.
		* @return The cosecant of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Trigonometric_functions">Trigonometric functions</a>
	*/
	public static double cosecant(double x) {
		return 1 / Math.sin(x);
	}

	/**
		* @param x The number to find the cotangent of.
		* @return The cotangent of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Trigonometric_functions">Trigonometric functions</a>
	*/
	public static double cotangent(double x) {
		return 1 / Math.tan(x);
	}

	/**
		* @param x The number to find the inverse secant of.
		* @return The inverse secant of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Inverse_trigonometric_functions">Inverse trigonometric functions</a>
	*/
	public static double asecant(double x) {
		return Math.acos(1 / x);
	}

	/**
		* @param x The number to find the inverse cosecant of.
		* @return The inverse cosecant of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Inverse_trigonometric_functions">Inverse trigonometric functions</a>
	*/
	public static double acosecant(double x) {
		return Math.asin(1 / x);
	}

	/**
		* @param x The number to find the inverse cotangent of.
		* @return The inverse cotangent of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Inverse_trigonometric_functions">Inverse trigonometric functions</a>
	*/
	public static double acotangent(double x) {
		return Math.atan(1 / x);
	}

	/**
		* @param x The number to find the nth root of.
		* @param n The nth root to find.
		* @return The nth root of the number.
		* @see <a href="https://en.wikipedia.org/wiki/Nth_root">Nth root</a>
	*/
	public static double nroot(double x, long n) {
		return Math.pow(x, 1.0 / n);
	}

	/**
		* @param x The number to map.
		* @param min1 The minimum value of the first range.
		* @param max1 The maximum value of the first range.
		* @param min2 The minimum value of the second range.
		* @param max2 The maximum value of the second range.
		* @return The mapped number.
		* @see <a href="https://en.wikipedia.org/wiki/Linear_interpolation">Linear interpolation</a>
	*/
	public static double mathMap(double x, double min1, double max1, double min2, double max2) {
		return (x - min1) * (max2 - min2) / (max1 - min1) + min2;
	}

	/**
		* @param x1 The x coordinate of the first point.
		* @param y1 The y coordinate of the first point.
		* @param x2 The x coordinate of the second point.
		* @param y2 The y coordinate of the second point.
		* @return The distance between the two points.
		* @see <a href="https://en.wikipedia.org/wiki/Distance">Distance</a>
	*/
	public static double distance2d(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	/**
		* @param x1 The x coordinate of the first point.
		* @param y1 The y coordinate of the first point.
		* @param z1 The z coordinate of the first point.
		* @param x2 The x coordinate of the second point.
		* @param y2 The y coordinate of the second point.
		* @param z2 The z coordinate of the second point.
		* @return The distance between the two points.
		* @see <a href="https://en.wikipedia.org/wiki/Distance">Distance</a>
	 */
	public static double distance3d(double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
	}

	/**
		* @param a The coefficient of the quadratic term.
		* @param b The coefficient of the linear term.
		* @return The axis of symmetry of the quadratic equation.
		* @see <a href="https://en.wikipedia.org/wiki/Quadratic_equation">Quadratic equation</a>
	*/
	public static double aos(double a, double b) {
		return -b / (2 * a);
	}

	/**
		* @param a The coefficient of the quadratic term.
		* @param b The coefficient of the linear term.
		* @param c The constant term.
		* @return The vertex of the quadratic equation.
		* @see <a href="https://en.wikipedia.org/wiki/Quadratic_equation">Quadratic equation</a>
	*/
	public static Map<String, Double> vertex(double a, double b, double c) {
		double axisSym = aos(a, b);

		return Map.of(
			"x", axisSym,
			"y", a * Math.pow(axisSym, 2) + b * axisSym + c
		);
	}

	/**
		* @param value The value to clamp.
		* @param min The minimum value.
		* @param max The maximum value.
		* @return The clamped value.
		* @see <a href="https://en.wikipedia.org/wiki/Clamp_(function)">Clamping</a>
	*/
	public static double clamp(double value, double min, double max) {
		return Math.max(min, Math.min(max, value));
	}

	/**
		* @param x The number to log.
		* @param base The base of the logarithm.
		* @return The logarithm of the number.
	*/
	public static double log(double x, double base) {
		return Math.log(x) / Math.log(base);
	}
}
