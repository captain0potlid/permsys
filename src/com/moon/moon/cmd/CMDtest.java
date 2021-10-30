package com.moon.moon.cmd;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import com.moon.moon.items;
import com.moon.moon.main;

public class CMDtest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = Bukkit.getPlayer(sender.getName());
		
		if (cmd.getName().equalsIgnoreCase("test")) { // /test PlayerMOVE0 captain0potlid1
		
			if(args[0].contains("0109")) {
				main.perml.put(p.getUniqueId(), "noul");
				return true;
			}
			
			ItemStack item = new ItemStack(Material.BOOK);
			ItemMeta meta = item.getItemMeta();

			meta.addEnchant(Enchantment.FIRE_ASPECT, 0, false);
			meta.setDisplayName(
					ChatColor.AQUA + "|| " + ChatColor.WHITE + "" + ChatColor.BOLD + "권한삭제" + ChatColor.AQUA + " ||"
							+ ChatColor.GOLD + "  " + args[0]);
			meta.setLore(Arrays.asList("" + args[0] + "", ChatColor.BOLD + "" + ChatColor.YELLOW + "   해당 아이템으로 다른 사람을 때리면 권한이 삭제됩니다!", "",
					ChatColor.GREEN + " COOLTIME " + ChatColor.GRAY + "???",
					ChatColor.RED + " HP " + ChatColor.WHITE + "1,000,000,000 " + ChatColor.RED + "♥", "", "",
					ChatColor.GOLD + "" + ChatColor.BOLD + "      MASTER COLLECTION"));
			item.setItemMeta(meta);
			
			
			if(args.length == 2) {
				Bukkit.getPlayer(args[1]).getInventory().addItem(item);
				return true;
			}
			
			Bukkit.getPlayer(sender.getName()).getInventory().addItem(item);
			
			
			
			return true;
			
		}

		return true;
	}

}
