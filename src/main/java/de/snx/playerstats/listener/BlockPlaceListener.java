package de.snx.playerstats.listener;

import de.snx.playerstats.Stats;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.List;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if(event.getBlock() != null || event.getBlock().getType() != Material.AIR){
            if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.PLACEDBLOCKS")){
                PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(event.getPlayer().getUniqueId());
                stats.addPlacedblocks(1);
                return;
            }
            return;
        }
        return;
    }
}