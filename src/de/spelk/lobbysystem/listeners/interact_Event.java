package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.utils.ItemManager;
import de.spelk.lobbysystem.utils.LogManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class interact_Event implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8§l« §6§lNavigator §8§l»")){
                Inventory inv = Bukkit.createInventory(null, 45, "§8§l« §6§lNavigator §8§l»");
                for(int i = 0; i < 45; i++){
                    inv.setItem(i, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1,"§f",15, null));
                }
                p.openInventory(inv);
                LogManager.add(p.getName() + " used the navigator!");
            }
        }
    }

}
