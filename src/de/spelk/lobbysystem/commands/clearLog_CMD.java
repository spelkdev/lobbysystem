package de.spelk.lobbysystem.commands;

import de.spelk.lobbysystem.utils.LogManager;
import de.spelk.lobbysystem.utils.STATIC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

public class clearLog_CMD implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(p.hasPermission("lobby.clearlog")){
                p.sendMessage(STATIC.PREFIX + "§a§lDu hast den Log geleert!");
                List<String> cache = LogManager.cfg.getStringList("Log");
                cache.clear();
                LogManager.cfg.set("Log",cache);
                try {
                    LogManager.cfg.save(LogManager.file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                p.sendMessage(STATIC.ERROR + "§c§lDu hast dazu keine Rechte!");
            }
        }else{
            Bukkit.getConsoleSender().sendMessage(STATIC.PREFIX + "§a§lDu hast den Log geleert!");
            List<String> cache = LogManager.cfg.getStringList("Log");
            cache.clear();
            LogManager.cfg.set("Log",cache);
            try {
                LogManager.cfg.save(LogManager.file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
