<div align="center">
  <h1> PaperUpdater </h1>
  
API for PaperMC Minecraft Server core updates.
Made by [**The Asgard**](https://asgrad.fun/) with love 💙


[discord-invite]: https://discord.gg/QXSGvGrzDj
[discord-shield]: https://discord.com/api/guilds/646285836500860929/widget.png

[discord]: https://img.shields.io/badge/Our-discord-blue?style=for-the-badge&logo=discord

[version]: https://img.shields.io/badge/Version-1.0-success?style=for-the-badge&logo=wiki
[download]: #how-to-use

[wiki]: https://img.shields.io/badge/-Our%20wiki-yellow?style=for-the-badge&logo=wiki
[wiki-url]: https://github.com/TheAsgard/PaperUpdater/wiki

[docs]: https://img.shields.io/badge/Our%20documentation-1.0-critical?style=for-the-badge&logo=wiki
[docs-url]: https://github.com/TheAsgard/PaperUpdater/wiki/Documentation

[javadocs]: https://img.shields.io/badge/Java%20Doc-1.0-orange?style=for-the-badge&logo=wiki
[javadocs-url]: https://theasgard.github.io/PaperUpdater/fun/asgard/package-summary.html

[![version][]][download]
[![wiki][]][wiki-url]
[![javadocs][]][docs-url]
[![docs][]][docs-url]
[![discord][]][discord-invite] 
</div>

[papermc-url]: https://papermc.io/

## How to use

Requires [**PaperMC**][papermc-url]

> #### For Maven
```xml
<dependencies>
  <dependency>
    <groupId>fun.asgard</groupId>
    <artifactId>PaperUpdater</artifactId>
    <version>1.0</version>
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
  implementation 'fun.asgard:PaperUpdater:1.0'
}
```

## Brief Guide

**PLEASE READ [OUR DOCUMENTATION][docs-url] ALSO! THIS GUIDE IS NOT ALL THE POSSIBILITIES OF OUR LIBRARY!**

#### Initialization

```java
public final class Example extends JavaPlugin {
    public static PaperUpdater PU;

    @Override
    public void onEnable() {
        //                         |Version|
        PU = new PaperUpdater(this, "1.17");
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

#### Get the current JAR file 

```java
PU.getCurrentPaperJar()
```

#### Get the current build 

```java
PU.getCurrentPaperBuild()
```

#### Get all Paper JAR files in the server folder 

```java
PU.getPapers()
```

#### Set the start file

```java
//                |File name|
PU.setStartingFile("start.sh")
```

#### Set the content of the start file

```java
//                        |           Example content          |
PU.setStartingFileContent("java -jar " + PU.getCurrentPaperJar())
```

#### Set JVM options (If you have not specified the content of the start file, but have specified the name of the start file )

```java
//             |Example JVM options|
PU.setJVMOptions("-Xmx4G -Xms4G")
```

#### Delete unnecessary JVM files 

```java
PU.removeUnneededPapers()
```

#### Download the latest build 

```java
PU.downloadLatestPaper()
```

#### Download a specific build of PaperMC

```java
//             |Build|
PU.downloadPaper("43")
```

### File actions 

To make it convenient to handle the moment when, for example, the installation of a file was completed or files were deleted, we did the processing of such actions using `onComplete()` method. Here are some examples: 

```java
PU.downloadPaper("43").onComplete(complete -> {
    System.out.println("Installation of build 43 is complete!");
});
```

```java
PU.removeUnneededPapers().onComplete(complete -> {
    System.out.println("Unnecessary Papers removed: " + complete.getFiles().toString());
});
```
