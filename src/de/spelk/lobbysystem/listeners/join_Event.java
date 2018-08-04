package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.utils.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class join_Event implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        LogManager.add(p.getName() + " joined the Lobby!");
        ScoreboardManager.setSB(p);
        Date cDate = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = s.format(cDate);
        if(DailyManager.getLastDaily(p.getUniqueId()) == null || !DailyManager.getLastDaily(p.getUniqueId()).equals(currentDate)){
            DailyManager.setDaily(p,currentDate);
            if(p.hasPermission("lobby.mdc")){
                CoinsManager.addCoins(p,250);
                p.sendMessage(STATIC.PREFIX + "§a§lDu hast deine 250 Täglichencoins erhalten!");
            }else{
                CoinsManager.addCoins(p,100);
                p.sendMessage(STATIC.PREFIX + "§a§lDu hast deine 100 Täglichencoins erhalten!");
            }
        }else{
            p.sendMessage(STATIC.PREFIX + "§c§lDu hast heute schon deine Täglichencoins erhalten!");
        }
    }

}
