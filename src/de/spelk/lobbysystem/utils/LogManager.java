package de.spelk.lobbysystem.utils;

import de.spelk.lobbysystem.Main;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LogManager {

    public static File file = new File("plugins//LobbySystem", "log.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static String date(){
        Date cDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("[dd.MM.yy | HH:mm:ss] ");
        return sdf.format(cDate);
    }

    public static void add(String value){
        List<String> cache = cfg.getStringList("Log");
        cache.add(date() + value);
        cfg.set("Log", cache);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
