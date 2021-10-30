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

public class CMDallperm implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = Bukkit.getPlayer(sender.getName());

		if (cmd.getName().equalsIgnoreCase("allperm")) {
			//Bukkit.broadcastMessage("allperm sig");

			if (args[1].equalsIgnoreCase("[all]")) {
				for (Player e : Bukkit.getOnlinePlayers()) {

					if (voids.chkhasperm(e, "ADMIN") == true) {
						Bukkit.broadcastMessage(p.getDisplayName() + "���� ��ڿ��� ���� ������ ������� �ʾҽ��ϴ�.");
						continue;
					}
					if (voids.chkhasperm(e, args[0]) == true) {
						Bukkit.broadcastMessage(e.getDisplayName() + "���� �ش� ������ �̹� ������ �־� ������ ������� �ʾҽ��ϴ�.");
						continue;
					}
					if (voids.chkhasperm(e, "ADMIN") == false) {
						p.chat("/���ѽο� Ȱ��ȭ " + e.getDisplayName() + " " + args[0]);
						continue;
					}
				}
				return true;
			}

			voids.wan1(args);
			return true;
		}

		return true;
	}

}
