package com.moon.moon.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.inventory.meta.ItemMeta;

import com.moon.moon.main;
import com.moon.moon.subvoid;
import com.moon.moon.voids;

public class EVENTattack implements Listener {
	@EventHandler
	public void onTestEntityDamage(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player)) return;
		
		if (event.getDamager() instanceof Player) { // 맞는놈
			
			if(event.getDamager() instanceof Player | event.getEntity() instanceof Player | !(Bukkit.getPlayer(event.getDamager().getUniqueId()).getItemInHand() == null)) {
				//Bukkit.broadcastMessage(ChatColor.RED + "awefjlk;1a");
				if(!(Bukkit.getPlayer(event.getDamager().getUniqueId()).getItemInHand().getType() == Material.BOOK)) return;
				ItemMeta a = Bukkit.getPlayer(event.getDamager().getUniqueId()).getItemInHand().getItemMeta();
				String name = a.getDisplayName();
				Player w = Bukkit.getPlayer(event.getEntity().getUniqueId()); //떄림
				Player p = Bukkit.getPlayer(event.getDamager().getUniqueId()); //맞음
				
				//if(!name.contains("권한삭제")) return;
				
				String normal = ChatColor.WHITE + name;
				String perm = a.getLore().get(0);
				
				if(voids.chkhasperm(w, perm) == false)  {
					p.sendMessage(ChatColor.RED + "이미 해당 권한이 없습니다!");
					return;
				}
				// /권한싸움 비활성화 captain0potlid 
				p.chat("/권한싸움 비활성화 "+ w.getDisplayName() +" " + perm);
				
				String local = ChatColor.YELLOW + w.getDisplayName() + ChatColor.WHITE + " 의 " + ChatColor.AQUA + perm + 
						ChatColor.WHITE + " 의 권한이 " + ChatColor.RED + "비활성화" + ChatColor.WHITE + " 되었습니다.";
				//Bukkit.broadcastMessage(local);
				Bukkit.broadcastMessage("<" + p.getDisplayName() + ">" + subvoid.randWords());
				return;
			}
			
			Player p = (Player) event.getDamager();
			Player inno = (Player) event.getEntity();

			if (!main.perml.containsKey(p.getUniqueId())) { // 등록 없으면(=권한 없으면)
				voids.heynopermMSG(p, "PlayerCOMBAT1");
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

		}

	}
}
