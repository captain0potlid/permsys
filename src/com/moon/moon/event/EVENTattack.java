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
		
		if (event.getDamager() instanceof Player) { // �´³�
			
			if(event.getDamager() instanceof Player | event.getEntity() instanceof Player | !(Bukkit.getPlayer(event.getDamager().getUniqueId()).getItemInHand() == null)) {
				//Bukkit.broadcastMessage(ChatColor.RED + "awefjlk;1a");
				if(!(Bukkit.getPlayer(event.getDamager().getUniqueId()).getItemInHand().getType() == Material.BOOK)) return;
				ItemMeta a = Bukkit.getPlayer(event.getDamager().getUniqueId()).getItemInHand().getItemMeta();
				String name = a.getDisplayName();
				Player w = Bukkit.getPlayer(event.getEntity().getUniqueId()); //����
				Player p = Bukkit.getPlayer(event.getDamager().getUniqueId()); //����
				
				//if(!name.contains("���ѻ���")) return;
				
				String normal = ChatColor.WHITE + name;
				String perm = a.getLore().get(0);
				
				if(voids.chkhasperm(w, perm) == false)  {
					p.sendMessage(ChatColor.RED + "�̹� �ش� ������ �����ϴ�!");
					return;
				}
				// /���ѽο� ��Ȱ��ȭ captain0potlid 
				p.chat("/���ѽο� ��Ȱ��ȭ "+ w.getDisplayName() +" " + perm);
				
				String local = ChatColor.YELLOW + w.getDisplayName() + ChatColor.WHITE + " �� " + ChatColor.AQUA + perm + 
						ChatColor.WHITE + " �� ������ " + ChatColor.RED + "��Ȱ��ȭ" + ChatColor.WHITE + " �Ǿ����ϴ�.";
				//Bukkit.broadcastMessage(local);
				Bukkit.broadcastMessage("<" + p.getDisplayName() + ">" + subvoid.randWords());
				return;
			}
			
			Player p = (Player) event.getDamager();
			Player inno = (Player) event.getEntity();

			if (!main.perml.containsKey(p.getUniqueId())) { // ��� ������(=���� ������)
				voids.heynopermMSG(p, "PlayerCOMBAT1");
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

		}

	}
}
