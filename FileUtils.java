package UsefulJavaTools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
	* Provides methods for date and time operations using the Java {@code java.time} API.
	* @version 1.0.0
	* @see <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>
	* @see <a href="https://en.wikipedia.org/wiki/Unix_time">Unix time</a>
	* @see <a href="https://en.wikipedia.org/wiki/Leap_year">Leap year</a>
	* @see <a href="https://en.wikipedia.org/wiki/Time_zone">Time zone</a>
*/
public class DateUtils {
	static {
		Ujt.ujtCheckJavaVersion();
	}

	/**
		* @return Today's date as a {@link LocalDate}.
	*/
	public static LocalDate today() {
		return LocalDate.now();
	}

	/**
		* @return The current date and time as a {@link LocalDateTime}.
	*/
	public static LocalDateTime now() {
		return LocalDateTime.now();
	}

	/**
		* Formats a {@link LocalDate} using the given pattern.
		* @param d The date to format.
		* @param pattern The pattern to use (e.g. {@code "yyyy-MM-dd"}, {@code "MM/dd/yyyy"}).
		* @return The formatted date string.
		* @see <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>
	*/
	public static String format(LocalDate d, String pattern) {
		return d.format(DateTimeFormatter.ofPattern(pattern));
	}

	/**
		* Formats a {@link LocalDateTime} using the given pattern.
		* @param dt The date-time to format.
		* @param pattern The pattern to use (e.g. {@code "yyyy-MM-dd HH:mm:ss"}).
		* @return The formatted date-time string.
		* @see <a href="https://en.wikipedia.org/wiki/ISO_8601">ISO 8601</a>
	*/
	public static String format(LocalDateTime dt, String pattern) {
		return dt.format(DateTimeFormatter.ofPattern(pattern));
	}

	/**
		* Parses a date string into a {@link LocalDate} using the given pattern.
		* @param dateStr The date string to parse.
		* @param pattern The pattern to parse with (e.g. {@code "yyyy-MM-dd"}).
		* @return The parsed {@link LocalDate}.
	*/
	public static LocalDate parse(String dateStr, String pattern) {
		return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
	}

	/**
		* Parses a date-time string into a {@link LocalDateTime} using the given pattern.
		* @param dateTimeStr The date-time string to parse.
		* @param pattern The pattern to parse with (e.g. {@code "yyyy-MM-dd HH:mm:ss"}).
		* @return The parsed {@link LocalDateTime}.
	*/
	public static LocalDateTime parseDateTime(String dateTimeStr, String pattern) {
		return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
	}

	/**
		* Returns the number of days between two dates. The result is negative if {@code from} is after {@code to}.
		* @param from The start date.
		* @param to The end date.
		* @return The number of days between the two dates.
	*/
	public static long daysBetween(LocalDate from, LocalDate to) {
		return ChronoUnit.DAYS.between(from, to);
	}

	/**
		* Returns the number of whole months between two dates. The result is negative if {@code from} is after {@code to}.
		* @param from The start date.
		* @param to The end date.
		* @return The number of whole months between the two dates.
	*/
	public static long monthsBetween(LocalDate from, LocalDate to) {
		return ChronoUnit.MONTHS.between(from, to);
	}

	/**
		* Returns the number of whole years between two dates. The result is negative if {@code from} is after {@code to}.
		* @param from The start date.
		* @param to The end date.
		* @return The number of whole years between the two dates.
	*/
	public static long yearsBetween(LocalDate from, LocalDate to) {
		return ChronoUnit.YEARS.between(from, to);
	}

	/**
		* Adds a number of days to a date.
		* @param d The base date.
		* @param days The number of days to add.
		* @return The resulting {@link LocalDate}.
	*/
	public static LocalDate addDays(LocalDate d, long days) {
		return d.plusDays(days);
	}

	/**
		* Adds a number of months to a date.
		* @param d The base date.
		* @param months The number of months to add.
		* @return The resulting {@link LocalDate}.
	*/
	public static LocalDate addMonths(LocalDate d, long months) {
		return d.plusMonths(months);
	}

	/**
		* Adds a number of years to a date.
		* @param d The base date.
		* @param years The number of years to add.
		* @return The resulting {@link LocalDate}.
	*/
	public static LocalDate addYears(LocalDate d, long years) {
		return d.plusYears(years);
	}

	/**
		* Subtracts a number of days from a date.
		* @param d The base date.
		* @param days The number of days to subtract.
		* @return The resulting {@link LocalDate}.
	*/
	public static LocalDate subtractDays(LocalDate d, long days) {
		return d.minusDays(days);
	}

	/**
		* Subtracts a number of months from a date.
		* @param d The base date.
		* @param months The number of months to subtract.
		* @return The resulting {@link LocalDate}.
	*/
	public static LocalDate subtractMonths(LocalDate d, long months) {
		return d.minusMonths(months);
	}

	/**
		* Subtracts a number of years from a date.
		* @param d The base date.
		* @param years The number of years to subtract.
		* @return The resulting {@link LocalDate}.
	*/
	public static LocalDate subtractYears(LocalDate d, long years) {
		return d.minusYears(years);
	}

	/**
		* Checks whether a date is in the past (before today).
		* @param d The date to check.
		* @return {@code true} if the date is before today.
	*/
	public static boolean isPast(LocalDate d) {
		return d.isBefore(LocalDate.now());
	}

	/**
		* Checks whether a date is in the future (after today).
		* @param d The date to check.
		* @return {@code true} if the date is after today.
	*/
	public static boolean isFuture(LocalDate d) {
		return d.isAfter(LocalDate.now());
	}

	/**
		* Checks whether a date is today.
		* @param d The date to check.
		* @return {@code true} if the date equals today's date.
	*/
	public static boolean isToday(LocalDate d) {
		return d.isEqual(LocalDate.now());
	}

	/**
		* Checks whether a given year is a leap year.
		* @param year The year to check.
		* @return {@code true} if the year is a leap year.
		* @see <a href="https://en.wikipedia.org/wiki/Leap_year">Leap year</a>
	*/
	public static boolean isLeapYear(int year) {
		return LocalDate.of(year, 1, 1).isLeapYear();
	}

	/**
		* Returns the date of the Monday of the week containing the given date.
		* @param d The date to find the start of week for.
		* @return The {@link LocalDate} of the Monday of that week.
	*/
	public static LocalDate startOfWeek(LocalDate d) {
		return d.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);
	}

	/**
		* Returns the date of the Sunday of the week containing the given date.
		* @param d The date to find the end of week for.
		* @return The {@link LocalDate} of the Sunday of that week.
	*/
	public static LocalDate endOfWeek(LocalDate d) {
		return d.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 7);
	}

	/**
		* Returns the first day of the month for the given date.
		* @param d The date to find the start of month for.
		* @return The {@link LocalDate} of the first day of that month.
	*/
	public static LocalDate startOfMonth(LocalDate d) {
		return d.withDayOfMonth(1);
	}

	/**
		* Returns the last day of the month for the given date.
		* @param d The date to find the end of month for.
		* @return The {@link LocalDate} of the last day of that month.
	*/
	public static LocalDate endOfMonth(LocalDate d) {
		return d.withDayOfMonth(d.lengthOfMonth());
	}

	/**
		* Returns the full name of the day of the week for the given date (e.g. {@code "Monday"}).
		* @param d The date to get the day of week for.
		* @return The name of the day of the week.
	*/
	public static String dayOfWeek(LocalDate d) {
		return d.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault());
	}

	/**
		* Returns the day of the year for the given date (1–365 or 1–366 in a leap year).
		* @param d The date to get the day of year for.
		* @return The day of the year.
	*/
	public static int dayOfYear(LocalDate d) {
		return d.getDayOfYear();
	}

	/**
		* Returns the ISO week number of the year for the given date (1–53).
		* @param d The date to get the week number for.
		* @return The ISO week number.
	*/
	public static int weekOfYear(LocalDate d) {
		return d.get(WeekFields.ISO.weekOfWeekBasedYear());
	}

	/**
		* Converts a {@link LocalDateTime} from one timezone to another.
		* @param dt The date-time to convert.
		* @param fromZone The source timezone ID (e.g. {@code "America/New_York"}).
		* @param toZone The target timezone ID (e.g. {@code "Europe/London"}).
		* @return The converted {@link LocalDateTime} in the target timezone.
		* @throws java.time.zone.ZoneRulesException If either timezone ID is invalid.
		* @see <a href="https://en.wikipedia.org/wiki/Time_zone">Time zone</a>
	*/
	public static LocalDateTime convertTimezone(LocalDateTime dt, String fromZone, String toZone) {
		ZonedDateTime from = dt.atZone(ZoneId.of(fromZone));
		return from.withZoneSameInstant(ZoneId.of(toZone)).toLocalDateTime();
	}

	/**
		* Converts a {@link LocalDateTime} to Unix epoch seconds (UTC assumed).
		* @param dt The date-time to convert.
		* @return The number of seconds since 1970-01-01T00:00:00Z.
		* @see <a href="https://en.wikipedia.org/wiki/Unix_time">Unix time</a>
	*/
	public static long toEpochSeconds(LocalDateTime dt) {
		return dt.toEpochSecond(java.time.ZoneOffset.UTC);
	}

	/**
		* Converts Unix epoch seconds back to a {@link LocalDateTime} (UTC assumed).
		* @param epochSeconds The number of seconds since 1970-01-01T00:00:00Z.
		* @return The corresponding {@link LocalDateTime}.
		* @see <a href="https://en.wikipedia.org/wiki/Unix_time">Unix time</a>
	*/
	public static LocalDateTime fromEpochSeconds(long epochSeconds) {
		return LocalDateTime.ofEpochSecond(epochSeconds, 0, java.time.ZoneOffset.UTC);
	}
}
