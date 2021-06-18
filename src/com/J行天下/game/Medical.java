package com.J������.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Medical {
	/***����***/
	//����
	int md_x,md_y;
	//��С
	int md_width,md_height;
	//����״̬
	boolean isLife;
	//����
	GameStart gs;
	public Medical(int md_x, int md_y, int md_width, int md_height,
			boolean isLife, GameStart gs) {
		super();
		this.md_x = md_x;
		this.md_y = md_y;
		this.md_width = md_width;
		this.md_height = md_height;
		this.isLife = isLife;
		this.gs = gs;
	}
	//ҽ�ư�����
	public void drawMedical(Graphics g) {
		if(isLife==true){
			g.drawImage(gs.medical_image, md_x, md_y, md_width,md_height, gs);
			medicalMove();
		}
	}
	
	//ҽ�ư��ƶ�
	public void medicalMove(){
		md_y += 4;
		if(md_y>600){
			isLife=false;
		}
	}
	
	//��ȡҽ�ư����
	public Rectangle getMedicalSize(){
		Rectangle rtg = new Rectangle(md_x,md_y,md_width,md_height);
		return rtg;
	}
	
	//ҽ�ư����Ҿ��ɻ���ײ(�ཻ)
	public void mdMpIntersects(){
		if(this.isLife&&gs.mp.isLife&&this.getMedicalSize().intersects(gs.mp.getMyPlaneSize())){
			this.isLife=false;
			this.gs.mp.mp_health+=30;
			gs.gso.playSound("./music/GetItem.mp3",true);
			if(gs.mp.mp_health>=100){
				gs.mp.mp_health=100;
			}
		}
	}
}
