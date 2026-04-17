package UsefulJavaTools;

import java.util.Scanner;
import java.util.Map;

/**
	* Provides methods for terminal manipulation.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">ANSI escape code</a>
*/
public class Terminal {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	private static Scanner scan = new Scanner(System.in);

	/**
		* A map of terminal styles to their ANSI codes.
		* @see <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">ANSI escape code</a>
	*/
	public static Map<String, Integer> terminalStyles = Map.ofEntries(
		Map.entry("bold", 1),
		Map.entry("italic", 3),
		Map.entry("underline", 4),
		Map.entry("strikethrough", 9),
		Map.entry("text black", 30),
		Map.entry("text red", 31),
		Map.entry("text green", 32),
		Map.entry("text yellow", 33),
		Map.entry("text blue", 34),
		Map.entry("text magenta", 35),
		Map.entry("text cyan", 36),
		Map.entry("text white", 37),
		Map.entry("background black", 40),
		Map.entry("background red", 41),
		Map.entry("background green", 42),
		Map.entry("background yellow", 43),
		Map.entry("background blue", 44),
		Map.entry("background magenta", 45),
		Map.entry("background cyan", 46),
		Map.entry("background white", 47),
		Map.entry("overline", 53)
	);

	/**
		* Returns a colored string that can be printed to the terminal. 
		* @param r The red value of the color.
		* @param g The green value of the color.
		* @param b The blue value of the color.
		* @param s The string to be colored.
		* @return The colored string, ready for printing.
	*/
	public static String color(int r, int g, int b, String s) {
		return String.format("\u001B[38;2;%d;%d;%dm%s\u001B[0m", r, g, b, s);
	}

	/**
		* Returns a colored string that can be printed to the terminal. 
		* @param r The red value of the color.
		* @param g The green value of the color.
		* @param b The blue value of the color.
		* @param i The integer to be colored.
		* @return The colored string, ready for printing.
	*/
	public static String color(int r, int g, int b, int i) {
		return color(r, g, b, Integer.toString(i));
	}

	/**
		* Returns a colored string that can be printed to the terminal. 
		* @param r The red value of the color.
		* @param g The green value of the color.
		* @param b The blue value of the color.
		* @param d The double to be colored.
		* @return The colored string, ready for printing.
	*/
	public static String color(int r, int g, int b, double d) {
		return color(r, g, b, Double.toString(d));
	}

	/**
		* Returns a colored string that can be printed to the terminal. 
		* @param r The red value of the color.
		* @param g The green value of the color.
		* @param b The blue value of the color.
		* @param l The long to be colored.
		* @return The colored string, ready for printing.
	*/
	public static String color(int r, int g, int b, long l) {
		return color(r, g, b, Long.toString(l));
	}

	/**
		* Returns a colored string that can be printed to the terminal.
		* @param r The red value of the color.
		* @param g The green value of the color.
		* @param b The blue value of the color.
		* @param f The float to be colored.
		* @return The colored string, ready for printing.
	*/
	public static String color(int r, int g, int b, float f) {
		return color(r, g, b, Float.toString(f));
	}

	/**
		* Returns a colored string that can be printed to the terminal. 
		* @param r The red value of the color.
		* @param g The green value of the color.
		* @param b The blue value of the color.
		* @param bool The boolean to be colored.
		* @return The colored string, ready for printing.
	*/
	public static String color(int r, int g, int b, boolean bool) {
		return color(r, g, b, Boolean.toString(bool));
	}

	/**
		* @param prompt The prompt to display to the user.
		* @return The string input by the user.
	*/
	public static String strInput(String prompt) {
		try {
			System.out.println(prompt);
			System.out.print("> ");
			return scan.nextLine();
		} catch (Exception e) {
			System.out.println("Error: " + e);
			return strInput(prompt);
		}
	}

	/**
		* To add the error to your custom error message, put {e} in the error message.
		* <br><br>
		* For example:
		* strInput("Enter a number", "This is a custom error. {e} was your error.")
		* @param prompt The prompt to display to the user.
		* @param errorMessage The custom error message to display if the user enters an invalid input.
		* @return The string input by the user.
	*/
	public static String strInput(String prompt, String errorMessage) {
		try {
			System.out.println(prompt);
			System.out.print("> ");
			return scan.nextLine();
		} catch (Exception e) {
			System.out.println(errorMessage.replace("{e}", e.toString()));
			return strInput(prompt);
		}
	}

	/**
		* @param prompt The prompt to display to the user.
		* @return The integer input by the user.
	*/
	public static int intInput(String prompt) {
		String n = strInput(prompt);
		try {
			return Integer.parseInt(n);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Please enter an integer. You entered: " + n);
			return intInput(prompt);
		}
	}

	/**
		* To add the error to your custom error message, put {e} in the error message.
		* <br><br>
		* For example:
		* intInput("Enter a number", "This is a custom error. {e} was your error.")
		* @param prompt The prompt to display to the user.
		* @param errorMessage The custom error message to display if the user enters an invalid input.
		* @return The integer input by the user.
	*/
	public static int intInput(String prompt, String errorMessage) {
		String n = strInput(prompt);
		try {
			return Integer.parseInt(n);
		} catch (Exception e) {
			System.out.println(errorMessage.replace("{e}", e.toString()));
			return intInput(prompt);
		}
	}

	/**
		* @param prompt The prompt to display to the user.
		* @return The double input by the user.
	*/
	public static double dubInput(String prompt) {
		String n = strInput(prompt);
		try {
			return Double.parseDouble(n);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Please enter a double. You entered: " + n);
			return dubInput(prompt);
		}
	}

	/**
		* To add the error to your custom error message, put {e} in the error message.
		* <br><br>
		* For example:
		* dubInput("Enter a number", "This is a custom error. {e} was your error.")
		* @param prompt The prompt to display to the user.
		* @param errorMessage The custom error message to display if the user enters an invalid input.
		* @return The double input by the user.
	*/
	public static double dubInput(String prompt, String errorMessage) {
		String n = strInput(prompt);
		try {
			return Double.parseDouble(n);
		} catch (Exception e) {
			System.out.println(errorMessage.replace("{e}", e.toString()));
			return dubInput(prompt);
		}
	}

	/**
		* @param prompt The prompt to display to the user.
		* @return The long input by the user.
	*/
	public static long longInput(String prompt) {
		String n = strInput(prompt);
		try {
			return Long.parseLong(n);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Please enter a long. You entered: " + n);
			return longInput(prompt);
		}
	}

	/**
		* To add the error to your custom error message, put {e} in the error message.
		* <br><br>
		* For example:
		* longInput("Enter a number", "This is a custom error. {e} was your error.")
		* @param prompt The prompt to display to the user.
		* @param errorMessage The custom error message to display if the user enters an invalid input.
		* @return The long input by the user.
	*/
	public static long longInput(String prompt, String errorMessage) {
		String n = strInput(prompt);
		try {
			return Long.parseLong(n);
		} catch (Exception e) {
			System.out.println(errorMessage.replace("{e}", e.toString()));
			return longInput(prompt);
		}
	}

	/**
		* @param prompt The prompt to display to the user.
		* @return The float input by the user.
	*/
	public static float floatInput(String prompt) {
		String n = strInput(prompt);
		try {
			return Float.parseFloat(n);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Please enter a float. You entered: " + n);
			return floatInput(prompt);
		}
	}

	/**
		* To add the error to your custom error message, put {e} in the error message.
		* <br><br>
		* For example:
		* floatInput("Enter a number", "This is a custom error. {e} was your error.")
		* @param prompt The prompt to display to the user.
		* @param errorMessage The custom error message to display if the user enters an invalid input.
		* @return The float input by the user.
	*/
	public static float floatInput(String prompt, String errorMessage) {
		String n = strInput(prompt);
		try {
			return Float.parseFloat(n);
		} catch (Exception e) {
			System.out.println(errorMessage.replace("{e}", e.toString()));
			return floatInput(prompt);
		}
	}

	/**
		* @param min The minimum double value the user can enter.
		* @param max The maximum double value the user can enter.
		* @param prompt The prompt to display to the user.
		* @return The double input by the user.
	*/
	public static double loopVerifyRange(double min, double max, String prompt) {
		while (true) {
			double v = dubInput(prompt);

			if (min <= v && max >= v) {
				return v;
			} else {
				System.out.println(String.format("Please enter a value between %.1f and %.1f. You entered: %.1f", min, max, v));
			}
		}
	}

	/**
		* @param min The minimum integer value the user can enter.
		* @param max The maximum integer value the user can enter.
		* @param prompt The prompt to display to the user.
		* @return The integer input by the user.
	*/
	public static double loopVerifyRange(int min, int max, String prompt) {
		while (true) {
			int v = intInput(prompt);

			if (min <= v && max >= v) {
				return v;
			} else {
				System.out.println(String.format("Please enter a value between %d and %d. You entered: %d", min, max, v));
			}
		}
	}

	/**
		* @param min The minimum long value the user can enter.
		* @param max The maximum long value the user can enter.
		* @param prompt The prompt to display to the user.
		* @return The long input by the user.
	*/
	public static double loopVerifyRange(long min, long max, String prompt) {
		while (true) {
			long v = longInput(prompt);

			if (min <= v && max >= v) {
				return v;
			} else {
				System.out.println(String.format("Please enter a value between %d and %d. You entered: %d", min, max, v));
			}
		}
	}

	/**
		* @param min The minimum float value the user can enter.
		* @param max The maximum float value the user can enter.
		* @param prompt The prompt to display to the user.
		* @return The float input by the user.
	*/
	public static double loopVerifyRange(float min, float max, String prompt) {
		while (true) {
			float v = floatInput(prompt);

			if (min <= v && max >= v) {
				return v;
			} else {
				System.out.println(String.format("Please enter a value between %.1f and %.1f. You entered: %.1f", min, max, v));
			}
		}
	}

	/**
		* @param prompt The prompt to display to the user.
		* @return The boolean input by the user.
	*/
	public static boolean loopVerifyBool(String prompt) {
		while (true) {
			String s = strInput(prompt + " (type 'y' for yes and 'n' for no)");

			if (s.toLowerCase().equals("y")) {
				return true;
			} else if (s.toLowerCase().equals("n")) {
				return false;
			} else {
				System.out.println("Please type 'y' or 'n'.");
			}
		}
	}

	/**
		* @param option1 The first option the user can enter.
		* @param option2 The second option the user can enter.
		* @param prompt The prompt to display to the user.
		* @return The string input by the user.
	*/
	public static String loopVerifyString(String option1, String option2, String prompt) {
		while (true) {
			String s = strInput(prompt + String.format(" (type either '%s' or '%s')", option1, option2));

			if (s.toLowerCase().equals(option1)) {
				return option1;
			} else if (s.toLowerCase().equals(option2)) {
				return option2;
			} else {
				System.out.println(String.format("Please type '%s' or '%s'.", option1, option2));
			}
		}
	}

	/**
		* @param min The minimum length of the string the user can enter.
		* @param max The maximum length of the string the user can enter.
		* @param prompt The prompt to display to the user.
		* @return The string input by the user.
	*/
	public static String loopVerifyStringRange(double min, double max, String s) {
		while (true) {
			String v = strInput(s + String.format("(%.0f-%.0f characters)", min, max));

			if (min <= v.length() && max >= v.length()) {
				return v;
			} else {
				System.out.println(String.format(
					"Please enter a string with a length between %.0f and %.0f. You entered: %s (%d characters)",
					min, max, v, v.length()
				));
			}
		}
	}

	/**
		* Available styles:
		* <ul>
		*       <li>"bold"</li>
		*       <li>"italic"</li>
		*       <li>"underline"</li>
		*       <li>"strikethrough"</li>
		*       <li>"text black"</li>
		*       <li>"text red"</li>
		*       <li>"text green"</li>
		*       <li>"text yellow"</li>
		*       <li>"text blue"</li>
		*       <li>"text magenta"</li>
		*       <li>"text cyan"</li>
		*       <li>"text white"</li>
		*       <li>"background black"</li>
		*       <li>"background red"</li>
		*       <li>"background green"</li>
		*       <li>"background yellow"</li>
		*       <li>"background blue"</li>
		*       <li>"background magenta"</li>
		*       <li>"background cyan"</li>
		*       <li>"background white"</li>
		*       <li>"overline"</li>
		* </ul>
		* You can use multiple styles at once by passing an array of styles.
		* @param str The string to style.
		* @param options The styles to apply to the string.
		* @return The styled string.
		* @throws IllegalArgumentException If a style is invalid.
	*/
	public static String terminalStyle(String str, String[] options) {
		StringBuilder styled = new StringBuilder("\033[");

		for (String style : options) {
			if (!terminalStyles.containsKey(style)) {
				throw new IllegalArgumentException("Invalid style: " + style);
			}

			styled.append(terminalStyles.get(style)).append(";");
		}

		styled.setLength(styled.length() - 1);
		styled.append("m").append(str).append("\033[0m");
		return styled.toString();
	}

	/**
		* Available styles:
		* <ul>
		*       <li>"bold"</li>
		*       <li>"italic"</li>
		*       <li>"underline"</li>
		*       <li>"strikethrough"</li>
		*       <li>"text black"</li>
		*       <li>"text red"</li>
		*       <li>"text green"</li>
		*       <li>"text yellow"</li>
		*       <li>"text blue"</li>
		*       <li>"text magenta"</li>
		*       <li>"text cyan"</li>
		*       <li>"text white"</li>
		*       <li>"background black"</li>
		*       <li>"background red"</li>
		*       <li>"background green"</li>
		*       <li>"background yellow"</li>
		*       <li>"background blue"</li>
		*       <li>"background magenta"</li>
		*       <li>"background cyan"</li>
		*       <li>"background white"</li>
		*       <li>"overline"</li>
		* </ul>
		* You can use multiple styles at once by passing an array of styles.
		* @param str The string to style.
		* @param style The style to apply to the string.
		* @return The styled string.
		* @throws IllegalArgumentException If the style is invalid.
	*/
	public static String terminalStyle(String str, String style) {
		if (!terminalStyles.containsKey(style)) {
			throw new IllegalArgumentException("Invalid style: " + style);
		}

		return "\033[" + terminalStyles.get(style) + "m" + str + "\033[0m";
	}

	/**
		* Clears the terminal.
	*/
	public static void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	} 
}
