# Contributing to Useful Java Tools (UJT)

Thank you for your interest in contributing! Please read the guidelines below before submitting anything.

---

## Ground Rules

- **Zero dependencies.** UJT is built entirely on the Java standard library. Do not add any external dependencies — not even for tests.
- **Java 17+.** All code must compile and run on Java 17 or higher.
- **Static utility classes only.** Every class follows the same pattern: `public class`, all `public static` methods, no instantiation.

---

## Getting Started

**1. Clone the repository:**
```bash
git clone https://github.com/somerandomgamer-srg/Useful-Java-Tools.git
```

**2. Build the project:**
```bash
mvn clean install
```

**3. Run the tests:**
```bash
mvn exec:java -Dexec.mainClass="Test" -Dexec.classpathScope="test"
```

ALL tests must pass before submitting a contribution.

---

## Adding a Method

1. Place it in the appropriate existing class (e.g., math utilities go in `MathUtils`, string utilities in `StringUtils`).
2. If your method works on multiple numeric types, provide overloads for all relevant types (`int`, `long`, `float`, `double`) — see `MathUtils.average()` as a reference.
3. Add a Javadoc comment with at minimum `@param`, `@return`, and `@throws` (if applicable). Add a `@see` Wikipedia link if the concept has one.
4. Update `Current Methods and Variables.md` with the new entry, including a table-of-contents anchor link.

## Adding a Class

1. Place the file in `src/main/java/ujt/` with the `package ujt;` declaration.
2. Add a `static { Ujt.ujtCheckJavaVersion(); }` block at the top of the class.
3. Add a class-level Javadoc comment describing the class.
4. Add the class to the statistics table and class list in `README.md`.
5. Add a full section for it in `Current Methods and Variables.md`.

---

## Writing Tests

UJT uses a custom zero-dependency test harness located in `src/test/java/Test.java`.

Add a new `section("ClassName")` block inside the `test()` method and use `check()` to assert results:

```java
section("MyClass");
check(
    "myMethod(\"input\") == \"expected\"",
    "expected",
    MyClass.myMethod("input")
);
check(
    "myBoolMethod(x) == true",
    true,
    MyClass.myBoolMethod(x)
);
```

Aim to cover:
- At least one edge case per method (null input, empty input, boundary values)
- All overloads if the method is overloaded

---

## Code Style

Follow the conventions already used in the codebase:

- Tabs for indentation, not spaces
- Opening braces on the same line
- `if (condition) { ... }` — always use braces, even for single-line bodies
- Throw `IllegalArgumentException` for invalid input with a clear message
- Check for `null` inputs where a `NullPointerException` would otherwise occur silently

---

## Submitting a Contribution

Contributions are accepted via **Discord DM to SRG**. [Join the server](https://discord.gg/w9aE98gKDs) and send a DM with:

1. A description of what you added or changed and why
2. Confirmation that all tests pass
3. Your code (as a patch, branch link, or file)
4. What you would like to be displayed as in the `Ujt.ujtContributors` array.

---

## License

By contributing, you agree that your code will be released under the [MIT License](LICENSE).

## Further Questions

If you have any further questions, please DM me on Discord.
