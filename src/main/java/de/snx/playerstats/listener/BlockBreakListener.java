package de.snx.playerstats.listener;

import de.snx.playerstats.Stats;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(event.getBlock() != null || event.getBlock().getType() != Material.AIR){
            if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.BROKENBLOCKS")){
                PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(event.getPlayer().getUniqueId());
                stats.addBrokenblocks(1);
            }
        }
    }
}