package de.snx.playerstats.listener.player;

import de.snx.playerstats.Stats;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getClickedBlock().getType() == Material.CHEST){
            if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.OPENCHESTS")){
                PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(event.getPlayer().getUniqueId());
                stats.addOpenchests(1);
            }
        }
    }
}