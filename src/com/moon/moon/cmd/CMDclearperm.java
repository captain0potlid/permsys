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
import com.moon.moon.voids;

public class CMDclearperm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = Bukkit.getPlayer(sender.getName());
		
		if (cmd.getName().equalsIgnoreCase("clearperm")) {
			//Bukkit.broadcastMessage("clearperm sig");
			
			if(args[1].equalsIgnoreCase("[all]")) {
				for(Player e : Bukkit.getOnlinePlayers()) {
					
					if(voids.chkhasperm(e, "ADMIN") == true)  {
						Bukkit.broadcastMessage(p.getDisplayName() + "님은 운영자여서 권한 설정이 적용되지 않았습니다.");
						continue;
					}
					if(voids.chkhasperm(e, args[0]) == false) {
						Bukkit.broadcastMessage(e.getDisplayName() + "님은 해당 권한을 이미 가지고 있지 않아 설정이 적용되지 않았습니다.");
						continue;
					}
					if(voids.chkhasperm(e, "ADMIN") == false) {
						p.chat("/권한싸움 비활성화 " + e.getDisplayName() + " " + args[0]);
						continue;
					}
				}
				return true;
			}
			
			
			voids.wan(args);
			return true;
		}

		return true;
	}

}
