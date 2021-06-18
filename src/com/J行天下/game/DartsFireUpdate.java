package com.J������.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class DartsFireUpdate {
	//����
	int dbup_x,dbup_y;
	//��С
	int dbup_width,dbup_height;
	//����״̬
	boolean isLife;
	//����
	GameStart gs;
	public DartsFireUpdate(int dbup_x, int dbup_y, int dbup_width,
			int dbup_height, boolean isLife, GameStart gs) {
		super();
		this.dbup_x = dbup_x;
		this.dbup_y = dbup_y;
		this.dbup_width = dbup_width;
		this.dbup_height = dbup_height;
		this.isLife = isLife;
		this.gs = gs;
	}
	//������������������
	public void drawDartsFireUpdate(Graphics g) {
		if(isLife==true){
			g.drawImage(gs.dartsfireupdate_image, dbup_x, dbup_y, dbup_width,dbup_height, gs);
			dartsFireUpdateMove();
		}
	}
	
	//���������������ƶ�
	public void dartsFireUpdateMove(){
		dbup_y += 5;
		if(dbup_y>600){
			isLife=false;
		}
	}
	
	//��ȡ�����������������
	public Rectangle getDartsFireUpdateSize(){
		Rectangle rtg = new Rectangle(dbup_x,dbup_y,dbup_width,dbup_height);
		return rtg;
	}
	
	//�����������������Ҿ��ɻ���ײ(�ཻ)
	public void dbUpMpIntersects(){
		if(this.isLife&&gs.mp.isLife&&this.getDartsFireUpdateSize().intersects(gs.mp.getMyPlaneSize())){
			this.isLife=false;
			this.gs.mp.dartsfire_num+=50;
			this.gs.mp.doublefire_num=0;
			gs.gso.playSound("./music/GetItem.mp3",true);
		}
	}
}
