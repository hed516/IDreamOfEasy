package me.bunnky.idreamofeasy;

import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.BlobBuildUpdater;
import io.papermc.lib.PaperLib;
import me.bunnky.idreamofeasy.listeners.IdolListener;
import me.bunnky.idreamofeasy.listeners.MagnetoidListener;
import me.bunnky.idreamofeasy.slimefun.setup.Setup;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;

import javax.annotation.Nonnull;
import java.text.MessageFormat;

public class IDreamOfEasy extends JavaPlugin implements SlimefunAddon {
    private static IDreamOfEasy instance;
    private final String username;
    private final String repo;

    private static final int MAJOR = 20;
    private static final int PATCH = 6;

    public IDreamOfEasy() {
        this.username = "Bunnky";
        this.repo = "IDreamOfEasy";
    }

    @Override
    public void onEnable() {
        instance = this;

        int version = PaperLib.getMinecraftVersion();
        int patchVersion = PaperLib.getMinecraftPatchVersion();

        if (version != MAJOR || patchVersion != PATCH) {
            getLogger().severe("###############################################");
            getLogger().severe("# IDOE only supports Minecraft version 1." + MAJOR + "." + PATCH + " #");
            getLogger().severe("###############################################");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getLogger().info(" ┳  ┳┓┳┓┏┓┏┓┳┳┓  ┏┓┏┓  ┏┓┏┓┏┓┓┏ ");
        getLogger().info(" ┃  ┃┃┣┫┣ ┣┫┃┃┃  ┃┃┣   ┣ ┣┫┗┓┗┫ ");
        getLogger().info(" ┻  ┻┛┛┗┗┛┛┗┛ ┗  ┗┛┻   ┗┛┛┗┗┛┗┛ ");
        getLogger().info("        IDOE by Bunnky          ");
        saveDefaultConfig();

        setupMetrics();
        tryUpdate();

        Setup.setup();

        new MagnetoidListener(this);
        new IdolListener(this);
    }

    public void setupMetrics() {
        Metrics metrics = new Metrics(this, 23610);
    }

    public void tryUpdate() {
        if (getConfig().getBoolean("options.auto-update", true)
            && getDescription().getVersion().startsWith("Dev - ")
        ) {
            new BlobBuildUpdater(this, getFile(), "IDreamOfEasy", "Dev").start();
        }
    }

    public static void consoleMsg(@Nonnull String string) {
        instance.getLogger().info(string);
    }

    public static IDreamOfEasy getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {}

    @Override
    public String getBugTrackerURL() {
        return MessageFormat.format("https://github.com/{0}/{1}/issues", this.username, this.repo);
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}
