package ujt;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Provides methods for working with regular expressions.
 * @version 1.0.0
 * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
 * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html">java.util.regex.Pattern</a>
 */
public class RegexUtils {
  static {
    Ujt.ujtCheckJavaVersion();
  }

  /**
   * Tests whether the entire input string matches the given pattern.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return {@code true} if the whole string matches the pattern. Returns {@code false} for null inputs or invalid patterns.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static boolean matches(String str, String pattern) {
    if (str == null || pattern == null) {
			return false;
		}
    try {
      return Pattern.compile(pattern).matcher(str).matches();
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while matching the pattern: " + e.getMessage());
      return false;
    }
  }

  /**
   * Tests whether the pattern is found anywhere in the input string.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return {@code true} if at least one match exists in the string. Returns {@code false} for null inputs or invalid patterns.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static boolean contains(String str, String pattern) {
    if (str == null || pattern == null) {
			return false;
		}
    try {
      return Pattern.compile(pattern).matcher(str).find();
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while searching for the pattern: " + e.getMessage());
      return false;
    }
  }

  /**
   * Returns the first substring of the input that matches the pattern.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return The first matching substring, or {@code null} if no match was found or an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String findFirst(String str, String pattern) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      Matcher m = Pattern.compile(pattern).matcher(str);
      return m.find() ? m.group() : null;
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while searching for the pattern: " + e.getMessage());
      return null;
    }
  }

  /**
   * Returns every substring of the input that matches the pattern.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return A list of all matching substrings (empty if there are none), or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static List<String> findAll(String str, String pattern) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      List<String> matches = new ArrayList<>();
      Matcher m = Pattern.compile(pattern).matcher(str);
      while (m.find()) {
        matches.add(m.group());
      }
      return matches;
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while searching for the pattern: " + e.getMessage());
      return null;
    }
  }

  /**
   * Counts how many times the pattern occurs in the input string.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return The number of (non-overlapping) matches, or {@code -1} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static int count(String str, String pattern) {
    if (str == null || pattern == null) {
			return -1;
		}
    try {
      Matcher m = Pattern.compile(pattern).matcher(str);
      int n = 0;
      while (m.find()) {
        n++;
      }
      return n;
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while counting matches: " + e.getMessage());
      return -1;
    }
  }

  /**
   * Replaces every match of the pattern in the input string with the given replacement.
   * The replacement string follows {@link Matcher#replaceAll} rules ({@code $0}, {@code $1}, ... refer to capture groups).
   * @param str The input string.
   * @param pattern The regular expression.
   * @param replacement The replacement string.
   * @return The resulting string, or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String replaceAll(String str, String pattern, String replacement) {
    if (str == null || pattern == null || replacement == null) {
			return null;
		}
    try {
      return Pattern.compile(pattern).matcher(str).replaceAll(replacement);
    } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
      System.err.println("An error occurred while replacing matches: " + e.getMessage());
      return null;
    }
  }

  /**
   * Replaces only the first match of the pattern in the input string with the given replacement.
   * @param str The input string.
   * @param pattern The regular expression.
   * @param replacement The replacement string.
   * @return The resulting string, or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String replaceFirst(String str, String pattern, String replacement) {
    if (str == null || pattern == null || replacement == null) {
			return null;
		}
    try {
      return Pattern.compile(pattern).matcher(str).replaceFirst(replacement);
    } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
      System.err.println("An error occurred while replacing the first match: " + e.getMessage());
      return null;
    }
  }

  /**
   * Removes every match of the pattern from the input string.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return The resulting string with all matches removed, or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String removeAll(String str, String pattern) {
    return replaceAll(str, pattern, "");
  }

  /**
   * Splits the input string around matches of the given pattern.
   * @param str The input string.
   * @param pattern The regular expression to use as the separator.
   * @return The array of substrings, or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String[] split(String str, String pattern) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      return Pattern.compile(pattern).split(str);
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while splitting the string: " + e.getMessage());
      return null;
    }
  }

  /**
   * Splits the input string around matches of the given pattern, up to a maximum number of pieces.
   * @param str The input string.
   * @param pattern The regular expression to use as the separator.
   * @param limit The maximum number of substrings to return. See {@link Pattern#split(CharSequence, int)} for the meaning of zero and negative values.
   * @return The array of substrings, or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String[] split(String str, String pattern, int limit) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      return Pattern.compile(pattern).split(str, limit);
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while splitting the string: " + e.getMessage());
      return null;
    }
  }

  /**
   * Returns the capture groups of the first match of the pattern in the input string.
   * Index {@code 0} is the entire match; subsequent indices are the numbered capture groups.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return The captured groups of the first match, or {@code null} if there is no match or an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String[] groups(String str, String pattern) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      Matcher m = Pattern.compile(pattern).matcher(str);
      if (!m.find()) {
				return null;
			}
      String[] g = new String[m.groupCount() + 1];
      for (int i = 0; i <= m.groupCount(); i++) {
        g[i] = m.group(i);
      }
      return g;
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while extracting groups: " + e.getMessage());
      return null;
    }
  }

  /**
   * Returns the capture groups for every match of the pattern in the input string.
   * Each element is an array where index {@code 0} is the entire match and subsequent indices are the numbered groups.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return A list of group arrays, one per match (empty if there are none), or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static List<String[]> allGroups(String str, String pattern) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      List<String[]> all = new ArrayList<>();
      Matcher m = Pattern.compile(pattern).matcher(str);
      while (m.find()) {
        String[] g = new String[m.groupCount() + 1];
        for (int i = 0; i <= m.groupCount(); i++) {
          g[i] = m.group(i);
        }
        all.add(g);
      }
      return all;
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while extracting groups: " + e.getMessage());
      return null;
    }
  }

  /**
   * Returns the value of a named capture group from the first match of the pattern in the input string.
   * @param str The input string.
   * @param pattern The regular expression containing a named group, e.g. {@code "(?<year>\\d{4})"}.
   * @param groupName The name of the capture group to extract.
   * @return The captured value, or {@code null} if there is no match, the group does not exist, or an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String namedGroup(String str, String pattern, String groupName) {
    if (str == null || pattern == null || groupName == null) {
			return null;
		}
    try {
      Matcher m = Pattern.compile(pattern).matcher(str);
      return m.find() ? m.group(groupName) : null;
    } catch (IllegalArgumentException e) {
      System.err.println("An error occurred while extracting the named group: " + e.getMessage());
      return null;
    }
  }

  /**
   * Returns a map of named capture groups to their values from the first match of the pattern in the input string.
   * Only groups that are explicitly named in the pattern (e.g. {@code "(?<year>\\d{4})"}) are included.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return A map of group names to captured values (empty if there is no match or no named groups), or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static Map<String, String> namedGroups(String str, String pattern) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      Map<String, String> out = new LinkedHashMap<>();
      Pattern p = Pattern.compile(pattern);
      Matcher m = p.matcher(str);
      if (!m.find()) {
				return out;
			}
      Matcher nameMatcher = Pattern.compile("\\(\\?<([a-zA-Z][a-zA-Z0-9]*)>").matcher(pattern);
      while (nameMatcher.find()) {
        String name = nameMatcher.group(1);
        try {
          out.put(name, m.group(name));
        } catch (IllegalArgumentException e) {
					
        }
      }
      return out;
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while extracting named groups: " + e.getMessage());
      return null;
    }
  }

  /**
   * Returns the start and end positions of every match of the pattern in the input string.
   * Each element is an {@code int[]} of length 2 where {@code [0]} is the inclusive start index
   * and {@code [1]} is the exclusive end index.
   * @param str The input string.
   * @param pattern The regular expression.
   * @return A list of position pairs (empty if there are no matches), or {@code null} if an error occurred.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static List<int[]> matchPositions(String str, String pattern) {
    if (str == null || pattern == null) {
			return null;
		}
    try {
      List<int[]> positions = new ArrayList<>();
      Matcher m = Pattern.compile(pattern).matcher(str);
      while (m.find()) {
        positions.add(new int[] { m.start(), m.end() });
      }
      return positions;
    } catch (PatternSyntaxException e) {
      System.err.println("An error occurred while finding match positions: " + e.getMessage());
      return null;
    }
  }

  /**
   * Escapes the given literal string so it can be safely used inside a regular expression
   * without its metacharacters being interpreted.
   * @param literal The literal string to escape.
   * @return The escaped pattern string (using {@code \Q...\E}), or {@code null} if {@code literal} is {@code null}.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String escape(String literal) {
    if (literal == null) {
			return null;
		}
    return Pattern.quote(literal);
  }

  /**
   * Escapes the given literal string so it can be safely used inside a replacement string
   * passed to {@link #replaceAll(String, String, String)} or {@link #replaceFirst(String, String, String)}.
   * Specifically, escapes {@code \} and {@code $}.
   * @param literal The literal replacement to escape.
   * @return The escaped replacement string, or {@code null} if {@code literal} is {@code null}.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static String escapeReplacement(String literal) {
    if (literal == null) {
			return null;
		}
    return Matcher.quoteReplacement(literal);
  }

  /**
   * Checks whether the given regular expression compiles successfully.
   * @param pattern The regular expression to test.
   * @return {@code true} if the pattern is syntactically valid.
   * @see <a href="https://en.wikipedia.org/wiki/Regular_expression">Regular expression</a>
   */
  public static boolean isValidPattern(String pattern) {
    if (pattern == null) {
			return false;
		}
    try {
      Pattern.compile(pattern);
      return true;
    } catch (PatternSyntaxException e) {
      return false;
    }
  }
}
