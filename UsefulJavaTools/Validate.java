package UsefulJavaTools;

/**
	* Provides methods for validating strings.
	* @version 1.0.0
*/
public class Validate {
	static {
		Ujt.checkJavaVersion();
	}

	/**
		* Validates an email address using a regex pattern.
		* @param email The email to validate.
		* @return Whether or not the email matches a valid email format.
	*/
	public static boolean isValidEmail(String email) {
		return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	}

	/**
		* @param url The URL to validate.
		* @return Whether or not the URL is valid.
	*/
	public static boolean isValidURL(String url) {
		try {
			new java.net.URL(url).toURI();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
		* @param ip The IP to validate.
		* @return Whether or not the IP is valid.
	*/
	public static boolean isValidIP(String ip) {
		try {
			return java.net.InetAddress.getByName(ip) != null;
		} catch (Exception e) {
			return false;
		}
	}

	/**
		* @param port The port to validate.
		* @return Whether or not the port is valid.
	*/
	public static boolean isValidPort(int port) {
		return port >= 0 && port <= 65535;
	}

	/**
		* @param mac The MAC address to validate.
		* @return Whether or not the MAC address is valid.
	*/
	public static boolean isValidMAC(String mac) {
		return mac != null && mac.matches("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
	}
}
