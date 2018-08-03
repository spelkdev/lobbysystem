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
        p.getInventory().clear();
        p.getInventory().setItem(0, ItemManager.navigator());
        p.getInventory().setItem(1, ItemManager.hider());
        p.getInventory().setItem(7, ItemManager.lobbyswitcher());
        p.getInventory().setItem(8, ItemManager.gadgets());
        LogManager.add(p.getName() + " joined the Lobby!");
    }

}
