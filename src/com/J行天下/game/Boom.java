package com.J������.game;

import java.awt.Graphics;
import java.awt.Image;


public class Boom {
	/***����***/
	//����
	int boom_x,boom_y;
	//��С
	int boom_width,boom_height;
	//����״̬
	boolean isLife;
	//����
	GameStart gs;
	public Boom(int boom_x, int boom_y, int boom_width, int boom_height,
			boolean isLife, GameStart gs) {
		super();
		this.boom_x = boom_x;
		this.boom_y = boom_y;
		this.boom_width = boom_width*3;
		this.boom_height = boom_height*3;
		this.isLife = isLife;
		this.gs = gs;
	}
	//ͼƬ�����±�
	int index=0;
	String[] img_names={"bomb_enemy_0.png","bomb_enemy_1.png","bomb_enemy_2.png","bomb_enemy_3.png",
			"bomb_enemy_4.png","bomb_enemy_5.png",};
	public void drawBoom(Graphics g){
		//��ȡ������ͼƬ��
		String img_index=img_names[index];
		//��ȡͼƬ����
		Image boom_image=gs.tk.getImage(Boom.class
				.getResource("/images/Explosion/"+img_index));
		//����ͼƬ
		g.drawImage(boom_image, boom_x, boom_y, null);
		index++;
		if(index>=img_names.length){
			isLife=false;
		}
	}
	
}
