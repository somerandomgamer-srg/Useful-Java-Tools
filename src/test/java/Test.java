import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import ujt.*;
public class Test {
  private static int passed = 0;
  private static int failed = 0;
  private static final List<String> failures = new java.util.ArrayList<>();
  private static void check(String name, Object expected, Object actual) {
		String e = expected == null ? "null" : expected.toString();
		String a = actual == null ? "null" : actual.toString();
		if (e.equals(a)) {
			passed++;
			System.out.println("  PASS  " + name);
		} else {
			failed++;
			String msg = "  FAIL  " + name + "\n         expected: " + e + "\n         actual:   " + a;
			failures.add(msg);
			System.out.println(msg);
		}
  }
	private static void check(String name, boolean condition) {
		check(name, "true", String.valueOf(condition));
  }
  private static void section(String name) {
		System.out.println("\n--- " + name + " ---");
  }
  public static void test() {
		section("Ujt");
		check(
			"ujtMinimumJavaVersion",
			"17",
			Ujt.ujtMinimumJavaVersion
		);
		check(
			"ujtVersion",
			"V1.0.0",
			Ujt.ujtVersion
		);
		check(
			"ujtReleaseDate",
			"2026/04/16",
			Ujt.ujtReleaseDate
		);
		check(
			"ujtBuild",
			"ujt-V1.0.0-2026/04/16-17",
			Ujt.ujtBuild
		);
		section("Encoding");
		check(
			"toAscii(\"Hello World!\")",
			"72 101 108 108 111 32 87 111 114 108 100 33",
			Encoding.toAscii("Hello World!")
		);
		check(
			"fromAscii round-trip",
			"Hello World!",
			Encoding.fromAscii("72 101 108 108 111 32 87 111 114 108 100 33")
		);
		check(
			"toHex(\"Hello World!\")",
			"48 65 6c 6c 6f 20 57 6f 72 6c 64 21",
			Encoding.toHex("Hello World!")
		);
		check(
			"fromHex round-trip",
			"Hello World!",
			Encoding.fromHex("48 65 6c 6c 6f 20 57 6f 72 6c 64 21")
		);
		check(
			"toBinary(\"Hello World!\")",
			"010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001",
			Encoding.toBinary("Hello World!")
		);
		check(
			"fromBinary round-trip",
			"Hello World!",
			Encoding.fromBinary("010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001")
		);
		check(
			"toBase64(\"Hello World!\")",
			"SGVsbG8gV29ybGQh",
			Encoding.toBase64("Hello World!")
		);
		check(
			"fromBase64 round-trip",
			"Hello World!",
			Encoding.fromBase64("SGVsbG8gV29ybGQh")
		);
		check(
			"toBinary(\"A\", 16)",
			"0000000001000001",
			Encoding.toBinary("A", 16)
		);
		check(
			"fromBinary(\"0000000001000001\", 16) round-trip",
			"A",
			Encoding.fromBinary("0000000001000001", 16)
		);
		check(
			"toBase64Url(\"Hello World!\") round-trip",
			"Hello World!",
			Encoding.fromBase64Url(Encoding.toBase64Url("Hello World!"))
		);

		section("Cryptography");
		check(
			"caesarCipherEncrypt(\"Hello World!\", 3)",
		"Khoor Zruog!",
		Cryptography.caesarCipherEncrypt("Hello World!", 3)
		);
		check(
			"caesarCipherDecrypt(\"Khoor Zruog!\", 3)",
		"Hello World!",
		Cryptography.caesarCipherDecrypt("Khoor Zruog!", 3)
		);
		check(
			"ror then rol round-trip",
			"Hello World!",
			Cryptography.rol(Cryptography.ror("Hello World!", 3, 8), 3, 8)
		);
		check(
			"rol then ror round-trip",
			"Hello World!",
			Cryptography.ror(Cryptography.rol("Hello World!", 3, 8), 3, 8)
		);
		check(
			"btest(1, 2, 3) == false",
			false,
			Cryptography.btest(1, 2, 3)
		);
		check(
			"btest(1, 1, 1) == true",
			 true,
			Cryptography.btest(1, 1, 1)
		);
		check(
			"luhn(1234567890) == false",
			false,
			Cryptography.luhn(1234567890)
		);
		check(
			"luhn(4532015112830366L) == true",
			true,
			Cryptography.luhn(4532015112830366L)
		);
		check(
			"sha256String(\"Hello World!\")",
			"7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069",
			Cryptography.sha256String("Hello World!")
		);
		check(
			"md5String(\"Hello World!\")",
			"ed076287532e86365e841e92bfc50d8c",
			Cryptography.md5String("Hello World!")
		);
		check(
			"sha1String(\"Hello World!\")",
			"2ef7bde608ce5404e97d5f042f95f89f1c232871",
			Cryptography.sha1String("Hello World!")
		);
		section("Binary");
		check(
			"toDecimal(\"1010\")",
			"10",
			Binary.toDecimal("1010")
		);
		check(
			"fromDecimal(10)",
			"1010",
			Binary.fromDecimal(10)
		);
		check(
		"add(\"1100\", \"1010\")",
		"10110",
		Binary.add("1100", "1010")
		);
		check(
			"subtract(\"1100\", \"1010\")",
			"10",
			Binary.subtract("1100", "1010")
		);
		check(
			"subtract(\"1010\", \"1100\")",
			"-10",
			Binary.subtract("1010", "1100")
		);
		check(
			"multiply(\"1100\", \"1010\")",
			"1111000",
			Binary.multiply("1100", "1010")
		);
		check(
			"divide(\"1100\", \"1010\")",
			"1",
			Binary.divide("1100", "1010")
		);
		check(
			"divide(\"1010\", \"1100\")",
			"0",
			Binary.divide("1010", "1100")
		);
		check(
			"sqrt(\"10000\")",
			"100",
			Binary.sqrt("10000")
		);

		section("StringUtils");
		check(
			"capitalize(\"hello world\")",
			"Hello world",
			StringUtils.capitalize("hello world")
		);
		check(
			"reverse(\"Hello\")",
			"olleH",
			StringUtils.reverse("Hello")
		);
		check(
			"reverse(null) == null",
			null,
			StringUtils.reverse(null)
		);
		check(
			"count(\"hello world hello\", \"hello\")",
			"2",
			StringUtils.count("hello world hello", "hello")
		);
		check(
			"count(null, \"hello\") == 0",
			"0",
			StringUtils.count(null, "hello")
		);
		check(
			"wrap(\"The quick brown fox...\", 15)",
			"The quick brown\nfox jumps over\nthe lazy dog",
			StringUtils.wrap("The quick brown fox jumps over the lazy dog", 15)
		);
		check(
			"mask(\"4111111111111111\", \"*\", 4, 4)",
			"4111********1111",
			StringUtils.mask("4111111111111111", "*", 4, 4)
		);
		check(
			"pad(\"hello\", \"-\", 3, true, true)",
			"---hello---",
			StringUtils.pad("hello", "-", 3, true, true)
		);
		check(
			"isPalindrome(\"racecar\") == true",
			true,
			StringUtils.isPalindrome("racecar")
		);
		check(
			"isPalindrome(\"hello\") == false",
			false,
			StringUtils.isPalindrome("hello")
		);
		check(
			"levenshtein(\"kitten\", \"sitting\")",
			"3",
			StringUtils.levenshtein("kitten", "sitting")
		);
		check(
			"titleCase(\"hello world\")",
			"Hello World",
			StringUtils.titleCase("hello world")
		);
		check(
			"titleCase(\"hello-world\", \"-\")",
			"Hello-World",
			StringUtils.titleCase("hello-world", "-")
		);

		section("Validate");
		check(
			"isValidEmail(\"user@example.com\") == true",
			true,
			Validate.isValidEmail("user@example.com")
		);
		check(
			"isValidEmail(\"not-an-email\") == false",
			false,
			Validate.isValidEmail("not-an-email")
		);
		check(
			"isValidURL(\"https://example.com\") == true",
			true,
			Validate.isValidURL("https://example.com")
		);
		check(
			"isValidURL(\"not a url\") == false",
			false,
			Validate.isValidURL("not a url")
		);
		check(
			"isValidIP(\"192.168.1.1\") == true",
			true,
			Validate.isValidIP("192.168.1.1")
		);
		check(
			"isValidPort(8080) == true",
			true,
			Validate.isValidPort(8080)
		);
		check(
			"isValidPort(99999) == false",
			false,
			Validate.isValidPort(99999)
		);
		check(
			"isValidMAC(\"00:1A:2B:3C:4D:5E\") == true",
			true,
			Validate.isValidMAC("00:1A:2B:3C:4D:5E")
		);
		check(
			"isValidMAC(null) == false",
			false,
			Validate.isValidMAC(null)
		);

		section("ColorUtils");
		check(
			"toHex(255, 136, 0)",
			"#ff8800",
			ColorUtils.toHex(255, 136, 0)
		);
		check(
			"fromHex(\"#ff8800\")",
			"[255, 136, 0]",
			Arrays.toString(ColorUtils.fromHex("#ff8800"))
		);
		check(
			"blend(255,0,0, 0,0,255, 0.5)",
			"[128, 0, 128]",
			Arrays.toString(ColorUtils.blend(255, 0, 0, 0, 0, 255, 0.5))
		);
		check(
			"isLight(255, 255, 255) == true",
			true,
			ColorUtils.isLight(255, 255, 255)
		);
		check(
			"isDark(0, 0, 0) == true",
			true,
			ColorUtils.isDark(0, 0, 0)
		);
		check(
			"contrastRatio(0,0,0, 255,255,255) >= 21.0",
			ColorUtils.contrastRatio(0, 0, 0, 255, 255, 255) >= 21.0
		);
		double[] redHsl = ColorUtils.toHsl(255, 0, 0);
		check(
			"toHsl(255,0,0) hue == 0.0",
			"0.0",
			redHsl[0]
		);
		check(
			"toHsl(255,0,0) saturation == 1.0",
			"1.0",
			redHsl[1]
		);
		check(
			"toHsl(255,0,0) lightness == 0.5",
			"0.5",
			redHsl[2]
		);
		check(
			"fromHsl(0.0, 1.0, 0.5) round-trip to [255, 0, 0]",
			"[255, 0, 0]",
			Arrays.toString(ColorUtils.fromHsl(0.0, 1.0, 0.5))
		);
		double[] redHsv = ColorUtils.toHsv(255, 0, 0);
		check(
			"toHsv(255,0,0) hue == 0.0",
			"0.0",
			redHsv[0]
		);
		check(
			"toHsv(255,0,0) saturation == 1.0",
			"1.0",
			redHsv[1]
		);
		check(
			"toHsv(255,0,0) value == 1.0",
			"1.0",
			redHsv[2]
		);
		check(
			"fromHsv(0.0, 1.0, 1.0) round-trip to [255, 0, 0]",
			"[255, 0, 0]",
			Arrays.toString(ColorUtils.fromHsv(0.0, 1.0, 1.0))
		);
		check(
			"complementary(255, 0, 0) == [0, 255, 255]",
			"[0, 255, 255]",
			Arrays.toString(ColorUtils.complementary(255, 0, 0))
		);
		check(
			"luminance(255, 255, 255) == 1.0",
			"1.0",
			ColorUtils.luminance(255, 255, 255)
		);
		check(
			"luminance(0, 0, 0) == 0.0",
			"0.0",
			ColorUtils.luminance(0, 0, 0)
		);
		int[] lightened = ColorUtils.lighten(0, 0, 0, 0.5);
		check(
			"lighten(0,0,0, 0.5) is lighter than black",
			ColorUtils.isLight(lightened[0], lightened[1], lightened[2]) || lightened[0] > 0 || lightened[1] > 0 || lightened[2] > 0
		);
		int[] darkened = ColorUtils.darken(255, 255, 255, 0.5);
		check(
			"darken(255,255,255, 0.5) is darker than white",
			ColorUtils.isDark(darkened[0], darkened[1], darkened[2]) || darkened[0] < 255 || darkened[1] < 255 || darkened[2] < 255
		);

		section("MathUtils");
		check(
			"round(3.567, 2)",
			"3.57",
			MathUtils.round(3.567, 2)
		);
		check(
			"round(3.5)",
			"4.0",
			MathUtils.round(3.5)
		);
		check(
			"inRange(1, 10, 5) == true",
			 true,
			 MathUtils.inRange(1, 10, 5)
		);
		check(
			"inRange(1, 10, 11) == false",
			false,
			MathUtils.inRange(1, 10, 11)
		);
		check(
			"average(int: 2, 4, 6, 8)",
			"5",
			MathUtils.average(2, 4, 6, 8)
		);
		check(
			"average(long: 10L, 20L, 30L)",
			"20",
			MathUtils.average(10L, 20L, 30L)
		);
		check(
			"average(float: 1.0f, 2.0f, 3.0f)",
			"2.0",
			MathUtils.average(1.0f, 2.0f, 3.0f)
		);
		check(
			"average(double: 1.5, 2.5, 3.5)",
			"2.5",
			MathUtils.average(1.5, 2.5, 3.5)
		);
		check(
			"median(1, 3, 5, 7, 9)",
			"5.0",
			MathUtils.median(1, 3, 5, 7, 9)
		);
		int[] modeResult = MathUtils.mode(1, 2, 2, 3);
		Arrays.sort(modeResult);
		check(
			"mode(1, 2, 2, 3) == [2]",
			"[2]",
			Arrays.toString(modeResult)
		);
		check(
			"range(int: 3, 1, 4, 1, 5, 9)",
			"8",
			MathUtils.range(3, 1, 4, 1, 5, 9)
		);
		check(
			"range(long: 10L, 20L, 30L)",
			"20",
			MathUtils.range(10L, 20L, 30L)
		);
		check(
			"standardDeviation(int: 2,4,6,8) rounded to 4 dp",
			"2.2361",
			MathUtils.round(MathUtils.standardDeviation(2, 4, 6, 8), 4)
		);
		check(
			"standardDeviation(double: 2.0,4.0,6.0,8.0) rounded to 4 dp",
			"2.2361",
			MathUtils.round(MathUtils.standardDeviation(2.0, 4.0, 6.0, 8.0), 4)
		);
		check(
			"gcd(int: 12, 8)",
			"4",
			MathUtils.gcd(12, 8)
		);
		check(
			"gcd(long: 36L, 24L, 12L)",
			"12",
			MathUtils.gcd(36L, 24L, 12L)
		);
		check(
			"lcm(int: 4, 6)",
			"12",
			MathUtils.lcm(4, 6)
		);
		check(
			"lcm(long: 4L, 6L)",
			"12",
			MathUtils.lcm(4L, 6L)
		);
		check(
			"isPrime(7) == true",
			true,
			MathUtils.isPrime(7)
		);
		check(
			"isPrime(9) == false",
			false,
			MathUtils.isPrime(9)
		);
		check(
			"fibonacci(10)",
			"34",
			MathUtils.fibonacci(10)
		);
		check(
			"fibonacci(1)",
			"0",
			MathUtils.fibonacci(1)
		);
		check(
			"fibonacci(2)",
			"1",
			MathUtils.fibonacci(2)
		);
		check(
			"isWhole(3.0) == true",
			true,
			MathUtils.isWhole(3.0)
		);
		check(
			"isWhole(3.5) == false",
			false,
			MathUtils.isWhole(3.5)
		);
		check(
			"isEven(4) == true",
			true,
			MathUtils.isEven(4)
		);
		check(
			"isOdd(3) == true",
			true,
			MathUtils.isOdd(3)
		);
		check(
			"isPerfectSquare(25) == true",
			true,
			MathUtils.isPerfectSquare(25)
		);
		check(
			"isPerfectSquare(26) == false",
			false,
			MathUtils.isPerfectSquare(26)
		);
		check(
			"factorial(5)",
			"120",
			MathUtils.factorial(5)
		);
		check(
			"factorial(0)",
			"1",
			MathUtils.factorial(0)
		);
		check(
			"bigFactorial(10)",
			"3628800",
			MathUtils.bigFactorial(10)
		);
		check(
			"permutation(5, 3)",
			"60",
			MathUtils.permutation(5, 3)
		);
		check(
			"combination(5, 3)",
			"10",
			MathUtils.combination(5, 3)
		);
		long[] factorsOf12 = MathUtils.factors(12);
		check(
			"factors(12).length == 6",
			"6",
			factorsOf12.length
		);
		check(
			"isPerfect(6) == true",
			true,
			MathUtils.isPerfect(6)
		);
		check(
			"isPerfect(7) == false",
			false,
			MathUtils.isPerfect(7)
		);
		check(
			"isDeficient(4) == true",
			true,
			MathUtils.isDeficient(4)
		);
		check(
			"isAbundant(12) == true",
			true,
			MathUtils.isAbundant(12)
		);
		check(
			"classifyNumber(6) == \"Perfect\"",
			"Perfect",
			MathUtils.classifyNumber(6)
		);
		check(
			"classifyNumber(4) == \"Deficient\"",
			"Deficient",
			MathUtils.classifyNumber(4)
		);
		check(
			"classifyNumber(12) == \"Abundant\"",
			"Abundant",
			MathUtils.classifyNumber(12)
		);
		check(
			"zScore(5, 2,4,6,8) == 0.0",
			"0.0",
			MathUtils.zScore(5.0, 2, 4, 6, 8)
		);
		check(
			"acosh(1.0) == 0.0",
			"0.0",
			MathUtils.acosh(1.0)
		);
		check(
			"atanh(0.0) == 0.0",
			"0.0",
			MathUtils.atanh(0.0)
		);
		check(
			"asinh(0.0) == 0.0",
			"0.0",
			MathUtils.asinh(0.0)
		);
		check(
			"secant(0.0) == 1.0",
			"1.0",
			MathUtils.secant(0.0)
		);
		check(
			"cosecant(PI/2) rounded == 1.0",
			"1.0",
			MathUtils.round(MathUtils.cosecant(Math.PI / 2), 10)
		);
		check(
			"cotangent(PI/4) rounded == 1.0",
			"1.0",
			MathUtils.round(MathUtils.cotangent(Math.PI / 4), 10)
		);
		check(
			"asecant(1.0) == 0.0",
			"0.0",
			MathUtils.asecant(1.0)
		);
		check(
			"nroot(8.0, 3) == 2.0",
			"2.0",
			MathUtils.nroot(8.0, 3)
		);
		check(
			"mathMap(5, 0, 10, 0, 100) == 50.0",
			"50.0",
			MathUtils.mathMap(5, 0, 10, 0, 100)
		);
		check(
			"distance2d(0,0, 3,4) == 5.0",
			"5.0",
			MathUtils.distance2d(0, 0, 3, 4)
		);
		check(
			"distance3d(0,0,0, 1,2,2) == 3.0",
			"3.0",
			MathUtils.distance3d(0, 0, 0, 1, 2, 2)
		);
		check(
			"aos(1, -4) == 2.0",
			"2.0",
			MathUtils.aos(1, -4)
		);
		Map<String, Double> v = MathUtils.vertex(1, -4, 3);
		check(
			"vertex(1,-4,3).x == 2.0",
			"2.0",
			v.get("x")
		);
		check(
			"vertex(1,-4,3).y == -1.0",
			"-1.0",
			v.get("y")
		);
		check(
			"clamp(15, 0, 10) == 10.0",
			"10.0",
			MathUtils.clamp(15, 0, 10)
		);
		check(
			"clamp(-5, 0, 10) == 0.0",
			"0.0",
			MathUtils.clamp(-5, 0, 10)
		);
		check(
			"clamp(5, 0, 10) == 5.0",
			"5.0",
			MathUtils.clamp(5, 0, 10)
		);
		check(
			"log(8, 2) == 3.0",
			"3.0",
			MathUtils.round(MathUtils.log(8, 2), 10)
		);

		section("DateUtils");
		LocalDate d1 = DateUtils.parse("2024-01-01", "yyyy-MM-dd");
		LocalDate d2 = DateUtils.parse("2024-04-10", "yyyy-MM-dd");
		check(
			"parse(\"2024-01-01\", \"yyyy-MM-dd\")",
			"2024-01-01",
			d1
		);
		check(
			"format(d1, \"MM/dd/yyyy\")",
			"01/01/2024",
			DateUtils.format(d1, "MM/dd/yyyy")
		);
		check(
			"daysBetween(d1, d2)",
			"100",
			DateUtils.daysBetween(d1, d2)
		);
		check(
			"monthsBetween(d1, d2)",
			"3",
			DateUtils.monthsBetween(d1, d2)
		);
		check(
			"yearsBetween(d1, d2)",
			"0",
			DateUtils.yearsBetween(d1, d2)
		);
		check(
			"yearsBetween(2020-01-01, 2024-01-01)",
			"4",
			DateUtils.yearsBetween(
				DateUtils.parse("2020-01-01", "yyyy-MM-dd"),
				DateUtils.parse("2024-01-01", "yyyy-MM-dd")
			)
		);
		check(
			"today() != null",
			DateUtils.today() != null
		);
		check(
			"now() != null",
			DateUtils.now() != null
		);
		check(
			"addDays(d1, 10)",
			"2024-01-11",
			DateUtils.addDays(d1, 10)
		);
		check(
			"addMonths(d1, 3)",
			"2024-04-01",
			DateUtils.addMonths(d1, 3)
		);
		check(
			"addYears(d1, 1)",
			"2025-01-01",
			DateUtils.addYears(d1, 1)
		);
		check(
			"subtractDays(d1, 1)",
			"2023-12-31",
			DateUtils.subtractDays(d1, 1)
		);
		check(
			"subtractMonths(d1, 1)",
			"2023-12-01",
			DateUtils.subtractMonths(d1, 1)
		);
		check(
			"subtractYears(d1, 1)",
			"2023-01-01",
			DateUtils.subtractYears(d1, 1)
		);
		check(
			"isLeapYear(2024) == true",
			true,
			DateUtils.isLeapYear(2024)
		);
		check(
			"isLeapYear(2023) == false",
			false,
			DateUtils.isLeapYear(2023)
		);
		check(
			"isPast(2020-01-01) == true",
			true,
			DateUtils.isPast(DateUtils.parse("2020-01-01", "yyyy-MM-dd"))
		);
		check(
			"isFuture(2099-01-01) == true",
			true,
			DateUtils.isFuture(DateUtils.parse("2099-01-01", "yyyy-MM-dd"))
		);
		check(
			"isToday(today()) == true",
			true,
			DateUtils.isToday(DateUtils.today())
		);
		check(
			"startOfMonth(2024-04-15)",
			"2024-04-01",
			DateUtils.startOfMonth(DateUtils.parse("2024-04-15", "yyyy-MM-dd"))
		);
		check(
			"endOfMonth(2024-04-15)",
			"2024-04-30",
			DateUtils.endOfMonth(DateUtils.parse("2024-04-15", "yyyy-MM-dd"))
		);
		check(
			"dayOfYear(2024-01-31) == 31",
			"31",
			DateUtils.dayOfYear(DateUtils.parse("2024-01-31", "yyyy-MM-dd"))
		);
		check(
			"weekOfYear(2024-01-01) == 1",
			"1",
			DateUtils.weekOfYear(DateUtils.parse("2024-01-01", "yyyy-MM-dd"))
		);
		LocalDateTime epoch = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
		long epochSecs = DateUtils.toEpochSeconds(epoch);
		check(
			"fromEpochSeconds(toEpochSeconds(2024-01-01T00:00:00)) round-trip",
			epoch.toString(),
			DateUtils.fromEpochSeconds(epochSecs).toString()
		);
		check(
			"parseDateTime(\"2024-06-15 12:30:00\", ...)",
			"2024-06-15T12:30",
			DateUtils.parseDateTime("2024-06-15 12:30:00", "yyyy-MM-dd HH:mm:ss").toString()
		);
		LocalDateTime nyTime = LocalDateTime.of(2024, 6, 15, 12, 0, 0);
		LocalDateTime londonTime = DateUtils.convertTimezone(nyTime, "America/New_York", "Europe/London");
		check(
			"convertTimezone(NY 12:00 -> London) is 5 hours ahead",
			"2024-06-15T17:00",
			londonTime.toString()
		);

		section("Csv");
		check(
			"parseLine(\"one,two,three\")",
			"[one, two, three]",
			Arrays.toString(Csv.parseLine("one,two,three"))
		);
		check(
			"parseLine with quoted commas",
			"[one, two,three, four]",
			Arrays.toString(Csv.parseLine("one,\"two,three\",four"))
		);
		check(
			"formatLine(new String[]{\"one\", \"two\", \"three\"})",
			"one,two,three",
			Csv.formatLine(new String[]{"one", "two", "three"})
		);
		check(
			"formatLine with comma in field",
			"one,\"two,extra\",three",
			Csv.formatLine(new String[]{"one", "two,extra", "three"})
		);

		section("Json");
		check(
			"toJson(\"hello\")",
			"\"hello\"",
			Json.toJson("hello")
		);
		check(
			"toJson(42)",
			   "42",
			  Json.toJson(42)
		);
		check(
			"toJson(true)",
			 "true",
			Json.toJson(true)
		);
		check(
			"parse(\"\\\"hello\\\"\") == \"hello\"",
			"hello",
			Json.parse("\"hello\"")
		);
		check(
			"parse(\"42\") instanceof Long",
			true, Json.parse("42") instanceof Long
		);
		Map<String, Object> obj = Json.parseObject("{\"name\":\"SRG\",\"version\":1}"
		);
		check(
			"parseObject.get(\"name\")",
			"SRG",
			obj.get("name")
		);
		List<Object> arr = Json.parseArray("[1,2,3]"
		);
		check(
			"parseArray(\"[1,2,3]\").size() == 3",
			"3",
			arr.size()
		);

		section("Jvm");
		check(
			"getJavaUptime() > 0",
			Jvm.getJavaUptime() > 0
		);
		check(
			"getJavaStartTime() > 0",
			Jvm.getJavaStartTime() > 0
		);
		check(
			"maxMemory() > 0",
			Jvm.maxMemory() > 0
		);
		check(
			"currentWorkingDirectory != null",
			Jvm.currentWorkingDirectory != null
		);

		section("SystemInfo");
		check(
			"OSName != null",
			SystemInfo.OSName != null
		);
		check(
			"numOfCores > 0",
			SystemInfo.numOfCores > 0
		);
		check(
			"fileSeparator != null",
			SystemInfo.fileSeparator != null
		);
		check(
			"fileEncoding != null",
			 SystemInfo.fileEncoding != null
		);

		section("RandomUtils");
		int ri = RandomUtils.randomInt(1, 10);
		check(
			"randomInt(1, 10) in [1, 10]",
			ri >= 1 && ri <= 10
		);
		double rd = RandomUtils.randomDouble(0.0, 1.0, 2);
		check(
			"randomDouble(0.0, 1.0, 2) in [0.0, 1.0]",
			rd >= 0.0 && rd <= 1.0
		);
		long rl = RandomUtils.randomLong(100L, 200L);
		check(
			"randomLong(100, 200) in [100, 200]",
			rl >= 100L && rl <= 200L
		);
		check(
			"randomHex(8).length() == 8",
			RandomUtils.randomHex(8).length() == 8
		);
		check(
			"randomBoolean(100, 0) == true",
			true,
			RandomUtils.randomBoolean(100, 0)
		);
		check(
			"randomBoolean(0, 100) == false",
			false,
			RandomUtils.randomBoolean(0, 100)
		);
		float rf = RandomUtils.randomFloat(1.0f, 2.0f, 2);
		check(
			"randomFloat(1.0, 2.0, 2) in [1.0, 2.0]",
			rf >= 1.0f && rf <= 2.0f
		);
		check(
			"randomColor() != null",
			RandomUtils.randomColor() != null
		);
		check(
			"randomSign(5.0, 100, 0) == -5.0",
			"-5.0",
			RandomUtils.randomSign(5.0, 100, 0)
		);
		check(
			"randomSign(5.0, 0, 100) == 5.0",
			"5.0",
			RandomUtils.randomSign(5.0, 0, 100)
		);

		section("FileUtils");
		String tmpFile = System.getProperty("java.io.tmpdir") + java.io.File.separator + "ujt_test.txt";
		String tmpDir  = System.getProperty("java.io.tmpdir") + java.io.File.separator + "ujt_test_dir";
		FileUtils.deleteFile(tmpFile);
		check(
			"createFile(path, content) == true",
			true,
			FileUtils.createFile(tmpFile, "hello ujt")
		);
		check(
			"fileExists(path) == true after create",
			true,
			FileUtils.fileExists(tmpFile)
		);
		check(
			"isFile(path) == true",
			true,
			FileUtils.isFile(tmpFile)
		);
		check(
			"isDirectory(path) == false for a file",
			false,
			FileUtils.isDirectory(tmpFile)
		);
		check(
			"readFile(path) == \"hello ujt\"",
			"hello ujt",
			FileUtils.readFile(tmpFile)
		);
		check(
			"fileSize(path) > 0",
			FileUtils.fileSize(tmpFile) > 0
		);
		check(
			"writeFile(path, newContent) == true",
			true,
			FileUtils.writeFile(tmpFile, "overwritten")
		);
		check(
			"readFile after writeFile == \"overwritten\"",
			"overwritten",
			FileUtils.readFile(tmpFile)
		);
		check(
			"appendFile(path, content) == true",
			true,
			FileUtils.appendFile(tmpFile, " appended")
		);
		check(
			"readFile after appendFile",
			"overwritten appended",
			FileUtils.readFile(tmpFile)
		);
		check(
			"readLines(path).size() == 1",
			"1",
			FileUtils.readLines(tmpFile).size()
		);
		check(
			"getFileExtension returns empty for extensionless file",
			"",
			FileUtils.getFileExtension(System.getProperty("java.io.tmpdir") + java.io.File.separator + "noext")
		);
		check(
			"getFileExtension(\".../ujt_test.txt\") == \".txt\"",
			".txt",
			FileUtils.getFileExtension(tmpFile)
		);
		check(
			"getFileName(\".../ujt_test.txt\") == \"ujt_test.txt\"",
			"ujt_test.txt",
			FileUtils.getFileName(tmpFile)
		);
		check(
			"getFileNameWithoutExtension(\".../ujt_test.txt\") == \"ujt_test\"",
			"ujt_test",
			FileUtils.getFileNameWithoutExtension(tmpFile)
		);
		check(
			"createDirectory(tmpDir) == true",
			true,
			FileUtils.createDirectory(tmpDir)
		);
		check(
			"isDirectory(tmpDir) == true",
			true,
			FileUtils.isDirectory(tmpDir)
		);
		check(
			"isDirectoryEmpty(tmpDir) == true",
			true,
			FileUtils.isDirectoryEmpty(tmpDir)
		);
		String[] listed = FileUtils.listFiles(System.getProperty("java.io.tmpdir"), ".txt");
		check(
			"listFiles(tmpdir, \".txt\") contains our file",
			listed != null && Arrays.stream(listed).anyMatch(p -> p.endsWith("ujt_test.txt"))
		);
		check(
			"deleteFile(path) == true",
			true,
			FileUtils.deleteFile(tmpFile)
		);
		check(
			"fileExists(path) == false after delete",
			false,
			FileUtils.fileExists(tmpFile)
		);
		FileUtils.deleteFile(tmpDir);

		System.out.println("\n==============================");
		System.out.println("Results: " + passed + " passed, " + failed + " failed.");
		if (failed > 0) {
		  System.out.println("\nFailed tests:");
			for (String f : failures) {
				System.out.println(f);
			}
			System.exit(1);
		} else {
		  System.out.println("All tests passed!");
		}
  }
}
