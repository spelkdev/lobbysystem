package de.spelk.lobbysystem;

import de.spelk.lobbysystem.listeners.build_Event;
import de.spelk.lobbysystem.listeners.drop_Event;
import de.spelk.lobbysystem.listeners.join_Event;
import de.spelk.lobbysystem.utils.LogManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class Main extends JavaPlugin {

    private static Main instance;
    public static List<Player> buildMode = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§8§l==     §4§lCOPYRIGHT    §8§l==");
        Bukkit.getConsoleSender().sendMessage(" §a§l   Lobbysystem V1.0");
        Bukkit.getConsoleSender().sendMessage(" §a§l© Copyright by spelk ");
        Bukkit.getConsoleSender().sendMessage("§8§l==     §4§lCOPYRIGHT    §8§l==");
        instance = this;
        LogManager.add("Lobbysystem enabled!");
        regEvents();
    }

    @Override
    public void onDisable() {
        LogManager.add("Lobbysystem disabled!");
    }

    private void regEvents(){
        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new join_Event(), this);
        pl.registerEvents(new drop_Event(), this);
        pl.registerEvents(new build_Event(), this);
    }

    private void regCommands(){

    }

    public static Main getInstance() {
        return instance;
    }
}
