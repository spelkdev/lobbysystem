package de.spelk.lobbysystem.utils;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TrailManager {

    public static void register(Player player){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO Trails (UUID,Player,Fire,Hearts,Water) VALUES (?,?,?,?,?)");
            ps.setString(1, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getFire(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Trails WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Fire");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getHearts(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Trails WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Hearts");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getWater(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Trails WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Water");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setFire(Player player, int state){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE Gadgets SET Fire = ?, Player = ?, Hearts = ?, Water = ? WHERE UUID = ?");
            ps.setString(5, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setInt(1, state);
            ps.setInt(3,getHearts(player.getUniqueId()));
            ps.setInt(4,getWater(player.getUniqueId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setHearts(Player player, int state){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE Gadgets SET Hearts = ?, Player = ?, Fire = ?, Water = ? WHERE UUID = ?");
            ps.setString(5, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setInt(1, state);
            ps.setInt(3, getFire(player.getUniqueId()));
            ps.setInt(4, getWater(player.getUniqueId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setWater(Player player, int state){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE Gadgets SET Water = ?, Player = ?, Hearts = ?, Fire = ? WHERE UUID = ?");
            ps.setString(5, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setInt(1, state);
            ps.setInt(3, getHearts(player.getUniqueId()));
            ps.setInt(4, getFire(player.getUniqueId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
