package UsefulJavaTools;

import java.lang.management.ManagementFactory;

/**
	* Provides access to Java Virtual Machine (JVM) runtime statistics and environment properties.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
*/
public class Jvm {
	static {
		Ujt.checkJavaVersion();
	}

	/**
		* The current working directory of the Java Virtual Machine.
		* @see <a href="https://en.wikipedia.org/wiki/Working_directory">Working directory</a>
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static String currentWorkingDirectory = System.getProperty("user.dir");

	/**
		* The version of the Java Runtime Environment currently in use.
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static String getJavaVersion = System.getProperty("java.version");

	/**
		* The installation directory of the Java Runtime Environment.
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static String javaHome = System.getProperty("java.home");

	/**
		* The vendor of the Java Runtime Environment (e.g., Oracle, Eclipse Adoptium).
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static String javaVendor = System.getProperty("java.vendor");

	/**
		* The maximum amount of memory the JVM will attempt to use, in bytes.
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static long maxMemory = Runtime.getRuntime().maxMemory();

	/**
		* The total amount of memory currently reserved by the JVM from the host OS, in bytes.
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static long totalMemory = Runtime.getRuntime().totalMemory();

	/**
		* The amount of reserved memory that is currently available for new objects, in bytes.
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static long freeMemory = Runtime.getRuntime().freeMemory();

	/**
		* The calculated amount of memory currently occupied by objects (Total - Free), in bytes.
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static long usedMemory = totalMemory - freeMemory;

	/**
		* Retrieves the total time the Java Virtual Machine has been running.
		* @return The uptime of the JVM in milliseconds.
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static long getJavaUptime() {
		return ManagementFactory.getRuntimeMXBean().getUptime();
	}

	/**
		* Retrieves the point in time when the Java Virtual Machine was started.
		* @return The start time of the JVM in milliseconds since the epoch (1970-01-01).
		* @see <a href="https://en.wikipedia.org/wiki/Java_(software_platform)#Java_Virtual_Machine">Java Virtual Machine</a>
	*/
	public static long getJavaStartTime() {
		return ManagementFactory.getRuntimeMXBean().getStartTime();
	}
}
