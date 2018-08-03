package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class build_Event implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(Main.buildMode.contains(p)){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(Main.buildMode.contains(p)){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

}
