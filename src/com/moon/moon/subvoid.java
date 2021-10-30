package com.moon.moon;

import java.util.Random;

import org.bukkit.ChatColor;

public class subvoid {
	public static String randWords() {
		Random rand = new Random();
		int a = rand.nextInt(10);//1부터 n까지
		String m;
		m = "";
		switch(a) {
			case(1):
				m="5252~ 권한 겟또다제--!";
				break;
			case(2):
				m="wwwwwwww 권한은 이제 내꺼라구!";
				break;
			case(3):
				m="아! 그거! 그렇게 하는거! 아닌데! ㅋㅋ ㅋㅋ";
				break;
			case(4):
				m="너의 권한은 내가 접수한다.";
				break;
			case(5):
				m="권한 잘 가져갈게요!";
				break;
			case(6):
				m="아싸! 개꿀!!!";
				break;
			case(7):
				m="히히 키키 죄송";
				break;
			case(8):
				m="권한삭제술. 발동. 처리한다.";
				break;
			case(9):
				m="YUMMY YUMMY!";
				break;
			case(10):
				m="아 겁나못해~~";
				break;
		}
		
		String aw = "  ";
		String fw = aw + ChatColor.YELLOW + m;
		
		return fw;
	}
}
