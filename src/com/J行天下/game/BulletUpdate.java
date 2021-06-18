package com.J������.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class BulletUpdate {
	//����
	int buup_x,buup_y;
	//��С
	int buup_width,buup_height;
	//����״̬
	boolean isLife;
	//����
	GameStart gs;
	
	public BulletUpdate(int buup_x, int buup_y, int buup_width,
			int buup_height, boolean isLife, GameStart gs) {
		super();
		this.buup_x = buup_x;
		this.buup_y = buup_y;
		this.buup_width = buup_width;
		this.buup_height = buup_height;
		this.isLife = isLife;
		this.gs = gs;
	}
	
	//��������������
	public void drawBulletUpdate(Graphics g) {
		if(isLife==true){
			g.drawImage(gs.bulletupdate_image, buup_x, buup_y, buup_width,buup_height, gs);
			bulletUpdateMove();
		}
	}
	
	//�����������ƶ�
	public void bulletUpdateMove(){
		buup_y += 4;
		if(buup_y>600){
			isLife=false;
		}
	}
	
	//��ȡ�������������
	public Rectangle getBulletUpdateSize(){
		Rectangle rtg = new Rectangle(buup_x,buup_y,buup_width,buup_height);
		return rtg;
	}
	
	//�������������Ҿ��ɻ���ײ(�ཻ)
	public void bulletUpMpIntersects(){
		if(this.isLife&&gs.mp.isLife&&this.getBulletUpdateSize().intersects(gs.mp.getMyPlaneSize())){
			this.isLife=false;
			this.gs.mp.doublefire_num+=100;
			this.gs.mp.dartsfire_num=0;
			gs.gso.playSound("./music/GetItem.mp3",true);
		}
	}
}
