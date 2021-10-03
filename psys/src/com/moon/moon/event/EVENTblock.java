package com.moon.moon.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

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
}
