package com.moon.moon.event;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.moon.moon.voids;

public class EVENTinteract implements Listener {
    @EventHandler
    public void ballFiring(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR)) return;
        
        if (!(e.getItem().getType() == Material.BLAZE_ROD)) return;
        if(!voids.chkhasperm(p, "fb")) return;
        
        Fireball s = e.getPlayer().launchProjectile(Fireball.class);
    }
}
