package de.spelk.lobbysystem.utils;

import net.md_5.bungee.api.ProxyServer;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class ItemManager {

    public static ItemStack navigator(){
        ItemStack item = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8§l« §6§lNavigator §8§l»");
        meta.setLore(null);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack hider(){
        ItemStack item = new ItemStack(Material.CLAY_BALL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8§l« §6§lHider §8§l»");
        meta.setLore(null);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack lobbyswitcher(){
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8§l« §6§lLobbyswitcher §8§l»");
        meta.setLore(null);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack gadgets(){
        ItemStack item = new ItemStack(Material.CHEST, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8§l« §6§lGadgets §8§l»");
        meta.setLore(null);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack silentlobby(){
        ItemStack item = new ItemStack(Material.TNT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8§l« §6§lSilentlobby §8§l»");
        meta.setLore(null);
        item.setItemMeta(meta);
        return item;
    }

    public static void loadDefault(Player player){
        player.getInventory().clear();
        player.getInventory().setItem(0, navigator());
        player.getInventory().setItem(1, hider());
        player.getInventory().setItem(7, lobbyswitcher());
        player.getInventory().setItem(8, gadgets());
        if(player.hasPermission("lobby.sl")){
            if(!(ProxyServer.getInstance().getPlayer(player.getUniqueId()).getServer().getInfo().getName().equals("Silentlobby"))){
                player.getInventory().setItem(4, silentlobby());
            }
        }
    }

    public static ItemStack createItem(Material material, int amount, String name, int subId, List<String> lore){
        ItemStack item = new ItemStack(material, amount, (short) subId);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createHead(Player player, int amount, String name){
        ItemStack item = new ItemStack(Material.SKULL, amount, (short) 3);
        ItemMeta meta = (SkullMeta)item.getItemMeta();
        ((SkullMeta) meta).setOwner(player.getName());
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

}
