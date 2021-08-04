<div align="center">
  <h1> PaperUpdater </h1>
  
API for PaperMC Minecraft Server core updates.
Made by [**The Asgard**](https://asgrad.fun/) with love 💙


[discord-invite]: https://discord.gg/QXSGvGrzDj
[discord-shield]: https://discord.com/api/guilds/646285836500860929/widget.png

[discord]: https://img.shields.io/badge/Our-discord-blue?style=for-the-badge&logo=discord

[version]: https://img.shields.io/badge/Version-1.4-success?style=for-the-badge&logo=wiki
[download]: #---get-started

[wiki]: https://img.shields.io/badge/-Our%20wiki-yellow?style=for-the-badge&logo=wiki
[wiki-url]: https://github.com/TheAsgard/PaperUpdater/wiki

[docs]: https://img.shields.io/badge/Our%20documentation-1.4-critical?style=for-the-badge&logo=wiki
[docs-url]: https://github.com/TheAsgard/PaperUpdater/wiki/Documentation

[javadocs]: https://img.shields.io/badge/Java%20Doc-1.4-orange?style=for-the-badge&logo=wiki
[javadocs-url]: https://theasgard.github.io/PaperUpdater/fun/asgard/package-summary.html

[![version][]][download]
[![wiki][]][wiki-url]
[![javadocs][]][javadocs-url]
[![docs][]][docs-url]
[![discord][]][discord-invite] 

[**Update from 1.3.1 to 1.4**](https://github.com/TheAsgard/PaperUpdater/wiki/Upgrade-from-1.3.1-to-1.4)
</div>

[papermc-url]: https://papermc.io/

## 🧩 - Get started

**Requires [PaperMC][papermc-url]**

> #### For Maven
```xml
<repository>
    <id>asgardfun</id>
    <url>https://asgard.fun/repository/maven-public/</url>
</repositorys>
```
```xml
<dependency>
    <groupId>fun.asgard</groupId>
    <artifactId>PaperUpdater</artifactId>
    <version>1.4</version>
</dependency>
```

____

> #### For Gradle
```gradle
repositories {
    maven { url "https://asgard.fun/repository/maven-public/" }
}
```
```gradle
dependencies {
    implementation 'fun.asgard:PaperUpdater:1.4'
}
```

## ✈ - Brief Guide

**PLEASE READ [OUR DOCUMENTATION][docs-url] ALSO! THIS GUIDE IS NOT ALL THE POSSIBILITIES OF OUR LIBRARY!**

#### Initialization

```java
public final class Example extends JavaPlugin {
    public static PaperUpdater PU;

    @Override
    public void onEnable() {
        PU = new PaperUpdater(this);
    }
}    
```

____

#### Checking for an update

```java
if (PU.isAvailableUpdate()) {
    // Update available
} else {
    // No new update found 
}
```

____

#### Get the latest build 

```java
PU.getLatestBuild()
```

____


#### Get the current JAR file 

```java
PU.getCurrentPaperJar()
```

____

#### Get the current build 

```java
PU.getCurrentPaperBuild()
```
____

#### Set the start file

```java
//                |File name|
PU.setStartingFile("start.sh")
```

____

#### Set the content of the start file

```java
//                        |           Example content          |
PU.setStartingFileContent("java -jar " + PU.getCurrentPaperJar())
```

____

#### Set JVM options (If you haven't specified the content of the start file, but have specified the name of the start file)

```java
//             |Example JVM options|
PU.setJVMOptions("-Xmx4G -Xms4G")
```

____

#### Set the path of the Java (If you haven't specified the content of the start file, but have specified the name of the start file)

```java
//             |     Example path of the Java   |
PU.setJavaPath("/usr/lib/jvm/jdk-16.0.2/bin/java")
```

____

#### Delete unnecessary JAR files in the server folder

```java
PU.removeUnneededPapers()
```

____

#### Download the latest build 

```java
PU.downloadLatestPaper()
```

____

#### Download a specific build of PaperMC

```java
//                                          |Build id|
PU.downloadPaper(PU.getUtils().getBuildById(    154   ))
```

____

#### File actions 

To make it convenient to handle the moment when, for example, the installation of a file was completed or files were deleted, we did the processing of such actions using `onComplete()` and `onError()` methods. Here are some examples: 

```java
PU.downloadPaper("468578534845858356845793")
    .onComplete(complete -> {
        System.out.println("Installation of build 468578534845858356845793 is complete!");
    })
    .onError(error -> {
        System.out.println("An error has occurred: " + error.getErrorMessage())
    });
```

```java
PU.removeUnneededPapers().onComplete(complete -> {
    System.out.println("Unnecessary Papers removed: " + complete.getFiles().toString());
});
```
