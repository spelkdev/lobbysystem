package de.spelk.lobbysystem.utils;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class GadgetsManager {

    public static void register(Player player){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO Gadgets (UUID,Player,Grappling_Hook,Gun,Fly_Feather) VALUES (?,?,?,?,?)");
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

    public static int getGrappling_Hook(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Gadgets WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Grappling_Hook");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getGun(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Gadgets WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Gun");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getFly_Feather(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Gadgets WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Fly_Feather");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setGrappling_Hook(Player player, int state){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE Gadgets SET Grappling_Hook = ?, Player = ?, Gun = ?, Fly_Feather = ? WHERE UUID = ?");
            ps.setString(5, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setInt(1, state);
            ps.setInt(3,getGun(player.getUniqueId()));
            ps.setInt(4,getFly_Feather(player.getUniqueId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setGun(Player player, int state){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE Gadgets SET Gun = ?, Player = ?, Grappling_Hook = ?, Fly_Feather = ? WHERE UUID = ?");
            ps.setString(5, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setInt(1, state);
            ps.setInt(3, getGrappling_Hook(player.getUniqueId()));
            ps.setInt(4, getFly_Feather(player.getUniqueId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setFly_Feather(Player player, int state){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE Gadgets SET Fly_Feather = ?, Player = ?, Gun = ?, Grappling_Hook = ? WHERE UUID = ?");
            ps.setString(5, player.getUniqueId().toString());
            ps.setString(2, player.getName());
            ps.setInt(1, state);
            ps.setInt(3, getGun(player.getUniqueId()));
            ps.setInt(4, getGrappling_Hook(player.getUniqueId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
