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
		
		if (event.getDamager() instanceof Player) { // �´³�

			Player p = (Player) event.getDamager();
			Player inno = (Player) event.getEntity();

			if (!main.perml.containsKey(p.getUniqueId())) { // ��� ������(=���� ������)
				voids.heynopermMSG(p, "PlayerCOMBAT");
				return;
			}
			if (voids.isAdmin(p) == true) { // ��� �ɷ�����
				return;
			}
			if (voids.chkhasperm(p, "PlayerCOMBAT") == true) {
				return;// �˾Ƽ� �ϼ� ����
			} else {
				event.setCancelled(true);
				voids.heynopermMSG(p, "PlayerCOMBAT"); // ���� ����ϴ�
				return;
			}

		} else {
			Entity p = (Entity) event.getDamager(); //100�� ���
			Entity inno =(Entity) event.getEntity(); //�´� ��ƼƼ
			
			
		}

	}
}
