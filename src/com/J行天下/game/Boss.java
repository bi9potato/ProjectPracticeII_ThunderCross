package com.J������.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Boss {
	//����
	int boss_x,boss_y;
	//��С
	int boss_width,boss_height;
	//����״̬
	boolean isLife;
	//����ֵ
	int health;
	//����
	GameStart gs;
	public Boss(int boss_x, int boss_y, int boss_width, int boss_height,
			boolean isLife, int health, GameStart gs) {
		super();
		this.boss_x = boss_x;
		this.boss_y = boss_y;
		this.boss_width = boss_width;
		this.boss_height = boss_height;
		this.isLife = isLife;
		this.health = health;
		this.gs = gs;
	}
	
	//����
	public  void fire(){
		for(int i=0;i<=360;i+=20){
			BossBullet bossbullet=new BossBullet(boss_x+30, boss_y+40, 20,20, true,gs,i);
			gs.bossBullet_list.add(bossbullet);
		}
	}
	
	//����
	public void drawBoss(Graphics g){
		//�ж�����״̬
		if(isLife==true&&this.health>0){
			g.drawImage(gs.boss_image, boss_x, boss_y, boss_width, boss_height, gs);
			bossMove();
			if(System.currentTimeMillis()%151==0){
				this.fire();
				gs.gso.playSound("./music/Boss_Fire.mp3",true);
			}
		}
	}
	
	//�ƶ�
	int left_right=1;
	public void bossMove(){
		if(boss_y>=0&&boss_y<120){
			boss_y += 1;
		}
		if(boss_y>=120){
			//�����ƶ�
			boss_x+=left_right;//����
			if(boss_x>=320){
				left_right--;//����
			}else if(boss_x<10){
				left_right++;
			}
		}
	}
	//��ȡ�л����
	public Rectangle getBossSize(){
		Rectangle rtg = new Rectangle(boss_x,boss_y,boss_width,boss_height);
		return rtg;
	}
	
	//BOSS���Ҿ��ɻ���ײ
	public void bossMpIntersects(){
		if(this.isLife&&gs.mp.isLife&&this.getBossSize().intersects(gs.mp.getMyPlaneSize())){
			gs.mp.mp_health-=1;
			this.health-=5;
			if(this.health<=0){
				this.isLife=false;
			}
			Boom boommp = new Boom(gs.mp.mp_x-15, gs.mp.mp_y-20,gs.mp.mp_width, gs.mp.mp_height, true, gs);
			gs.boom_list.add(boommp);
			gs.gso.playSound("./music/Enemy_Boom.mp3",true);
			if(gs.mp.mp_health<=0){
				gs.gso.playSound("./music/gameover.mp3",true);
				gs.mp.isLife=false;
				gs.flag++;
			}
			if(gs.mp.mp_health>10&&gs.mp.mp_health<=30){
				gs.gso.playSound("./music/Health_Low.mp3",true);
			}
		}
	}
}
