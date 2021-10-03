package com.moon.moon.event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.moon.moon.main;
import com.moon.moon.voids;

public class EVENTattack implements Listener {
	@EventHandler
	public void onTestEntityDamage(EntityDamageByEntityEvent event) {
		
		if(!(event.getDamager() instanceof Player)) return;
		
		if (event.getDamager() instanceof Player) { // 맞는놈

			Player p = (Player) event.getDamager();
			Player inno = (Player) event.getEntity();

			if (!main.perml.containsKey(p.getUniqueId())) { // 등록 없으면(=권한 없으면)
				voids.heynopermMSG(p, "PlayerCOMBAT");
				return;
			}
			if (voids.isAdmin(p) == true) { // 운영자 걸러내고
				return;
			}
			if (voids.chkhasperm(p, "PlayerCOMBAT") == true) {
				return;// 알아서 하셈 수고
			} else {
				event.setCancelled(true);
				voids.heynopermMSG(p, "PlayerCOMBAT"); // 권한 없답니다
				return;
			}

		} else {
			Entity p = (Entity) event.getDamager(); //100퍼 사람
			Entity inno =(Entity) event.getEntity(); //맞는 엔티티
			
			
		}

	}
}
