package com.moon.moon.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.moon.moon.voids;


public class EVENTblock implements Listener{
	@EventHandler
	public static void MainEvent(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		Material[] baseblocks = {};
		
		
		
		
		if(voids.isAdmin(p)) return;
		if(voids.chkhasperm(p, "PlayerPIXAXE") == true) return;
		
		e.setCancelled(true);
		voids.heynopermMSG(p, "PlayerPIXAXE");
		return;
	}
	@EventHandler
	public static void subevent(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(e.getBlock() == null) return;
		if(p.getItemInHand().getType()==null)return;
		Material b = p.getItemInHand().getType();
		if(b == Material.SEEDS || b == Material.BEETROOT_SEEDS || b == Material.MELON_SEEDS || b == Material.PUMPKIN_SEEDS) {
			if(voids.isAdmin(p) == true) return;
			if(voids.chkhasperm(p, "PlayerFARM") == true) return;
			
			voids.heynopermMSG(p, "PlayerFARM");
			e.setCancelled(true);
			return;
		}
		//Bukkit.broadcastMessage("12");
		if(voids.isAdmin(p)) return;
		if(voids.chkhasperm(p, "PlayerPIXAXE") == true) return;
		
		e.setCancelled(true);
		voids.heynopermMSG(p, "PlayerPIXAXE");
		return;
	}
}
