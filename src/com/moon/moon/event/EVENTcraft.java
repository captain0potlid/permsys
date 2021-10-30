package com.moon.moon.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import com.moon.moon.voids;

public class EVENTcraft implements Listener{
	@EventHandler
	public static void OnCraft(CraftItemEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(voids.isAdmin(p) == true) return;
		if(voids.chkhasperm(p, "PlayerCRAFT") == true ) return;
		
		e.setCancelled(true);
		voids.heynopermMSG(p, "PlayerCRAFT");
		p.closeInventory();
		
		return;
	}
}
