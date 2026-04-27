package ujt;

/**
 * Provides methods for validating strings.
 * @version 1.0.0
 */
public class Validate {
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
	 * Validates an IPv4 or IPv6 address using regex pattern matching (no DNS lookup).
	 * @param ip The IP to validate.
	 * @return Whether or not the IP is valid.
	 */
	public static boolean isValidIP(String ip) {
		if (ip == null) return false;
		String ipv4 = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		String ipv6 = "^([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}$";
		return ip.matches(ipv4) || ip.matches(ipv6);
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
