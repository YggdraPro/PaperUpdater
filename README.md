<div align="center">
  <h1> PaperUpdater </h1>
  
API for PaperMC Minecraft Server core updates.
Made by [**The Asgard**](https://asgrad.fun/) with love 💙


[discord-invite]: https://discord.gg/QXSGvGrzDj
[discord-shield]: https://discord.com/api/guilds/646285836500860929/widget.png

[discord]: https://img.shields.io/badge/Our-discord-blue?style=for-the-badge&logo=discord

[version]: https://img.shields.io/badge/Version-1.1-success?style=for-the-badge&logo=wiki
[download]: #---get-started

[wiki]: https://img.shields.io/badge/-Our%20wiki-yellow?style=for-the-badge&logo=wiki
[wiki-url]: https://github.com/TheAsgard/PaperUpdater/wiki

[docs]: https://img.shields.io/badge/Our%20documentation-1.1-critical?style=for-the-badge&logo=wiki
[docs-url]: https://github.com/TheAsgard/PaperUpdater/wiki/Documentation

[javadocs]: https://img.shields.io/badge/Java%20Doc-1.1-orange?style=for-the-badge&logo=wiki
[javadocs-url]: https://theasgard.github.io/PaperUpdater/fun/asgard/package-summary.html

[![version][]][download]
[![wiki][]][wiki-url]
[![javadocs][]][javadocs-url]
[![docs][]][docs-url]
[![discord][]][discord-invite] 
</div>

[papermc-url]: https://papermc.io/

## 🧩 - Get started

Requires [**PaperMC**][papermc-url]

> #### For Maven
```xml
<dependencies>
  <dependency>
    <groupId>fun.asgard</groupId>
    <artifactId>PaperUpdater</artifactId>
    <version>1.1</version>
  </dependency>
</dependencies>  
```

____

> #### For Gradle
```gradle
repositories {
  mavenCentral()
}
```
```gradle
dependencies {
  implementation 'fun.asgard:PaperUpdater:1.1'
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
        //                         |        Version       |
        PU = new PaperUpdater(this, MinecraftVersions.AUTO);
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

#### Get all Paper JAR files in the server folder 

```java
PU.getPapers()
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

#### Delete unnecessary JVM files 

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
//             |Build|
PU.downloadPaper("43")
```

____

#### File actions 

To make it convenient to handle the moment when, for example, the installation of a file was completed or files were deleted, we did the processing of such actions using `onComplete()` method. Here are some examples: 

```java
PU.downloadPaper("468578534845858356845793").onComplete(complete -> {
    if (complete.isError()) {
        System.out.println("An error has occurred: " + complete.getErrorMessage())
    } else {
        System.out.println("Installation of build 468578534845858356845793 is complete!");
    }
});
```

```java
PU.removeUnneededPapers().onComplete(complete -> {
    System.out.println("Unnecessary Papers removed: " + complete.getFiles().toString());
});
```
