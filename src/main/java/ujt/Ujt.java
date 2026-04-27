package ujt;

/**
 * Provides access to the main metadata and helpers of the library.
 * @version 2.0.0
 */
public class Ujt {
	/**
	 * The minimum Java version required to use this library.
	 */
	public static final int MINIMUM_JAVA_VERSION = 17;

	/**
	 * The current version of the library.
	 * Format: V"Major Update"."Minor Update"."Patch/Very Minor Update"
	 */
	public static final String VERSION = "V2.0.0";

	/**
	 * The release date of the current version of the library in the format of "YYYY/MM/DD".
	 */
	public static final String RELEASE_DATE = "2026/04/27";

	/**
	 * The contributors to the library (Thank you to everyone who has contributed!)
	 */
	public static final String[] CONTRIBUTORS = {"SRG (Some Random Gamer)"};

	/**
	 * The current build of the library.
	 * @see <a href="https://en.wikipedia.org/wiki/Software_build">Software build</a>
	 */
	public static final String BUILD = String.format("ujt-%s-%s-%s", VERSION, RELEASE_DATE, MINIMUM_JAVA_VERSION);

	/**
	 * Copyright 2026 SRG (Some Random Gamer)
	 * <br><br>
	 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
	 * <br><br>
	 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
	 * <br><br>
	 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
	 * @see <a href="https://en.wikipedia.org/wiki/MIT_License">MIT License</a>
	 */
	public static final String LICENSE = """
	Copyright 2026 SRG (Some Random Gamer)

	Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
	""";

	/**
	 * Checks if the current Java version is supported by this library.
	 * <p>
	 * This is provided for callers that want to fail fast at startup with a clear
	 * message. The JVM itself will already throw {@link UnsupportedClassVersionError}
	 * automatically if the bytecode is too new, so calling this from every class is
	 * unnecessary.
	 * @throws UnsupportedClassVersionError If the current Java version is not supported.
	 */
	public static void checkJavaVersion() {
		String version = System.getProperty("java.specification.version");
		int parsed;
		if (version.startsWith("1.")) {
			parsed = Integer.parseInt(version.substring(2));
		} else {
			parsed = Integer.parseInt(version);
		}
		if (parsed < MINIMUM_JAVA_VERSION) {
			throw new UnsupportedClassVersionError(
				"This application requires Java " + MINIMUM_JAVA_VERSION + " or higher. Current version: " + parsed
			);
		}
	}

	/**
	 * Waits for a specified amount of time.
	 * @param x The amount of time to wait in seconds.
	 * @return Whether or not the wait was successful.
	 */
	public static boolean sleep(double x) {
		try {
			Thread.sleep((long)(x * 1000));
			return true;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return false;
		}
	}

	/**
	 * Measures the execution time of 1 or more methods.
	 * @param methods The method(s) to measure the execution time of.
	 * @return The execution time in nanoseconds.
	 */
	public static long executionTime(Runnable... methods) {
		long startTime = System.nanoTime();
		for (Runnable m : methods) {
			m.run();
		}
		return System.nanoTime() - startTime;
	}

	/**
	 * Measures the execution time of 1 or more methods over a specified number of iterations.
	 * @param iterations The number of iterations to run the method(s) for.
	 * @param method The method(s) to measure the execution time of.
	 * @return The execution time in nanoseconds.
	 */
	public static long executionTime(int iterations, Runnable... method) {
		long startTime = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			for (Runnable m : method) {
				m.run();
			}
		}
		return System.nanoTime() - startTime;
	}
}
