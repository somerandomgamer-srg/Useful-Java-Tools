package ujt;

/**
	* Provides methods for string manipulation.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/String_(computer_science)">String</a>
	* @see <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein distance</a>
	* @see <a href="https://en.wikipedia.org/wiki/Title_case">Title Case</a>
	* @see <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a>
	* @see <a href="https://en.wikipedia.org/wiki/Line_wrapping">Line wrapping</a>
	* @see <a href="https://en.wikipedia.org/wiki/Masking_(computing)">Masking</a>
	* @see <a href="https://en.wikipedia.org/wiki/Padding_(data)">Padding</a>
*/
public class StringUtils {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
		* @param s The string to capitalize.
		* @return The capitalized string.
	*/
	public static String capitalize(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
		* @param s The string to reverse.
		* @return The reversed string.
	*/
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	/**
		* @param s The string to check.
		* @param strToCheck The string to check for in the string `s`.
		* @return The amount of times the string `strToCheck` appears in the string `s`.
	*/
	public static long count(String s, String strToCheck) {
		if (strToCheck.isEmpty()) {
			return 0;
		}
		int count = 0;
		int index = 0;
		while ((index = s.indexOf(strToCheck, index)) != -1) {
			count++;
			index += strToCheck.length();
		}
		return count;
	}

	/**
		* @param str The string to wrap.
		* @param length The maximum amount of characters per line.
		* @return The wrapped string.
		* @see <a href="https://en.wikipedia.org/wiki/Line_wrapping">Line wrapping</a>
	*/
	public static String wrap(String str, int length) {
		String[] words = str.split("\\s+");
		StringBuilder wrapped = new StringBuilder();
		StringBuilder line = new StringBuilder();

		for (String word : words) {
			if (line.length() > 0) {
				if (line.length() + word.length() + 1 > length) {
					wrapped.append(line).append("\n");
					line.setLength(0);
					line.append(word);
				} else {
					line.append(" ").append(word);
				}
			} else {
				line.append(word);
			}
		}

		wrapped.append(line);
		return wrapped.toString();
	}

	/**
		* @param str The string to mask.
		* @param maskChar The character to mask the string with.
		* @param startCharactersVisible The amount of characters to leave visible at the start of the string.
		* @param endCharactersVisible The amount of characters to leave visible at the end of the string.
		* @return The masked string.
		* @see <a href="https://en.wikipedia.org/wiki/Masking_(computing)">Masking</a>
	*/
	public static String mask(String str, String maskChar, int startCharactersVisible, int endCharactersVisible) {
		int len = str.length();

		if (endCharactersVisible > len) {
			endCharactersVisible = len;
		}

		if (startCharactersVisible > len) {
			startCharactersVisible = len;
		}

		return str.substring(0, startCharactersVisible) + maskChar.repeat(len - startCharactersVisible - endCharactersVisible) + str.substring(len - endCharactersVisible);
	}

	/**
		* @param str The string to pad.
		* @param character The character to pad the string with.
		* @param length The amount of characters to pad the string with.
		* @param includeStart Whether or not to pad the start of the string.
		* @param includeEnd Whether or not to pad the end of the string.
		* @return The padded string.
		* @see <a href="https://en.wikipedia.org/wiki/Padding_(data)">Padding</a>
	*/
	public static String pad(String str, String character, int length, boolean includeStart, boolean includeEnd) {
		StringBuilder result = new StringBuilder();
		if (includeStart) {
			result.append(character.repeat(length));
		}
		result.append(str);
		if (includeEnd) {
			result.append(character.repeat(length));
		}

		return result.toString();
	}

	/**
		* @param str The string to check.
		* @return Whether or not the string is a palindrome.
		* @see <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a>
	*/
	public static boolean isPalindrome(String str) {
		return reverse(str).equalsIgnoreCase(str);
	}

	/**
		* @param str The string to check.
		* @param caseSensitive Whether or not the check should be case sensitive.
		* @return Whether or not the string is a palindrome.
		* @see <a href="https://en.wikipedia.org/wiki/Palindrome">Palindrome</a>
	*/
	public static boolean isPalindrome(String str, Boolean caseSensitive) {
		if (caseSensitive) {
			return reverse(str).equals(str);
		}
		return reverse(str).equalsIgnoreCase(str);
	}

	/**
		* @param s1 The first string to compare.
		* @param s2 The second string to compare.
		* @return The Levenshtein distance between the two strings.
		* @see <a href="https://en.wikipedia.org/wiki/Levenshtein_distance">Levenshtein distance</a>
	*/
	public static long levenshtein(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
				dp[i][j] = Math.min(
					dp[i - 1][j] + 1,
					Math.min(
						dp[i][j - 1] + 1,
						dp[i - 1][j - 1] + cost
					)
				);
			}
		}

		return dp[len1][len2];
	}

	/**
		* @param str The string to convert to Title Case.
		* @return The string in Title Case.
		* @see <a href="https://en.wikipedia.org/wiki/Title_case">Title Case</a>
	*/
	public static String titleCase(String str) {
		String[] words = str.split("\\s+");
		StringBuilder title = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			if (i > 0) {
				title.append(" ");
			}
			title.append(capitalize(words[i]));
		}

		return title.toString();
	}

	/**
		* @param str The string to convert to Title Case.
		* @param sep The separator to detect words with.
		* @return The string in Title Case.
		* @see <a href="https://en.wikipedia.org/wiki/Title_case">Title Case</a>
	*/
	public static String titleCase(String str, String sep) {
		String[] words = str.split(java.util.regex.Pattern.quote(sep));
		StringBuilder title = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			if (i > 0) {
				title.append(sep);
			}
			title.append(capitalize(words[i]));
		}

		return title.toString();
	}
}
