package de.spelk.lobbysystem.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class staticConfigManager {

    private static File file = new File("plugins//LobbySystem", "static.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public static int getRandom(int lower, int upper) {
        return new Random().nextInt((upper - lower) + 1) + lower;
    }

}
