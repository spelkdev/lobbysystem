package de.spelk.lobbysystem.utils;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CoinsManager {

    public static int getCoins(UUID uuid){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT * FROM Coins WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("Coins");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setCoins(Player player, int coins){
        if(getCoins(player.getUniqueId()) == 0){
            try {
                PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO Coins (UUID,Player,Coins) VALUES (?,?,?)");
                ps.setString(1, player.getUniqueId().toString());
                ps.setString(2, player.getName());
                ps.setInt(3, coins);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            try {
                PreparedStatement ps = MySQL.con.prepareStatement("UPDATE Coins SET Coins = ? WHERE UUID = ?");
                ps.setString(2, player.getUniqueId().toString());
                ps.setInt(1, coins);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addCoins(Player player, int coins){
        setCoins(player, coins + getCoins(player.getUniqueId()));
    }

    public static void removeCoins(Player player, int coins){
        setCoins(player, getCoins(player.getUniqueId()) - coins);
    }

}
