package de.snx.playerstats;

import de.snx.playerstats.listener.BlockBreakListener;
import de.snx.playerstats.listener.BlockPlaceListener;
import de.snx.playerstats.listener.player.PlayerInteractListener;
import de.snx.playerstats.listener.player.PlayerDeathListener;
import de.snx.playerstats.manager.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Stats extends JavaPlugin {

    public static FileManager fileManager;
    public static Stats instance;

    @Override
    public void onEnable() {
        instance = this;
        fileManager = new FileManager();
        PluginManager load = Bukkit.getPluginManager();
        load.registerEvents(new PlayerDeathListener(), this);
        load.registerEvents(new BlockBreakListener(), this);
        load.registerEvents(new BlockPlaceListener(), this);
        load.registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FileManager getFileManager() {
        return fileManager;
    }

    public static Stats getInstance() {
        return instance;
    }
}