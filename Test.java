import java.time.LocalDate;
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
		String a = actual   == null ? "null" : actual.toString();
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
  public static void main(String[] args) {
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
		section("Cryptography");
		check(
			"toAscii(\"Hello World!\")",
			"72 101 108 108 111 32 87 111 114 108 100 33",
			Cryptography.toAscii("Hello World!")
		);
		check(
			"fromAscii round-trip",
			"Hello World!",
			Cryptography.fromAscii("72 101 108 108 111 32 87 111 114 108 100 33")
		);
		check(
			"toHex(\"Hello World!\")",
			"48 65 6c 6c 6f 20 57 6f 72 6c 64 21",
			Cryptography.toHex("Hello World!")
		);
		check(
			"fromHex round-trip",
			"Hello World!",
			Cryptography.fromHex("48 65 6c 6c 6f 20 57 6f 72 6c 64 21"));
		check(
			"toBinary(\"Hello World!\")",
			"010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001",
			Cryptography.toBinary("Hello World!"));
		check(
			"fromBinary round-trip",
			"Hello World!",
			Cryptography.fromBinary("010010000110010101101100011011000110111100100000010101110110111101110010011011000110010000100001")
		);
		check(
			"toBase64(\"Hello World!\")",
			"SGVsbG8gV29ybGQh",
			Cryptography.toBase64("Hello World!")
		);
		check(
			"fromBase64 round-trip",
			"Hello World!",
			Cryptography.fromBase64("SGVsbG8gV29ybGQh")
		);
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
			"count(\"hello world hello\", \"hello\")",
			"2",
			StringUtils.count("hello world hello", "hello")
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

		section("MathUtils");
		check(
			"round(3.567, 2)",
			"3.57",
			MathUtils.round(3.567, 2)
		);
		check(
			"round(3.5)",
			"4",
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
			"average(2, 4, 6, 8)",
			"5",
			MathUtils.average(2, 4, 6, 8)
		);
		check(
			"median(1, 3, 5, 7, 9)",
			"5.0",
			MathUtils.median(1, 3, 5, 7, 9)
		);
		check(
			"gcd(12, 8)",
			"4",
			MathUtils.gcd(12, 8)
		);
		check(
			"lcm(4, 6)",
			"12",
			MathUtils.lcm(4, 6)
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
			"factorial(5)",
			"120",
			MathUtils.factorial(5)
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
			"today() != null",
			DateUtils.today() != null
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
			"maxMemory > 0",
			Jvm.maxMemory > 0
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
