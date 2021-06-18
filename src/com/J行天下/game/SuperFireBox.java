package com.J������.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class SuperFireBox {
	/***����***/
	//����
	int sfb_x,sfb_y;
	//��С
	int sfb_width,sfb_height;
	//����״̬
	boolean isLife;
	//����
	GameStart gs;
	public SuperFireBox(int sfa_x, int sfa_y, int sfa_width, int sfa_height,
			boolean isLife, GameStart gs) {
		super();
		this.sfb_x = sfa_x;
		this.sfb_y = sfa_y;
		this.sfb_width = sfa_width;
		this.sfb_height = sfa_height;
		this.isLife = isLife;
		this.gs = gs;
	}
	//��������������
	public void drawSpFireBox(Graphics g) {
		if(isLife==true){
			g.drawImage(gs.superfirebox_image, sfb_x, sfb_y, sfb_width,sfb_height, gs);
			spFireBoxMove();
		}
	}
	
	//�����������ƶ�
	public void spFireBoxMove(){
		sfb_y += 4;
		if(sfb_y>600){
			isLife=false;
		}
	}
	
	//�������������
	public Rectangle getSpFireBoxSize(){
		Rectangle rtg = new Rectangle(sfb_x,sfb_y,sfb_width,sfb_height);
		return rtg;
	}
	
	//�������������Ҿ��ɻ���ײ(�ཻ)
	public void sfbMpIntersects(){
		if(this.isLife&&gs.mp.isLife&&this.getSpFireBoxSize().intersects(gs.mp.getMyPlaneSize())){
			this.isLife=false;
			gs.gso.playSound("./music/GetItem.mp3",true);
			this.gs.mp.superfire_num++;
		}
	}
	
}
