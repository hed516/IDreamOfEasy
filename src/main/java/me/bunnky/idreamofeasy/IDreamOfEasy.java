package me.bunnky.idreamofeasy;

import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.BlobBuildUpdater;
import me.bunnky.idreamofeasy.slimefun.listener.IdolListener;
import me.bunnky.idreamofeasy.slimefun.listener.MagnetoidListener;
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

    public IDreamOfEasy() {
        this.username = "Bunnky";
        this.repo = "IDreamOfEasy";
    }

    @Override
    public void onEnable() {
        instance = this;

        if (!Slimefun.getMinecraftVersion().isAtLeast(MinecraftVersion.MINECRAFT_1_20)) {
            getLogger().warning("IDOE requires version 1.20+");
            getServer().getPluginManager().disablePlugin(this);
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
            new BlobBuildUpdater(this, getFile(), "SlimeVision", "Dev").start();
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
