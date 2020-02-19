package de.snx.playerstats.file;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile extends FileBase {

    public ConfigFile(){
        super("", "config");
        writeDefaults();
    }

    private void writeDefaults(){
        FileConfiguration cfg = getConfig();

        cfg.addDefault("CONFIG.SAVING.KILLS", true);
        cfg.addDefault("CONFIG.SAVING.DEATHS", true);
        cfg.addDefault("CONFIG.SAVING.PLACEDBLOCKS", true);
        cfg.addDefault("CONFIG.SAVING.BROKENBLOCKS", true);
        cfg.addDefault("CONFIG.SAVING.OPENCHESTS", true);

        cfg.options().copyDefaults(true);
        saveConfig();
    }
}