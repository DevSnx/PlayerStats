package de.snx.playerstats.file;

import org.bukkit.configuration.file.FileConfiguration;

public class MessagesFile extends FileBase{

    public MessagesFile(){
        super("", "messages");
        writeDefaults();
    }


    private void writeDefaults(){
        FileConfiguration cfg = getConfig();

        cfg.addDefault("MESSAGES.KILLEDBYPLAYER", "&e%PLAYER% &7was killed by &c%KILLER%");
        cfg.addDefault("MESSAGES.DEATH", "&b%PLAYER% &7died");

        cfg.options().copyDefaults(true);
        saveConfig();
    }
}