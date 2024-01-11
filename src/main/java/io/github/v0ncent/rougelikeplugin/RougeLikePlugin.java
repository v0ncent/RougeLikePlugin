package io.github.v0ncent.rougelikeplugin;

import io.github.v0ncent.rougelikeplugin.Commands.GetCoords;
import io.github.v0ncent.rougelikeplugin.Commands.GetTo;
import io.github.v0ncent.rougelikeplugin.Commands.HowFar;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RougeLikePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getLogger().info("Ready!");

        getCommand("getcoords").setExecutor(new GetCoords());
        getCommand("getto").setExecutor(new GetTo());
        getCommand("howfar").setExecutor(new HowFar());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getServer().getLogger().info("Shutting Down!");
    }
}
