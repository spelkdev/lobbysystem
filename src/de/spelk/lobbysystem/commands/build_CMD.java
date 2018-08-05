package de.spelk.lobbysystem.commands;

import de.spelk.lobbysystem.Main;
import de.spelk.lobbysystem.utils.ItemManager;
import de.spelk.lobbysystem.utils.STATIC;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class build_CMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(p.hasPermission("lobby.build")){
                if(args.length < 1){
                    if(!(Main.buildMode.contains(p))){
                        p.setGameMode(GameMode.CREATIVE);
                        Main.buildMode.add(p);
                        p.sendMessage(STATIC.PREFIX + "§5§lBaumodus §8§l» §a§lAktiviert");
                        p.getInventory().clear();
                    }else{
                        p.setGameMode(GameMode.SURVIVAL);
                        Main.buildMode.remove(p);
                        p.sendMessage(STATIC.PREFIX + "§5§lBaumodus §8§l» §c§lDeaktiviert");
                        ItemManager.loadDefault(p);
                    }
                }
            }else{
                p.sendMessage(STATIC.ERROR + "§c§lDu hast dazu keine Rechte!");
            }
        }
        return true;
    }
}
