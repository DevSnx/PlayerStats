package de.snx.playerstats.listener.player;

import de.snx.playerstats.Stats;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            Block b = event.getClickedBlock();
            if(b.getType() == Material.CHEST){
                if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.OPENCHESTS")){
                    PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(event.getPlayer().getUniqueId());
                    stats.addOpenchests(1);
                }
            }
        }
    }
}