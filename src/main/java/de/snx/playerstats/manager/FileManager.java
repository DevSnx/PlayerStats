package de.snx.playerstats.manager;

import de.snx.playerstats.file.ConfigFile;
import de.snx.playerstats.file.MessagesFile;

public class FileManager {

    public ConfigFile configFile;
    public MessagesFile messagesFile;

    public FileManager(){
        this.configFile = new ConfigFile();
        this.messagesFile = new MessagesFile();
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public MessagesFile getMessagesFile() {
        return messagesFile;
    }
}