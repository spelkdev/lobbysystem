package de.spelk.lobbysystem.utils;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DailyManager {

    public static String getLastDaily(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM daily WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString("LastDaily");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setDaily(Player player, String currentDate){
        if(getLastDaily(player.getUniqueId()) == null){
            try {
                PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO daily (UUID,Player,LastDaily) VALUES (?,?,?)");
                ps.setString(1, player.getUniqueId().toString());
                ps.setString(2, player.getName());
                ps.setString(3, currentDate);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try {
                PreparedStatement ps = MySQL.con.prepareStatement("UPDATE daily SET lastdaily = ?, Player = ? WHERE UUID = ?");
                ps.setString(3, player.getUniqueId().toString());
                ps.setString(2, player.getName());
                ps.setString(1, currentDate);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
