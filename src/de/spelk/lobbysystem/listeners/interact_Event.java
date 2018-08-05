package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.Main;
import de.spelk.lobbysystem.utils.CheckServerManager;
import de.spelk.lobbysystem.utils.ItemManager;
import de.spelk.lobbysystem.utils.LogManager;
import de.spelk.lobbysystem.utils.STATIC;
import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class interact_Event implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)){
                if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8§l« §6§lNavigator §8§l»")){
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1,1);
                    Inventory inv = Bukkit.createInventory(null, 27, "§8§l« §6§lNavigator §8§l»");
                    for(int i = 0; i < 27; i++){
                        inv.setItem(i, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1,"§f",15, null));
                    }
                    inv.setItem(12, ItemManager.createItem(Material.MAGMA_CREAM, 1, "§8§l« §6§lSpawn §8§l»", 0, null));
                    inv.setItem(14, ItemManager.createItem(Material.CAKE, 1, "§8§l« §6§lCommunity §8§l»", 0, null));
                    inv.setItem(1, ItemManager.createItem(Material.BED, 1, "§8§l« §4§lBed§f§lWars §8§l»", 0, null));
                    inv.setItem(7, ItemManager.createItem(Material.GRASS, 1, "§8§l« §2§lSkyWars §8§l»", 0, null));
                    inv.setItem(25, ItemManager.createItem(Material.BARRIER, 1, "§8§l« §4§lComming soon §8§l»", 0, null));
                    inv.setItem(19, ItemManager.createItem(Material.BARRIER, 1, "§8§l« §4§lComming soon §8§l»", 0, null));
                    p.openInventory(inv);
                    LogManager.add(p.getName() + " used the navigator!");
                }
                if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8§l« §6§lHider §8§l»")){
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1,1);
                    Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§8§l« §6§lHider §8§l»");
                    if(Main.hiderCache.containsKey(p)){
                        int i = Main.hiderCache.get(p);
                        if(i == 0){
                            inv.setItem(3, ItemManager.createItem(Material.GREEN_RECORD, 1, "§5§lDu siehst §8§l» §a§lAlle Spieler", 0, null));
                        }
                        if(i == 1){
                            inv.setItem(3, ItemManager.createItem(Material.GOLD_RECORD, 1, "§5§lDu siehst §8§l» §6§lNur VIPs", 0, null));
                        }
                        if(i == 2){
                            inv.setItem(3, ItemManager.createItem(Material.RECORD_3, 1, "§5§lDu siehst §8§l» §c§lKeine Spieler", 0, null));
                        }
                    }else{
                        Main.hiderCache.put(p, 0);
                        inv.setItem(3, ItemManager.createItem(Material.GREEN_RECORD, 1, "§5§lDu siehst §8§l» §a§lAlle Spieler", 0, null));
                    }
                    inv.setItem(0, ItemManager.createItem(Material.GREEN_RECORD, 1, "§a§lAlle Spieler", 0, null));
                    inv.setItem(1, ItemManager.createItem(Material.GOLD_RECORD, 1, "§6§lNur VIPs", 0, null));
                    inv.setItem(2, ItemManager.createItem(Material.RECORD_3, 1, "§c§lKeine Spieler", 0, null));
                    p.openInventory(inv);
                    LogManager.add(p.getName() + " used the hider!");
                }
                if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8§l« §6§lSilentlobby §8§l»")){
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1,1);
                    if(CheckServerManager.isOnline("127.0.0.1", Main.config.getInt("Silentlobby"))){
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("Silentlobby");
                            p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
                        } catch (IOException e1) {
                        }
                    }else{
                        p.sendMessage(STATIC.ERROR + "§c§lDie Silentlobby ist derzeit nicht verfügbar");
                    }
                    LogManager.add(p.getName() + " used the silentlobby!");
                }
                if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8§l« §6§lLobbyswitcher §8§l»")){
                    p.sendMessage(STATIC.PREFIX + "§c§lIch, spelkles[Dev] entschuldige mich dafür das der Lobbyswitcher eine lange Ladezeit hat");
                    Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING,"§8§l« §6§lLobbyswitcher §8§l»" );
                    if(CheckServerManager.isOnline("127.0.0.1", Main.config.getInt("Premiumlobby"))){
                        inv.setItem(3, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, "§6§lPremiumlobby", 0, null));
                    }else{
                        inv.setItem(3, ItemManager.createItem(Material.SUGAR, 1, "§c§lOFFLINE", 0, null));
                    }
                    if(CheckServerManager.isOnline("127.0.0.1", Main.config.getInt("Lobby-1"))){
                        inv.setItem(0, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, "§a§lLobby-1", 0, null));
                    }else{
                        inv.setItem(0, ItemManager.createItem(Material.SUGAR, 1, "§c§lOFFLINE", 0, null));
                    }
                    if(CheckServerManager.isOnline("127.0.0.1", Main.config.getInt("Lobby-2"))){
                        inv.setItem(1, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, "§a§lLobby-2", 0, null));
                    }else{
                        inv.setItem(1, ItemManager.createItem(Material.SUGAR, 1, "§c§lOFFLINE", 0, null));
                    }
                    if(CheckServerManager.isOnline("127.0.0.1", Main.config.getInt("Lobby-3"))){
                        inv.setItem(2, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, "§a§lLobby-3", 0, null));
                    }else{
                        inv.setItem(2, ItemManager.createItem(Material.SUGAR, 1, "§c§lOFFLINE", 0, null));
                    }
                    LogManager.add(p.getName() + " used the lobbyswitcher!");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1,1);
                    p.openInventory(inv);
                }
                if(p.getItemInHand().getItemMeta().getDisplayName().equals("§8§l« §6§lProfil §8§l»")){
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1,1);
                    Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING,"§8§l« §6§lProfil §8§l»");
                    inv.setItem(1, ItemManager.gadgets());
                    inv.setItem(3, ItemManager.createHead(p, 1, "§8§l« §6§lDein Profil §8§l»"));
                    inv.setItem(0, ItemManager.createItem(Material.IRON_BOOTS, 1, "§8§l« §6§lBoots §8§l»", 0, null));
                    inv.setItem(2, ItemManager.createItem(Material.REDSTONE, 1, "§8§l« §6§lTrails §8§l»", 0, null));
                    LogManager.add(p.getName() + " used the profile!");
                    p.openInventory(inv);
                }
            }
        }catch(Exception e1){
        }
    }

}
