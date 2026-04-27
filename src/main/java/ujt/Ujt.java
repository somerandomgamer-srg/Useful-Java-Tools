package ujt;

/**
 * Provides access to the main methods of the library.
 * @version 1.0.0
 */
public class Ujt {
	/**
	 * The minimum Java version required to use this library.
	 */
	public static final int ujtMinimumJavaVersion = 17;

	/**
	 * Checks if the current Java version is supported by this library.
	 * @throws UnsupportedClassVersionError If the current Java version is not supported.
	 */
	public static void ujtCheckJavaVersion() {
		String version = System.getProperty("java.specification.version");
		if (version.startsWith("1.")) {
			if (Integer.parseInt(version.substring(2)) < ujtMinimumJavaVersion) {
				throw new UnsupportedClassVersionError(
					"This application requires Java " + ujtMinimumJavaVersion + " or higher. Current version: " + Integer.parseInt(version.substring(2)
				));
			}
		} else {
			if (Integer.parseInt(version) < ujtMinimumJavaVersion) {
				throw new UnsupportedClassVersionError(
					"This application requires Java " + ujtMinimumJavaVersion + " or higher. Current version: " + Integer.parseInt(version)
				);
			}
		}
	}

	static {
		ujtCheckJavaVersion();
	}

	/**
	 * The current version of the library.
	 * Format: V"Major Update"."Minor Update"."Patch/Very Minor Update"
	 */
	public static final String ujtVersion = "V1.0.0";

	/**
	 * The release date of the current version of the library in the format of "YYYY-MM-DD".
	 */
	public static final String ujtReleaseDate = "2026/04/16";

	/**
	 * The contributors to the library (Thank you to everyone who has contributed!)
	 */
	public static final String[] ujtContributors = {"SRG (Some Random Gamer)"};

	/**
	 * The current build of the library.
	 * @see <a href="https://en.wikipedia.org/wiki/Software_build">Software build</a>
	 */
	public static final String ujtBuild = String.format("ujt-%s-%s-%s", ujtVersion, ujtReleaseDate, ujtMinimumJavaVersion);

	/**
	 * Copyright 2026 SRG (Some Random Gamer)
	 * <br><br>
	 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
	 * <br><br>
	 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
	 * <br><br>
	 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
	 * <br><br>
	 * DISCLAIMERS:
	 * <br><br>
	 * <ol>
	 * 	<li>No Support Obligation: SRG is under no obligation to provide support, updates, or maintenance for this toolkit.</li>
	 * 	<li>No Liability for Data Loss: SRG is not responsible for any data loss or corruption that may occur from using this toolkit.</li>
	 * 	<li>Performance Considerations: The functions provided may not be optimized for all use cases or performance requirements.</li>
	 * 	<li>Security Disclaimer: While efforts have been made to implement secure functions, this toolkit should not be used for critical security applications without thorough review and testing.</li>
	 * 	<li>Compatibility: The toolkit may not be compatible with all Java versions or implementations. Users should verify compatibility with their specific environment.</li>
	 * 	<li>Resource Usage: Some functions may consume significant computational resources depending on input size and complexity. Users should test performance with their specific use cases.</li>
	 * 	<li>Documentation Accuracy: While efforts are made to maintain accurate documentation, there may be discrepancies between documentation and actual functionality.</li>
	 * 	<li>Third-Party Dependencies: Any issues arising from the use of third-party dependencies or libraries are not the responsibility of SRG.</li>
	 * 	<li>Breaking Changes: Future updates may include breaking changes that could affect existing implementations.</li>
	 * 	<li>User Responsibility: Users are responsible for testing and validating the functions for their specific use cases before implementing them in production environments.</li>
	 * </ol>
	 * @see <a href="https://en.wikipedia.org/wiki/MIT_License">MIT License</a>
	 */
	public static final String ujtLicense = """
	Copyright 2026 SRG (Some Random Gamer)

	Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

	DISCLAIMERS:

	1. No Support Obligation: SRG is under no obligation to provide support, updates, or maintenance for this toolkit.

	2. No Liability for Data Loss: SRG is not responsible for any data loss or corruption that may occur from using this toolkit.

	3. Performance Considerations: The functions provided may not be optimized for all use cases or performance requirements.

	4. Security Disclaimer: While efforts have been made to implement secure functions, this toolkit should not be used for critical security applications without thorough review and testing.

	5. Compatibility: The toolkit may not be compatible with all Java versions or implementations. Users should verify compatibility with their specific environment.

	6. Resource Usage: Some functions may consume significant computational resources depending on input size and complexity. Users should test performance with their specific use cases.

	7. Documentation Accuracy: While efforts are made to maintain accurate documentation, there may be discrepancies between documentation and actual functionality.

	8. Third-Party Dependencies: Any issues arising from the use of third-party dependencies or libraries are not the responsibility of SRG.

	9. Breaking Changes: Future updates may include breaking changes that could affect existing implementations.

	10. User Responsibility: Users are responsible for testing and validating the functions for their specific use cases before implementing them in production environments.
	""";

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
