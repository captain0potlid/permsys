package com.moon.moon.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.moon.moon.items;
import com.moon.moon.main;

public class CMDtest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = Bukkit.getPlayer(sender.getName());
		
		if (cmd.getName().equalsIgnoreCase("test")) {
			
			p.sendMessage(ChatColor.WHITE + "TEST");
			main.perml.put(p.getUniqueId(), "placeholder");
			System.out.println("¼±¾ð : " + main.perml.get(p.getUniqueId()));
			
			if(args.length == 0) return true;
			
			Bukkit.getPlayer(sender.getName()).getInventory().addItem(items.getExampleBook(p));
			
			return true;
			
		}

		return true;
	}

}
