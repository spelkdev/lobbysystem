package de.spelk.lobbysystem;

import de.spelk.lobbysystem.commands.build_CMD;
import de.spelk.lobbysystem.commands.clearLog_CMD;
import de.spelk.lobbysystem.listeners.*;
import de.spelk.lobbysystem.utils.LogManager;
import de.spelk.lobbysystem.utils.MySQL;
import de.spelk.lobbysystem.utils.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Main extends JavaPlugin {

    private static Main instance;
    public static List<Player> buildMode = new ArrayList<>();
    public static HashMap<Player,Integer> hiderCache = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§8§l==     §4§lCOPYRIGHT    §8§l==");
        Bukkit.getConsoleSender().sendMessage(" §a§l   Lobbysystem V1.0");
        Bukkit.getConsoleSender().sendMessage(" §a§l© Copyright by spelk ");
        Bukkit.getConsoleSender().sendMessage("§8§l==     §4§lCOPYRIGHT    §8§l==");
        instance = this;
        LogManager.add("Lobbysystem enabled!");
        LogManager.add("OutgoingPluginChannel[BungeeCord] registered");
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        regEvents();
        regCommands();
        if(!MySQL.file.exists()){
            MySQL.setupConfig("127.0.0.1", "3306", "root", "", "lobbysystem");
            Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                @Override
                public void run() {
                    Bukkit.reload();
                }
            },40);
        }
        MySQL.connect();
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS coins(UUID VARCHAR(100), Player VARCHAR(100), Coins INTEGER(100))");
            PreparedStatement ps1 = MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS gadgets(UUID VARCHAR(100), Player VARCHAR(100), Grappling_Hook INT(1), Gun INT(1), Fly_Feather INT(1))");
            PreparedStatement ps2 = MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS trails(UUID VARCHAR(100), Player VARCHAR(100), Fire INT(1), Hearts INT(1), Water INT(1))");
            PreparedStatement ps3 = MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS boots(UUID VARCHAR(100), Player VARCHAR(100), Love INT(1), Jetpack INT(1), Fire INT(1), Water INT(1))");
            PreparedStatement ps4 = MySQL.con.prepareStatement("CREATE TABLE IF NOT EXISTS daily(UUID VARCHAR(100), Player VARCHAR(100), LastDaily VARCHAR(100))");
            ps.executeUpdate();
            ps1.executeUpdate();
            ps2.executeUpdate();
            ps3.executeUpdate();
            ps4.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        LogManager.add("Lobbysystem disabled!");
        MySQL.disconnect();
    }

    private void regEvents(){
        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new join_Event(), this);
        pl.registerEvents(new drop_Event(), this);
        pl.registerEvents(new build_Event(), this);
        pl.registerEvents(new quit_Event(), this);
        pl.registerEvents(new interact_Event(), this);
        pl.registerEvents(new others_Event(), this);
    }

    private void regCommands(){
        getCommand("build").setExecutor(new build_CMD());
        getCommand("clearlog").setExecutor(new clearLog_CMD());
    }

    public static Main getInstance() {
        return instance;
    }
}
