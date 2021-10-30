package com.moon.moon;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.moon.moon.event.*;
import com.moon.moon.cmd.*;
import com.moon.moon.event.EVENTjustcmd;

public class main extends JavaPlugin implements Listener {

	public static ConsoleCommandSender consol = Bukkit.getConsoleSender();

	public static HashMap<UUID, String> perml = new HashMap<UUID, String>(); // permission list config into String
																				// array?
	public static HashMap<UUID, Integer> w = new HashMap<UUID, Integer>();

	@Override
	public void onEnable() {

		consol.sendMessage(ChatColor.AQUA
				+ "---------------------------------------------------------------------------------------------");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA + "[	*	*	*	Psys 플러그인 정상가동됨!	*	*	*	]");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA
				+ "---------------------------------------------------------------------------------------------");

		getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new EVENTmove(), this);
		this.getServer().getPluginManager().registerEvents(new EVENTjustcmd(), this);
		this.getServer().getPluginManager().registerEvents(new EVENTchat(), this);
		this.getServer().getPluginManager().registerEvents(new EVENTattack(), this);
		this.getServer().getPluginManager().registerEvents(new com.moon.moon.event.EVENTblock(), this);
		this.getServer().getPluginManager().registerEvents(new EVENTcraft(), this);
		this.getServer().getPluginManager().registerEvents(new test(), this);
		this.getServer().getPluginManager().registerEvents(new com.moon.moon.event.EVENTinteract(), this);
		this.getServer().getPluginManager().registerEvents(new EVENTeat(), this);
		getCommand("test").setExecutor(new CMDtest());
		getCommand("kor").setExecutor(new CMDkor());
		getCommand("display").setExecutor(new CMDdisplay());
		getCommand("clearperm").setExecutor(new CMDclearperm());
		getCommand("allperm").setExecutor(new CMDallperm());
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(ChatColor.GRAY + "Connected to server #BETA - 서버 #BETA 에 연결되었습니다. TDS 8080");
			
			
			if (p.isOp()) {
				main.perml.put(p.getUniqueId(), "ADMIN");
				p.sendMessage(ChatColor.YELLOW + "OP 유저는 자동으로 모든 권한이 주어집니다. 명령어를 통해 수정하실 수 있습니다!");
				voids.YesMOVE(p);
			}
			
			if(!main.perml.containsKey(p.getUniqueId())) p.chat("/test");
			voids.chklive(p);
		}
		
		
	}
	
	@Override
	public void onDisable() {
		
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		// 개발자용!!!!!!

		p.sendMessage(ChatColor.RED + "[#주의#] 이 버전은 개발자용 베타 버전입니다.");
		p.sendMessage(ChatColor.RED + "[#주의#] NET 프레임워크와의 충돌이 있을 수 있습니다!");
		p.sendMessage(ChatColor.RED + "");

		if (p.isOp()) {
			main.perml.put(p.getUniqueId(), "ADMIN");
			p.sendMessage(ChatColor.YELLOW + "OP 유저는 자동으로 모든 권한이 주어집니다. 명령어를 통해 수정하실 수 있습니다!");
			voids.YesMOVE(p);
		}
		
		voids.chklive(p);
		
		if(!main.perml.containsKey(p.getUniqueId())) p.chat("/test");
		
		return;
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if(!w.containsKey(p.getUniqueId())) return;
		
		Bukkit.getScheduler().cancelTask(w.get(p.getUniqueId()));
	}

}
