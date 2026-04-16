# Useful Java Tools (Version 1.0.0)
## (A message from the creator)
### About Me
Hello, I am SRG (short for `Some Random Gamer`).

- I have been into coding for about a year.
- I know how to:
	- Code with Javascript.
	- Code with Java.
	- Code with Lua
	- Code with Luau, a sub-version of Lua that was specifically made for Roblox
	- Make datastores with SQL
	- Partially code with Python. (Willing to learn more).
- I originally got into coding because of my online friend Michialok.
- I started coding in Roblox and self-taught myself most of the things I know.

## About this Project
I first learned Java in my APCSA (AP Computer Science A) class. I, however, decided to learn Java on my own, and am now using this class as free-time.

I first started coding in Luau, then moved onto Lua. When I started learning Java, I noticed an insane amount of different things that took some time getting used to.

1. First major difference, Lua is a dynamically-typed programming language, while Java is a statically-typed object-oriented programming language.

2. Second, in Lua, you didn't have to state what type of data your variables were. In Java, you have to state what type of data your variables were.

3. Third, arrays. In Lua, tables ('arrays' are called 'tables' in Lua) are super simple. You don't have to declare what type of data is in your tables, tables support multiple different types of formats, such as key-pairs (no need for 5+ different classes).

I can list so many differences here, but it might cause this file to be a million lines long, so I'll only list these 3.

Not that long ago, I made ULT (Useful Lua Tools). If you want to check it out, [you can check it out here!](https://github.com/somerandomgamer-srg/Useful-Lua-Tools).

After moving to Java, I noticed how powerful it was, but noticed how much boiler-plate coding you had to do to get what you wanted. I thought that, just like ULT, I should probably make UJT.

This project aims to provide a comprehensive, zero-dependency utility library for Java developers, while simplifying the coding language a little bit.

## Usage
Nothing much to say here.

1. Clone or download the repository and install:
```bash
mvn clean install
```
2. Add the dependency to your `pom.xml`:
```xml
<dependency>
	<groupId>com.srg</groupId>
	<artifactId>useful-java-tools</artifactId>
	<version>1.0.0</version>
</dependency>
```
3. Import the classes you need:
```java
import UsefulJavaTools.*;
```
```java
import UsefulJavaTools.Binary;
```
4. Start using the various functions in your application

## Statistics

### Overall
- **Total Methods**: 233
- **Total Variables**: 28
- **Total Methods/Variables**: 261
- **Total Lines of Code**: 5,162
- **File Size**: ~154 KB
- **Language**: Java 17+
- **External Dependencies**: None (pure Java standard library)
- **Total Classes**: 17

### Classes Included
`Binary`, `ClipboardUtils`, `ColorUtils`, `Cryptography`, `Csv`, `DateUtils`, `FileUtils`, `Json`, `Jvm`, `Main`, `MathUtils`, `RandomUtils`, `StringUtils`, `SystemInfo`, `Terminal`, `Validate`

### Methods per Class
|      Class       | Method Count |
|:----------------:|:------------:|
|     MathUtils    |      63      |
|     DateUtils    |      29      |
|     Terminal     |      26      |
|   Cryptography   |      24      |
|    FileUtils     |      22      |
|    ColorUtils    |      14      |
|   StringUtils    |      11      |
|    RandomUtils   |       8      |
|       Csv        |       8      |
|      Binary      |       7      |
|       Json       |       5      |
|     Validate     |       5      |
|       Ujt        |       4      |
|  ClipboardUtils  |       4      |
|       Jvm        |       2      |
|       Test       |       1      |

### Variables per Class
|      Class       | Variable Count |
|:----------------:|:--------------:|
|    SystemInfo    |       12       |
|       Jvm        |        8       |
|       Ujt        |        6       |
|     Terminal     |        1       |
|   RandomUtils    |        1       |

## Contact
For questions, suggestions, or contributions related to this template:

- **Creator**: Some Random Gamer (SRG)
- **Discord**: [Join my Discord Server!](https://discord.gg/w9aE98gKDs)
- **Issues**: Please report any bugs to the [bugs-suggestions-and-feedback](https://discord.com/channels/1296889247176982528/1298419569135980564) channel
- **Contributions**: DM me on Discord!

# MIT License and Stuff

## License
```
Copyright (c) 2026 Some Random Gamer (SRG)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
## Disclaimers
1. **No Support Obligation**: SRG is under no obligation to provide support, updates, or maintenance for this toolkit.

2. **No Liability for Data Loss**: SRG is not responsible for any data loss or corruption that may occur from using this toolkit.

3. **Performance Considerations**: The functions provided may not be optimized for all use cases or performance requirements.

4. **Security Disclaimer**: While efforts have been made to implement secure functions, this toolkit should not be used for critical security applications without thorough review and testing.

5. **Compatibility**: The toolkit may not be compatible with all Java versions or implementations. Users should verify compatibility with their specific environment.

6. **Resource Usage**: Some functions may consume significant computational resources depending on input size and complexity. Users should test performance with their specific use cases.

7. **Documentation Accuracy**: While efforts are made to maintain accurate documentation, there may be discrepancies between documentation and actual functionality.

8. **Third-Party Dependencies**: Any issues arising from the use of third-party dependencies or libraries are not the responsibility of SRG.

9. **Breaking Changes**: Future updates may include breaking changes that could affect existing implementations.

10. **User Responsibility**: Users are responsible for testing and validating the functions for their specific use cases before implementing them in production environments.
