package de.snx.playerstats.file;

import de.snx.statsapi.file.FileBase;
import org.bukkit.configuration.file.FileConfiguration;

public class MessagesFile extends FileBase {

    public MessagesFile(){
        super("", "");
        writeDefaults();
    }

    private void writeDefaults(){
        FileConfiguration cfg = getConfig();


        saveConfig();
    }
}