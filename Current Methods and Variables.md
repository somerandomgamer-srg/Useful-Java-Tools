# **Table of Contents:**
- [Legend](#legend)
- [Summary](#summary)
- [1. Ujt Class (V1.0.0)](#1-ujt-class-v100)
  - [1.1 Ujt Variables](#11-ujt-variables)
    - [1.1.1 `Ujt.ujtVersion`](#111-ujtujtversion)
    - [1.1.2 `Ujt.ujtContributors`](#112-ujtujtcontributors)
    - [1.1.3 `Ujt.ujtMinimumJavaVersion`](#113-ujtujtminimumjavaversion)
    - [1.1.4 `Ujt.ujtReleaseDate`](#114-ujtujtreleasedate)
    - [1.1.5 `Ujt.ujtBuild`](#115-ujtujtbuild)
    - [1.1.6 `Ujt.ujtLicense`](#116-ujtujtlicense)
  - [1.2 Ujt Methods](#12-ujt-methods)
    - [1.2.1 `Ujt.ujtCheckJavaVersion()`](#121-ujtujtcheckjavaversion)
    - [1.2.2 `Ujt.sleep(double x)`](#122-ujtsleepdouble-x)
    - [1.2.3 `Ujt.executionTime(Runnable... methods)`](#123-ujtexecutiontimerunnable-methods)
    - [1.2.4 `Ujt.executionTime(int iterations, Runnable... method)`](#124-ujtexecutiontimeint-iterations-runnable-method)
- [2. Binary Class (V1.0.0)](#2-binary-class-v100)
  - [2.1 Binary Methods](#21-binary-methods)
    - [2.1.1 `Binary.toDecimal(String binary)`](#211-binarytodecimalstring-binary)
    - [2.1.2 `Binary.fromDecimal(long decimal)`](#212-binaryfromdecimallong-decimal)
    - [2.1.3 `Binary.add(String... binary)`](#213-binaryaddstring-binary)
    - [2.1.4 `Binary.subtract(String... binary)`](#214-binarysubtractstring-binary)
    - [2.1.5 `Binary.multiply(String... binary)`](#215-binarymultiplystring-binary)
    - [2.1.6 `Binary.divide(String... binary)`](#216-binarydividestring-binary)
    - [2.1.7 `Binary.sqrt(String binary)`](#217-binarysqrtstring-binary)
- [3. ClipboardUtils Class (V1.0.0)](#3-clipboardutils-class-v100)
  - [3.1 ClipboardUtils Methods](#31-clipboardutils-methods)
    - [3.1.1 `ClipboardUtils.read()`](#311-clipboardutilsread)
    - [3.1.2 `ClipboardUtils.write(String text)`](#312-clipboardutilswritestring-text)
    - [3.1.3 `ClipboardUtils.clear()`](#313-clipboardutilsclear)
    - [3.1.4 `ClipboardUtils.hasText()`](#314-clipboardutilshastext)
- [4. ColorUtils Class (V1.0.0)](#4-colorutils-class-v100)
  - [4.1 ColorUtils Methods](#41-colorutils-methods)
    - [4.1.1 `ColorUtils.toHex(int r, int g, int b)`](#411-colorutilstohexint-r-int-g-int-b)
    - [4.1.2 `ColorUtils.fromHex(String hex)`](#412-colorutilsfromhexstring-hex)
    - [4.1.3 `ColorUtils.toHsl(int r, int g, int b)`](#413-colorutilstohslint-r-int-g-int-b)
    - [4.1.4 `ColorUtils.fromHsl(double h, double s, double l)`](#414-colorutilsfromhsldouble-h-double-s-double-l)
    - [4.1.5 `ColorUtils.toHsv(int r, int g, int b)`](#415-colorutilstohsvint-r-int-g-int-b)
    - [4.1.6 `ColorUtils.fromHsv(double h, double s, double v)`](#416-colorutilsfromhsvdouble-h-double-s-double-v)
    - [4.1.7 `ColorUtils.blend(int r1, int g1, int b1, int r2, int g2, int b2, double ratio)`](#417-colorutilsblendint-r1-int-g1-int-b1-int-r2-int-g2-int-b2-double-ratio)
    - [4.1.8 `ColorUtils.complementary(int r, int g, int b)`](#418-colorutilscomplementaryint-r-int-g-int-b)
    - [4.1.9 `ColorUtils.lighten(int r, int g, int b, double amount)`](#419-colorutilslightenint-r-int-g-int-b-double-amount)
    - [4.1.10 `ColorUtils.darken(int r, int g, int b, double amount)`](#4110-colorutilsdarkenint-r-int-g-int-b-double-amount)
    - [4.1.11 `ColorUtils.luminance(int r, int g, int b)`](#4111-colorutilsluminanceint-r-int-g-int-b)
    - [4.1.12 `ColorUtils.isLight(int r, int g, int b)`](#4112-colorutilsislightint-r-int-g-int-b)
    - [4.1.13 `ColorUtils.isDark(int r, int g, int b)`](#4113-colorutilsisdarkint-r-int-g-int-b)
    - [4.1.14 `ColorUtils.contrastRatio(int r1, int g1, int b1, int r2, int g2, int b2)`](#4114-colorutilscontrastratioint-r1-int-g1-int-b1-int-r2-int-g2-int-b2)
- [5. Cryptography Class (V1.0.0)](#5-cryptography-class-v100)
  - [5.1 Cryptography Methods](#51-cryptography-methods)
    - [5.1.1 `Cryptography.caesarCipherEncrypt(String message, int shift)`](#511-cryptographycaesarcipherencryptstring-message-int-shift)
    - [5.1.2 `Cryptography.caesarCipherDecrypt(String message, int shift)`](#512-cryptographycaesarcipherdecryptstring-message-int-shift)
    - [5.1.3 `Cryptography.ror(String str, int displacement, int bits)`](#513-cryptographyrorstring-str-int-displacement-int-bits)
    - [5.1.4 `Cryptography.rol(String str, int displacement, int bits)`](#514-cryptographyrolstring-str-int-displacement-int-bits)
    - [5.1.5 `Cryptography.btest(int... numbers)`](#515-cryptographybtestint-numbers)
    - [5.1.6 `Cryptography.luhn(long x)`](#516-cryptographyluhnlong-x)
    - [5.1.7 `Cryptography.sha256(String str)`](#517-cryptographysha256string-str)
    - [5.1.8 `Cryptography.sha256String(String str)`](#518-cryptographysha256stringstring-str)
    - [5.1.9 `Cryptography.md5(String str)`](#519-cryptographymd5string-str)
    - [5.1.10 `Cryptography.md5String(String str)`](#5110-cryptographymd5stringstring-str)
    - [5.1.11 `Cryptography.sha1(String str)`](#5111-cryptographysha1string-str)
    - [5.1.12 `Cryptography.sha1String(String str)`](#5112-cryptographysha1stringstring-str)
- [6. Csv Class (V1.0.0)](#6-csv-class-v100)
  - [6.1 Csv Methods](#61-csv-methods)
    - [6.1.1 `Csv.read(String path)`](#611-csvreadstring-path)
    - [6.1.2 `Csv.read(String path, char delimiter)`](#612-csvreadstring-path-char-delimiter)
    - [6.1.3 `Csv.write(String path, List<String[]> data)`](#613-csvwritestring-path-liststring-data)
    - [6.1.4 `Csv.write(String path, List<String[]> data, char delimiter)`](#614-csvwritestring-path-liststring-data-char-delimiter)
    - [6.1.5 `Csv.parseLine(String line)`](#615-csvparselinestring-line)
    - [6.1.6 `Csv.parseLine(String line, char delimiter)`](#616-csvparselinestring-line-char-delimiter)
    - [6.1.7 `Csv.formatLine(String[] fields)`](#617-csvformatlinestring-fields)
    - [6.1.8 `Csv.formatLine(String[] fields, char delimiter)`](#618-csvformatlinestring-fields-char-delimiter)
- [7. DateUtils Class (V1.0.0)](#7-dateutils-class-v100)
  - [7.1 DateUtils Methods](#71-dateutils-methods)
    - [7.1.1 `DateUtils.today()`](#711-dateutilstoday)
    - [7.1.2 `DateUtils.now()`](#712-dateutilsnow)
    - [7.1.3 `DateUtils.format(LocalDate d, String pattern)`](#713-dateutilsformatlocaldate-d-string-pattern)
    - [7.1.4 `DateUtils.format(LocalDateTime dt, String pattern)`](#714-dateutilsformatlocaldatetime-dt-string-pattern)
    - [7.1.5 `DateUtils.parse(String dateStr, String pattern)`](#715-dateutilsparsestring-datestr-string-pattern)
    - [7.1.6 `DateUtils.parseDateTime(String dateTimeStr, String pattern)`](#716-dateutilsparsedatetimestring-datetimestr-string-pattern)
    - [7.1.7 `DateUtils.daysBetween(LocalDate from, LocalDate to)`](#717-dateutilsdaysbetweenlocaldate-from-localdate-to)
    - [7.1.8 `DateUtils.monthsBetween(LocalDate from, LocalDate to)`](#718-dateutilsmonthsbetweenlocaldate-from-localdate-to)
    - [7.1.9 `DateUtils.yearsBetween(LocalDate from, LocalDate to)`](#719-dateutilsyearsbetweenlocaldate-from-localdate-to)
    - [7.1.10 `DateUtils.addDays(LocalDate d, long days)`](#7110-dateutilsadddayslocaldate-d-long-days)
    - [7.1.11 `DateUtils.addMonths(LocalDate d, long months)`](#7111-dateutilsaddmonthslocaldate-d-long-months)
    - [7.1.12 `DateUtils.addYears(LocalDate d, long years)`](#7112-dateutilsaddyearslocaldate-d-long-years)
    - [7.1.13 `DateUtils.subtractDays(LocalDate d, long days)`](#7113-dateutilssubtractdayslocaldate-d-long-days)
    - [7.1.14 `DateUtils.subtractMonths(LocalDate d, long months)`](#7114-dateutilssubtractmonthslocaldate-d-long-months)
    - [7.1.15 `DateUtils.subtractYears(LocalDate d, long years)`](#7115-dateutilssubtractyearslocaldate-d-long-years)
    - [7.1.16 `DateUtils.isPast(LocalDate d)`](#7116-dateutilsispastlocaldate-d)
    - [7.1.17 `DateUtils.isFuture(LocalDate d)`](#7117-dateutilsisfuturelocaldate-d)
    - [7.1.18 `DateUtils.isToday(LocalDate d)`](#7118-dateutilsistodaylocaldate-d)
    - [7.1.19 `DateUtils.isLeapYear(int year)`](#7119-dateutilsisleapyearint-year)
    - [7.1.20 `DateUtils.startOfWeek(LocalDate d)`](#7120-dateutilsstartofweeklocaldate-d)
    - [7.1.21 `DateUtils.endOfWeek(LocalDate d)`](#7121-dateutilsendofweeklocaldate-d)
    - [7.1.22 `DateUtils.startOfMonth(LocalDate d)`](#7122-dateutilsstartofmonthlocaldate-d)
    - [7.1.23 `DateUtils.endOfMonth(LocalDate d)`](#7123-dateutilsendofmonthlocaldate-d)
    - [7.1.24 `DateUtils.dayOfWeek(LocalDate d)`](#7124-dateutilsdayofweeklocaldate-d)
    - [7.1.25 `DateUtils.dayOfYear(LocalDate d)`](#7125-dateutilsdayofyearlocaldate-d)
    - [7.1.26 `DateUtils.weekOfYear(LocalDate d)`](#7126-dateutilsweekofyearlocaldate-d)
    - [7.1.27 `DateUtils.convertTimezone(LocalDateTime dt, String fromZone, String toZone)`](#7127-dateutilsconverttimezonelocaldatetime-dt-string-fromzone-string-tozone)
    - [7.1.28 `DateUtils.toEpochSeconds(LocalDateTime dt)`](#7128-dateutilstoepochsecondslocaldatetime-dt)
    - [7.1.29 `DateUtils.fromEpochSeconds(long epochSeconds)`](#7129-dateutilsfromepochsecondslong-epochseconds)
- [8. Encoding Class (V1.0.0)](#8-encoding-class-v100)
  - [8.1 Encoding Methods](#81-encoding-methods)
    - [8.1.1 `Encoding.toAscii(String str)`](#811-encodingtoasciistring-str)
    - [8.1.2 `Encoding.fromAscii(String ascii)`](#812-encodingfromasciistring-ascii)
    - [8.1.3 `Encoding.toHex(String str)`](#813-encodingtohexstring-str)
    - [8.1.4 `Encoding.fromHex(String hex)`](#814-encodingfromhexstring-hex)
    - [8.1.5 `Encoding.toBinary(String str)`](#815-encodingtobinarystring-str)
    - [8.1.6 `Encoding.toBinary(String str, int bits)`](#816-encodingtobinarystring-str-int-bits)
    - [8.1.7 `Encoding.fromBinary(String binary)`](#817-encodingfrombinarystring-binary)
    - [8.1.8 `Encoding.fromBinary(String binary, int bits)`](#818-encodingfrombinarystring-binary-int-bits)
    - [8.1.9 `Encoding.toBase64(String str)`](#819-encodingtobase64string-str)
    - [8.1.10 `Encoding.fromBase64(String base64)`](#8110-encodingfrombase64string-base64)
    - [8.1.11 `Encoding.toBase64Url(String str)`](#8111-encodingtobase64urlstring-str)
    - [8.1.12 `Encoding.fromBase64Url(String base64)`](#8112-encodingfrombase64urlstring-base64)
- [9. FileUtils Class (V1.0.0)](#9-fileutils-class-v100)
  - [9.1 FileUtils Methods](#91-fileutils-methods)
    - [9.1.1 `FileUtils.createFile(String path, String content)`](#911-fileutilscreatefilestring-path-string-content)
    - [9.1.2 `FileUtils.createFile(String path)`](#912-fileutilscreatefilestring-path)
    - [9.1.3 `FileUtils.deleteFile(String path)`](#913-fileutilsdeletefilestring-path)
    - [9.1.4 `FileUtils.fileExists(String path)`](#914-fileutilsfileexistsstring-path)
    - [9.1.5 `FileUtils.readFile(String path)`](#915-fileutilsreadfilestring-path)
    - [9.1.6 `FileUtils.readLines(String path)`](#916-fileutilsreadlinesstring-path)
    - [9.1.7 `FileUtils.writeFile(String path, String content)`](#917-fileutilswritefilestring-path-string-content)
    - [9.1.8 `FileUtils.appendFile(String path, String content)`](#918-fileutilsappendfilestring-path-string-content)
    - [9.1.9 `FileUtils.renameFile(String oldPath, String newPath)`](#919-fileutilsrenamefilestring-oldpath-string-newpath)
    - [9.1.10 `FileUtils.copyFile(String sourcePath, String destinationPath)`](#9110-fileutilscopyfilestring-sourcepath-string-destinationpath)
    - [9.1.11 `FileUtils.moveFile(String sourcePath, String destinationPath)`](#9111-fileutilsmovefilestring-sourcepath-string-destinationpath)
    - [9.1.12 `FileUtils.createDirectory(String path)`](#9112-fileutilscreatedirectorystring-path)
    - [9.1.13 `FileUtils.createDirectories(String path)`](#9113-fileutilscreatedirectoriesstring-path)
    - [9.1.14 `FileUtils.listFiles(String path)`](#9114-fileutilslistfilesstring-path)
    - [9.1.15 `FileUtils.listFiles(String path, String extension)`](#9115-fileutilslistfilesstring-path-string-extension)
    - [9.1.16 `FileUtils.fileSize(String path)`](#9116-fileutilsfilesizestring-path)
    - [9.1.17 `FileUtils.isDirectory(String path)`](#9117-fileutilsisdirectorystring-path)
    - [9.1.18 `FileUtils.isFile(String path)`](#9118-fileutilsisfilestring-path)
    - [9.1.19 `FileUtils.isDirectoryEmpty(String path)`](#9119-fileutilsisdirectoryemptystring-path)
    - [9.1.20 `FileUtils.getFileExtension(String path)`](#9120-fileutilsgetfileextensionstring-path)
    - [9.1.21 `FileUtils.getFileName(String path)`](#9121-fileutilsgetfilenamestring-path)
    - [9.1.22 `FileUtils.getFileNameWithoutExtension(String path)`](#9122-fileutilsgetfilenamewithoutextensionstring-path)
- [10. HttpUtils Class (V1.0.0)](#10-httputils-class-v100)
  - [10.1 HttpUtils Variables](#101-httputils-variables)
    - [10.1.1 `HttpUtils.defaultTimeoutSeconds`](#1011-httputilsdefaulttimeoutseconds)
  - [10.2 HttpUtils Methods](#102-httputils-methods)
    - [10.2.1 `HttpUtils.get(String url)`](#1021-httputilsgetstring-url)
    - [10.2.2 `HttpUtils.get(String url, Map<String, String> headers, int timeoutSeconds)`](#1022-httputilsgetstring-url-mapstring-string-headers-int-timeoutseconds)
    - [10.2.3 `HttpUtils.post(String url, String body)`](#1023-httputilspoststring-url-string-body)
    - [10.2.4 `HttpUtils.post(String url, String body, Map<String, String> headers, int timeoutSeconds)`](#1024-httputilspoststring-url-string-body-mapstring-string-headers-int-timeoutseconds)
    - [10.2.5 `HttpUtils.put(String url, String body)`](#1025-httputilsputstring-url-string-body)
    - [10.2.6 `HttpUtils.put(String url, String body, Map<String, String> headers, int timeoutSeconds)`](#1026-httputilsputstring-url-string-body-mapstring-string-headers-int-timeoutseconds)
    - [10.2.7 `HttpUtils.delete(String url)`](#1027-httputilsdeletestring-url)
    - [10.2.8 `HttpUtils.delete(String url, Map<String, String> headers, int timeoutSeconds)`](#1028-httputilsdeletestring-url-mapstring-string-headers-int-timeoutseconds)
    - [10.2.9 `HttpUtils.head(String url)`](#1029-httputilsheadstring-url)
    - [10.2.10 `HttpUtils.getStatusCode(String url)`](#10210-httputilsgetstatuscodestring-url)
    - [10.2.11 `HttpUtils.getHeaders(String url)`](#10211-httputilsgetheadersstring-url)
    - [10.2.12 `HttpUtils.downloadFile(String url, String destinationPath)`](#10212-httputilsdownloadfilestring-url-string-destinationpath)
    - [10.2.13 `HttpUtils.urlEncode(String str)`](#10213-httputilsurlencodestring-str)
    - [10.2.14 `HttpUtils.urlDecode(String str)`](#10214-httputilsurldecodestring-str)
    - [10.2.15 `HttpUtils.buildQueryString(Map<String, String> params)`](#10215-httputilsbuildquerystringmapstring-string-params)
    - [10.2.16 `HttpUtils.parseQueryString(String query)`](#10216-httputilsparsequerystringstring-query)
    - [10.2.17 `HttpUtils.isSuccess(int statusCode)`](#10217-httputilsissuccessint-statuscode)
    - [10.2.18 `HttpUtils.isRedirect(int statusCode)`](#10218-httputilsisredirectint-statuscode)
    - [10.2.19 `HttpUtils.isClientError(int statusCode)`](#10219-httputilsisclienterrorint-statuscode)
    - [10.2.20 `HttpUtils.isServerError(int statusCode)`](#10220-httputilsisservererrorint-statuscode)
- [11. Json Class (V1.0.0)](#11-json-class-v100)
  - [11.1 Json Methods](#111-json-methods)
    - [11.1.1 `Json.toJson(Object value)`](#1111-jsontojsonobject-value)
    - [11.1.2 `Json.toPrettyJson(Object value)`](#1112-jsontoprettyjsonobject-value)
    - [11.1.3 `Json.parse(String jsonString)`](#1113-jsonparsestring-jsonstring)
    - [11.1.4 `Json.parseObject(String jsonString)`](#1114-jsonparseobjectstring-jsonstring)
    - [11.1.5 `Json.parseArray(String jsonString)`](#1115-jsonparsearraystring-jsonstring)
- [12. Jvm Class (V1.0.0)](#12-jvm-class-v100)
  - [12.1 Jvm Variables](#121-jvm-variables)
    - [12.1.1 `Jvm.currentWorkingDirectory`](#1211-jvmcurrentworkingdirectory)
    - [12.1.2 `Jvm.getJavaVersion`](#1212-jvmgetjavaversion)
    - [12.1.3 `Jvm.javaHome`](#1213-jvmjavahome)
    - [12.1.4 `Jvm.javaVendor`](#1214-jvmjavavendor)
  - [12.2 Jvm Methods](#122-jvm-methods)
    - [12.2.1 `Jvm.maxMemory()`](#1221-jvmmaxmemory)
    - [12.2.2 `Jvm.totalMemory()`](#1222-jvmtotalmemory)
    - [12.2.3 `Jvm.freeMemory()`](#1223-jvmfreememory)
    - [12.2.4 `Jvm.usedMemory()`](#1224-jvmusedmemory)
    - [12.2.5 `Jvm.getJavaUptime()`](#1225-jvmgetjavauptime)
    - [12.2.6 `Jvm.getJavaStartTime()`](#1226-jvmgetjavastarttime)
- [13. MathUtils Class (V1.0.0)](#13-mathutils-class-v100)
  - [13.1 MathUtils Methods](#131-mathutils-methods)
    - [13.1.1 `MathUtils.round(double x)`](#1311-mathutilsrounddouble-x)
    - [13.1.2 `MathUtils.round(double x, int precision)`](#1312-mathutilsrounddouble-x-int-precision)
    - [13.1.3 `MathUtils.inRange(double min, double max, double x)`](#1313-mathutilsinrangedouble-min-double-max-double-x)
    - [13.1.4 `MathUtils.average(int... numbers)`](#1314-mathutilsaverageint-numbers)
    - [13.1.5 `MathUtils.average(long... numbers)`](#1315-mathutilsaveragelong-numbers)
    - [13.1.6 `MathUtils.average(float... numbers)`](#1316-mathutilsaveragefloat-numbers)
    - [13.1.7 `MathUtils.average(double... numbers)`](#1317-mathutilsaveragedouble-numbers)
    - [13.1.8 `MathUtils.median(int... numbers)`](#1318-mathutilsmedianint-numbers)
    - [13.1.9 `MathUtils.median(long... numbers)`](#1319-mathutilsmedianlong-numbers)
    - [13.1.10 `MathUtils.median(float... numbers)`](#13110-mathutilsmedianfloat-numbers)
    - [13.1.11 `MathUtils.median(double... numbers)`](#13111-mathutilsmediandouble-numbers)
    - [13.1.12 `MathUtils.mode(int... numbers)`](#13112-mathutilsmodeint-numbers)
    - [13.1.13 `MathUtils.mode(long... numbers)`](#13113-mathutilsmodelong-numbers)
    - [13.1.14 `MathUtils.mode(float... numbers)`](#13114-mathutilsmodefloat-numbers)
    - [13.1.15 `MathUtils.mode(double... numbers)`](#13115-mathutilsmodedouble-numbers)
    - [13.1.16 `MathUtils.range(int... numbers)`](#13116-mathutilsrangeint-numbers)
    - [13.1.17 `MathUtils.range(long... numbers)`](#13117-mathutilsrangelong-numbers)
    - [13.1.18 `MathUtils.range(float... numbers)`](#13118-mathutilsrangefloat-numbers)
    - [13.1.19 `MathUtils.range(double... numbers)`](#13119-mathutilsrangedouble-numbers)
    - [13.1.20 `MathUtils.standardDeviation(int... numbers)`](#13120-mathutilsstandarddeviationint-numbers)
    - [13.1.21 `MathUtils.standardDeviation(long... numbers)`](#13121-mathutilsstandarddeviationlong-numbers)
    - [13.1.22 `MathUtils.standardDeviation(float... numbers)`](#13122-mathutilsstandarddeviationfloat-numbers)
    - [13.1.23 `MathUtils.standardDeviation(double... numbers)`](#13123-mathutilsstandarddeviationdouble-numbers)
    - [13.1.24 `MathUtils.gcd(int... numbers)`](#13124-mathutilsgcdint-numbers)
    - [13.1.25 `MathUtils.gcd(long... numbers)`](#13125-mathutilsgcdlong-numbers)
    - [13.1.26 `MathUtils.isPrime(long x)`](#13126-mathutilsisprimelong-x)
    - [13.1.27 `MathUtils.lcm(int... numbers)`](#13127-mathutilslcmint-numbers)
    - [13.1.28 `MathUtils.lcm(long... numbers)`](#13128-mathutilslcmlong-numbers)
    - [13.1.29 `MathUtils.acosh(double x)`](#13129-mathutilsacoshdouble-x)
    - [13.1.30 `MathUtils.atanh(double x)`](#13130-mathutilsatanhdouble-x)
    - [13.1.31 `MathUtils.asinh(double x)`](#13131-mathutilsasinhdouble-x)
    - [13.1.32 `MathUtils.fibonacci(long nth)`](#13132-mathutilsfibonaccilong-nth)
    - [13.1.33 `MathUtils.isWhole(double x)`](#13133-mathutilsiswholedouble-x)
    - [13.1.34 `MathUtils.isOdd(long x)`](#13134-mathutilsisoddlong-x)
    - [13.1.35 `MathUtils.isEven(long x)`](#13135-mathutilsisevenlong-x)
    - [13.1.36 `MathUtils.isPerfectSquare(long x)`](#13136-mathutilsisperfectsquarelong-x)
    - [13.1.37 `MathUtils.factorial(long x)`](#13137-mathutilsfactoriallong-x)
    - [13.1.38 `MathUtils.bigFactorial(long x)`](#13138-mathutilsbigfactoriallong-x)
    - [13.1.39 `MathUtils.permutation(long x, long r)`](#13139-mathutilspermutationlong-x-long-r)
    - [13.1.40 `MathUtils.combination(long x, long r)`](#13140-mathutilscombinationlong-x-long-r)
    - [13.1.41 `MathUtils.factors(long x)`](#13141-mathutilsfactorslong-x)
    - [13.1.42 `MathUtils.isPerfect(long x)`](#13142-mathutilsisperfectlong-x)
    - [13.1.43 `MathUtils.isDeficient(long x)`](#13143-mathutilsisdeficientlong-x)
    - [13.1.44 `MathUtils.isAbundant(long x)`](#13144-mathutilsisabundantlong-x)
    - [13.1.45 `MathUtils.classifyNumber(long x)`](#13145-mathutilsclassifynumberlong-x)
    - [13.1.46 `MathUtils.zScore(double x, int... numbers)`](#13146-mathutilszscoredouble-x-int-numbers)
    - [13.1.47 `MathUtils.zScore(double x, long... numbers)`](#13147-mathutilszscoredouble-x-long-numbers)
    - [13.1.48 `MathUtils.zScore(double x, float... numbers)`](#13148-mathutilszscoredouble-x-float-numbers)
    - [13.1.49 `MathUtils.zScore(double x, double... numbers)`](#13149-mathutilszscoredouble-x-double-numbers)
    - [13.1.50 `MathUtils.secant(double x)`](#13150-mathutilssecantdouble-x)
    - [13.1.51 `MathUtils.cosecant(double x)`](#13151-mathutilscosecantdouble-x)
    - [13.1.52 `MathUtils.cotangent(double x)`](#13152-mathutilscotangentdouble-x)
    - [13.1.53 `MathUtils.asecant(double x)`](#13153-mathutilsasecantdouble-x)
    - [13.1.54 `MathUtils.acosecant(double x)`](#13154-mathutilsacosecantdouble-x)
    - [13.1.55 `MathUtils.acotangent(double x)`](#13155-mathutilsacotangentdouble-x)
    - [13.1.56 `MathUtils.nroot(double x, long n)`](#13156-mathutilsnrootdouble-x-long-n)
    - [13.1.57 `MathUtils.mathMap(double x, double min1, double max1, double min2, double max2)`](#13157-mathutilsmathmapdouble-x-double-min1-double-max1-double-min2-double-max2)
    - [13.1.58 `MathUtils.distance2d(double x1, double y1, double x2, double y2)`](#13158-mathutilsdistance2ddouble-x1-double-y1-double-x2-double-y2)
    - [13.1.59 `MathUtils.distance3d(double x1, double y1, double z1, double x2, double y2, double z2)`](#13159-mathutilsdistance3ddouble-x1-double-y1-double-z1-double-x2-double-y2-double-z2)
    - [13.1.60 `MathUtils.aos(double a, double b)`](#13160-mathutilsaosdouble-a-double-b)
    - [13.1.61 `MathUtils.vertex(double a, double b, double c)`](#13161-mathutilsvertexdouble-a-double-b-double-c)
    - [13.1.62 `MathUtils.clamp(double value, double min, double max)`](#13162-mathutilsclampdouble-value-double-min-double-max)
    - [13.1.63 `MathUtils.log(double x, double base)`](#13163-mathutilslogdouble-x-double-base)
- [14. RandomUtils Class (V1.0.0)](#14-randomutils-class-v100)
  - [14.1 RandomUtils Variables](#141-randomutils-variables)
    - [14.1.1 `RandomUtils.rng`](#1411-randomutilsrng)
  - [14.2 RandomUtils Methods](#142-randomutils-methods)
    - [14.2.1 `RandomUtils.randomInt(int min, int max)`](#1421-randomutilsrandomintint-min-int-max)
    - [14.2.2 `RandomUtils.randomDouble(double min, double max, int decimals)`](#1422-randomutilsrandomdoubledouble-min-double-max-int-decimals)
    - [14.2.3 `RandomUtils.randomLong(long min, long max)`](#1423-randomutilsrandomlonglong-min-long-max)
    - [14.2.4 `RandomUtils.randomFloat(float min, float max, int decimals)`](#1424-randomutilsrandomfloatfloat-min-float-max-int-decimals)
    - [14.2.5 `RandomUtils.randomHex(int length)`](#1425-randomutilsrandomhexint-length)
    - [14.2.6 `RandomUtils.randomColor()`](#1426-randomutilsrandomcolor)
    - [14.2.7 `RandomUtils.randomBoolean(double truePossibility, double falsePossibility)`](#1427-randomutilsrandombooleandouble-truepossibility-double-falsepossibility)
    - [14.2.8 `RandomUtils.randomSign(double x, double negativePossibility, double positivePossibility)`](#1428-randomutilsrandomsigndouble-x-double-negativepossibility-double-positivepossibility)
- [15. RegexUtils Class (V1.0.0)](#15-regexutils-class-v100)
  - [15.1 RegexUtils Methods](#151-regexutils-methods)
    - [15.1.1 `RegexUtils.matches(String str, String pattern)`](#1511-regexutilsmatchesstring-str-string-pattern)
    - [15.1.2 `RegexUtils.contains(String str, String pattern)`](#1512-regexutilscontainsstring-str-string-pattern)
    - [15.1.3 `RegexUtils.findFirst(String str, String pattern)`](#1513-regexutilsfindfirststring-str-string-pattern)
    - [15.1.4 `RegexUtils.findAll(String str, String pattern)`](#1514-regexutilsfindallstring-str-string-pattern)
    - [15.1.5 `RegexUtils.count(String str, String pattern)`](#1515-regexutilscountstring-str-string-pattern)
    - [15.1.6 `RegexUtils.replaceAll(String str, String pattern, String replacement)`](#1516-regexutilsreplaceallstring-str-string-pattern-string-replacement)
    - [15.1.7 `RegexUtils.replaceFirst(String str, String pattern, String replacement)`](#1517-regexutilsreplacefirststring-str-string-pattern-string-replacement)
    - [15.1.8 `RegexUtils.removeAll(String str, String pattern)`](#1518-regexutilsremoveallstring-str-string-pattern)
    - [15.1.9 `RegexUtils.split(String str, String pattern)`](#1519-regexutilssplitstring-str-string-pattern)
    - [15.1.10 `RegexUtils.split(String str, String pattern, int limit)`](#15110-regexutilssplitstring-str-string-pattern-int-limit)
    - [15.1.11 `RegexUtils.groups(String str, String pattern)`](#15111-regexutilsgroupsstring-str-string-pattern)
    - [15.1.12 `RegexUtils.allGroups(String str, String pattern)`](#15112-regexutilsallgroupsstring-str-string-pattern)
    - [15.1.13 `RegexUtils.namedGroup(String str, String pattern, String groupName)`](#15113-regexutilsnamedgroupstring-str-string-pattern-string-groupname)
    - [15.1.14 `RegexUtils.namedGroups(String str, String pattern)`](#15114-regexutilsnamedgroupsstring-str-string-pattern)
    - [15.1.15 `RegexUtils.matchPositions(String str, String pattern)`](#15115-regexutilsmatchpositionsstring-str-string-pattern)
    - [15.1.16 `RegexUtils.escape(String literal)`](#15116-regexutilsescapestring-literal)
    - [15.1.17 `RegexUtils.escapeReplacement(String literal)`](#15117-regexutilsescapereplacementstring-literal)
    - [15.1.18 `RegexUtils.isValidPattern(String pattern)`](#15118-regexutilsisvalidpatternstring-pattern)
- [16. StringUtils Class (V1.0.0)](#16-stringutils-class-v100)
  - [16.1 StringUtils Methods](#161-stringutils-methods)
    - [16.1.1 `StringUtils.capitalize(String s)`](#1611-stringutilscapitalizestring-s)
    - [16.1.2 `StringUtils.reverse(String s)`](#1612-stringutilsreversestring-s)
    - [16.1.3 `StringUtils.count(String s, String strToCheck)`](#1613-stringutilscountstring-s-string-strtocheck)
    - [16.1.4 `StringUtils.wrap(String str, int length)`](#1614-stringutilswrapstring-str-int-length)
    - [16.1.5 `StringUtils.mask(String str, String maskChar, int startCharactersVisible, int endCharactersVisible)`](#1615-stringutilsmaskstring-str-string-maskchar-int-startcharactersvisible-int-endcharactersvisible)
    - [16.1.6 `StringUtils.pad(String str, String character, int length, boolean includeStart, boolean includeEnd)`](#1616-stringutilspadstring-str-string-character-int-length-boolean-includestart-boolean-includeend)
    - [16.1.7 `StringUtils.isPalindrome(String str)`](#1617-stringutilsispalindromestring-str)
    - [16.1.8 `StringUtils.isPalindrome(String str, boolean caseSensitive)`](#1618-stringutilsispalindromestring-str-boolean-casesensitive)
    - [16.1.9 `StringUtils.levenshtein(String s1, String s2)`](#1619-stringutilslevenshteinstring-s1-string-s2)
    - [16.1.10 `StringUtils.titleCase(String str)`](#16110-stringutilstitlecasestring-str)
    - [16.1.11 `StringUtils.titleCase(String str, String sep)`](#16111-stringutilstitlecasestring-str-string-sep)
- [17. SystemInfo Class (V1.0.0)](#17-systeminfo-class-v100)
  - [17.1 SystemInfo Variables](#171-systeminfo-variables)
    - [17.1.1 `SystemInfo.userDirectory`](#1711-systeminfouserdirectory)
    - [17.1.2 `SystemInfo.timezone`](#1712-systeminfotimezone)
    - [17.1.3 `SystemInfo.country`](#1713-systeminfocountry)
    - [17.1.4 `SystemInfo.language`](#1714-systeminfolanguage)
    - [17.1.5 `SystemInfo.OSName`](#1715-systeminfoosname)
    - [17.1.6 `SystemInfo.fileSeparator`](#1716-systeminfofileseparator)
    - [17.1.7 `SystemInfo.pathSeparator`](#1717-systeminfopathseparator)
    - [17.1.8 `SystemInfo.lineSeparator`](#1718-systeminfolineseparator)
    - [17.1.9 `SystemInfo.OSVersion`](#1719-systeminfoosversion)
    - [17.1.10 `SystemInfo.OSArchitecture`](#17110-systeminfoosarchitecture)
    - [17.1.11 `SystemInfo.fileEncoding`](#17111-systeminfofileencoding)
    - [17.1.12 `SystemInfo.numOfCores`](#17112-systeminfonumofcores)
- [18. Terminal Class (V1.0.0)](#18-terminal-class-v100)
  - [18.1 Terminal Variables](#181-terminal-variables)
    - [18.1.1 `Terminal.terminalStyles`](#1811-terminalterminalstyles)
  - [18.2 Terminal Methods](#182-terminal-methods)
    - [18.2.1 `Terminal.color(int r, int g, int b, String s)`](#1821-terminalcolorint-r-int-g-int-b-string-s)
    - [18.2.2 `Terminal.color(int r, int g, int b, int i)`](#1822-terminalcolorint-r-int-g-int-b-int-i)
    - [18.2.3 `Terminal.color(int r, int g, int b, double d)`](#1823-terminalcolorint-r-int-g-int-b-double-d)
    - [18.2.4 `Terminal.color(int r, int g, int b, long l)`](#1824-terminalcolorint-r-int-g-int-b-long-l)
    - [18.2.5 `Terminal.color(int r, int g, int b, float f)`](#1825-terminalcolorint-r-int-g-int-b-float-f)
    - [18.2.6 `Terminal.color(int r, int g, int b, boolean bool)`](#1826-terminalcolorint-r-int-g-int-b-boolean-bool)
    - [18.2.7 `Terminal.strInput(String prompt)`](#1827-terminalstrinputstring-prompt)
    - [18.2.8 `Terminal.strInput(String prompt, String errorMessage)`](#1828-terminalstrinputstring-prompt-string-errormessage)
    - [18.2.9 `Terminal.intInput(String prompt)`](#1829-terminalintinputstring-prompt)
    - [18.2.10 `Terminal.intInput(String prompt, String errorMessage)`](#18210-terminalintinputstring-prompt-string-errormessage)
    - [18.2.11 `Terminal.dubInput(String prompt)`](#18211-terminaldubinputstring-prompt)
    - [18.2.12 `Terminal.dubInput(String prompt, String errorMessage)`](#18212-terminaldubinputstring-prompt-string-errormessage)
    - [18.2.13 `Terminal.longInput(String prompt)`](#18213-terminallonginputstring-prompt)
    - [18.2.14 `Terminal.longInput(String prompt, String errorMessage)`](#18214-terminallonginputstring-prompt-string-errormessage)
    - [18.2.15 `Terminal.floatInput(String prompt)`](#18215-terminalfloatinputstring-prompt)
    - [18.2.16 `Terminal.floatInput(String prompt, String errorMessage)`](#18216-terminalfloatinputstring-prompt-string-errormessage)
    - [18.2.17 `Terminal.loopVerifyRange(double min, double max, String prompt)`](#18217-terminalloopverifyrangedouble-min-double-max-string-prompt)
    - [18.2.18 `Terminal.loopVerifyRange(int min, int max, String prompt)`](#18218-terminalloopverifyrangeint-min-int-max-string-prompt)
    - [18.2.19 `Terminal.loopVerifyRange(long min, long max, String prompt)`](#18219-terminalloopverifyrangelong-min-long-max-string-prompt)
    - [18.2.20 `Terminal.loopVerifyRange(float min, float max, String prompt)`](#18220-terminalloopverifyrangefloat-min-float-max-string-prompt)
    - [18.2.21 `Terminal.loopVerifyBool(String prompt)`](#18221-terminalloopverifyboolstring-prompt)
    - [18.2.22 `Terminal.loopVerifyString(String option1, String option2, String prompt)`](#18222-terminalloopverifystringstring-option1-string-option2-string-prompt)
    - [18.2.23 `Terminal.loopVerifyStringRange(double min, double max, String s)`](#18223-terminalloopverifystringrangedouble-min-double-max-string-s)
    - [18.2.24 `Terminal.terminalStyle(String str, String[] options)`](#18224-terminalterminalstylestring-str-string-options)
    - [18.2.25 `Terminal.terminalStyle(String str, String style)`](#18225-terminalterminalstylestring-str-string-style)
    - [18.2.26 `Terminal.clear()`](#18226-terminalclear)
- [19. Validate Class (V1.0.0)](#19-validate-class-v100)
  - [19.1 Validate Methods](#191-validate-methods)
    - [19.1.1 `Validate.isValidEmail(String email)`](#1911-validateisvalidemailstring-email)
    - [19.1.2 `Validate.isValidURL(String url)`](#1912-validateisvalidurlstring-url)
    - [19.1.3 `Validate.isValidIP(String ip)`](#1913-validateisvalidipstring-ip)
    - [19.1.4 `Validate.isValidPort(int port)`](#1914-validateisvalidportint-port)
    - [19.1.5 `Validate.isValidMAC(String mac)`](#1915-validateisvalidmacstring-mac)
- [20. ZipUtils Class (V1.0.0)](#20-ziputils-class-v100)
  - [20.1 ZipUtils Methods](#201-ziputils-methods)
    - [20.1.1 `ZipUtils.zipFile(String sourceFile, String zipPath)`](#2011-ziputilszipfilestring-sourcefile-string-zippath)
    - [20.1.2 `ZipUtils.zipDirectory(String sourceDirectory, String zipPath)`](#2012-ziputilszipdirectorystring-sourcedirectory-string-zippath)
    - [20.1.3 `ZipUtils.zipFiles(String[] sourceFiles, String zipPath)`](#2013-ziputilszipfilesstring-sourcefiles-string-zippath)
    - [20.1.4 `ZipUtils.unzip(String zipPath, String destinationDirectory)`](#2014-ziputilsunzipstring-zippath-string-destinationdirectory)
    - [20.1.5 `ZipUtils.listEntries(String zipPath)`](#2015-ziputilslistentriesstring-zippath)
    - [20.1.6 `ZipUtils.entryCount(String zipPath)`](#2016-ziputilsentrycountstring-zippath)
    - [20.1.7 `ZipUtils.containsEntry(String zipPath, String entryName)`](#2017-ziputilscontainsentrystring-zippath-string-entryname)
    - [20.1.8 `ZipUtils.readEntry(String zipPath, String entryName)`](#2018-ziputilsreadentrystring-zippath-string-entryname)
    - [20.1.9 `ZipUtils.readEntryAsString(String zipPath, String entryName)`](#2019-ziputilsreadentryasstringstring-zippath-string-entryname)
    - [20.1.10 `ZipUtils.gzip(byte[] data)`](#20110-ziputilsgzipbyte-data)
    - [20.1.11 `ZipUtils.gzip(String str)`](#20111-ziputilsgzipstring-str)
    - [20.1.12 `ZipUtils.gunzip(byte[] data)`](#20112-ziputilsgunzipbyte-data)
    - [20.1.13 `ZipUtils.gunzipToString(byte[] data)`](#20113-ziputilsgunziptostringbyte-data)
    - [20.1.14 `ZipUtils.gzipFile(String sourceFile, String destinationFile)`](#20114-ziputilsgzipfilestring-sourcefile-string-destinationfile)
    - [20.1.15 `ZipUtils.gunzipFile(String sourceFile, String destinationFile)`](#20115-ziputilsgunzipfilestring-sourcefile-string-destinationfile)
    - [20.1.16 `ZipUtils.deflate(byte[] data)`](#20116-ziputilsdeflatebyte-data)
    - [20.1.17 `ZipUtils.inflate(byte[] data)`](#20117-ziputilsinflatebyte-data)
    - [20.1.18 `ZipUtils.isValidZip(String zipPath)`](#20118-ziputilsisvalidzipstring-zippath)

# **Legend:**
- ## **R**: Required parameter
- ## **...**: Multiple arguments/array argument
- ## **D**: Deprecated (method still works but may be removed in future versions)

# Summary

- ## **Total Methods**: 292

|      Class       | Methods |
|:----------------:|:-------:|
|    MathUtils     |   63    |
|    DateUtils     |   29    |
|     Terminal     |   26    |
|    FileUtils     |   22    |
|    HttpUtils     |   20    |
|    RegexUtils    |   18    |
|     ZipUtils     |   18    |
|    ColorUtils    |   14    |
|   Cryptography   |   12    |
|     Encoding     |   12    |
|   StringUtils    |   11    |
|       Csv        |    8    |
|   RandomUtils    |    8    |
|      Binary      |    7    |
|       Jvm        |    6    |
|       Json       |    5    |
|     Validate     |    5    |
|  ClipboardUtils  |    4    |
|       Ujt        |    4    |

- ## **Total Variables**: 25

|    Class     | Variables |
|:------------:|:---------:|
|  SystemInfo  |    12     |
|     Ujt      |     6     |
|     Jvm      |     4     |
|  HttpUtils   |     1     |
| RandomUtils  |     1     |
|   Terminal   |     1     |

- ## **Total Methods and Variables**: 317

# 1. Ujt Class (V1.0.0)
## 1.1 Ujt Variables
### 1.1.1 `Ujt.ujtVersion`
- **Type**: `String`
- **Description**: The version of Useful Java Tools ("Major Update"."Minor Update"."Patch").

### 1.1.2 `Ujt.ujtContributors`
- **Type**: `Array`
- **Description**: The people who contributed to Useful Java Tools.

### 1.1.3 `Ujt.ujtMinimumJavaVersion`
- **Type**: `Integer`
- **Description**: The minimum version of Java required to run Useful Java Tools.

### 1.1.4 `Ujt.ujtReleaseDate`
- **Type**: `String`
- **Description**: The release date of the current version of the library in the format of "YYYY-MM-DD".

### 1.1.5 `Ujt.ujtBuild`
- **Type**: `String`
- **Description**: The current build of UsefulJavaTools.

### 1.1.6 `Ujt.ujtLicense`
- **Type**: `String`
- **Description**: MIT license

## 1.2 Ujt Methods
### 1.2.1 `Ujt.ujtCheckJavaVersion()`
- **Arguments**: None
- **Returns**: `Void`
- **Description**: Checks if the current Java version is supported by this library.

### 1.2.2 `Ujt.sleep(double x)`
- **Arguments**:
	- `x`: **R** The amount of time to wait in seconds.
- **Returns**: `boolean` Whether or not the wait was successful.
- **Description**: Waits for a specified amount of time.

### 1.2.3 `Ujt.executionTime(Runnable... methods)`
- **Arguments**:
	- `methods`: **R** **...** The method(s) to measure the execution time of.
- **Returns**: `long` The execution time in nanoseconds.
- **Description**: Measures the execution time of 1 or more methods.

### 1.2.4 `Ujt.executionTime(int iterations, Runnable... method)`
- **Arguments**:
	- `iterations`: **R** The number of iterations to run the method(s) for.
	- `method`: **R** **...** The method(s) to measure the execution time of.
- **Returns**: `long` The execution time in nanoseconds.
- **Description**: Measures the execution time of 1 or more methods over a specified number of iterations.

---

# 2. Binary Class (V1.0.0)
## 2.1 Binary Methods
### 2.1.1 `Binary.toDecimal(String binary)`
- **Arguments**:
	- `binary`: **R** The binary string to convert to its decimal representation.
- **Returns**: `long` The decimal representation of the binary string.
- **Description**: Converts a binary string to its decimal representation.

### 2.1.2 `Binary.fromDecimal(long decimal)`
- **Arguments**:
	- `decimal`: **R** The decimal number to convert to its binary representation.
- **Returns**: `String` The binary representation of the decimal number.
- **Description**: Converts a decimal number to its binary representation.

### 2.1.3 `Binary.add(String... binary)`
- **Arguments**:
	- `binary`: **R** **...** The binary strings to add together.
- **Returns**: `String` The sum of the binary strings.
- **Description**: Adds two or more binary strings together.

### 2.1.4 `Binary.subtract(String... binary)`
- **Arguments**:
	- `binary`: **R** **...** The binary strings to subtract.
- **Returns**: `String` The difference of the binary strings. Negative results are prefixed with a `-` sign.
- **Description**: Subtracts two or more binary strings from one another.

### 2.1.5 `Binary.multiply(String... binary)`
- **Arguments**:
	- `binary`: **R** **...** The binary strings to multiply.
- **Returns**: `String` The product of the binary strings.
- **Description**: Multiplies two or more binary strings together.

### 2.1.6 `Binary.divide(String... binary)`
- **Arguments**:
	- `binary`: **R** **...** The binary strings to divide.
- **Returns**: `String` The quotient of the binary strings (integer division).
- **Description**: Divides two or more binary strings.

### 2.1.7 `Binary.sqrt(String binary)`
- **Arguments**:
	- `binary`: **R** The binary string to find the square root of.
- **Returns**: `String` The integer square root of the binary string, in binary.
- **Description**: Returns the square root of a binary number.

---

# 3. ClipboardUtils Class (V1.0.0)
> Requires a graphical environment — will not work in headless server contexts.

## 3.1 ClipboardUtils Methods
### 3.1.1 `ClipboardUtils.read()`
- **Arguments**: None
- **Returns**: `String` The clipboard text, or `null` if the clipboard contains no text.
- **Description**: Reads the current text content of the system clipboard.

### 3.1.2 `ClipboardUtils.write(String text)`
- **Arguments**:
	- `text`: **R** The text to write.
- **Returns**: `Void`
- **Description**: Writes a string to the system clipboard, replacing any existing content.

### 3.1.3 `ClipboardUtils.clear()`
- **Arguments**: None
- **Returns**: `Void`
- **Description**: Clears the system clipboard.

### 3.1.4 `ClipboardUtils.hasText()`
- **Arguments**: None
- **Returns**: `boolean` `true` if the clipboard has text content.
- **Description**: Checks whether the system clipboard currently contains text.

---

# 4. ColorUtils Class (V1.0.0)
## 4.1 ColorUtils Methods
### 4.1.1 `ColorUtils.toHex(int r, int g, int b)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
- **Returns**: `String` The hex color string (e.g. `"#ff8800"`).
- **Description**: Converts RGB values to a hex color string.

### 4.1.2 `ColorUtils.fromHex(String hex)`
- **Arguments**:
	- `hex`: **R** The hex color string. Accepts `"#rrggbb"` or `"rrggbb"`.
- **Returns**: `int[]` An array `[r, g, b]` with values 0–255.
- **Description**: Converts a hex color string to an RGB array.

### 4.1.3 `ColorUtils.toHsl(int r, int g, int b)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
- **Returns**: `double[]` An array `[hue (0–360), saturation (0–1), lightness (0–1)]`.
- **Description**: Converts RGB values to HSL.

### 4.1.4 `ColorUtils.fromHsl(double h, double s, double l)`
- **Arguments**:
	- `h`: **R** Hue (0–360).
	- `s`: **R** Saturation (0–1).
	- `l`: **R** Lightness (0–1).
- **Returns**: `int[]` An array `[r, g, b]` with values 0–255.
- **Description**: Converts HSL values to RGB.

### 4.1.5 `ColorUtils.toHsv(int r, int g, int b)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
- **Returns**: `double[]` An array `[hue (0–360), saturation (0–1), value (0–1)]`.
- **Description**: Converts RGB values to HSV.

### 4.1.6 `ColorUtils.fromHsv(double h, double s, double v)`
- **Arguments**:
	- `h`: **R** Hue (0–360).
	- `s`: **R** Saturation (0–1).
	- `v`: **R** Value (0–1).
- **Returns**: `int[]` An array `[r, g, b]` with values 0–255.
- **Description**: Converts HSV values to RGB.

### 4.1.7 `ColorUtils.blend(int r1, int g1, int b1, int r2, int g2, int b2, double ratio)`
- **Arguments**:
	- `r1`: **R** Red of the first color (0–255).
	- `g1`: **R** Green of the first color (0–255).
	- `b1`: **R** Blue of the first color (0–255).
	- `r2`: **R** Red of the second color (0–255).
	- `g2`: **R** Green of the second color (0–255).
	- `b2`: **R** Blue of the second color (0–255).
	- `ratio`: **R** How much of the first color to use (0.0 = all second, 1.0 = all first).
- **Returns**: `int[]` An array `[r, g, b]` of the blended color.
- **Description**: Blends two RGB colors together.

### 4.1.8 `ColorUtils.complementary(int r, int g, int b)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
- **Returns**: `int[]` An array `[r, g, b]` of the complementary color.
- **Description**: Returns the complementary color (opposite on the color wheel).

### 4.1.9 `ColorUtils.lighten(int r, int g, int b, double amount)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `amount`: **R** Amount to add to lightness (0–1).
- **Returns**: `int[]` An array `[r, g, b]` of the lightened color.
- **Description**: Lightens a color by increasing its HSL lightness.

### 4.1.10 `ColorUtils.darken(int r, int g, int b, double amount)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `amount`: **R** Amount to subtract from lightness (0–1).
- **Returns**: `int[]` An array `[r, g, b]` of the darkened color.
- **Description**: Darkens a color by decreasing its HSL lightness.

### 4.1.11 `ColorUtils.luminance(int r, int g, int b)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
- **Returns**: `double` The relative luminance (0–1).
- **Description**: Calculates the relative luminance of a color (WCAG definition).

### 4.1.12 `ColorUtils.isLight(int r, int g, int b)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
- **Returns**: `boolean` `true` if the color is light.
- **Description**: Returns whether a color is perceived as light.

### 4.1.13 `ColorUtils.isDark(int r, int g, int b)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
- **Returns**: `boolean` `true` if the color is dark.
- **Description**: Returns whether a color is perceived as dark.

### 4.1.14 `ColorUtils.contrastRatio(int r1, int g1, int b1, int r2, int g2, int b2)`
- **Arguments**:
	- `r1`: **R** Red of the first color (0–255).
	- `g1`: **R** Green of the first color (0–255).
	- `b1`: **R** Blue of the first color (0–255).
	- `r2`: **R** Red of the second color (0–255).
	- `g2`: **R** Green of the second color (0–255).
	- `b2`: **R** Blue of the second color (0–255).
- **Returns**: `double` The WCAG contrast ratio. A ratio of 4.5:1 or higher passes AA for normal text.
- **Description**: Calculates the WCAG contrast ratio between two colors.

---

# 5. Cryptography Class (V1.0.0)
## 5.1 Cryptography Methods
### 5.1.1 `Cryptography.caesarCipherEncrypt(String message, int shift)`
- **Arguments**:
	- `message`: **R** The message to encrypt.
	- `shift`: **R** The number of characters to shift by.
- **Returns**: `String` The encrypted message.
- **Description**: Encrypts a string using the Caesar cipher.

### 5.1.2 `Cryptography.caesarCipherDecrypt(String message, int shift)`
- **Arguments**:
	- `message`: **R** The message to decrypt.
	- `shift`: **R** The number of characters to shift by.
- **Returns**: `String` The decrypted message.
- **Description**: Decrypts a string encrypted with the Caesar cipher.

### 5.1.3 `Cryptography.ror(String str, int displacement, int bits)`
- **Arguments**:
	- `str`: **R** The string to rotate.
	- `displacement`: **R** The number of bits to rotate by.
	- `bits`: **R** The bit width of each character.
- **Returns**: `String` The rotated string.
- **Description**: Performs a bitwise rotate-right on each character of a string.

### 5.1.4 `Cryptography.rol(String str, int displacement, int bits)`
- **Arguments**:
	- `str`: **R** The string to rotate.
	- `displacement`: **R** The number of bits to rotate by.
	- `bits`: **R** The bit width of each character.
- **Returns**: `String` The rotated string.
- **Description**: Performs a bitwise rotate-left on each character of a string.

### 5.1.5 `Cryptography.btest(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to bitwise AND.
- **Returns**: `boolean` `true` if the result of the bitwise AND is non-zero.
- **Description**: Performs a bitwise AND on two or more numbers and returns whether the result is non-zero.

### 5.1.6 `Cryptography.luhn(long x)`
- **Arguments**:
	- `x`: **R** The number to validate.
- **Returns**: `boolean` Whether or not the number passes the Luhn check.
- **Description**: Performs the Luhn algorithm on a number. Commonly used to validate credit card numbers, IMEI numbers, and other identification numbers.

### 5.1.7 `Cryptography.sha256(String str)`
- **Arguments**:
	- `str`: **R** The string to hash.
- **Returns**: `byte[]` The SHA-256 hash as a byte array.
- **Description**: Hashes a string using SHA-256.

### 5.1.8 `Cryptography.sha256String(String str)`
- **Arguments**:
	- `str`: **R** The string to hash.
- **Returns**: `String` The SHA-256 hash as a hexadecimal string.
- **Description**: Hashes a string using SHA-256 and returns the result as a hex string.

### 5.1.9 `Cryptography.md5(String str)`
> **WARNING:** MD5 is not secure and should not be used for cryptographic purposes.
- **Arguments**:
	- `str`: **R** The string to hash.
- **Returns**: `byte[]` The MD5 hash as a byte array.
- **Description**: Hashes a string using MD5.

### 5.1.10 `Cryptography.md5String(String str)`
> **WARNING:** MD5 is not secure and should not be used for cryptographic purposes.
- **Arguments**:
	- `str`: **R** The string to hash.
- **Returns**: `String` The MD5 hash as a hexadecimal string.
- **Description**: Hashes a string using MD5 and returns the result as a hex string.

### 5.1.11 `Cryptography.sha1(String str)`
- **Arguments**:
	- `str`: **R** The string to hash.
- **Returns**: `byte[]` The SHA-1 hash as a byte array.
- **Description**: Hashes a string using SHA-1.

### 5.1.12 `Cryptography.sha1String(String str)`
- **Arguments**:
	- `str`: **R** The string to hash.
- **Returns**: `String` The SHA-1 hash as a hexadecimal string.
- **Description**: Hashes a string using SHA-1 and returns the result as a hex string.

---

# 6. Csv Class (V1.0.0)
## 6.1 Csv Methods
### 6.1.1 `Csv.read(String path)`
- **Arguments**:
	- `path`: **R** The path to the CSV file.
- **Returns**: `List<String[]>` A list of rows, each row being an array of field values.
- **Description**: Reads a CSV file and returns its rows as a list of string arrays. Handles quoted fields containing commas and newlines.

### 6.1.2 `Csv.read(String path, char delimiter)`
- **Arguments**:
	- `path`: **R** The path to the CSV file.
	- `delimiter`: **R** The character used to separate fields.
- **Returns**: `List<String[]>` A list of rows, each row being an array of field values.
- **Description**: Reads a CSV file with a custom delimiter and returns its rows as a list of string arrays.

### 6.1.3 `Csv.write(String path, List<String[]> data)`
- **Arguments**:
	- `path`: **R** The path to the CSV file.
	- `data`: **R** The rows to write.
- **Returns**: `Void`
- **Description**: Writes a list of rows to a CSV file using a comma delimiter, overwriting any existing content.

### 6.1.4 `Csv.write(String path, List<String[]> data, char delimiter)`
- **Arguments**:
	- `path`: **R** The path to the CSV file.
	- `data`: **R** The rows to write.
	- `delimiter`: **R** The character used to separate fields.
- **Returns**: `Void`
- **Description**: Writes a list of rows to a CSV file with a custom delimiter, overwriting any existing content.

### 6.1.5 `Csv.parseLine(String line)`
- **Arguments**:
	- `line`: **R** The CSV line to parse.
- **Returns**: `String[]` An array of field values.
- **Description**: Parses a single CSV line into an array of field values using a comma delimiter. Handles quoted fields containing commas.

### 6.1.6 `Csv.parseLine(String line, char delimiter)`
- **Arguments**:
	- `line`: **R** The CSV line to parse.
	- `delimiter`: **R** The character used to separate fields.
- **Returns**: `String[]` An array of field values.
- **Description**: Parses a single CSV line into an array of field values using a custom delimiter.

### 6.1.7 `Csv.formatLine(String[] fields)`
- **Arguments**:
	- `fields`: **R** The field values to format.
- **Returns**: `String` The formatted CSV line.
- **Description**: Formats an array of field values into a single CSV line using a comma delimiter. Fields containing commas, quotes, or newlines are automatically quoted.

### 6.1.8 `Csv.formatLine(String[] fields, char delimiter)`
- **Arguments**:
	- `fields`: **R** The field values to format.
	- `delimiter`: **R** The character used to separate fields.
- **Returns**: `String` The formatted CSV line.
- **Description**: Formats an array of field values into a single CSV line using a custom delimiter. Fields containing the delimiter, quotes, or newlines are automatically quoted.

---

# 7. DateUtils Class (V1.0.0)
## 7.1 DateUtils Methods
### 7.1.1 `DateUtils.today()`
- **Arguments**: None
- **Returns**: `LocalDate` Today's date.
- **Description**: Returns today's date.

### 7.1.2 `DateUtils.now()`
- **Arguments**: None
- **Returns**: `LocalDateTime` The current date and time.
- **Description**: Returns the current date and time.

### 7.1.3 `DateUtils.format(LocalDate d, String pattern)`
- **Arguments**:
	- `d`: **R** The date to format.
	- `pattern`: **R** The pattern to use (e.g. `"yyyy-MM-dd"`, `"MM/dd/yyyy"`).
- **Returns**: `String` The formatted date string.
- **Description**: Formats a `LocalDate` using the given pattern.

### 7.1.4 `DateUtils.format(LocalDateTime dt, String pattern)`
- **Arguments**:
	- `dt`: **R** The date-time to format.
	- `pattern`: **R** The pattern to use (e.g. `"yyyy-MM-dd HH:mm:ss"`).
- **Returns**: `String` The formatted date-time string.
- **Description**: Formats a `LocalDateTime` using the given pattern.

### 7.1.5 `DateUtils.parse(String dateStr, String pattern)`
- **Arguments**:
	- `dateStr`: **R** The date string to parse.
	- `pattern`: **R** The pattern to parse with (e.g. `"yyyy-MM-dd"`).
- **Returns**: `LocalDate` The parsed date.
- **Description**: Parses a date string into a `LocalDate` using the given pattern.

### 7.1.6 `DateUtils.parseDateTime(String dateTimeStr, String pattern)`
- **Arguments**:
	- `dateTimeStr`: **R** The date-time string to parse.
	- `pattern`: **R** The pattern to parse with (e.g. `"yyyy-MM-dd HH:mm:ss"`).
- **Returns**: `LocalDateTime` The parsed date-time.
- **Description**: Parses a date-time string into a `LocalDateTime` using the given pattern.

### 7.1.7 `DateUtils.daysBetween(LocalDate from, LocalDate to)`
- **Arguments**:
	- `from`: **R** The start date.
	- `to`: **R** The end date.
- **Returns**: `long` The number of days between the two dates. Negative if `from` is after `to`.
- **Description**: Returns the number of days between two dates.

### 7.1.8 `DateUtils.monthsBetween(LocalDate from, LocalDate to)`
- **Arguments**:
	- `from`: **R** The start date.
	- `to`: **R** The end date.
- **Returns**: `long` The number of whole months between the two dates. Negative if `from` is after `to`.
- **Description**: Returns the number of whole months between two dates.

### 7.1.9 `DateUtils.yearsBetween(LocalDate from, LocalDate to)`
- **Arguments**:
	- `from`: **R** The start date.
	- `to`: **R** The end date.
- **Returns**: `long` The number of whole years between the two dates. Negative if `from` is after `to`.
- **Description**: Returns the number of whole years between two dates.

### 7.1.10 `DateUtils.addDays(LocalDate d, long days)`
- **Arguments**:
	- `d`: **R** The base date.
	- `days`: **R** The number of days to add.
- **Returns**: `LocalDate` The resulting date.
- **Description**: Adds a number of days to a date.

### 7.1.11 `DateUtils.addMonths(LocalDate d, long months)`
- **Arguments**:
	- `d`: **R** The base date.
	- `months`: **R** The number of months to add.
- **Returns**: `LocalDate` The resulting date.
- **Description**: Adds a number of months to a date.

### 7.1.12 `DateUtils.addYears(LocalDate d, long years)`
- **Arguments**:
	- `d`: **R** The base date.
	- `years`: **R** The number of years to add.
- **Returns**: `LocalDate` The resulting date.
- **Description**: Adds a number of years to a date.

### 7.1.13 `DateUtils.subtractDays(LocalDate d, long days)`
- **Arguments**:
	- `d`: **R** The base date.
	- `days`: **R** The number of days to subtract.
- **Returns**: `LocalDate` The resulting date.
- **Description**: Subtracts a number of days from a date.

### 7.1.14 `DateUtils.subtractMonths(LocalDate d, long months)`
- **Arguments**:
	- `d`: **R** The base date.
	- `months`: **R** The number of months to subtract.
- **Returns**: `LocalDate` The resulting date.
- **Description**: Subtracts a number of months from a date.

### 7.1.15 `DateUtils.subtractYears(LocalDate d, long years)`
- **Arguments**:
	- `d`: **R** The base date.
	- `years`: **R** The number of years to subtract.
- **Returns**: `LocalDate` The resulting date.
- **Description**: Subtracts a number of years from a date.

### 7.1.16 `DateUtils.isPast(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to check.
- **Returns**: `boolean` `true` if the date is before today.
- **Description**: Checks whether a date is in the past.

### 7.1.17 `DateUtils.isFuture(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to check.
- **Returns**: `boolean` `true` if the date is after today.
- **Description**: Checks whether a date is in the future.

### 7.1.18 `DateUtils.isToday(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to check.
- **Returns**: `boolean` `true` if the date equals today.
- **Description**: Checks whether a date is today.

### 7.1.19 `DateUtils.isLeapYear(int year)`
- **Arguments**:
	- `year`: **R** The year to check.
- **Returns**: `boolean` `true` if the year is a leap year.
- **Description**: Checks whether a given year is a leap year.

### 7.1.20 `DateUtils.startOfWeek(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to find the start of week for.
- **Returns**: `LocalDate` The Monday of that week.
- **Description**: Returns the date of the Monday of the week containing the given date.

### 7.1.21 `DateUtils.endOfWeek(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to find the end of week for.
- **Returns**: `LocalDate` The Sunday of that week.
- **Description**: Returns the date of the Sunday of the week containing the given date.

### 7.1.22 `DateUtils.startOfMonth(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to find the start of month for.
- **Returns**: `LocalDate` The first day of that month.
- **Description**: Returns the first day of the month for the given date.

### 7.1.23 `DateUtils.endOfMonth(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to find the end of month for.
- **Returns**: `LocalDate` The last day of that month.
- **Description**: Returns the last day of the month for the given date.

### 7.1.24 `DateUtils.dayOfWeek(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to get the day of week for.
- **Returns**: `String` The full name of the day (e.g. `"Monday"`).
- **Description**: Returns the full name of the day of the week for the given date.

### 7.1.25 `DateUtils.dayOfYear(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to get the day of year for.
- **Returns**: `int` The day of the year (1–365, or 1–366 in a leap year).
- **Description**: Returns the day of the year for the given date.

### 7.1.26 `DateUtils.weekOfYear(LocalDate d)`
- **Arguments**:
	- `d`: **R** The date to get the week number for.
- **Returns**: `int` The ISO week number (1–53).
- **Description**: Returns the ISO week number of the year for the given date.

### 7.1.27 `DateUtils.convertTimezone(LocalDateTime dt, String fromZone, String toZone)`
- **Arguments**:
	- `dt`: **R** The date-time to convert.
	- `fromZone`: **R** The source timezone ID (e.g. `"America/New_York"`).
	- `toZone`: **R** The target timezone ID (e.g. `"Europe/London"`).
- **Returns**: `LocalDateTime` The converted date-time in the target timezone.
- **Description**: Converts a `LocalDateTime` from one timezone to another.

### 7.1.28 `DateUtils.toEpochSeconds(LocalDateTime dt)`
- **Arguments**:
	- `dt`: **R** The date-time to convert.
- **Returns**: `long` The number of seconds since 1970-01-01T00:00:00Z.
- **Description**: Converts a `LocalDateTime` to Unix epoch seconds (UTC assumed).

### 7.1.29 `DateUtils.fromEpochSeconds(long epochSeconds)`
- **Arguments**:
	- `epochSeconds`: **R** The number of seconds since 1970-01-01T00:00:00Z.
- **Returns**: `LocalDateTime` The corresponding date-time.
- **Description**: Converts Unix epoch seconds back to a `LocalDateTime` (UTC assumed).

---

# 8. Encoding Class (V1.0.0)
## 8.1 Encoding Methods
### 8.1.1 `Encoding.toAscii(String str)`
- **Arguments**:
	- `str`: **R** The string to convert.
- **Returns**: `String` The ASCII code points of the string, space-separated.
- **Description**: Converts a string to a space-separated list of ASCII code points.

### 8.1.2 `Encoding.fromAscii(String ascii)`
- **Arguments**:
	- `ascii`: **R** The space-separated ASCII code points to convert.
- **Returns**: `String` The decoded string.
- **Description**: Converts a space-separated list of ASCII code points back to a string.

### 8.1.3 `Encoding.toHex(String str)`
- **Arguments**:
	- `str`: **R** The string to convert.
- **Returns**: `String` The hexadecimal representation of the string, space-separated.
- **Description**: Converts a string to a space-separated list of hexadecimal values.

### 8.1.4 `Encoding.fromHex(String hex)`
- **Arguments**:
	- `hex`: **R** The space-separated hexadecimal values to convert.
- **Returns**: `String` The decoded string.
- **Description**: Converts a space-separated list of hexadecimal values back to a string.

### 8.1.5 `Encoding.toBinary(String str)`
- **Arguments**:
	- `str`: **R** The string to convert.
- **Returns**: `String` The binary representation of the string (8 bits per character).
- **Description**: Converts a string to its binary representation using 8 bits per character.

### 8.1.6 `Encoding.toBinary(String str, int bits)`
- **Arguments**:
	- `str`: **R** The string to convert.
	- `bits`: **R** The number of bits to use for each character (8–32).
- **Returns**: `String` The binary representation of the string.
- **Description**: Converts a string to its binary representation using a custom bit width per character.

### 8.1.7 `Encoding.fromBinary(String binary)`
- **Arguments**:
	- `binary`: **R** The binary string to convert (must be a multiple of 8 bits).
- **Returns**: `String` The decoded string.
- **Description**: Converts a binary string back to a string using 8 bits per character.

### 8.1.8 `Encoding.fromBinary(String binary, int bits)`
- **Arguments**:
	- `binary`: **R** The binary string to convert (must be a multiple of `bits`).
	- `bits`: **R** The number of bits used per character (8–32).
- **Returns**: `String` The decoded string.
- **Description**: Converts a binary string back to a string using a custom bit width per character.

### 8.1.9 `Encoding.toBase64(String str)`
- **Arguments**:
	- `str`: **R** The string to encode.
- **Returns**: `String` The Base64-encoded string.
- **Description**: Encodes a string to Base64.

### 8.1.10 `Encoding.fromBase64(String base64)`
- **Arguments**:
	- `base64`: **R** The Base64 string to decode.
- **Returns**: `String` The decoded string.
- **Description**: Decodes a Base64 string back to a plain string.

### 8.1.11 `Encoding.toBase64Url(String str)`
- **Arguments**:
	- `str`: **R** The string to encode.
- **Returns**: `String` The URL-safe Base64-encoded string.
- **Description**: Encodes a string to URL-safe Base64.

### 8.1.12 `Encoding.fromBase64Url(String base64)`
- **Arguments**:
	- `base64`: **R** The URL-safe Base64 string to decode.
- **Returns**: `String` The decoded string.
- **Description**: Decodes a URL-safe Base64 string back to a plain string.

---

# 9. FileUtils Class (V1.0.0)
## 9.1 FileUtils Methods
### 9.1.1 `FileUtils.createFile(String path, String content)`
- **Arguments**:
	- `path`: **R** The path to the file.
	- `content`: **R** The content to write to the file.
- **Returns**: `boolean` Whether or not the file was created.
- **Description**: Creates a file at the given path with the given content. Creates parent directories if needed.

### 9.1.2 `FileUtils.createFile(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `boolean` Whether or not the file was created.
- **Description**: Creates an empty file at the given path. Creates parent directories if needed.

### 9.1.3 `FileUtils.deleteFile(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `boolean` Whether or not the file was deleted.
- **Description**: Deletes the file at the given path.

### 9.1.4 `FileUtils.fileExists(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `boolean` Whether or not the file exists.
- **Description**: Checks whether a file exists at the given path.

### 9.1.5 `FileUtils.readFile(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `String` The content of the file, or `null` if an error occurred.
- **Description**: Reads the entire contents of a file into a single string.

### 9.1.6 `FileUtils.readLines(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `List<String>` A list of lines from the file, or `null` if an error occurred.
- **Description**: Reads a file line by line and returns the lines as a list of strings.

### 9.1.7 `FileUtils.writeFile(String path, String content)`
- **Arguments**:
	- `path`: **R** The path to the file.
	- `content`: **R** The content to write.
- **Returns**: `boolean` Whether or not the file was written to.
- **Description**: Writes content to a file, overwriting any existing content.

### 9.1.8 `FileUtils.appendFile(String path, String content)`
- **Arguments**:
	- `path`: **R** The path to the file.
	- `content`: **R** The content to append.
- **Returns**: `boolean` Whether or not the content was appended.
- **Description**: Appends content to the end of a file.

### 9.1.9 `FileUtils.renameFile(String oldPath, String newPath)`
- **Arguments**:
	- `oldPath`: **R** The current path of the file.
	- `newPath`: **R** The new path for the file.
- **Returns**: `boolean` Whether or not the file was renamed.
- **Description**: Renames or moves a file from one path to another.

### 9.1.10 `FileUtils.copyFile(String sourcePath, String destinationPath)`
- **Arguments**:
	- `sourcePath`: **R** The path to the file to copy.
	- `destinationPath`: **R** The path to the destination file.
- **Returns**: `boolean` Whether or not the file was copied.
- **Description**: Copies a file from one path to another, overwriting the destination if it exists.

### 9.1.11 `FileUtils.moveFile(String sourcePath, String destinationPath)`
- **Arguments**:
	- `sourcePath`: **R** The path to the file to move.
	- `destinationPath`: **R** The path to the destination file.
- **Returns**: `boolean` Whether or not the file was moved.
- **Description**: Moves a file from one path to another, overwriting the destination if it exists.

### 9.1.12 `FileUtils.createDirectory(String path)`
- **Arguments**:
	- `path`: **R** The path of the directory to create.
- **Returns**: `boolean` Whether or not the directory was created.
- **Description**: Creates a single directory. The parent directory must already exist.

### 9.1.13 `FileUtils.createDirectories(String path)`
- **Arguments**:
	- `path`: **R** The path of the directory to create.
- **Returns**: `boolean` Whether or not the directory was created.
- **Description**: Creates a directory and any missing parent directories along the path.

### 9.1.14 `FileUtils.listFiles(String path)`
- **Arguments**:
	- `path`: **R** The path to the directory.
- **Returns**: `String[]` An array of path strings for each entry, or `null` if an error occurred.
- **Description**: Lists all files and subdirectories directly inside a directory (non-recursive).

### 9.1.15 `FileUtils.listFiles(String path, String extension)`
- **Arguments**:
	- `path`: **R** The path to the directory.
	- `extension`: **R** The file extension to filter by (e.g. `".txt"`, `".java"`).
- **Returns**: `String[]` An array of matching path strings, or `null` if an error occurred.
- **Description**: Lists all files directly inside a directory that match a given file extension (non-recursive).

### 9.1.16 `FileUtils.fileSize(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `long` The size of the file in bytes, or `-1` if an error occurred.
- **Description**: Returns the size of a file in bytes.

### 9.1.17 `FileUtils.isDirectory(String path)`
- **Arguments**:
	- `path`: **R** The path to check.
- **Returns**: `boolean` `true` if the path is a directory.
- **Description**: Checks whether the given path points to a directory.

### 9.1.18 `FileUtils.isFile(String path)`
- **Arguments**:
	- `path`: **R** The path to check.
- **Returns**: `boolean` `true` if the path is a regular file.
- **Description**: Checks whether the given path points to a regular file.

### 9.1.19 `FileUtils.isDirectoryEmpty(String path)`
- **Arguments**:
	- `path`: **R** The path to the directory.
- **Returns**: `boolean` `true` if the directory exists and is empty.
- **Description**: Checks whether a directory is empty (contains no files or subdirectories).

### 9.1.20 `FileUtils.getFileExtension(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `String` The extension including the dot (e.g. `".txt"`), or `""` if there is none.
- **Description**: Returns the file extension of the given path.

### 9.1.21 `FileUtils.getFileName(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `String` The full filename including its extension.
- **Description**: Returns the filename of the given path.

### 9.1.22 `FileUtils.getFileNameWithoutExtension(String path)`
- **Arguments**:
	- `path`: **R** The path to the file.
- **Returns**: `String` The filename without its extension.
- **Description**: Returns the filename of the given path, without its extension.

---

# 10. HttpUtils Class (V1.0.0)
## 10.1 HttpUtils Variables
### 10.1.1 `HttpUtils.defaultTimeoutSeconds`
- **Type**: `Integer`
- **Description**: The default timeout in seconds (30) used by overloads that don't take an explicit timeout.

## 10.2 HttpUtils Methods
### 10.2.1 `HttpUtils.get(String url)`
- **Arguments**:
	- `url`: **R** The URL to send a GET request to.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a GET request to the given URL and returns the response body as a string.

### 10.2.2 `HttpUtils.get(String url, Map<String, String> headers, int timeoutSeconds)`
- **Arguments**:
	- `url`: **R** The URL to send a GET request to.
	- `headers`: **R** A map of request headers to send (may be `null`).
	- `timeoutSeconds`: **R** The request timeout in seconds.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a GET request with custom headers and a custom timeout.

### 10.2.3 `HttpUtils.post(String url, String body)`
- **Arguments**:
	- `url`: **R** The URL to send a POST request to.
	- `body`: **R** The request body to send.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a POST request with the given body and returns the response body as a string.

### 10.2.4 `HttpUtils.post(String url, String body, Map<String, String> headers, int timeoutSeconds)`
- **Arguments**:
	- `url`: **R** The URL to send a POST request to.
	- `body`: **R** The request body to send.
	- `headers`: **R** A map of request headers to send (may be `null`).
	- `timeoutSeconds`: **R** The request timeout in seconds.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a POST request with custom headers and a custom timeout.

### 10.2.5 `HttpUtils.put(String url, String body)`
- **Arguments**:
	- `url`: **R** The URL to send a PUT request to.
	- `body`: **R** The request body to send.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a PUT request with the given body and returns the response body as a string.

### 10.2.6 `HttpUtils.put(String url, String body, Map<String, String> headers, int timeoutSeconds)`
- **Arguments**:
	- `url`: **R** The URL to send a PUT request to.
	- `body`: **R** The request body to send.
	- `headers`: **R** A map of request headers to send (may be `null`).
	- `timeoutSeconds`: **R** The request timeout in seconds.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a PUT request with custom headers and a custom timeout.

### 10.2.7 `HttpUtils.delete(String url)`
- **Arguments**:
	- `url`: **R** The URL to send a DELETE request to.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a DELETE request to the given URL and returns the response body as a string.

### 10.2.8 `HttpUtils.delete(String url, Map<String, String> headers, int timeoutSeconds)`
- **Arguments**:
	- `url`: **R** The URL to send a DELETE request to.
	- `headers`: **R** A map of request headers to send (may be `null`).
	- `timeoutSeconds`: **R** The request timeout in seconds.
- **Returns**: `String` The response body, or `null` if an error occurred.
- **Description**: Sends a DELETE request with custom headers and a custom timeout.

### 10.2.9 `HttpUtils.head(String url)`
- **Arguments**:
	- `url`: **R** The URL to send a HEAD request to.
- **Returns**: `int` The HTTP status code, or `-1` if an error occurred.
- **Description**: Sends a HEAD request to the given URL and returns the response status code.

### 10.2.10 `HttpUtils.getStatusCode(String url)`
- **Arguments**:
	- `url`: **R** The URL to query.
- **Returns**: `int` The HTTP status code, or `-1` if an error occurred.
- **Description**: Sends a GET request to the given URL and returns just the response status code.

### 10.2.11 `HttpUtils.getHeaders(String url)`
- **Arguments**:
	- `url`: **R** The URL to query.
- **Returns**: `Map<String, String>` A map of response header names to their values (multiple values for the same header are joined with `, `), or `null` if an error occurred.
- **Description**: Sends a GET request to the given URL and returns the response headers.

### 10.2.12 `HttpUtils.downloadFile(String url, String destinationPath)`
- **Arguments**:
	- `url`: **R** The URL to download from.
	- `destinationPath`: **R** The local file path to save the downloaded content to. The parent directory must already exist.
- **Returns**: `boolean` Whether or not the download succeeded (HTTP status in the range 200-299).
- **Description**: Downloads the content at the given URL and saves it to a local file.

### 10.2.13 `HttpUtils.urlEncode(String str)`
- **Arguments**:
	- `str`: **R** The string to encode.
- **Returns**: `String` The URL-encoded string, or `null` if an error occurred.
- **Description**: Percent-encodes a string for safe use in URLs (UTF-8).

### 10.2.14 `HttpUtils.urlDecode(String str)`
- **Arguments**:
	- `str`: **R** The URL-encoded string to decode.
- **Returns**: `String` The decoded string, or `null` if an error occurred.
- **Description**: Decodes a percent-encoded URL string (UTF-8).

### 10.2.15 `HttpUtils.buildQueryString(Map<String, String> params)`
- **Arguments**:
	- `params`: **R** A map of parameter names to values (may be `null`).
- **Returns**: `String` A URL-encoded query string (without the leading `?`), or `""` if `params` is `null` or empty. Entries with a `null` key are skipped, and `null` values are encoded as the empty string.
- **Description**: Builds a URL-encoded query string from a map of parameters.

### 10.2.16 `HttpUtils.parseQueryString(String query)`
- **Arguments**:
	- `query`: **R** The query string to parse, with or without a leading `?` (may be `null`).
- **Returns**: `Map<String, String>` A map of parameter names to decoded values (empty if `query` is `null` or empty). Parameters with no `=` are stored with an empty-string value.
- **Description**: Parses a URL-encoded query string into a map of parameter names to values.

### 10.2.17 `HttpUtils.isSuccess(int statusCode)`
- **Arguments**:
	- `statusCode`: **R** The HTTP status code to check.
- **Returns**: `boolean` `true` if the status code is in the range 200-299.
- **Description**: Checks whether an HTTP status code represents a successful response.

### 10.2.18 `HttpUtils.isRedirect(int statusCode)`
- **Arguments**:
	- `statusCode`: **R** The HTTP status code to check.
- **Returns**: `boolean` `true` if the status code is in the range 300-399.
- **Description**: Checks whether an HTTP status code represents a redirection.

### 10.2.19 `HttpUtils.isClientError(int statusCode)`
- **Arguments**:
	- `statusCode`: **R** The HTTP status code to check.
- **Returns**: `boolean` `true` if the status code is in the range 400-499.
- **Description**: Checks whether an HTTP status code represents a client error.

### 10.2.20 `HttpUtils.isServerError(int statusCode)`
- **Arguments**:
	- `statusCode`: **R** The HTTP status code to check.
- **Returns**: `boolean` `true` if the status code is in the range 500-599.
- **Description**: Checks whether an HTTP status code represents a server error.

---

# 11. Json Class (V1.0.0)
## 11.1 Json Methods
### 11.1.1 `Json.toJson(Object value)`
- **Arguments**:
	- `value`: **R** The value to serialize. Supports `String`, `Number`, `Boolean`, `null`, `Map`, `List`, and arrays.
- **Returns**: `String` The compact JSON string.
- **Description**: Serializes a Java object to a compact JSON string.

### 11.1.2 `Json.toPrettyJson(Object value)`
- **Arguments**:
	- `value`: **R** The value to serialize.
- **Returns**: `String` The indented (pretty-printed) JSON string.
- **Description**: Serializes a Java object to a pretty-printed JSON string.

### 11.1.3 `Json.parse(String jsonString)`
- **Arguments**:
	- `jsonString`: **R** The JSON string to parse.
- **Returns**: `Object` A `Map` for objects, `List` for arrays, `String`, `Long`, `Double`, `Boolean`, or `null`.
- **Description**: Parses a JSON string into a Java object.

### 11.1.4 `Json.parseObject(String jsonString)`
- **Arguments**:
	- `jsonString`: **R** The JSON object string.
- **Returns**: `Map<String, Object>` The parsed map.
- **Description**: Parses a JSON object string into a `Map`.

### 11.1.5 `Json.parseArray(String jsonString)`
- **Arguments**:
	- `jsonString`: **R** The JSON array string.
- **Returns**: `List<Object>` The parsed list.
- **Description**: Parses a JSON array string into a `List`.

---

# 12. Jvm Class (V1.0.0)
## 12.1 Jvm Variables
### 12.1.1 `Jvm.currentWorkingDirectory`
- **Type**: `String`
- **Description**: The current working directory of the Java Virtual Machine.

### 12.1.2 `Jvm.getJavaVersion`
- **Type**: `String`
- **Description**: The version of the Java Runtime Environment currently in use.

### 12.1.3 `Jvm.javaHome`
- **Type**: `String`
- **Description**: The installation directory of the Java Runtime Environment.

### 12.1.4 `Jvm.javaVendor`
- **Type**: `String`
- **Description**: The vendor of the Java Runtime Environment (e.g., Oracle, Eclipse Adoptium).

## 12.2 Jvm Methods
### 12.2.1 `Jvm.maxMemory()`
- **Arguments**: None
- **Returns**: `long` The maximum memory in bytes.
- **Description**: Returns the maximum amount of memory the JVM will attempt to use.

### 12.2.2 `Jvm.totalMemory()`
- **Arguments**: None
- **Returns**: `long` The total reserved memory in bytes.
- **Description**: Returns the total amount of memory currently reserved by the JVM from the host OS.

### 12.2.3 `Jvm.freeMemory()`
- **Arguments**: None
- **Returns**: `long` The free memory in bytes.
- **Description**: Returns the amount of reserved memory currently available for new objects.

### 12.2.4 `Jvm.usedMemory()`
- **Arguments**: None
- **Returns**: `long` The used memory in bytes (Total − Free).
- **Description**: Returns the amount of memory currently occupied by objects.

### 12.2.5 `Jvm.getJavaUptime()`
- **Arguments**: None
- **Returns**: `long` The JVM uptime in milliseconds.
- **Description**: Returns the total time the JVM has been running.

### 12.2.6 `Jvm.getJavaStartTime()`
- **Arguments**: None
- **Returns**: `long` The JVM start time in milliseconds since the epoch (1970-01-01).
- **Description**: Returns the point in time when the JVM was started.

---

# 13. MathUtils Class (V1.0.0)
## 13.1 MathUtils Methods
### 13.1.1 `MathUtils.round(double x)`
- **Arguments**:
	- `x`: **R** The number to round.
- **Returns**: `double` The rounded number (0 decimal places).
- **Description**: Rounds a number to the nearest integer.

### 13.1.2 `MathUtils.round(double x, int precision)`
- **Arguments**:
	- `x`: **R** The number to round.
	- `precision`: **R** The number of decimal places to round to.
- **Returns**: `double` The rounded number.
- **Description**: Rounds a number to a specified number of decimal places.

### 13.1.3 `MathUtils.inRange(double min, double max, double x)`
- **Arguments**:
	- `min`: **R** The minimum value of the range.
	- `max`: **R** The maximum value of the range.
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is in the range (inclusive).
- **Description**: Checks whether a number is within a given range.

### 13.1.4 `MathUtils.average(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to average (at least two required).
- **Returns**: `int` The integer average (truncated, not rounded).
- **Description**: Returns the average of two or more integers as an integer.

### 13.1.5 `MathUtils.average(long... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to average (at least two required).
- **Returns**: `long` The average.
- **Description**: Returns the average of two or more longs.

### 13.1.6 `MathUtils.average(float... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to average (at least two required).
- **Returns**: `float` The average.
- **Description**: Returns the average of two or more floats.

### 13.1.7 `MathUtils.average(double... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to average (at least two required).
- **Returns**: `double` The average.
- **Description**: Returns the average of two or more doubles.

### 13.1.8 `MathUtils.median(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the median of (at least two required).
- **Returns**: `double` The median.
- **Description**: Returns the median of two or more integers.

### 13.1.9 `MathUtils.median(long... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the median of (at least two required).
- **Returns**: `double` The median.
- **Description**: Returns the median of two or more longs.

### 13.1.10 `MathUtils.median(float... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the median of (at least two required).
- **Returns**: `double` The median.
- **Description**: Returns the median of two or more floats.

### 13.1.11 `MathUtils.median(double... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the median of (at least two required).
- **Returns**: `double` The median.
- **Description**: Returns the median of two or more doubles.

### 13.1.12 `MathUtils.mode(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the mode of (at least two required).
- **Returns**: `int[]` The mode(s). Contains multiple values if there is a tie.
- **Description**: Returns the mode(s) of two or more integers.

### 13.1.13 `MathUtils.mode(long... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the mode of (at least two required).
- **Returns**: `long[]` The mode(s).
- **Description**: Returns the mode(s) of two or more longs.

### 13.1.14 `MathUtils.mode(float... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the mode of (at least two required).
- **Returns**: `float[]` The mode(s).
- **Description**: Returns the mode(s) of two or more floats.

### 13.1.15 `MathUtils.mode(double... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the mode of (at least two required).
- **Returns**: `double[]` The mode(s).
- **Description**: Returns the mode(s) of two or more doubles.

### 13.1.16 `MathUtils.range(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the range of (at least two required).
- **Returns**: `int` The range (max − min).
- **Description**: Returns the statistical range of two or more integers.

### 13.1.17 `MathUtils.range(long... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the range of (at least two required).
- **Returns**: `long` The range.
- **Description**: Returns the statistical range of two or more longs.

### 13.1.18 `MathUtils.range(float... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the range of (at least two required).
- **Returns**: `float` The range.
- **Description**: Returns the statistical range of two or more floats.

### 13.1.19 `MathUtils.range(double... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the range of (at least two required).
- **Returns**: `double` The range.
- **Description**: Returns the statistical range of two or more doubles.

### 13.1.20 `MathUtils.standardDeviation(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the standard deviation of (at least two required).
- **Returns**: `double` The population standard deviation.
- **Description**: Returns the standard deviation of two or more integers.

### 13.1.21 `MathUtils.standardDeviation(long... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the standard deviation of (at least two required).
- **Returns**: `double` The population standard deviation.
- **Description**: Returns the standard deviation of two or more longs.

### 13.1.22 `MathUtils.standardDeviation(float... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the standard deviation of (at least two required).
- **Returns**: `double` The population standard deviation.
- **Description**: Returns the standard deviation of two or more floats.

### 13.1.23 `MathUtils.standardDeviation(double... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the standard deviation of (at least two required).
- **Returns**: `double` The population standard deviation.
- **Description**: Returns the standard deviation of two or more doubles.

### 13.1.24 `MathUtils.gcd(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the GCD of (at least two required).
- **Returns**: `int` The greatest common divisor.
- **Description**: Returns the greatest common divisor of two or more integers.

### 13.1.25 `MathUtils.gcd(long... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the GCD of (at least two required).
- **Returns**: `long` The greatest common divisor.
- **Description**: Returns the greatest common divisor of two or more longs.

### 13.1.26 `MathUtils.isPrime(long x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is prime.
- **Description**: Checks whether a number is prime.

### 13.1.27 `MathUtils.lcm(int... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the LCM of (at least two required).
- **Returns**: `int` The least common multiple.
- **Description**: Returns the least common multiple of two or more integers.

### 13.1.28 `MathUtils.lcm(long... numbers)`
- **Arguments**:
	- `numbers`: **R** **...** The numbers to find the LCM of (at least two required).
- **Returns**: `long` The least common multiple.
- **Description**: Returns the least common multiple of two or more longs.

### 13.1.29 `MathUtils.acosh(double x)`
- **Arguments**:
	- `x`: **R** The number to find the inverse hyperbolic cosine of.
- **Returns**: `double` The inverse hyperbolic cosine.
- **Description**: Returns the inverse hyperbolic cosine of a number.

### 13.1.30 `MathUtils.atanh(double x)`
- **Arguments**:
	- `x`: **R** The number to find the inverse hyperbolic tangent of.
- **Returns**: `double` The inverse hyperbolic tangent.
- **Description**: Returns the inverse hyperbolic tangent of a number.

### 13.1.31 `MathUtils.asinh(double x)`
- **Arguments**:
	- `x`: **R** The number to find the inverse hyperbolic sine of.
- **Returns**: `double` The inverse hyperbolic sine.
- **Description**: Returns the inverse hyperbolic sine of a number.

### 13.1.32 `MathUtils.fibonacci(long nth)`
- **Arguments**:
	- `nth`: **R** The position in the Fibonacci sequence (1-indexed).
- **Returns**: `long` The nth Fibonacci number.
- **Description**: Returns the nth number in the Fibonacci sequence. `fibonacci(1)` = 0, `fibonacci(2)` = 1.

### 13.1.33 `MathUtils.isWhole(double x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is a whole number.
- **Description**: Checks whether a number is a whole number (no fractional part).

### 13.1.34 `MathUtils.isOdd(long x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is odd.
- **Description**: Checks whether a number is odd.

### 13.1.35 `MathUtils.isEven(long x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is even.
- **Description**: Checks whether a number is even.

### 13.1.36 `MathUtils.isPerfectSquare(long x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is a perfect square.
- **Description**: Checks whether a number is a perfect square.

### 13.1.37 `MathUtils.factorial(long x)`
- **Arguments**:
	- `x`: **R** The number to find the factorial of (must be non-negative).
- **Returns**: `long` The factorial of the number.
- **Description**: Returns the factorial of a number. Returns 1 for `x = 0`.

### 13.1.38 `MathUtils.bigFactorial(long x)`
- **Arguments**:
	- `x`: **R** The number to find the factorial of (must be non-negative).
- **Returns**: `BigInteger` The factorial of the number.
- **Description**: Returns the factorial of a number as a `BigInteger`, supporting very large results.

### 13.1.39 `MathUtils.permutation(long x, long r)`
- **Arguments**:
	- `x`: **R** The total number of items.
	- `r`: **R** The number of items to choose (must be ≤ `x`).
- **Returns**: `long` The number of permutations.
- **Description**: Returns the number of permutations (ordered selections) of `r` items from `x`.

### 13.1.40 `MathUtils.combination(long x, long r)`
- **Arguments**:
	- `x`: **R** The total number of items.
	- `r`: **R** The number of items to choose (must be ≤ `x`).
- **Returns**: `long` The number of combinations.
- **Description**: Returns the number of combinations (unordered selections) of `r` items from `x`.

### 13.1.41 `MathUtils.factors(long x)`
- **Arguments**:
	- `x`: **R** The number to find the factors of (must be non-negative).
- **Returns**: `long[]` An array of all factors of the number.
- **Description**: Returns all factors of a number, including 1 and itself.

### 13.1.42 `MathUtils.isPerfect(long x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is a perfect number.
- **Description**: Checks whether a number is a perfect number (sum of its proper divisors equals itself).

### 13.1.43 `MathUtils.isDeficient(long x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is a deficient number.
- **Description**: Checks whether a number is a deficient number (sum of its proper divisors is less than itself).

### 13.1.44 `MathUtils.isAbundant(long x)`
- **Arguments**:
	- `x`: **R** The number to check.
- **Returns**: `boolean` Whether or not the number is an abundant number.
- **Description**: Checks whether a number is an abundant number (sum of its proper divisors is greater than itself).

### 13.1.45 `MathUtils.classifyNumber(long x)`
- **Arguments**:
	- `x`: **R** The number to classify.
- **Returns**: `String` `"Perfect"`, `"Deficient"`, or `"Abundant"`.
- **Description**: Classifies a number as perfect, deficient, or abundant.

### 13.1.46 `MathUtils.zScore(double x, int... numbers)`
- **Arguments**:
	- `x`: **R** The value to find the z-score of.
	- `numbers`: **R** **...** The dataset (at least two numbers required).
- **Returns**: `double` The z-score.
- **Description**: Returns the z-score of a value within an integer dataset.

### 13.1.47 `MathUtils.zScore(double x, long... numbers)`
- **Arguments**:
	- `x`: **R** The value to find the z-score of.
	- `numbers`: **R** **...** The dataset (at least two numbers required).
- **Returns**: `double` The z-score.
- **Description**: Returns the z-score of a value within a long dataset.

### 13.1.48 `MathUtils.zScore(double x, float... numbers)`
- **Arguments**:
	- `x`: **R** The value to find the z-score of.
	- `numbers`: **R** **...** The dataset (at least two numbers required).
- **Returns**: `double` The z-score.
- **Description**: Returns the z-score of a value within a float dataset.

### 13.1.49 `MathUtils.zScore(double x, double... numbers)`
- **Arguments**:
	- `x`: **R** The value to find the z-score of.
	- `numbers`: **R** **...** The dataset (at least two numbers required).
- **Returns**: `double` The z-score.
- **Description**: Returns the z-score of a value within a double dataset.

### 13.1.50 `MathUtils.secant(double x)`
- **Arguments**:
	- `x`: **R** The angle in radians.
- **Returns**: `double` The secant of the angle.
- **Description**: Returns the secant of an angle (1 / cos(x)).

### 13.1.51 `MathUtils.cosecant(double x)`
- **Arguments**:
	- `x`: **R** The angle in radians.
- **Returns**: `double` The cosecant of the angle.
- **Description**: Returns the cosecant of an angle (1 / sin(x)).

### 13.1.52 `MathUtils.cotangent(double x)`
- **Arguments**:
	- `x`: **R** The angle in radians.
- **Returns**: `double` The cotangent of the angle.
- **Description**: Returns the cotangent of an angle (1 / tan(x)).

### 13.1.53 `MathUtils.asecant(double x)`
- **Arguments**:
	- `x`: **R** The number to find the inverse secant of.
- **Returns**: `double` The inverse secant in radians.
- **Description**: Returns the inverse secant of a number (acos(1 / x)).

### 13.1.54 `MathUtils.acosecant(double x)`
- **Arguments**:
	- `x`: **R** The number to find the inverse cosecant of.
- **Returns**: `double` The inverse cosecant in radians.
- **Description**: Returns the inverse cosecant of a number (asin(1 / x)).

### 13.1.55 `MathUtils.acotangent(double x)`
- **Arguments**:
	- `x`: **R** The number to find the inverse cotangent of.
- **Returns**: `double` The inverse cotangent in radians.
- **Description**: Returns the inverse cotangent of a number (atan(1 / x)).

### 13.1.56 `MathUtils.nroot(double x, long n)`
- **Arguments**:
	- `x`: **R** The number to find the nth root of.
	- `n`: **R** The root to compute.
- **Returns**: `double` The nth root of the number.
- **Description**: Returns the nth root of a number.

### 13.1.57 `MathUtils.mathMap(double x, double min1, double max1, double min2, double max2)`
- **Arguments**:
	- `x`: **R** The value to map.
	- `min1`: **R** The minimum of the source range.
	- `max1`: **R** The maximum of the source range.
	- `min2`: **R** The minimum of the target range.
	- `max2`: **R** The maximum of the target range.
- **Returns**: `double` The mapped value in the target range.
- **Description**: Maps a value from one range to another (linear interpolation).

### 13.1.58 `MathUtils.distance2d(double x1, double y1, double x2, double y2)`
- **Arguments**:
	- `x1`: **R** The x coordinate of the first point.
	- `y1`: **R** The y coordinate of the first point.
	- `x2`: **R** The x coordinate of the second point.
	- `y2`: **R** The y coordinate of the second point.
- **Returns**: `double` The Euclidean distance between the two points.
- **Description**: Returns the 2D distance between two points.

### 13.1.59 `MathUtils.distance3d(double x1, double y1, double z1, double x2, double y2, double z2)`
- **Arguments**:
	- `x1`: **R** The x coordinate of the first point.
	- `y1`: **R** The y coordinate of the first point.
	- `z1`: **R** The z coordinate of the first point.
	- `x2`: **R** The x coordinate of the second point.
	- `y2`: **R** The y coordinate of the second point.
	- `z2`: **R** The z coordinate of the second point.
- **Returns**: `double` The Euclidean distance between the two points.
- **Description**: Returns the 3D distance between two points.

### 13.1.60 `MathUtils.aos(double a, double b)`
- **Arguments**:
	- `a`: **R** The coefficient of the quadratic term.
	- `b`: **R** The coefficient of the linear term.
- **Returns**: `double` The axis of symmetry.
- **Description**: Returns the axis of symmetry of a quadratic equation (−b / 2a).

### 13.1.61 `MathUtils.vertex(double a, double b, double c)`
- **Arguments**:
	- `a`: **R** The coefficient of the quadratic term.
	- `b`: **R** The coefficient of the linear term.
	- `c`: **R** The constant term.
- **Returns**: `Map<String, Double>` A map with keys `"x"` and `"y"` representing the vertex coordinates.
- **Description**: Returns the vertex of a quadratic equation.

### 13.1.62 `MathUtils.clamp(double value, double min, double max)`
- **Arguments**:
	- `value`: **R** The value to clamp.
	- `min`: **R** The minimum allowed value.
	- `max`: **R** The maximum allowed value.
- **Returns**: `double` The clamped value.
- **Description**: Clamps a value so it stays within the given range.

### 13.1.63 `MathUtils.log(double x, double base)`
- **Arguments**:
	- `x`: **R** The number to take the logarithm of.
	- `base`: **R** The base of the logarithm.
- **Returns**: `double` The logarithm of `x` in the given base.
- **Description**: Returns the logarithm of a number in a specified base.

---

# 14. RandomUtils Class (V1.0.0)
## 14.1 RandomUtils Variables
### 14.1.1 `RandomUtils.rng`
- **Type**: `SecureRandom`
- **Description**: The secure random number generator used by all random methods.

## 14.2 RandomUtils Methods
### 14.2.1 `RandomUtils.randomInt(int min, int max)`
- **Arguments**:
	- `min`: **R** The minimum integer value (inclusive).
	- `max`: **R** The maximum integer value (inclusive).
- **Returns**: `int` A random integer between min and max.
- **Description**: Returns a random integer in the given range.

### 14.2.2 `RandomUtils.randomDouble(double min, double max, int decimals)`
- **Arguments**:
	- `min`: **R** The minimum value (inclusive).
	- `max`: **R** The maximum value (inclusive).
	- `decimals`: **R** The number of decimal places.
- **Returns**: `double` A random double in the given range.
- **Description**: Returns a random double in the given range, rounded to a specified number of decimal places.

### 14.2.3 `RandomUtils.randomLong(long min, long max)`
- **Arguments**:
	- `min`: **R** The minimum value (inclusive).
	- `max`: **R** The maximum value (inclusive).
- **Returns**: `long` A random long in the given range.
- **Description**: Returns a random long in the given range.

### 14.2.4 `RandomUtils.randomFloat(float min, float max, int decimals)`
- **Arguments**:
	- `min`: **R** The minimum value (inclusive).
	- `max`: **R** The maximum value (inclusive).
	- `decimals`: **R** The number of decimal places.
- **Returns**: `float` A random float in the given range.
- **Description**: Returns a random float in the given range, rounded to a specified number of decimal places.

### 14.2.5 `RandomUtils.randomHex(int length)`
- **Arguments**:
	- `length`: **R** The length of the hex string.
- **Returns**: `String` A random hexadecimal string.
- **Description**: Returns a random hexadecimal string of the given length.

### 14.2.6 `RandomUtils.randomColor()`
- **Arguments**: None
- **Returns**: `Color` A random `java.awt.Color`.
- **Description**: Returns a random RGB color.

### 14.2.7 `RandomUtils.randomBoolean(double truePossibility, double falsePossibility)`
- **Arguments**:
	- `truePossibility`: **R** The percentage chance of returning `true` (must sum to 100 with `falsePossibility`).
	- `falsePossibility`: **R** The percentage chance of returning `false`.
- **Returns**: `boolean` A random boolean weighted by the given percentages.
- **Description**: Returns a random boolean using weighted probabilities.

### 14.2.8 `RandomUtils.randomSign(double x, double negativePossibility, double positivePossibility)`
- **Arguments**:
	- `x`: **R** The number to randomize the sign of.
	- `negativePossibility`: **R** The percentage chance of returning a negative value (must sum to 100 with `positivePossibility`).
	- `positivePossibility`: **R** The percentage chance of returning a positive value.
- **Returns**: `double` The number with a randomly chosen sign.
- **Description**: Returns the given number with a randomly chosen sign based on weighted probabilities.

---

# 15. RegexUtils Class (V1.0.0)
## 15.1 RegexUtils Methods
### 15.1.1 `RegexUtils.matches(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `boolean` `true` if the whole string matches the pattern, `false` for null inputs or invalid patterns.
- **Description**: Tests whether the entire input string matches the given pattern.

### 15.1.2 `RegexUtils.contains(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `boolean` `true` if at least one match exists in the string.
- **Description**: Tests whether the pattern is found anywhere in the input string.

### 15.1.3 `RegexUtils.findFirst(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `String` The first matching substring, or `null` if no match was found or an error occurred.
- **Description**: Returns the first substring of the input that matches the pattern.

### 15.1.4 `RegexUtils.findAll(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `List<String>` A list of all matching substrings (empty if there are none), or `null` if an error occurred.
- **Description**: Returns every substring of the input that matches the pattern.

### 15.1.5 `RegexUtils.count(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `int` The number of (non-overlapping) matches, or `-1` if an error occurred.
- **Description**: Counts how many times the pattern occurs in the input string.

### 15.1.6 `RegexUtils.replaceAll(String str, String pattern, String replacement)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
	- `replacement`: **R** The replacement string (supports `$0`, `$1`, ... back-references).
- **Returns**: `String` The resulting string, or `null` if an error occurred.
- **Description**: Replaces every match of the pattern in the input string with the given replacement.

### 15.1.7 `RegexUtils.replaceFirst(String str, String pattern, String replacement)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
	- `replacement`: **R** The replacement string.
- **Returns**: `String` The resulting string, or `null` if an error occurred.
- **Description**: Replaces only the first match of the pattern in the input string with the given replacement.

### 15.1.8 `RegexUtils.removeAll(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `String` The resulting string with all matches removed, or `null` if an error occurred.
- **Description**: Removes every match of the pattern from the input string.

### 15.1.9 `RegexUtils.split(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression to use as the separator.
- **Returns**: `String[]` The array of substrings, or `null` if an error occurred.
- **Description**: Splits the input string around matches of the given pattern.

### 15.1.10 `RegexUtils.split(String str, String pattern, int limit)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression to use as the separator.
	- `limit`: **R** The maximum number of substrings to return (see `Pattern.split` for the meaning of zero and negative values).
- **Returns**: `String[]` The array of substrings, or `null` if an error occurred.
- **Description**: Splits the input string around matches of the given pattern, up to a maximum number of pieces.

### 15.1.11 `RegexUtils.groups(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `String[]` The captured groups of the first match (index `0` is the whole match), or `null` if there is no match or an error occurred.
- **Description**: Returns the capture groups of the first match of the pattern in the input string.

### 15.1.12 `RegexUtils.allGroups(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `List<String[]>` A list of group arrays, one per match (empty if there are none), or `null` if an error occurred.
- **Description**: Returns the capture groups for every match of the pattern in the input string.

### 15.1.13 `RegexUtils.namedGroup(String str, String pattern, String groupName)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression containing a named group, e.g. `(?<year>\d{4})`.
	- `groupName`: **R** The name of the capture group to extract.
- **Returns**: `String` The captured value, or `null` if there is no match, the group does not exist, or an error occurred.
- **Description**: Returns the value of a named capture group from the first match of the pattern in the input string.

### 15.1.14 `RegexUtils.namedGroups(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `Map<String, String>` A map of group names to captured values in declaration order (empty if no match or no named groups), or `null` if an error occurred.
- **Description**: Returns a map of every explicitly named capture group to its value from the first match of the pattern in the input string.

### 15.1.15 `RegexUtils.matchPositions(String str, String pattern)`
- **Arguments**:
	- `str`: **R** The input string.
	- `pattern`: **R** The regular expression.
- **Returns**: `List<int[]>` A list of `[startInclusive, endExclusive]` pairs (empty if there are no matches), or `null` if an error occurred.
- **Description**: Returns the start and end positions of every match of the pattern in the input string.

### 15.1.16 `RegexUtils.escape(String literal)`
- **Arguments**:
	- `literal`: **R** The literal string to escape.
- **Returns**: `String` The escaped pattern string (using `\Q...\E`), or `null` if `literal` is `null`.
- **Description**: Escapes the given literal string so it can be safely used inside a regular expression without its metacharacters being interpreted.

### 15.1.17 `RegexUtils.escapeReplacement(String literal)`
- **Arguments**:
	- `literal`: **R** The literal replacement to escape.
- **Returns**: `String` The escaped replacement string, or `null` if `literal` is `null`.
- **Description**: Escapes the given literal string so it can be safely used inside a replacement string passed to `replaceAll` / `replaceFirst`.

### 15.1.18 `RegexUtils.isValidPattern(String pattern)`
- **Arguments**:
	- `pattern`: **R** The regular expression to test.
- **Returns**: `boolean` `true` if the pattern is syntactically valid.
- **Description**: Checks whether the given regular expression compiles successfully.

---

# 16. StringUtils Class (V1.0.0)
## 16.1 StringUtils Methods
### 16.1.1 `StringUtils.capitalize(String s)`
- **Arguments**:
	- `s`: **R** The string to capitalize.
- **Returns**: `String` The string with its first character uppercased.
- **Description**: Capitalizes the first character of a string.

### 16.1.2 `StringUtils.reverse(String s)`
- **Arguments**:
	- `s`: **R** The string to reverse.
- **Returns**: `String` The reversed string, or `null` if `s` is `null`.
- **Description**: Reverses a string.

### 16.1.3 `StringUtils.count(String s, String strToCheck)`
- **Arguments**:
	- `s`: **R** The string to search in.
	- `strToCheck`: **R** The substring to count occurrences of.
- **Returns**: `long` The number of non-overlapping occurrences of `strToCheck` in `s`.
- **Description**: Counts the number of times a substring appears in a string.

### 16.1.4 `StringUtils.wrap(String str, int length)`
- **Arguments**:
	- `str`: **R** The string to wrap.
	- `length`: **R** The maximum number of characters per line.
- **Returns**: `String` The word-wrapped string.
- **Description**: Wraps a string to a specified line length by inserting newlines between words.

### 16.1.5 `StringUtils.mask(String str, String maskChar, int startCharactersVisible, int endCharactersVisible)`
- **Arguments**:
	- `str`: **R** The string to mask.
	- `maskChar`: **R** The character(s) to use for masking.
	- `startCharactersVisible`: **R** The number of characters to leave visible at the start.
	- `endCharactersVisible`: **R** The number of characters to leave visible at the end.
- **Returns**: `String` The masked string.
- **Description**: Masks a string, leaving a specified number of characters visible at each end.

### 16.1.6 `StringUtils.pad(String str, String character, int length, boolean includeStart, boolean includeEnd)`
- **Arguments**:
	- `str`: **R** The string to pad.
	- `character`: **R** The character(s) to pad with.
	- `length`: **R** The number of padding characters to add on each side.
	- `includeStart`: **R** Whether to pad the start of the string.
	- `includeEnd`: **R** Whether to pad the end of the string.
- **Returns**: `String` The padded string.
- **Description**: Pads a string with a specified character on either or both sides.

### 16.1.7 `StringUtils.isPalindrome(String str)`
- **Arguments**:
	- `str`: **R** The string to check.
- **Returns**: `boolean` Whether or not the string is a palindrome (case-insensitive).
- **Description**: Checks whether a string is a palindrome (case-insensitive).

### 16.1.8 `StringUtils.isPalindrome(String str, boolean caseSensitive)`
- **Arguments**:
	- `str`: **R** The string to check.
	- `caseSensitive`: **R** Whether the check should be case-sensitive.
- **Returns**: `boolean` Whether or not the string is a palindrome.
- **Description**: Checks whether a string is a palindrome with optional case sensitivity.

### 16.1.9 `StringUtils.levenshtein(String s1, String s2)`
- **Arguments**:
	- `s1`: **R** The first string.
	- `s2`: **R** The second string.
- **Returns**: `long` The Levenshtein (edit) distance between the two strings.
- **Description**: Returns the Levenshtein distance between two strings — the minimum number of single-character edits needed to transform one string into the other.

### 16.1.10 `StringUtils.titleCase(String str)`
- **Arguments**:
	- `str`: **R** The string to convert.
- **Returns**: `String` The string in Title Case.
- **Description**: Converts a string to Title Case, splitting on whitespace.

### 16.1.11 `StringUtils.titleCase(String str, String sep)`
- **Arguments**:
	- `str`: **R** The string to convert.
	- `sep`: **R** The separator used to detect word boundaries.
- **Returns**: `String` The string in Title Case.
- **Description**: Converts a string to Title Case using a custom separator.

---

# 17. SystemInfo Class (V1.0.0)
## 17.1 SystemInfo Variables
### 17.1.1 `SystemInfo.userDirectory`
- **Type**: `String`
- **Description**: The user's home directory.

### 17.1.2 `SystemInfo.timezone`
- **Type**: `String`
- **Description**: The user's timezone (lowercase).

### 17.1.3 `SystemInfo.country`
- **Type**: `String`
- **Description**: The user's country code (lowercase).

### 17.1.4 `SystemInfo.language`
- **Type**: `String`
- **Description**: The user's language code (lowercase).

### 17.1.5 `SystemInfo.OSName`
- **Type**: `String`
- **Description**: The operating system name (lowercase).

### 17.1.6 `SystemInfo.fileSeparator`
- **Type**: `String`
- **Description**: The file separator character used by the operating system (e.g. `"/"` on Unix, `"\\"` on Windows).

### 17.1.7 `SystemInfo.pathSeparator`
- **Type**: `String`
- **Description**: The path separator character used by the operating system (e.g. `":"` on Unix, `";"` on Windows).

### 17.1.8 `SystemInfo.lineSeparator`
- **Type**: `String`
- **Description**: The line separator character(s) used by the operating system.

### 17.1.9 `SystemInfo.OSVersion`
- **Type**: `String`
- **Description**: The operating system version.

### 17.1.10 `SystemInfo.OSArchitecture`
- **Type**: `String`
- **Description**: The CPU architecture (lowercase, e.g. `"amd64"`, `"aarch64"`).

### 17.1.11 `SystemInfo.fileEncoding`
- **Type**: `String`
- **Description**: The file encoding used by the operating system (lowercase, e.g. `"utf-8"`).

### 17.1.12 `SystemInfo.numOfCores`
- **Type**: `int`
- **Description**: The number of processors (cores) available to the JVM.

---

# 18. Terminal Class (V1.0.0)
## 18.1 Terminal Variables
### 18.1.1 `Terminal.terminalStyles`
- **Type**: `Map<String, Integer>`
- **Description**: A map of style names to their ANSI escape codes. Available styles: `"bold"`, `"italic"`, `"underline"`, `"strikethrough"`, `"overline"`, `"text black"`, `"text red"`, `"text green"`, `"text yellow"`, `"text blue"`, `"text magenta"`, `"text cyan"`, `"text white"`, `"background black"`, `"background red"`, `"background green"`, `"background yellow"`, `"background blue"`, `"background magenta"`, `"background cyan"`, `"background white"`.

## 18.2 Terminal Methods
### 18.2.1 `Terminal.color(int r, int g, int b, String s)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `s`: **R** The string to color.
- **Returns**: `String` The ANSI-colored string.
- **Description**: Returns a string wrapped in ANSI RGB color codes, ready for printing.

### 18.2.2 `Terminal.color(int r, int g, int b, int i)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `i`: **R** The integer to color.
- **Returns**: `String` The ANSI-colored string.
- **Description**: Returns an integer as an ANSI-colored string.

### 18.2.3 `Terminal.color(int r, int g, int b, double d)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `d`: **R** The double to color.
- **Returns**: `String` The ANSI-colored string.
- **Description**: Returns a double as an ANSI-colored string.

### 18.2.4 `Terminal.color(int r, int g, int b, long l)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `l`: **R** The long to color.
- **Returns**: `String` The ANSI-colored string.
- **Description**: Returns a long as an ANSI-colored string.

### 18.2.5 `Terminal.color(int r, int g, int b, float f)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `f`: **R** The float to color.
- **Returns**: `String` The ANSI-colored string.
- **Description**: Returns a float as an ANSI-colored string.

### 18.2.6 `Terminal.color(int r, int g, int b, boolean bool)`
- **Arguments**:
	- `r`: **R** Red value (0–255).
	- `g`: **R** Green value (0–255).
	- `b`: **R** Blue value (0–255).
	- `bool`: **R** The boolean to color.
- **Returns**: `String` The ANSI-colored string.
- **Description**: Returns a boolean as an ANSI-colored string.

### 18.2.7 `Terminal.strInput(String prompt)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `String` The string entered by the user.
- **Description**: Prompts the user to enter a string and returns the input.

### 18.2.8 `Terminal.strInput(String prompt, String errorMessage)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
	- `errorMessage`: **R** The error message to display on failure. Use `{e}` as a placeholder for the exception.
- **Returns**: `String` The string entered by the user.
- **Description**: Prompts the user to enter a string and returns the input, using a custom error message on failure.

### 18.2.9 `Terminal.intInput(String prompt)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `int` The integer entered by the user.
- **Description**: Prompts the user to enter an integer and returns the input. Loops until valid input is given.

### 18.2.10 `Terminal.intInput(String prompt, String errorMessage)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
	- `errorMessage`: **R** The error message to display on invalid input. Use `{e}` as a placeholder for the exception.
- **Returns**: `int` The integer entered by the user.
- **Description**: Prompts the user to enter an integer with a custom error message. Loops until valid input is given.

### 18.2.11 `Terminal.dubInput(String prompt)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `double` The double entered by the user.
- **Description**: Prompts the user to enter a double and returns the input. Loops until valid input is given.

### 18.2.12 `Terminal.dubInput(String prompt, String errorMessage)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
	- `errorMessage`: **R** The error message to display on invalid input. Use `{e}` as a placeholder for the exception.
- **Returns**: `double` The double entered by the user.
- **Description**: Prompts the user to enter a double with a custom error message. Loops until valid input is given.

### 18.2.13 `Terminal.longInput(String prompt)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `long` The long entered by the user.
- **Description**: Prompts the user to enter a long and returns the input. Loops until valid input is given.

### 18.2.14 `Terminal.longInput(String prompt, String errorMessage)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
	- `errorMessage`: **R** The error message to display on invalid input. Use `{e}` as a placeholder for the exception.
- **Returns**: `long` The long entered by the user.
- **Description**: Prompts the user to enter a long with a custom error message. Loops until valid input is given.

### 18.2.15 `Terminal.floatInput(String prompt)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `float` The float entered by the user.
- **Description**: Prompts the user to enter a float and returns the input. Loops until valid input is given.

### 18.2.16 `Terminal.floatInput(String prompt, String errorMessage)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
	- `errorMessage`: **R** The error message to display on invalid input. Use `{e}` as a placeholder for the exception.
- **Returns**: `float` The float entered by the user.
- **Description**: Prompts the user to enter a float with a custom error message. Loops until valid input is given.

### 18.2.17 `Terminal.loopVerifyRange(double min, double max, String prompt)`
- **Arguments**:
	- `min`: **R** The minimum double value the user can enter.
	- `max`: **R** The maximum double value the user can enter.
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `double` The double entered by the user.
- **Description**: Prompts the user to enter a double and loops until the entered value is within the given range.

### 18.2.18 `Terminal.loopVerifyRange(int min, int max, String prompt)`
- **Arguments**:
	- `min`: **R** The minimum integer value the user can enter.
	- `max`: **R** The maximum integer value the user can enter.
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `int` The integer entered by the user.
- **Description**: Prompts the user to enter an integer and loops until the entered value is within the given range.

### 18.2.19 `Terminal.loopVerifyRange(long min, long max, String prompt)`
- **Arguments**:
	- `min`: **R** The minimum long value the user can enter.
	- `max`: **R** The maximum long value the user can enter.
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `long` The long entered by the user.
- **Description**: Prompts the user to enter a long and loops until the entered value is within the given range.

### 18.2.20 `Terminal.loopVerifyRange(float min, float max, String prompt)`
- **Arguments**:
	- `min`: **R** The minimum float value the user can enter.
	- `max`: **R** The maximum float value the user can enter.
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `float` The float entered by the user.
- **Description**: Prompts the user to enter a float and loops until the entered value is within the given range.

### 18.2.21 `Terminal.loopVerifyBool(String prompt)`
- **Arguments**:
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `boolean` `true` if the user types `"y"`, `false` if the user types `"n"`.
- **Description**: Prompts the user to enter `"y"` or `"n"` and loops until a valid answer is given.

### 18.2.22 `Terminal.loopVerifyString(String option1, String option2, String prompt)`
- **Arguments**:
	- `option1`: **R** The first valid option.
	- `option2`: **R** The second valid option.
	- `prompt`: **R** The prompt to display to the user.
- **Returns**: `String` The option entered by the user.
- **Description**: Prompts the user to choose between two string options and loops until a valid option is entered.

### 18.2.23 `Terminal.loopVerifyStringRange(double min, double max, String s)`
- **Arguments**:
	- `min`: **R** The minimum allowed string length.
	- `max`: **R** The maximum allowed string length.
	- `s`: **R** The prompt to display to the user.
- **Returns**: `String` The string entered by the user.
- **Description**: Prompts the user to enter a string and loops until its length is within the given range.

### 18.2.24 `Terminal.terminalStyle(String str, String[] options)`
- **Arguments**:
	- `str`: **R** The string to style.
	- `options`: **R** An array of style names to apply (see `Terminal.terminalStyles` for valid names).
- **Returns**: `String` The ANSI-styled string.
- **Description**: Applies one or more ANSI styles to a string.

### 18.2.25 `Terminal.terminalStyle(String str, String style)`
- **Arguments**:
	- `str`: **R** The string to style.
	- `style`: **R** The style name to apply (see `Terminal.terminalStyles` for valid names).
- **Returns**: `String` The ANSI-styled string.
- **Description**: Applies a single ANSI style to a string.

### 18.2.26 `Terminal.clear()`
- **Arguments**: None
- **Returns**: `Void`
- **Description**: Clears the terminal.

---

# 19. Validate Class (V1.0.0)
## 19.1 Validate Methods
### 19.1.1 `Validate.isValidEmail(String email)`
- **Arguments**:
	- `email`: **R** The email address to validate.
- **Returns**: `boolean` Whether or not the email matches a valid email format.
- **Description**: Validates an email address using a regex pattern.

### 19.1.2 `Validate.isValidURL(String url)`
- **Arguments**:
	- `url`: **R** The URL to validate.
- **Returns**: `boolean` Whether or not the URL is valid.
- **Description**: Validates a URL by attempting to parse it.

### 19.1.3 `Validate.isValidIP(String ip)`
- **Arguments**:
	- `ip`: **R** The IP address to validate.
- **Returns**: `boolean` Whether or not the IP is a valid IPv4 or IPv6 address.
- **Description**: Validates an IPv4 or IPv6 address using regex pattern matching (no DNS lookup).

### 19.1.4 `Validate.isValidPort(int port)`
- **Arguments**:
	- `port`: **R** The port number to validate.
- **Returns**: `boolean` Whether or not the port is in the valid range (0–65535).
- **Description**: Validates a port number.

### 19.1.5 `Validate.isValidMAC(String mac)`
- **Arguments**:
	- `mac`: **R** The MAC address to validate.
- **Returns**: `boolean` Whether or not the MAC address matches a valid format.
- **Description**: Validates a MAC address using a regex pattern. Accepts both `:` and `-` as separators.

---

# 20. ZipUtils Class (V1.0.0)
## 20.1 ZipUtils Methods
### 20.1.1 `ZipUtils.zipFile(String sourceFile, String zipPath)`
- **Arguments**:
	- `sourceFile`: **R** The path to the file to compress.
	- `zipPath`: **R** The path of the resulting zip file.
- **Returns**: `boolean` Whether or not the zip was created successfully.
- **Description**: Compresses a single file into a zip archive.

### 20.1.2 `ZipUtils.zipDirectory(String sourceDirectory, String zipPath)`
- **Arguments**:
	- `sourceDirectory`: **R** The path to the directory to compress.
	- `zipPath`: **R** The path of the resulting zip file.
- **Returns**: `boolean` Whether or not the zip was created successfully.
- **Description**: Recursively compresses an entire directory (and its contents) into a zip archive.

### 20.1.3 `ZipUtils.zipFiles(String[] sourceFiles, String zipPath)`
- **Arguments**:
	- `sourceFiles`: **R** An array of file paths to compress.
	- `zipPath`: **R** The path of the resulting zip file.
- **Returns**: `boolean` Whether or not the zip was created successfully.
- **Description**: Compresses multiple files into a single zip archive.

### 20.1.4 `ZipUtils.unzip(String zipPath, String destinationDirectory)`
- **Arguments**:
	- `zipPath`: **R** The path to the zip file to extract.
	- `destinationDirectory`: **R** The directory to extract the contents into.
- **Returns**: `boolean` Whether or not the extraction succeeded.
- **Description**: Extracts a zip archive into the given directory. Protects against Zip Slip path-traversal attacks.

### 20.1.5 `ZipUtils.listEntries(String zipPath)`
- **Arguments**:
	- `zipPath`: **R** The path to the zip file.
- **Returns**: `String[]` An array of entry names inside the archive, or `null` if an error occurred.
- **Description**: Lists the names of every entry inside a zip archive.

### 20.1.6 `ZipUtils.entryCount(String zipPath)`
- **Arguments**:
	- `zipPath`: **R** The path to the zip file.
- **Returns**: `int` The number of entries in the archive, or `-1` if an error occurred.
- **Description**: Returns the number of entries inside a zip archive.

### 20.1.7 `ZipUtils.containsEntry(String zipPath, String entryName)`
- **Arguments**:
	- `zipPath`: **R** The path to the zip file.
	- `entryName`: **R** The entry name to look for.
- **Returns**: `boolean` `true` if the archive contains an entry with the given name.
- **Description**: Checks whether a zip archive contains an entry with the given name.

### 20.1.8 `ZipUtils.readEntry(String zipPath, String entryName)`
- **Arguments**:
	- `zipPath`: **R** The path to the zip file.
	- `entryName`: **R** The name of the entry to read.
- **Returns**: `byte[]` The raw bytes of the entry, or `null` if the entry does not exist or an error occurred.
- **Description**: Reads the contents of a single entry inside a zip archive as raw bytes.

### 20.1.9 `ZipUtils.readEntryAsString(String zipPath, String entryName)`
- **Arguments**:
	- `zipPath`: **R** The path to the zip file.
	- `entryName`: **R** The name of the entry to read.
- **Returns**: `String` The contents of the entry decoded as a UTF-8 string, or `null` if an error occurred.
- **Description**: Reads the contents of a single entry inside a zip archive as a UTF-8 string.

### 20.1.10 `ZipUtils.gzip(byte[] data)`
- **Arguments**:
	- `data`: **R** The raw bytes to compress.
- **Returns**: `byte[]` The gzip-compressed bytes, or `null` if an error occurred.
- **Description**: Compresses raw bytes using the gzip format.

### 20.1.11 `ZipUtils.gzip(String str)`
- **Arguments**:
	- `str`: **R** The string to compress (UTF-8).
- **Returns**: `byte[]` The gzip-compressed bytes, or `null` if an error occurred.
- **Description**: Compresses a UTF-8 string using the gzip format.

### 20.1.12 `ZipUtils.gunzip(byte[] data)`
- **Arguments**:
	- `data`: **R** The gzip-compressed bytes.
- **Returns**: `byte[]` The decompressed bytes, or `null` if an error occurred.
- **Description**: Decompresses gzip-compressed bytes back to the original raw bytes.

### 20.1.13 `ZipUtils.gunzipToString(byte[] data)`
- **Arguments**:
	- `data`: **R** The gzip-compressed bytes.
- **Returns**: `String` The decompressed bytes decoded as a UTF-8 string, or `null` if an error occurred.
- **Description**: Decompresses gzip-compressed bytes and returns the result as a UTF-8 string.

### 20.1.14 `ZipUtils.gzipFile(String sourceFile, String destinationFile)`
- **Arguments**:
	- `sourceFile`: **R** The path to the file to compress.
	- `destinationFile`: **R** The path of the resulting `.gz` file.
- **Returns**: `boolean` Whether or not the file was compressed successfully.
- **Description**: Compresses a file using the gzip format and writes the result to another file.

### 20.1.15 `ZipUtils.gunzipFile(String sourceFile, String destinationFile)`
- **Arguments**:
	- `sourceFile`: **R** The path to the gzip-compressed file.
	- `destinationFile`: **R** The path to write the decompressed contents to.
- **Returns**: `boolean` Whether or not the file was decompressed successfully.
- **Description**: Decompresses a gzip-compressed file and writes the result to another file.

### 20.1.16 `ZipUtils.deflate(byte[] data)`
- **Arguments**:
	- `data`: **R** The raw bytes to compress.
- **Returns**: `byte[]` The deflate-compressed bytes, or `null` if an error occurred.
- **Description**: Compresses raw bytes using the raw deflate format (no gzip headers).

### 20.1.17 `ZipUtils.inflate(byte[] data)`
- **Arguments**:
	- `data`: **R** The deflate-compressed bytes.
- **Returns**: `byte[]` The decompressed bytes, or `null` if an error occurred.
- **Description**: Decompresses deflate-compressed bytes back to the original raw bytes.

### 20.1.18 `ZipUtils.isValidZip(String zipPath)`
- **Arguments**:
	- `zipPath`: **R** The path to the file to check.
- **Returns**: `boolean` `true` if the file exists and is a valid zip archive.
- **Description**: Checks whether a file is a valid (openable) zip archive.

