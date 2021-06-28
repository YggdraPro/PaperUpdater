# PaperUpdater
API for PaperMC Minecraft Server core updates.
Made by [The Asgard](https://asgrad.fun/) with love 💙 

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

[papermc-url]: https://papermc.io/

## How to use

Requires [**Minecraft 1.16.5**][minecraft-url] or **higher**.
Works with [PaperMC][papermc-url], [SpigotMC][spigotmc-url], [MohistMC][mohist-url], [CraftBukkit][bukkit-url] etc. 

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
