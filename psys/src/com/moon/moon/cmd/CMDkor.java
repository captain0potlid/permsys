package com.moon.moon.cmd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.moon.moon.BookUtil;
import com.moon.moon.items;
import com.moon.moon.main;

public class CMDkor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = Bukkit.getPlayer(sender.getName());
		
		if (cmd.getName().equalsIgnoreCase("kor")) {
			
			p.sendMessage(ChatColor.WHITE + "kor1");
			
			BookUtil.openBook(items.nullbook(), p);
			
			return true;
			
		}

		return true;
	}

}
