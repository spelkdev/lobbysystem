package de.spelk.lobbysystem.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

}
