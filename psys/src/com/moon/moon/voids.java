package com.moon.moon;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class voids {

	public static ConsoleCommandSender consol = Bukkit.getConsoleSender();

	public static void NoMOVE(Player p) {
		p.setWalkSpeed(0);
		p.setFlySpeed(0);
	}

	public static void YesMOVE(Player p) {
		p.setWalkSpeed(0.2F);
		p.setFlySpeed(0.1F);
	}

	public static void announce(String integer) {
		System.out.println("");
		System.out.println(ChatColor.AQUA + "& NEW INTEGER CHANGE ANNOUNCED $ - " + ChatColor.YELLOW + integer);
	}

	public static void heynopermMSG(Player p, String a) {
		p.sendMessage(ChatColor.RED + " * " + ChatColor.GRAY + "다음 권한이 없습니다! :" + a);
	}

	public static void addpermssion(Player p, String a) {
		main.perml.put(p.getUniqueId(), main.perml.get(p.getUniqueId()) + " " + a);
		announce("+ " + a);
	}

	public static void deletepermission(Player p, String w) {

		main.perml.put(p.getUniqueId(), main.perml.get(p.getUniqueId()).replaceAll(w, ""));

		announce("- " + w);
	}

	public static boolean chkhasperm(Player p, String w) {
		Boolean rf = null;

		if (!main.perml.containsKey(p.getUniqueId())) {
			consol.sendMessage(
					ChatColor.RED + "0011 error /hey no permission record to load false return but error chk plz/");
			return false;
		}
		if (!main.perml.get(p.getUniqueId()).contains(w))
			return false;

		return true;
	}

	public static boolean isAdmin(Player p) {
		Boolean a = null;

		if (!main.perml.containsKey(p.getUniqueId())) {
			consol.sendMessage(ChatColor.RED + "0056 error /not admin no key maybe reloaded?/");
			return false;
		}
		if (main.perml.get(p.getUniqueId()).contains("ADMIN")) a = true;
		if (!main.perml.get(p.getUniqueId()).contains("ADMIN")) a = false;

		return a;
	}
	
	public static void chklive(Player p) {
		int count;
		
		count = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getPlugin(main.class), new Runnable() {
		    @Override
		    public void run() {
		    	
		    	if(!main.perml.containsKey(p.getUniqueId())) p.chat("/test");
		    	
		    	if(voids.chkhasperm(p, "PlayerMOVE") == true || voids.isAdmin(p) == true) {
		    		voids.YesMOVE(p);
		    		return;
		    	}
		    	if(voids.chkhasperm(p, "PlayerMOVE")== false) {
		    		voids.NoMOVE(p);
		    		voids.heynopermMSG(p,"PlayerMOVE");
		    		return;
		    	} else {
		    		voids.NoMOVE(p);
		    		voids.heynopermMSG(p,"PlayerMOVE");
		    		return;
		    	}
		    }
		}, 0L, 100L);
		
		main.w.put(p.getUniqueId(), count);
	}
	
	public static String kw(Player p, String perm) {
		
		if(voids.chkhasperm(p, perm) == true) return "/권한싸움 비활성화 " + p.getDisplayName() +" "+ perm; 
		if(voids.chkhasperm(p, perm)== false) return "/권한싸움 활성화 " + p.getDisplayName() +" "+ perm; 
		
		
		
		return null;
	}
}
