package com.moon.moon.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

import com.moon.moon.voids;

public class EVENTeat implements Listener{
	@EventHandler
	public static void OnEat(PlayerItemConsumeEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(voids.isAdmin(p) == true) return;
		if(voids.chkhasperm(p, "PlayerEAT") == true ) return;
		
		e.setCancelled(true);
		voids.heynopermMSG(p, "PlayerEAT");
		p.closeInventory();
		
		return;
	}
}
