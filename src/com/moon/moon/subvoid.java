package com.moon.moon;

import java.util.Random;

import org.bukkit.ChatColor;

public class subvoid {
	public static String randWords() {
		Random rand = new Random();
		int a = rand.nextInt(10);//1���� n����
		String m;
		m = "";
		switch(a) {
			case(1):
				m="5252~ ���� �ٶǴ���--!";
				break;
			case(2):
				m="wwwwwwww ������ ���� ������!";
				break;
			case(3):
				m="��! �װ�! �׷��� �ϴ°�! �ƴѵ�! ���� ����";
				break;
			case(4):
				m="���� ������ ���� �����Ѵ�.";
				break;
			case(5):
				m="���� �� �������Կ�!";
				break;
			case(6):
				m="�ƽ�! ����!!!";
				break;
			case(7):
				m="���� ŰŰ �˼�";
				break;
			case(8):
				m="���ѻ�����. �ߵ�. ó���Ѵ�.";
				break;
			case(9):
				m="YUMMY YUMMY!";
				break;
			case(10):
				m="�� �̳�����~~";
				break;
		}
		
		String aw = "  ";
		String fw = aw + ChatColor.YELLOW + m;
		
		return fw;
	}
}
