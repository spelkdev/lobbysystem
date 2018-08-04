package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.utils.ItemManager;
import de.spelk.lobbysystem.utils.LogManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class join_Event implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        ItemManager.loadDefault(p);
        LogManager.add(p.getName() + " joined the Lobby!");
    }

}
