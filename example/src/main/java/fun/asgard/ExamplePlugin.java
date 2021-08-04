package fun.asgard;

import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    public static PaperUpdater PU;

    @Override
    public void onEnable() {
        PU = new PaperUpdater(this)
                .setStartingFile("start.sh")
                .setJVMOptions("-Xmx4G -Xms4G")
                .setJavaPath("/usr/lib/jvm/jdk-16.0.2/bin/java");

        PU.removeUnneededPapers();

        if (PU.isAvailableUpdate()) {
            System.out.println("There are new updates (" + PU.getCurrentPaperBuild().getId() + "/" + PU.getLatestBuild().getId() + ")");
            System.out.println("The download of the new build has begun...");
            PU.downloadLatestPaper().onComplete(downloadAction -> System.out.println("Download complete! Restart the server to apply the updates"));
        } else {
            System.out.println("No new updates");
        }
    }

}
