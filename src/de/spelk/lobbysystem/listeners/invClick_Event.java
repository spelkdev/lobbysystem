package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.Main;
import de.spelk.lobbysystem.utils.*;
import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class invClick_Event implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        try{
            if(e.getClickedInventory() == p.getInventory()){
                if(Main.buildMode.contains(p)){
                }else{
                    e.setCancelled(true);
                }
            }else{
                if(e.getClickedInventory().getName().equals("§8§l« §6§lNavigator §8§l»")){
                    e.setCancelled(true);
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §6§lSpawn §8§l»")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        p.teleport(LocationManager.buildLocation(1));
                        p.sendMessage(STATIC.PREFIX + "§a§lDu wurdest zum §6§lSpawn §a§lteleportiert");
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §6§lCommunity §8§l»")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        p.teleport(LocationManager.buildLocation(2));
                        p.sendMessage(STATIC.PREFIX + "§a§lDu wurdest zur §6§lCommunity §a§lteleportiert");
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §4§lBed§f§lWars §8§l»")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        p.teleport(LocationManager.buildLocation(3));
                        p.sendMessage(STATIC.PREFIX + "§a§lDu wurdest zu §4§lBed§f§lWars §a§lteleportiert");
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §2§lSkyWars §8§l»")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        p.teleport(LocationManager.buildLocation(4));
                        p.sendMessage(STATIC.PREFIX + "§a§lDu wurdest zu §2§lSkyWars §a§lteleportiert");
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §4§lComming soon §8§l»")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        p.sendMessage(STATIC.ERROR + "§c§lDieser Spielmodus kommt bald");
                    }
                    p.closeInventory();
                }
                if(e.getClickedInventory().getName().equals("§8§l« §6§lHider §8§l»")){
                    e.setCancelled(true);
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lAlle Spieler")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        for(Player all : Bukkit.getOnlinePlayers()){
                            p.showPlayer(all);
                        }
                        p.sendMessage(STATIC.PREFIX + "§a§lDu siehst nun alle Spieler");
                        Main.hiderCache.put(p,0);
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lNur VIPs")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        for(Player all : Bukkit.getOnlinePlayers()){
                            if(all.hasPermission("lobby.vip")){
                            }else{
                                p.hidePlayer(all);
                            }
                        }
                        p.sendMessage(STATIC.PREFIX + "§6§lDu siehst nun nur noch VIPs");
                        Main.hiderCache.put(p,1);
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lKeine Spieler")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        for(Player all : Bukkit.getOnlinePlayers()){
                            p.hidePlayer(all);
                        }
                        p.sendMessage(STATIC.PREFIX + "§c§lDu siehst nun keine Spieler mehr");
                        Main.hiderCache.put(p,2);
                    }
                    p.closeInventory();
                }
                if(e.getClickedInventory().getName().equals("§8§l« §6§lLobbyswitcher §8§l»")){
                    e.setCancelled(true);
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lLobby-1")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("Lobby-1");
                            p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
                        } catch (IOException e1) {
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lLobby-2")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("Lobby-2");
                            p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
                        } catch (IOException e1) {
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lLobby-3")){
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("Lobby-3");
                            p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
                        } catch (IOException e1) {
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lPremiumlobby")){
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);
                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("Premiumlobby-1");
                            p.sendPluginMessage(Main.getInstance(), "BungeeCord", b.toByteArray());
                        } catch (IOException e1) {
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lOFFLINE")){
                        p.sendMessage(STATIC.ERROR + "§c§lDieser Server ist zurzeit nicht verfügbar!");
                    }
                    p.closeInventory();
                }
                if(e.getClickedInventory().getName().equals("§8§l« §6§lProfil §8§l»")){
                    e.setCancelled(true);
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §6§lGadgets §8§l»")){
                        Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§8§l« §6§lGadgets §8§l»");
                        inv.setItem(0, ItemManager.createItem(Material.FISHING_ROD, 1, "§a§lEnterhaken", 0, null));
                        inv.setItem(1, ItemManager.createItem(Material.BLAZE_ROD, 1, "§a§lPistole", 0, null));
                        inv.setItem(2, ItemManager.createItem(Material.FEATHER, 1, "§a§lFlugfeder", 0, null));
                        inv.setItem(3, ItemManager.gadgets());
                        p.openInventory(inv);
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §6§lBoots §8§l»")){
                        Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§8§l« §6§lBoots §8§l»");
                        inv.setItem(0, ItemManager.FireBoots());
                        inv.setItem(1, ItemManager.LoveBoots());
                        inv.setItem(2, ItemManager.WaterBoots());
                        inv.setItem(3, ItemManager.createItem(Material.IRON_BOOTS, 1, "§8§l« §6§lBoots §8§l»", 0, null));
                        p.openInventory(inv);
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§8§l« §6§lTrails §8§l»")){
                        Inventory inv = Bukkit.createInventory(null, InventoryType.BREWING, "§8§l« §6§lTrails §8§l»");
                        inv.setItem(0, ItemManager.createItem(Material.SUGAR, 1, "§a§lFeuer", 0 ,null));
                        inv.setItem(1, ItemManager.createItem(Material.REDSTONE, 1, "§a§lHerzen", 0 ,null));
                        inv.setItem(2, ItemManager.createItem(Material.GLOWSTONE_DUST, 1, "§a§lWasser", 0 ,null));
                        inv.setItem(3, ItemManager.createItem(Material.REDSTONE, 1, "§8§l« §6§lTrails §8§l»", 0, null));
                        p.openInventory(inv);
                        p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1,1);
                    }
                }
                if(e.getClickedInventory().getName().equals("§8§l« §6§lGadgets §8§l»")){
                    e.setCancelled(true);
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lEnterhaken")){
                        if(GadgetsManager.getGrappling_Hook(p.getUniqueId()) == 0){
                            Inventory inv = Bukkit.createInventory(null, 9, "§8§l« §6§lKasse §8§l»");
                            List<String> lore = new ArrayList<>();
                            lore.add("§a§lPreis: 800 Coins");
                            inv.setItem(4, ItemManager.createItem(Material.FISHING_ROD, 1, "§a§lEnterhaken", 0, lore));
                            inv.setItem(2, ItemManager.createItem(Material.STAINED_CLAY, 1, "§a§lKaufen", 5, null));
                            inv.setItem(6, ItemManager.createItem(Material.STAINED_CLAY, 1, "§c§lAbbrechen", 14, null));
                            p.openInventory(inv);
                            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP,1,1);
                        }else{
                            p.sendMessage(STATIC.ERROR + "§c§lDu besitzt dieses Gadget bereits!");
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lPistole")){
                        if(GadgetsManager.getGun(p.getUniqueId()) == 0){
                            Inventory inv = Bukkit.createInventory(null, 9, "§8§l« §6§lKasse §8§l»");
                            List<String> lore = new ArrayList<>();
                            lore.add("§a§lPreis: 800 Coins");
                            inv.setItem(4, ItemManager.createItem(Material.BLAZE_ROD, 1, "§a§lPistole", 0, lore));
                            inv.setItem(2, ItemManager.createItem(Material.STAINED_CLAY, 1, "§a§lKaufen", 5, null));
                            inv.setItem(6, ItemManager.createItem(Material.STAINED_CLAY, 1, "§c§lAbbrechen", 14, null));
                            p.openInventory(inv);
                            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP,1,1);
                        }else{
                            p.sendMessage(STATIC.ERROR + "§c§lDu besitzt dieses Gadget bereits!");
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lFlugfeder")){
                        if(GadgetsManager.getFly_Feather(p.getUniqueId()) == 0){
                            Inventory inv = Bukkit.createInventory(null, 9, "§8§l« §6§lKasse §8§l»");
                            List<String> lore = new ArrayList<>();
                            lore.add("§a§lPreis: 800 Coins");
                            inv.setItem(4, ItemManager.createItem(Material.FEATHER, 1, "§a§lFlugfeder", 0, lore));
                            inv.setItem(2, ItemManager.createItem(Material.STAINED_CLAY, 1, "§a§lKaufen", 5, null));
                            inv.setItem(6, ItemManager.createItem(Material.STAINED_CLAY, 1, "§c§lAbbrechen", 14, null));
                            p.openInventory(inv);
                            p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP,1,1);
                        }else{
                            p.sendMessage(STATIC.ERROR + "§c§lDu besitzt dieses Gadget bereits!");
                        }
                    }
                }

                if(e.getClickedInventory().getName().equals("§8§l« §6§lKasse §8§l»")){
                    e.setCancelled(true);
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lKaufen")){
                        if(CoinsManager.getCoins(p.getUniqueId()) > 799){
                            ItemStack item = e.getClickedInventory().getItem(4);
                            if(item.getItemMeta().getDisplayName().equals("§a§lEnterhaken")){
                                if(GadgetsManager.getGrappling_Hook(p.getUniqueId()) == 0){
                                    GadgetsManager.setGrappling_Hook(p,1);
                                    CoinsManager.removeCoins(p,800);
                                    p.sendMessage(STATIC.PREFIX + "§a§lDu hast dir den Enterhaken gekauft!");
                                    ScoreboardManager.setSB(p);
                                }else{
                                    p.sendMessage(STATIC.ERROR + "§c§lDu besitzt dieses Gadget bereits!");
                                }
                            }
                            if(item.getItemMeta().getDisplayName().equals("§a§lPistole")){
                                if(GadgetsManager.getGun(p.getUniqueId()) == 0){
                                    GadgetsManager.setGun(p,1);
                                    CoinsManager.removeCoins(p,800);
                                    p.sendMessage(STATIC.PREFIX + "§a§lDu hast dir die Pistole gekauft!");
                                    ScoreboardManager.setSB(p);
                                }else{
                                    p.sendMessage(STATIC.ERROR + "§c§lDu besitzt dieses Gadget bereits!");
                                }
                            }
                            if(item.getItemMeta().getDisplayName().equals("§a§lFlugfeder")){
                                if(GadgetsManager.getFly_Feather(p.getUniqueId()) == 0){
                                    GadgetsManager.setFly_Feather(p,1);
                                    CoinsManager.removeCoins(p,800);
                                    p.sendMessage(STATIC.PREFIX + "§a§lDu hast dir die Flugfeder gekauft!");
                                    ScoreboardManager.setSB(p);
                                }else{
                                    p.sendMessage(STATIC.ERROR + "§c§lDu besitzt dieses Gadget bereits!");
                                }
                            }
                            p.closeInventory();
                        }else{
                            p.sendMessage(STATIC.ERROR + "§c§lDu hast nicht genug Coins!");
                            p.closeInventory();
                        }
                    }
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lAbbrechen")){
                        p.closeInventory();
                    }
                }
            }
        }catch(Exception e1){
        }
    }

}
