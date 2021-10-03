package com.moon.moon.event;

import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Door;
import org.bukkit.material.Gate;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.google.common.collect.Sets;
import com.moon.moon.main;
import com.moon.moon.voids;
import com.moon.moon.main;

public class EVENTchat implements Listener {

	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();

		if(voids.isAdmin(p) == true) {
			return;
		}
		if(voids.chkhasperm(p, "PlayerCHAT") == false) {
			e.setCancelled(true);
			voids.heynopermMSG(p, "PlayerCHAT");
		}
	}
}