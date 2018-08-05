package de.spelk.lobbysystem.listeners;

import de.spelk.lobbysystem.Main;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class others_Event implements Listener {

    @EventHandler
    public void onFallDamage(EntityDamageEvent e){
        if(e.getEntityType().equals(EntityType.PLAYER)){
           if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
               e.setCancelled(true);
           }
           if(e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)){
               e.setCancelled(true);
           }
            if(e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)){
                e.setCancelled(true);
            }
            if(e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)){
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e){
        if(Main.buildMode.contains(e.getPlayer())){
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        e.setCancelled(true);
    }

}
