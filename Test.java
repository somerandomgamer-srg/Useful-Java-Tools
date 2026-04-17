import UsefulJavaTools.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.List;

public class Test {
	private static void printTest(String test, String expected, Object actual) {
		System.out.println("Test: " + test);
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + actual);
		System.out.println("Passed: " + expected.equals(actual.toString()));
		System.out.println("\n");
		Ujt.sleep(0.5);
	}

	public static void test() {
		System.out.println("-------Ujt--------");

		printTest(
			"Ujt.ujtMinimumJavaVersion",
			"17",
			Ujt.ujtMinimumJavaVersion
		);

		printTest(
			"Ujt.ujtVersion",
			"V1.0.0",
			Ujt.ujtVersion
		);

		printTest(
			"Ujt.ujtReleaseDate",
			"2026/04/16",
			Ujt.ujtReleaseDate
		);

		printTest(
			"Ujt.ujtBuild",
			"ujt-V1.0.0-2026/04/16-17",
			Ujt.ujtBuild
		);

		System.out.println("-------Cryptography--------");

		printTest(
			"Cryptography.toAscii(\"Hello World!\")",
			"72 101 108 108 111 32 87 111 114 108 100 33",
			Cryptography.toAscii("Hello World!")
		);

		printTest(
			"Cryptography.fromAscii(\"72 101 108 108 111 32 87 111 114 108 100 33\")",
			"Hello World!",
			Cryptography.fromAscii("72 101 108 108 111 32 87 111 114 108 100 33")
		);

		printTest(
			"Cryptography.toHex(\"Hello World!\")",
			"48 65 6c 6c 6f 20 57 6f 72 6c 64 21",
			Cryptography.toHex("Hello World!")
		);

		printTest(
			"Cryptography.fromHex(\"48 65 6c 6c 6f 20 57 6f 72 6c 64 21\")",
			"Hello World!",
			Cryptography.fromHex("48 65 6c 6c 6f 20 57 6f 72 6c 64 21")
		);

		printTest(
			"Cryptography.toBinary(\"Hello World!\")",
			"010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001",
			Cryptography.toBinary("Hello World!")
		);

		printTest(
			"Cryptography.fromBinary(\"010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001\")",
			"Hello World!",
			Cryptography.fromBinary("010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001")
		);

		printTest(
			"Cryptography.toBase64(\"Hello World!\")",
			"SGVsbG8gV29ybGQh",
			Cryptography.toBase64("Hello World!")
		);

		printTest(
			"Cryptography.fromBase64(\"SGVsbG8gV29ybGQh\")",
			"Hello World!",
			Cryptography.fromBase64("SGVsbG8gV29ybGQh")
		);

		printTest(
			"Cryptography.caesarCipherEncrypt(\"Hello World!\", 3)",
			"Khoor Zruog!",
			Cryptography.caesarCipherEncrypt("Hello World!", 3)
		);

		printTest(
			"Cryptography.caesarCipherDecrypt(\"Khoor Zruog!\", 3)",
			"Hello World!",
			Cryptography.caesarCipherDecrypt("Khoor Zruog!", 3)
		);

		String rorResult = Cryptography.ror("Hello World!", 3, 8);
		printTest(
			"Cryptography.rol(Cryptography.ror(\"Hello World!\", 3, 8), 3, 8) round-trip",
			"Hello World!",
			Cryptography.rol(rorResult, 3, 8)
		);

		String rolResult = Cryptography.rol("Hello World!", 3, 8);
		printTest(
			"Cryptography.ror(Cryptography.rol(\"Hello World!\", 3, 8), 3, 8) round-trip",
			"Hello World!",
			Cryptography.ror(rolResult, 3, 8)
		);

		printTest(
			"Cryptography.btest(1, 2, 3)",
			"false",
			Cryptography.btest(1, 2, 3)
		);

		printTest(
			"Cryptography.btest(1, 1, 1)",
			"true",
			Cryptography.btest(1, 1, 1)
		);

		printTest(
			"Cryptography.luhn(1234567890)",
			"false",
			Cryptography.luhn(1234567890)
		);

		printTest(
			"Cryptography.luhn(4532015112830366)",
			"true",
			Cryptography.luhn(4532015112830366L)
		);

		printTest(
			"Cryptography.sha256String(\"Hello World!\")",
			"7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069",
			Cryptography.sha256String("Hello World!")
		);

		printTest(
			"Cryptography.md5String(\"Hello World!\")",
			"ed076287532e86365e841e92bfc50d8c",
			Cryptography.md5String("Hello World!")
		);

		printTest(
			"Cryptography.sha1String(\"Hello World!\")",
			"2ef7bde608ce5404e97d5f042f95f89f1c232871",
			Cryptography.sha1String("Hello World!")
		);

		System.out.println("-------Binary--------");

		printTest(
			"Binary.toDecimal(\"1010\")",
			"10",
			Binary.toDecimal("1010")
		);

		printTest(
			"Binary.fromDecimal(10)",
			"1010",
			Binary.fromDecimal(10)
		);

		printTest(
			"Binary.add(\"1100\", \"1010\")",
			"10110",
			Binary.add("1100", "1010")
		);

		printTest(
			"Binary.subtract(\"1100\", \"1010\")",
			"10",
			Binary.subtract("1100", "1010")
		);

		printTest(
			"Binary.subtract(\"1010\", \"1100\")",
			"-10",
			Binary.subtract("1010", "1100")
		);

		printTest(
			"Binary.multiply(\"1100\", \"1010\")",
			"1111000",
			Binary.multiply("1100", "1010")
		);

		printTest(
			"Binary.divide(\"1100\", \"1010\")",
			"1",
			Binary.divide("1100", "1010")
		);

		printTest(
			"Binary.divide(\"1010\", \"1100\")",
			"0",
			Binary.divide("1010", "1100")
		);

		printTest(
			"Binary.sqrt(\"10000\")",
			"100",
			Binary.sqrt("10000")
		);

		System.out.println("-------StringUtils--------");

		printTest(
			"StringUtils.capitalize(\"hello world\")",
			"Hello world",
			StringUtils.capitalize("hello world")
		);

		printTest(
			"StringUtils.reverse(\"Hello\")",
			"olleH",
			StringUtils.reverse("Hello")
		);

		printTest(
			"StringUtils.count(\"hello world hello\", \"hello\")",
			"2",
			StringUtils.count("hello world hello", "hello")
		);

		printTest(
			"StringUtils.wrap(\"The quick brown fox jumps over the lazy dog\", 15)",
			"The quick brown\nfox jumps over\nthe lazy dog",
			StringUtils.wrap("The quick brown fox jumps over the lazy dog", 15)
		);

		printTest(
			"StringUtils.mask(\"4111111111111111\", \"*\", 4, 4)",
			"4111********1111",
			StringUtils.mask("4111111111111111", "*", 4, 4)
		);

		printTest(
			"StringUtils.pad(\"hello\", \"-\", 3, true, true)",
			"---hello---",
			StringUtils.pad("hello", "-", 3, true, true)
		);

		printTest(
			"StringUtils.isPalindrome(\"racecar\")",
			"true",
			StringUtils.isPalindrome("racecar")
		);

		printTest(
			"StringUtils.isPalindrome(\"hello\")",
			"false",
			StringUtils.isPalindrome("hello")
		);

		printTest(
			"StringUtils.levenshtein(\"kitten\", \"sitting\")",
			"3",
			StringUtils.levenshtein("kitten", "sitting")
		);

		printTest(
			"StringUtils.titleCase(\"hello world\")",
			"Hello World",
			StringUtils.titleCase("hello world")
		);

		printTest(
			"StringUtils.titleCase(\"hello-world\", \"-\")",
			"Hello-World",
			StringUtils.titleCase("hello-world", "-")
		);

		System.out.println("-------Validate--------");

		printTest(
			"Validate.isValidEmail(\"user@example.com\")",
			"true",
			Validate.isValidEmail("user@example.com")
		);

		printTest(
			"Validate.isValidEmail(\"not-an-email\")",
			"false",
			Validate.isValidEmail("not-an-email")
		);

		printTest(
			"Validate.isValidURL(\"https://example.com\")",
			"true",
			Validate.isValidURL("https://example.com")
		);

		printTest(
			"Validate.isValidURL(\"not a url\")",
			"false",
			Validate.isValidURL("not a url")
		);

		printTest(
			"Validate.isValidIP(\"192.168.1.1\")",
			"true",
			Validate.isValidIP("192.168.1.1")
		);

		printTest(
			"Validate.isValidPort(8080)",
			"true",
			Validate.isValidPort(8080)
		);

		printTest(
			"Validate.isValidPort(99999)",
			"false",
			Validate.isValidPort(99999)
		);

		printTest(
			"Validate.isValidMAC(\"00:1A:2B:3C:4D:5E\")",
			"true",
			Validate.isValidMAC("00:1A:2B:3C:4D:5E")
		);

		printTest(
			"Validate.isValidMAC(null)",
			"false",
			Validate.isValidMAC(null)
		);

		System.out.println("-------ColorUtils--------");

		printTest(
			"ColorUtils.toHex(255, 136, 0)",
			"#ff8800",
			ColorUtils.toHex(255, 136, 0)
		);

		printTest(
			"ColorUtils.fromHex(\"#ff8800\")",
			"[255, 136, 0]",
			Arrays.toString(ColorUtils.fromHex("#ff8800"))
		);

		printTest(
			"ColorUtils.blend(255,0,0, 0,0,255, 0.5)",
			"[128, 0, 128]",
			Arrays.toString(ColorUtils.blend(255, 0, 0, 0, 0, 255, 0.5))
		);

		printTest(
			"ColorUtils.isLight(255, 255, 255)",
			"true",
			ColorUtils.isLight(255, 255, 255)
		);

		printTest(
			"ColorUtils.isDark(0, 0, 0)",
			"true",
			ColorUtils.isDark(0, 0, 0)
		);

		printTest(
			"ColorUtils.contrastRatio(0,0,0, 255,255,255) >= 21.0",
			"true",
			ColorUtils.contrastRatio(0, 0, 0, 255, 255, 255) >= 21.0
		);

		System.out.println("-------MathUtils--------");

		printTest(
			"MathUtils.round(3.567, 2)",
			"3.57",
			MathUtils.round(3.567, 2)
		);

		printTest(
			"MathUtils.round(3.5)",
			"4",
			MathUtils.round(3.5)
		);

		printTest(
			"MathUtils.inRange(1, 10, 5)",
			"true",
			MathUtils.inRange(1, 10, 5)
		);

		printTest(
			"MathUtils.inRange(1, 10, 11)",
			"false",
			MathUtils.inRange(1, 10, 11)
		);

		printTest(
			"MathUtils.average(2, 4, 6, 8)",
			"5",
			MathUtils.average(2, 4, 6, 8)
		);

		printTest(
			"MathUtils.median(1, 3, 5, 7, 9)",
			"5.0",
			MathUtils.median(1, 3, 5, 7, 9)
		);

		printTest(
			"MathUtils.gcd(12, 8)",
			"4",
			MathUtils.gcd(12, 8)
		);

		printTest(
			"MathUtils.lcm(4, 6)",
			"12",
			MathUtils.lcm(4, 6)
		);

		printTest(
			"MathUtils.isPrime(7)",
			"true",
			MathUtils.isPrime(7)
		);

		printTest(
			"MathUtils.isPrime(9)",
			"false",
			MathUtils.isPrime(9)
		);

		printTest(
			"MathUtils.fibonacci(10)",
			"34",
			MathUtils.fibonacci(10)
		);

		printTest(
			"MathUtils.factorial(5)",
			"120",
			MathUtils.factorial(5)
		);

		printTest(
			"MathUtils.isEven(4)",
			"true",
			MathUtils.isEven(4)
		);

		printTest(
			"MathUtils.isOdd(3)",
			"true",
			MathUtils.isOdd(3)
		);

		printTest(
			"MathUtils.isPerfectSquare(25)",
			"true",
			MathUtils.isPerfectSquare(25)
		);

		printTest(
			"MathUtils.isPerfectSquare(26)",
			"false",
			MathUtils.isPerfectSquare(26)
		);

		System.out.println("-------DateUtils--------");

		LocalDate d1 = DateUtils.parse("2024-01-01", "yyyy-MM-dd");
		LocalDate d2 = DateUtils.parse("2024-04-10", "yyyy-MM-dd");

		printTest(
			"DateUtils.parse(\"2024-01-01\", \"yyyy-MM-dd\")",
			"2024-01-01",
			d1
		);

		printTest(
			"DateUtils.format(d1, \"MM/dd/yyyy\")",
			"01/01/2024",
			DateUtils.format(d1, "MM/dd/yyyy")
		);

		printTest(
			"DateUtils.daysBetween(d1, d2)",
			"100",
			DateUtils.daysBetween(d1, d2)
		);

		printTest(
			"DateUtils.monthsBetween(d1, d2)",
			"3",
			DateUtils.monthsBetween(d1, d2)
		);

		printTest(
			"DateUtils.today() != null",
			"true",
			DateUtils.today() != null
		);

		System.out.println("-------Csv--------");

		printTest(
			"Csv.parseLine(\"one,two,three\")",
			"[one, two, three]",
			Arrays.toString(Csv.parseLine("one,two,three"))
		);

		printTest(
			"Csv.parseLine(\"one,\\\"two,three\\\",four\")",
			"[one, two,three, four]",
			Arrays.toString(Csv.parseLine("one,\"two,three\",four"))
		);

		printTest(
			"Csv.formatLine(new String[]{\"one\", \"two\", \"three\"})",
			"one,two,three",
			Csv.formatLine(new String[]{"one", "two", "three"})
		);

		printTest(
			"Csv.formatLine(new String[]{\"one\", \"two,extra\", \"three\"})",
			"one,\"two,extra\",three",
			Csv.formatLine(new String[]{"one", "two,extra", "three"})
		);

		System.out.println("-------Json--------");

		printTest(
			"Json.toJson(\"hello\")",
			"\"hello\"",
			Json.toJson("hello")
		);

		printTest(
			"Json.toJson(42)",
			"42",
			Json.toJson(42)
		);

		printTest(
			"Json.toJson(true)",
			"true",
			Json.toJson(true)
		);

		printTest(
			"Json.parse(\"\\\"hello\\\"\")",
			"hello",
			Json.parse("\"hello\"")
		);

		printTest(
			"Json.parse(\"42\") instanceof Integer",
			"true",
			Json.parse("42") instanceof Integer
		);

		Map<String, Object> obj = Json.parseObject("{\"name\":\"SRG\",\"version\":1}");
		printTest(
			"Json.parseObject(\"{\\\"name\\\":\\\"SRG\\\",\\\"version\\\":1}\").get(\"name\")",
			"SRG",
			obj.get("name")
		);

		List<Object> arr = Json.parseArray("[1,2,3]");
		printTest(
			"Json.parseArray(\"[1,2,3]\").size()",
			"3",
			arr.size()
		);

		System.out.println("-------Jvm--------");

		printTest(
			"Jvm.getJavaUptime() > 0",
			"true",
			Jvm.getJavaUptime() > 0
		);

		printTest(
			"Jvm.getJavaStartTime() > 0",
			"true",
			Jvm.getJavaStartTime() > 0
		);

		printTest(
			"Jvm.maxMemory > 0",
			"true",
			Jvm.maxMemory > 0
		);

		printTest(
			"Jvm.currentWorkingDirectory != null",
			"true",
			Jvm.currentWorkingDirectory != null
		);

		System.out.println("-------SystemInfo--------");

		printTest(
			"SystemInfo.OSName != null",
			"true",
			SystemInfo.OSName != null
		);

		printTest(
			"SystemInfo.numOfCores > 0",
			"true",
			SystemInfo.numOfCores > 0
		);

		printTest(
			"SystemInfo.fileSeparator != null",
			"true",
			SystemInfo.fileSeparator != null
		);

		printTest(
			"SystemInfo.fileEncoding != null",
			"true",
			SystemInfo.fileEncoding != null
		);

		System.out.println("-------RandomUtils--------");

		int ri = RandomUtils.randomInt(1, 10);
		printTest(
			"RandomUtils.randomInt(1, 10) in range [1, 10]",
			"true",
			ri >= 1 && ri <= 10
		);

		double rd = RandomUtils.randomDouble(0.0, 1.0, 2);
		printTest(
			"RandomUtils.randomDouble(0.0, 1.0, 2) in range [0.0, 1.0]",
			"true",
			rd >= 0.0 && rd <= 1.0
		);

		long rl = RandomUtils.randomLong(100L, 200L);
		printTest(
			"RandomUtils.randomLong(100, 200) in range [100, 200]",
			"true",
			rl >= 100L && rl <= 200L
		);

		String rh = RandomUtils.randomHex(8);
		printTest(
			"RandomUtils.randomHex(8).length() == 8",
			"true",
			rh.length() == 8
		);

		printTest(
			"RandomUtils.randomBoolean(100, 0)",
			"true",
			RandomUtils.randomBoolean(100, 0)
		);

		printTest(
			"RandomUtils.randomBoolean(0, 100)",
			"false",
			RandomUtils.randomBoolean(0, 100)
		);

		System.out.println("-------End--------");
	}
}
