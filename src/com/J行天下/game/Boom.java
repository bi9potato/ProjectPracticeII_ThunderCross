package com.J行天下.game;

import java.awt.Graphics;
import java.awt.Image;


public class Boom {
	/***属性***/
	//坐标
	int boom_x,boom_y;
	//大小
	int boom_width,boom_height;
	//生命状态
	boolean isLife;
	//窗体
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
	//图片数组下标
	int index=0;
	String[] img_names={"bomb_enemy_0.png","bomb_enemy_1.png","bomb_enemy_2.png","bomb_enemy_3.png",
			"bomb_enemy_4.png","bomb_enemy_5.png",};
	public void drawBoom(Graphics g){
		//获取数组中图片名
		String img_index=img_names[index];
		//获取图片对象
		Image boom_image=gs.tk.getImage(Boom.class
				.getResource("/images/Explosion/"+img_index));
		//绘制图片
		g.drawImage(boom_image, boom_x, boom_y, null);
		index++;
		if(index>=img_names.length){
			isLife=false;
		}
	}
	
}
