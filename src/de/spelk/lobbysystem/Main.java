package de.spelk.lobbysystem;

import de.spelk.lobbysystem.utils.LogManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        LogManager.add("Lobbysystem enabled!");
    }

    @Override
    public void onDisable() {

    }

    public static Main getInstance() {
        return instance;
    }
}
