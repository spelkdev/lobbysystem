package de.spelk.lobbysystem.utils;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayersManager {

    public static int getJoined(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Players WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Joined");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setJoined(Player player){
        if(getJoined(player.getUniqueId()) == 0){
            GadgetsManager.register(player);
            TrailManager.register(player);
            BootsManager.register(player);
            try {
                PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO Players(UUID,PLAYER,JOINED) VALUES (?,?,?)");
                ps.setString(1,player.getUniqueId().toString());
                ps.setString(2,player.getName());
                ps.setInt(3,1);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
