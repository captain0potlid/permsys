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

	// /���ѽο� �� [ �����̸� ] : [ �����̸� ] �� ���Ѻ��� �����մϴ� [ �����̸� ]�� ���Ѻ� ��Ŭ���� �ش� ������ Ȱ��ȭ �˴ϴ�
	// /���ѽο� ��Ȱ��ȭ [ �÷��̾� ] [ �����̸� ] : [ �÷��̾� ] �� [ �����̸� ]�� ������ ��Ȱ��ȭ �մϴ�.
	// /���ѽο� Ȱ��ȭ [ �÷��̾� ] [ �����̸� ] : [ �÷��̾� ] �� [ �����̸� ]�� ������ Ȱ��ȭ �մϴ�.
	// /���ѽο� ����Ʈ : ���� ��ϵ��� �����ݴϴ�.
	// /���ѽο� ��ȸ [�÷��̾�] : [�÷��̾�] �� ���� ����� ǥ���մϴ�.(����׿�)

	// �̵� ����[X] �Ļ� ���� ���� ��� ���� ä�� ����ũ

	public void heyargschk(Player p) {
		p.sendMessage(ChatColor.RED + "��ɾ� ������ Ʋ�Ƚ��ϴ�. /���ѽο� ����");
	}

	@EventHandler
	public void justcmd(PlayerCommandPreprocessEvent e) { //[ �÷��̾� ] �� [ ���� �̸� ] �� ������ ( &aȰ��ȭ/&c��Ȱ��ȭ ) �Ǿ����ϴ�.
		if (e.getMessage().contains("/���ѽο�")) {
			String args5 = e.getMessage();
			String[] args = args5.split(" ");
			Player p = e.getPlayer();
			Player sender = p;
			
			
			if (args[1].equalsIgnoreCase("��")) {
				p.chat("/kor");
				return;
			}
			if (args[1].equalsIgnoreCase("��Ȱ��ȭ")) {
				Player target = Bukkit.getPlayer(args[2]);
				if(!main.perml.get(target.getUniqueId()).contains(args[3])) {
					p.sendMessage(ChatColor.RED + "�̹� �ش� ������ �ش� ������ �����ϰ� ���� �ʾҽ��ϴ�!");
					return;
				}
				Bukkit.broadcastMessage(ChatColor.WHITE + "signal ��Ȱ��ȭ");

				// /���ѽο� ��Ȱ��ȭ captain0potlid Example1

				voids.deletepermission(target, args[3]);
				voids.announce(ChatColor.YELLOW + "OUT " + args[3]);
				
				String local = ChatColor.YELLOW + target.getDisplayName() + ChatColor.WHITE + " �� " + ChatColor.AQUA + args[3] + 
						ChatColor.WHITE + " �� ������ " + ChatColor.RED + "��Ȱ��ȭ" + ChatColor.WHITE + " �Ǿ����ϴ�.";
				
				p.chat("/display " + target.getDisplayName());
				p.sendMessage(local);
				target.sendMessage(local);
				
				return;
			}
			if (args[1].contains("Ȱ��ȭ")) {
				Player target = Bukkit.getPlayer(args[2]);
				if(main.perml.get(target.getUniqueId()).contains(args[3])) {
					p.sendMessage(ChatColor.RED + "�̹� �ش� ������ �ش� ������ �����ϰ� �ֽ��ϴ�!");
					return;
				}
				
				Bukkit.broadcastMessage(ChatColor.WHITE + "signal Ȱ��ȭ");
				// /���ѽο� Ȱ��ȭ captain0potlid Example1
				
				
				
				voids.addpermssion(target, args[3]);
				
				String local = ChatColor.YELLOW + target.getDisplayName() + ChatColor.WHITE + " �� " + ChatColor.AQUA + args[3] + 
						ChatColor.WHITE + " �� ������ " + ChatColor.GREEN + "Ȱ��ȭ" + ChatColor.WHITE + " �Ǿ����ϴ�.";
				
				p.chat("/display " + target.getDisplayName());
				
				p.sendMessage(local);
				target.sendMessage(local);
				
				voids.announce(ChatColor.YELLOW + "NEW " + args[3]);
				return;
			}
			if (args[1].contains("����Ʈ")) {
				p.sendMessage(
						ChatColor.WHITE + "���� ������Ʈ���� ��� ������ ���ѵ�(" + ChatColor.GREEN + "9" + ChatColor.WHITE + ") : ");
				p.sendMessage("");
				p.sendMessage(ChatColor.YELLOW + " * " + ChatColor.WHITE + "�̵� ����(PlayerMOVE)        �Ļ� ����(PlayerEAT)");
				p.sendMessage(ChatColor.YELLOW + " * " + ChatColor.WHITE + "���� ����(PlayerCOMBAT)   ���� ����(PlayerCRAFT)");
				p.sendMessage(
						ChatColor.YELLOW + " * " + ChatColor.WHITE + "��� ����(PlayerFARM)        ���� ����(PlayerPIXAXE)");
				p.sendMessage(
						ChatColor.YELLOW + " * " + ChatColor.WHITE + "ä�� ����(PlayerCHAT)        ����ũ ����(PlayerMIC)");
				return;
			}
			if (args[1].contains("��ȸ")) {
				Player target = Bukkit.getPlayer(args[2]);
				String targetname = args[2];
				Player target1 = Bukkit.getPlayer(targetname);
				String localprivate = main.perml.get(target1.getUniqueId());

				p.sendMessage(ChatColor.WHITE + targetname + "���� ������ ���� ���ѵ��� ���� ���Դϴ� :");
				p.sendMessage(ChatColor.WHITE + localprivate);
			} else {
				p.sendMessage(ChatColor.RED + "����� : /���ѽο� <��, ����Ʈ, ��Ȱ��ȭ, Ȱ��ȭ, ��ȸ, ����>");
			}
			return;
		}
		return;

	}
}
