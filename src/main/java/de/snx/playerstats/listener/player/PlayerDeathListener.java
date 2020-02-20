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
            if(event.getEntity().getKiller() instanceof Player){
                if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.MESSAGE.KILLEDBYPLAYER")){
                    String message = Stats.getFileManager().getMessagesFile().getConfig().getString("MESSAGES.KILLEDBYPLAYER");
                    message = message.replace("&", "§");
                    message = message.replace("%PLAYER%", event.getEntity().getPlayer().getName());
                    message = message.replace("%KILLER%", event.getEntity().getKiller().getName());
                    event.setDeathMessage(message);
                }
                if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.DEATHS")){
                    Player player = event.getEntity().getPlayer();
                    PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(player.getUniqueId());
                    stats.addDeaths(1);
                }
                if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.KILLS")){
                    Player killer = event.getEntity().getKiller();
                    PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(killer.getUniqueId());
                    stats.addKills(1);
                }
            }else{
                if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.SAVING.DEATHS")){
                    Player player = event.getEntity().getPlayer();
                    PlayerStats stats = StatsAPI.getStatsManager().getPlayerStats(player.getUniqueId());
                    stats.addDeaths(1);
                }
                if(Stats.getFileManager().getConfigFile().getConfig().getBoolean("CONFIG.MESSAGE.DEATH")){
                    String message = Stats.getFileManager().getMessagesFile().getConfig().getString("MESSAGES.DEATH");
                    message = message.replace("&", "§");
                    message = message.replace("%PLAYER%", event.getEntity().getPlayer().getName());
                    event.setDeathMessage(message);
                }
            }
        }
    }
}