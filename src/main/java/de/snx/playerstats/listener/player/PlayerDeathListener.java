package de.snx.playerstats.listener.player;

import de.snx.playerstats.Stats;
import de.snx.statsapi.StatsAPI;
import de.snx.statsapi.manager.other.PlayerStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        if(event.getEntity().getPlayer() instanceof Player){
            if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.DEATHS")){
                Player player = event.getEntity().getPlayer();
                PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(player.getUniqueId());
                stats.addDeaths(1);
            }
            if(event.getEntity().getKiller() instanceof Player){
                if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.KILLS")){
                    Player killer = event.getEntity().getKiller();
                    PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(killer.getUniqueId());
                    stats.addKills(1);
                }
            }
        }
    }
}