package UsefulJavaTools;

/**
	* Provides access to system runtime statistics and environment properties.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/Home_directory">Home directory</a>
	* @see <a href="https://en.wikipedia.org/wiki/CPU_architecture">CPU architecture</a>
	* @see <a href="https://en.wikipedia.org/wiki/Character_encoding">Character encoding</a>
*/
public class SystemInfo {
	static {
		Ujt.checkJavaVersion();
	}

	/**
		* The user's home directory.
		* @see <a href="https://en.wikipedia.org/wiki/Home_directory">Home directory</a>
	*/
	public static String userDirectory = System.getProperty("user.home");

	/** The user's timezone. */
	public static String timezone = System.getProperty("user.timezone").toLowerCase();

	/** The user's country. */
	public static String country = System.getProperty("user.country").toLowerCase();

	/** The user's language. */
	public static String language = System.getProperty("user.language").toLowerCase();

	/** The operating system name. */
	public static String OSName = System.getProperty("os.name").toLowerCase();

	/** The file separator character used by the operating system. */
	public static String fileSeparator = System.getProperty("file.separator");

	/** The path separator character used by the operating system. */
	public static String pathSeparator = System.getProperty("path.separator");

	/** The line separator character used by the operating system. */
	public static String lineSeparator = System.getProperty("line.separator");

	/** The operating system version. */
	public static String OSVersion = System.getProperty("os.version");

	/**
		* The CPU architecture.
		* @see <a href="https://en.wikipedia.org/wiki/CPU_architecture">CPU architecture</a>
	*/
	public static String OSArchitecture = System.getProperty("os.arch").toLowerCase();

	/**
		* The file encoding method used by the operating system.
		* @see <a href="https://en.wikipedia.org/wiki/Character_encoding">Character encoding</a>
	*/
	public static String fileEncoding = System.getProperty("file.encoding").toLowerCase();

	/** The number of processors available to the Java Virtual Machine. */
	public static int numOfCores = Runtime.getRuntime().availableProcessors();
}
