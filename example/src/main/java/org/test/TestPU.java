package org.test;

import fun.asgard.PaperUpdater;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class TestPU extends JavaPlugin {

    public static PaperUpdater PU;

    @Override
    public void onEnable() {
        PU = new PaperUpdater(this, getServer().getMinecraftVersion())
                .setJVMOptions("-Xmx7G -Xms7G")
                .setStartingFile("start.sh");

        PU.removeUnneededPapers();

        if (PU.isAvailableUpdate()) {
            System.out.println("Есть новые обновы (" + PU.getCurrentPaperBuild() + "/" + PU.getLatestBuild() + ")");
            System.out.println("Скачивание новой версии началось...");
            PU.downloadLatestPaper().onComplete(downloadAction -> System.out.println("Скачивание завершено! Перезапустите сервер, чтобы применились обновления"));
        } else {
            System.out.println("Нет обнов");
        }
    }

    @Override
    public void onDisable() { }

}
