package de.spelk.lobbysystem.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static File file = new File("plugins//Lobbysystem", "mysql.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static String host = config.getString("host");
    public static String port = config.getString("port");
    public static String username = config.getString("username");
    public static String password = config.getString("password");
    public static String database = config.getString("database");
    public static Connection con;

    public static void setupConfig(String host, String port, String username, String password, String database){
        config.set("host", host);
        config.set("port", port);
        config.set("username", username);
        config.set("password", password);
        config.set("database", database);
        try{
            config.save(file);
            LogManager.add("[MySQL] File created!");
        }catch(IOException e){
        }
    }

    public static void connect(){
        if(!isConnected()){
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                LogManager.add("[MySQL] Connected!");
            } catch (SQLException e) {
                e.printStackTrace();
                LogManager.add("[MySQL] Connecting to database failed!");
            }
        }
    }

    public static void disconnect(){
        if(isConnected()){
            try {
                con.close();
                LogManager.add("[MySQL] Disconnected!");
            } catch (SQLException e) {
                e.printStackTrace();
                LogManager.add("[MySQL] Disconnecting from database failed!");
            }

        }
    }

    public static boolean isConnected(){
        return (con != null);
    }

}
