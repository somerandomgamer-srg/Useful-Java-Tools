# Useful Java Tools (UJT) &nbsp;·&nbsp; Version 1.0.0

> A comprehensive, zero-dependency utility library for Java. 236 methods across 17 classes, built entirely on the standard library.

---

## Table of Contents

- [About the Creator](#about-the-creator)
- [About this Project](#about-this-project)
- [Usage](#usage)
- [Statistics](#statistics)
- [Contact](#contact)
- [License](#license)
- [Disclaimers](#disclaimers)

---

## About the Creator

Hello, I am **SRG** (short for `Some Random Gamer`).

- I have been into coding for about a year.
- I know how to:
	- Code with JavaScript
	- Code with Java
	- Code with Lua
	- Code with Luau - a variant of Lua made specifically for Roblox
	- Work with SQL datastores
	- Partially code with Python *(and always willing to learn more)*
- I originally got into coding because of my online friend **Michialok**.
- I started in Roblox and have been self-teaching ever since.

---

## About this Project

I first learned Java through my APCSA (AP Computer Science A) class, but quickly went beyond the curriculum and started learning on my own, so much further ahead in the curriculum to the point where I now use class time as free time.

Coming from Lua, Java was a big adjustment. A few of the biggest differences I noticed:

1. **Type system**: Lua is dynamically typed; Java is statically typed. Every variable needs an explicit type.
2. **Variable declarations**: In Lua you just write `x = 5`. In Java you write `int x = 5`.
3. **Arrays**: Lua tables are incredibly flexible (mixed types, key-value pairs out of the box). Java arrays are rigid by comparison, requiring multiple classes to replicate that flexibility.

I can list so many differences here, but it might cause this file to be a million lines long, so I'll only list these 3.

Not that long ago, I made ULT (Useful Lua Tools). If you want to check it out, [you can check it out here!](https://github.com/somerandomgamer-srg/Useful-Lua-Tools).

After moving to Java, I noticed how powerful it was, but i also noticed how much boilerplate you need for even simple things. UJT was born from the same idea as ULT: reduce that boilerplate and make common tasks simpler.    

This project aims to provide a comprehensive, zero-dependency utility library for Java developers, while simplifying the coding language a little bit.

---

## Usage

**1. Clone the repository and install locally:**
```bash
mvn clean install
```

**2. Add the dependency to your `pom.xml`:**
```xml
<dependency>
	<groupId>io.github.somerandomgamer-srg</groupId>
	<artifactId>useful-java-tools</artifactId>
	<version>1.0.0</version>
</dependency>
```

**3. Import the classes you need:**
```java
import ujt.*;          // import everything
import ujt.Binary;     // or import a specific class
```

**4. Start using the methods in your application.**

---

## Statistics

### Overview

| Stat | Value |
|-|:-|
| Total Classes | 17 |
| Total Methods | 236 |
| Total Variables | 24 |
| Total Methods + Variables | 260 |
| Lines of Code | 5,162 |
| File Size | ~154 KB |
| Language | Java 17+ |
| External Dependencies | None |

### Classes Included

`Binary` &nbsp;`ClipboardUtils` &nbsp;`ColorUtils` &nbsp;`Cryptography` &nbsp;`Csv` &nbsp;`DateUtils` &nbsp;`Encoding` &nbsp;`FileUtils` &nbsp;`Json` &nbsp;`Jvm` &nbsp;`MathUtils` &nbsp;`RandomUtils` &nbsp;`StringUtils` &nbsp;`SystemInfo` &nbsp;`Terminal` &nbsp;`Ujt` &nbsp;`Validate`

### Methods per Class

|      Class       | Methods |
|:----------------:|:-------:|
|    MathUtils     |   63    |
|    DateUtils     |   29    |
|    Terminal      |   26    |
|    FileUtils     |   22    |
|   ColorUtils     |   14    |
|  Cryptography    |   12    |
|    Encoding      |   12    |
|   StringUtils    |   11    |
|   RandomUtils    |    8    |
|      Csv         |    8    |
|     Binary       |    7    |
|      Jvm         |    6    |
|      Json        |    5    |
|    Validate      |    5    |
|      Ujt         |    4    |
| ClipboardUtils   |    4    |

### Variables per Class

|    Class     | Variables |
|:------------:|:---------:|
|  SystemInfo  |    12     |
|     Ujt      |     6     |
|     Jvm      |     4     |
|   Terminal   |     1     |
| RandomUtils  |     1     |

---

## Contact

| | |
|:--|:--|
| **Creator** | Some Random Gamer (SRG) |
| **Discord** | [Join the server](https://discord.gg/w9aE98gKDs) |
| **Bug reports** | [#bugs-suggestions-and-feedback](https://discord.com/channels/1296889247176982528/1298419569135980564) |
| **Contributions** | DM me on Discord |

---

## License

**MIT License** — Copyright (c) 2026 Some Random Gamer (SRG)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

---

## Disclaimers

1. **No Support Obligation** — SRG is under no obligation to provide support, updates, or maintenance for this toolkit.
2. **No Liability for Data Loss** — SRG is not responsible for any data loss or corruption that may occur from using this toolkit.
3. **Performance** — The functions provided may not be optimized for all use cases or performance requirements.
4. **Security** — While efforts have been made to implement secure functions, this toolkit should not be used for critical security applications without thorough review and testing.
5. **Compatibility** — The toolkit may not be compatible with all Java versions or implementations. Users should verify compatibility with their specific environment.
6. **Resource Usage** — Some functions may consume significant computational resources depending on input size and complexity.
7. **Documentation Accuracy** — While efforts are made to maintain accurate documentation, there may be discrepancies between documentation and actual functionality.
8. **Third-Party Dependencies** — Any issues arising from the use of third-party dependencies or libraries are not the responsibility of SRG.
9. **Breaking Changes** — Future updates may include breaking changes that could affect existing implementations.
10. **User Responsibility** — Users are responsible for testing and validating the functions for their specific use cases before implementing them in production environments.