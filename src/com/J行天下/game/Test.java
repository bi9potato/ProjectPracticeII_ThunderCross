package com.J行天下.game;

public class Test {
	public static void main(String[] args) {
		MainFrame mf=new MainFrame("雷霆战机");
		if(GameStart.flag==2)
		{
			new Dialog(mf,1);
		}
	}
}
