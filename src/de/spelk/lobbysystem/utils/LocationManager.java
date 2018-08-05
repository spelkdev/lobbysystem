package de.spelk.lobbysystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LocationManager {

    public static File file  = new File("plugins//Lobbysystem", "locations.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static void setLocation(Integer locNumber, Location location){
        config.set("Location_" + locNumber + ".X", location.getX());
        config.set("Location_" + locNumber + ".Y", location.getY());
        config.set("Location_" + locNumber + ".Z", location.getZ());
        config.set("Location_" + locNumber + ".Yaw", location.getYaw());
        config.set("Location_" + locNumber + ".Pitch", location.getPitch());
        config.set("Location_" + locNumber + ".World", location.getWorld().getName());
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location buildLocation(Integer locNumber){
        Location loc;
        String x = config.getString("Location_" + locNumber + ".X");
        String y = config.getString("Location_" + locNumber + ".Y");
        String z = config.getString("Location_" + locNumber + ".Z");
        String yaw = config.getString("Location_" + locNumber + ".Yaw");
        String pitch = config.getString("Location_" + locNumber + ".Pitch");
        String world = config.getString("Location_" + locNumber + ".World");
        World w = Bukkit.getWorld(world);
        loc = new Location(w, Float.valueOf(x), Float.valueOf(y), Float.valueOf(z), Float.valueOf(yaw), Float.valueOf(pitch));
        return loc;
    }

}
