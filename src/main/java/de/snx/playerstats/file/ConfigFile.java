package de.snx.playerstats.file;

import com.mojang.datafixers.TypeRewriteRule;
import de.snx.statsapi.file.FileBase;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile extends FileBase {

    public ConfigFile(){
        super("", "");
        writeDefaults();
    }

    private void writeDefaults(){
        FileConfiguration cfg = getConfig();

        cfg.addDefault("CONFIG.MESSAGE.PREFIX", "&8[&7PlayerStats&8]");

        cfg.addDefault("CONFIG.MESSAGE.PLAYERKILL.SHOW", true);
        cfg.addDefault("CONFIG.MESSAGE.PLAYERKILL.SOUND", true);

        cfg.addDefault("CONFIG.MESSAGE.DEATH.SHOW", true);
        cfg.addDefault("CONFIG.MESSAGE.DEATH.SOUND", true);

        cfg.addDefault("CONFIG.MESSAGE.DEATHBYPLAYER.SHOW", true);
        cfg.addDefault("CONFIG.MESSAGE.DEATHBYPLAYER.SOUND", true);

        saveConfig();
    }
}