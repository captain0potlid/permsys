package com.moon.moon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftMetaBook;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.md_5.bungee.api.plugin.Plugin;

public class items {
	public static ItemStack bookitem() {
		ItemStack item = new ItemStack(Material.BOOK);
		ItemMeta meta = item.getItemMeta();

		meta.addEnchant(Enchantment.FIRE_ASPECT, 0, false);
		meta.setDisplayName(
				ChatColor.AQUA + "|| " + ChatColor.WHITE + "" + ChatColor.BOLD + "�����̸�" + ChatColor.AQUA + " ||");
		meta.setLore(Arrays.asList(ChatColor.BOLD + "" + ChatColor.YELLOW + "   �� �������� ��� ���� �������Դϴ�!", "",
				ChatColor.GREEN + " COOLTIME " + ChatColor.GRAY + "???",
				ChatColor.RED + " HP " + ChatColor.WHITE + "1,000,000,000 " + ChatColor.RED + "��", "", "",
				ChatColor.GOLD + "" + ChatColor.BOLD + "      MASTER COLLECTION"));
		item.setItemMeta(meta);

		return item;
	}

	public static ItemStack nullbook() {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookMeta = (BookMeta) book.getItemMeta();
		String n = "\n";

		int w = 0;
		String local = "";
		// create a page
		for (Player p : Bukkit.getOnlinePlayers()) {
			w++;

			if (p.isOp())
				local = net.md_5.bungee.api.ChatColor.RED + " [!] OP �����Դϴ�!";
			if (voids.isAdmin(p) == true)
				local = local + n + net.md_5.bungee.api.ChatColor.RED + " [!] ��� ��� �����Դϴ�!";

			BaseComponent[] page = new ComponentBuilder(
					ChatColor.BLACK + p.getDisplayName() + ChatColor.GRAY + "���� ���� ����" + n + n + n + n + "         ["
							+ w + "/" + Bukkit.getOnlinePlayers().size() + "]" + n + n + n + local)
									.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/display " + p.getDisplayName()))
									.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
											new ComponentBuilder("�ش� ������ ������ �����մϴ�").create()))
									.create();

			// add the page to the meta
			bookMeta.spigot().addPage(page);
		}

		// set the title and author of this book
		bookMeta.setTitle(ChatColor.AQUA + "|| " + ChatColor.WHITE + "" + ChatColor.BOLD + "���� ��" + ChatColor.AQUA + " ||");
		bookMeta.setAuthor("SYSTEM(AUTO)");

		// update the ItemStack with this new meta
		book.setItemMeta(bookMeta);
		return book;

	}

	public static ItemStack profile() {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookMeta = (BookMeta) book.getItemMeta();
		String n = "\n";

		int w = 0;
		String local = "";
		// create a page
		for (Player p : Bukkit.getOnlinePlayers()) {
			w++;

			if (p.isOp())
				local = net.md_5.bungee.api.ChatColor.RED + " [!] OP �����Դϴ�!";
			if (voids.isAdmin(p) == true)
				local = local + n + net.md_5.bungee.api.ChatColor.RED + " [!] ��� ��� �����Դϴ�!";

			BaseComponent[] page = new ComponentBuilder(
					ChatColor.BLACK + p.getDisplayName() + ChatColor.GRAY + "���� ���� ����" + n + n + n + n + "         ["
							+ w + "/" + Bukkit.getOnlinePlayers().size() + "]" + n + n + n + local)
									.event(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://spigotmc.org"))
									.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
											new ComponentBuilder("�ش� ������ ������ �����մϴ�").create()))
									.create();

			// add the page to the metawprk 
			bookMeta.spigot().addPage(page);
		}

		// set the title and author of this book
		bookMeta.setTitle("Interactive Book");
		bookMeta.setAuthor("gigosaurus");

		// update the ItemStack with this new meta
		book.setItemMeta(bookMeta);
		return book;

	}

	public static ItemStack getExampleBook(Player p) {
		String a = ""; //comment local bin
		double health = p.getHealth();
		String y = String.valueOf(health);
		
		TextComponent on = new TextComponent(new ComponentBuilder("[Ȱ��ȭ] \n").color(net.md_5.bungee.api.ChatColor.AQUA).append("Ŭ���ؼ� ").color(net.md_5.bungee.api.ChatColor.GRAY).append("��Ȱ��ȭ").color(net.md_5.bungee.api.ChatColor.RED).append("�� �ٲ� �� �ֽ��ϴ�.").color(net.md_5.bungee.api.ChatColor.GRAY).create());
		TextComponent off = new TextComponent(new ComponentBuilder("[��Ȱ��ȭ] \n").color(net.md_5.bungee.api.ChatColor.RED).append("Ŭ���ؼ� ").color(net.md_5.bungee.api.ChatColor.GRAY).append("Ȱ��ȭ").color(net.md_5.bungee.api.ChatColor.AQUA).append("�� �ٲ� �� �ֽ��ϴ�.").color(net.md_5.bungee.api.ChatColor.GRAY).create());
		
		TextComponent move = (TextComponent) off.duplicate();
		TextComponent eat = (TextComponent) off.duplicate();
		TextComponent combat = (TextComponent) off.duplicate();
		TextComponent craft = (TextComponent) off.duplicate();
		TextComponent farm = (TextComponent) off.duplicate();
		TextComponent pixaxe = (TextComponent) off.duplicate();
		TextComponent chat = (TextComponent) off.duplicate();
		TextComponent mic = (TextComponent) off.duplicate();
		
		if(voids.chkhasperm(p, "PlayerMOVE") == true) move = (TextComponent) on.duplicate();
		if(voids.chkhasperm(p, "PlayerEAT") == true) eat = (TextComponent) on.duplicate();
		if(voids.chkhasperm(p, "PlayerCOMBAT") == true) combat = (TextComponent) on.duplicate();
		if(voids.chkhasperm(p, "PlayerCRAFT") == true) craft = (TextComponent) on.duplicate();
		if(voids.chkhasperm(p, "PlayerFARM") == true) farm = (TextComponent) on.duplicate();
		if(voids.chkhasperm(p, "PlayerPIXAXE") == true) pixaxe = (TextComponent) on.duplicate();
		if(voids.chkhasperm(p, "PlayerCHAT") == true) chat = (TextComponent) on.duplicate();
		if(voids.chkhasperm(p, "PlayerMIC") == true) mic = (TextComponent) on.duplicate();
		
		try {
			
			String n = "\n";
			String line = "-------------------";
			ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
			BookMeta meta = (BookMeta) book.getItemMeta();
			List<IChatBaseComponent> pages = (List<IChatBaseComponent>) CraftMetaBook.class.getDeclaredField("pages").get(meta);
			TextComponent hi = new TextComponent(
										new ComponentBuilder(p.getDisplayName() + "���� ���� ����" + n + line + n )
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(" �� ")
																	.color(net.md_5.bungee.api.ChatColor.RED)
																.append(new TextComponent(y + n))
																	.color(net.md_5.bungee.api.ChatColor.WHITE)
																.append(new TextComponent(" �� "))
																	.color(net.md_5.bungee.api.ChatColor.AQUA)
																.append(new TextComponent(String.valueOf(p.getLevel())))
																	.color(net.md_5.bungee.api.ChatColor.WHITE)
																			.create()))
										.append(new TextComponent("- �̵� ����[MOVE]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(move)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerMOVE")))
											
										.append(new TextComponent("- �Ļ� ����[EAT]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(eat)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerEAT")))
										.append(new TextComponent("- ���� ����[COMBAT]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(combat)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerCOMBAT")))
										.append(new TextComponent("- ���� ����[CRAFT]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(craft)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerCRAFT")))
										.append(new TextComponent("- ��� ����[FARM]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(farm)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerFARM")))
										.append(new TextComponent("- ��� ä�� ����[PIXAXE]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(pixaxe)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerPIXAXE")))
										.append(new TextComponent("- ä�� ����[CHAT]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(chat)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerCHAT")))
										.append(new TextComponent("- ����ũ ����[MIC]" + n))
											.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("")
																.append(mic)
																			.create()))
											.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, voids.kw(p, "PlayerMIC")))
										.append(n + line)
				.create()
			);
			
			
			IChatBaseComponent page = IChatBaseComponent.ChatSerializer.a(ComponentSerializer.toString(new BaseComponent[] { hi })); // This
			
			
			pages.add(page);
			meta.setTitle("Example");
			meta.setAuthor("Optics Server");
			book.setItemMeta(meta);
			return book;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
}
