package de.spelk.lobbysystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

    public static void setSB(Player player){
        org.bukkit.scoreboard.ScoreboardManager sb = Bukkit.getScoreboardManager();
        Scoreboard board = sb.getNewScoreboard();
        Objective o = board.registerNewObjective("lobby", "dummy");
        o.setDisplayName(STATIC.PREFIX);
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.getScore("§f  ").setScore(10);
        o.getScore("§6✪ §c§lDeine Coins").setScore(9);
        o.getScore("§8§l➥ §a§l" + CoinsManager.getCoins(player.getUniqueId())).setScore(8);
        o.getScore("§f ").setScore(7);
        o.getScore("§6✪ §c§lDein Rang").setScore(6);
        o.getScore("§8§l➥ " + getRank(player)).setScore(5);
        o.getScore("§f").setScore(4);
        o.getScore("§6✪ §c§lTeamspeak").setScore(3);
        o.getScore("§8§l➥ §b§lLePseudo.DE").setScore(2);
        o.getScore("§f         ").setScore(1);
        player.setScoreboard(board);
    }

    public static String getRank(Player player){
        String rank;
        if(player.hasPermission("lobby.owner")){
            rank = "§4§lOwner";
        }else if(player.hasPermission("lobby.admin")){
            rank = "§c§lAdmin";
        }else if(player.hasPermission("lobby.teamleitung")){
            rank = "§cTeam-Leitung";
        }else if(player.hasPermission("lobby.content")){
            rank = "§bContent";
        }else if(player.hasPermission("lobby.dev")){
            rank = "§bDeveloper";
        }else if(player.hasPermission("lobby.webdev")){
            rank = "§bWeb-Dev";
        }else if(player.hasPermission("lobby.modleitung")){
            rank = "§cMod-Leitung";
        }else if(player.hasPermission("lobby.bauleitung")){
            rank = "§eBau-Leitung";
        }else if(player.hasPermission("lobby.mod")){
            rank = "§cModerator";
        }else if(player.hasPermission("lobby.sup")){
            rank = "§aSupporter";
        }else if(player.hasPermission("lobby.builder")){
            rank = "§eBuilder";
        }else if(player.hasPermission("lobby.yt")){
            rank = "§5YouTuber";
        }else if(player.hasPermission("lobby.premium")){
            rank = "§6Premium";
        }else{
            rank = "§7Spieler";
        }
        return rank;
    }

}
