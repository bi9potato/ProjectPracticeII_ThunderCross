package com.J������.game;

import java.awt.Graphics;

//����
public class Background {
	//����
	int bg_x,bg_y;
	int bg_y_b;
	//��С
	int bg_width,bg_height;
	//����
	GameStart gs;
	//���캯��
	public Background(int bg_x, int bg_y, int bg_width, int bg_height, GameStart gs) {
		super();
		this.bg_x = bg_x;
		this.bg_y = bg_y;
		this.bg_width = bg_width;
		this.bg_height = bg_height;
		this.gs = gs;
		this.bg_y_b = bg_y -bg_height;
	}
	//����
	public void drawBackground(Graphics g){
		g.drawImage(gs.background_image, bg_x, bg_y, bg_width, bg_height, gs);
		g.drawImage(gs.background_image, bg_x, bg_y_b, bg_width, bg_height, gs);
		//���������Ƴ�������������ƶ�
		bgMove();
	}
	//�ƶ�
	public void bgMove(){
		bg_y+=2;
		bg_y_b +=2;
		
		//������ѭ��
		if(bg_y >= bg_height){ //˵����һ�ű����Ѿ������߽�
			bg_y = bg_y_b - bg_height;
		}
		if(bg_y_b >= bg_height){ //�ڶ��ű����Ѿ������߽�
			bg_y_b = bg_y - bg_height;
		}
	}
}
