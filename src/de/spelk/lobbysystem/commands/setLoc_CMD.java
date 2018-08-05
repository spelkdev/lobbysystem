package de.spelk.lobbysystem.commands;

import de.spelk.lobbysystem.utils.LocationManager;
import de.spelk.lobbysystem.utils.STATIC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setLoc_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(p.hasPermission("lobby.admin")){
                if(args.length < 1){
                    p.sendMessage(STATIC.ERROR + "§c§lBenutze /setLoc <1-6>");
                }else{
                    int locnumber = Integer.parseInt(args[0]);
                    LocationManager.setLocation(locnumber, p.getLocation());
                    p.sendMessage(STATIC.PREFIX + "§a§lLocation erstellt!");
                    p.sendMessage(STATIC.PREFIX + "§8§l ➥ §a§lX §8§l➥ §a§l" + p.getLocation().getX());
                    p.sendMessage(STATIC.PREFIX + "§8§l ➥ §a§lY §8§l➥ §a§l" + p.getLocation().getY());
                    p.sendMessage(STATIC.PREFIX + "§8§l ➥ §a§lZ §8§l➥ §a§l" + p.getLocation().getZ());
                    p.sendMessage(STATIC.PREFIX + "§8§l ➥ §a§lWelt §8§l➥ §a§l" + p.getLocation().getWorld().getName());
                }
            }else{
                p.sendMessage(STATIC.ERROR + "§c§lDu hast dazu keine Rechte!");
            }
        }
        return true;
    }
}
