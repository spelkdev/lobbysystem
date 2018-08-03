package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class drop_Event implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p =  e.getPlayer();
        if(Main.buildMode.contains(p)){
        }else{
            e.setCancelled(true);
        }
    }

}
