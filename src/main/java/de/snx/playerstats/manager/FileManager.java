package de.snx.playerstats.manager;

import de.snx.playerstats.file.ConfigFile;

public class FileManager {

    public ConfigFile configFile;

    public FileManager(){
        this.configFile = new ConfigFile();
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

}