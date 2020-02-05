package de.snx.playerstats;

import de.snx.playerstats.manager.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerStats extends JavaPlugin {

    public static PlayerStats instance;
    public static FileManager fileManager;

    @Override
    public void onEnable() {
        instance = this;
        fileManager = new FileManager();

        PluginManager load = Bukkit.getPluginManager();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static PlayerStats getInstance() {
        return instance;
    }
}