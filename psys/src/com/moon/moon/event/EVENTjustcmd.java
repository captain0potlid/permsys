package com.moon.moon.event;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.moon.moon.items;
import com.moon.moon.main;
import com.moon.moon.voids;

public class EVENTjustcmd implements Listener {

	// /권한싸움 북 [ 권한이름 ] : [ 권한이름 ] 의 권한북을 지급합니다 [ 권한이름 ]의 권한북 우클릭시 해당 권한이 활성화 됩니다
	// /권한싸움 비활성화 [ 플레이어 ] [ 권한이름 ] : [ 플레이어 ] 의 [ 권한이름 ]의 권한을 비활성화 합니다.
	// /권한싸움 활성화 [ 플레이어 ] [ 권한이름 ] : [ 플레이어 ] 의 [ 권한이름 ]의 권한을 활성화 합니다.
	// /권한싸움 리스트 : 권한 목록들을 보여줍니다.
	// /권한싸움 조회 [플레이어] : [플레이어] 의 권한 목록을 표시합니다.(디버그용)

	// 이동 점프[X] 식사 전투 조합 농사 광질 채팅 마이크

	public void heyargschk(Player p) {
		p.sendMessage(ChatColor.RED + "명령어 사용법이 틀렸습니다. /권한싸움 도움");
	}

	@EventHandler
	public void justcmd(PlayerCommandPreprocessEvent e) { //[ 플레이어 ] 의 [ 권한 이름 ] 의 권한이 ( &a활성화/&c비활성화 ) 되었습니다.
		if (e.getMessage().contains("/권한싸움")) {
			String args5 = e.getMessage();
			String[] args = args5.split(" ");
			Player p = e.getPlayer();
			Player sender = p;
			
			
			if (args[1].equalsIgnoreCase("북")) {
				p.chat("/kor");
				return;
			}
			if (args[1].equalsIgnoreCase("비활성화")) {
				Player target = Bukkit.getPlayer(args[2]);
				if(!main.perml.get(target.getUniqueId()).contains(args[3])) {
					p.sendMessage(ChatColor.RED + "이미 해당 유저는 해당 권한을 소지하고 있지 않았습니다!");
					return;
				}
				Bukkit.broadcastMessage(ChatColor.WHITE + "signal 비활성화");

				// /권한싸움 비활성화 captain0potlid Example1

				voids.deletepermission(target, args[3]);
				voids.announce(ChatColor.YELLOW + "OUT " + args[3]);
				
				String local = ChatColor.YELLOW + target.getDisplayName() + ChatColor.WHITE + " 의 " + ChatColor.AQUA + args[3] + 
						ChatColor.WHITE + " 의 권한이 " + ChatColor.RED + "비활성화" + ChatColor.WHITE + " 되었습니다.";
				
				p.chat("/display " + target.getDisplayName());
				p.sendMessage(local);
				target.sendMessage(local);
				
				return;
			}
			if (args[1].contains("활성화")) {
				Player target = Bukkit.getPlayer(args[2]);
				if(main.perml.get(target.getUniqueId()).contains(args[3])) {
					p.sendMessage(ChatColor.RED + "이미 해당 유저는 해당 권한을 소지하고 있습니다!");
					return;
				}
				
				Bukkit.broadcastMessage(ChatColor.WHITE + "signal 활성화");
				// /권한싸움 활성화 captain0potlid Example1
				
				
				
				voids.addpermssion(target, args[3]);
				
				String local = ChatColor.YELLOW + target.getDisplayName() + ChatColor.WHITE + " 의 " + ChatColor.AQUA + args[3] + 
						ChatColor.WHITE + " 의 권한이 " + ChatColor.GREEN + "활성화" + ChatColor.WHITE + " 되었습니다.";
				
				p.chat("/display " + target.getDisplayName());
				
				p.sendMessage(local);
				target.sendMessage(local);
				
				voids.announce(ChatColor.YELLOW + "NEW " + args[3]);
				return;
			}
			if (args[1].contains("리스트")) {
				p.sendMessage(
						ChatColor.WHITE + "현재 업데이트에서 사용 가능한 권한들(" + ChatColor.GREEN + "9" + ChatColor.WHITE + ") : ");
				p.sendMessage("");
				p.sendMessage(ChatColor.YELLOW + " * " + ChatColor.WHITE + "이동 권한(PlayerMOVE)        식사 권한(PlayerEAT)");
				p.sendMessage(ChatColor.YELLOW + " * " + ChatColor.WHITE + "전투 권한(PlayerCOMBAT)   조합 권한(PlayerCRAFT)");
				p.sendMessage(
						ChatColor.YELLOW + " * " + ChatColor.WHITE + "농사 권한(PlayerFARM)        광질 권한(PlayerPIXAXE)");
				p.sendMessage(
						ChatColor.YELLOW + " * " + ChatColor.WHITE + "채팅 권한(PlayerCHAT)        마이크 권한(PlayerMIC)");
				return;
			}
			if (args[1].contains("조회")) {
				Player target = Bukkit.getPlayer(args[2]);
				String targetname = args[2];
				Player target1 = Bukkit.getPlayer(targetname);
				String localprivate = main.perml.get(target1.getUniqueId());

				p.sendMessage(ChatColor.WHITE + targetname + "님은 다음과 같은 권한들을 소유 중입니다 :");
				p.sendMessage(ChatColor.WHITE + localprivate);
			} else {
				p.sendMessage(ChatColor.RED + "사용방법 : /권한싸움 <북, 리스트, 비활성화, 활성화, 조회, 도움>");
			}
			return;
		}
		return;

	}
}
