package de.spelk.lobbysystem.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class staticConfigManager {

    private static File file = new File("plugins//LobbySystem", "static.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static String genOwnerToken(){
        String out = "";
        for(int i = 1; i < 21; i++){
            out += getRandom(0,10);
        }
        return out;
    }

    public static void setOwnerToken(){
        config.set("Owner_Token", genOwnerToken());
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getRandom(int lower, int upper) {
        return new Random().nextInt((upper - lower) + 1) + lower;
    }

}
