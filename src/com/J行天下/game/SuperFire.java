package com.J������.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class SuperFire {
	/***����***/
	//����
	int sf_x,sf_y;
	//��С
	int sf_width,sf_height;
	//����״̬
	boolean isLife;
	//����
	GameStart gs;
	public SuperFire(int sf_x, int sf_y, int sf_width, int sf_height,
			boolean isLife, GameStart gs) {
		super();
		this.sf_x = sf_x;
		this.sf_y = sf_y;
		this.sf_width = sf_width;
		this.sf_height = sf_height;
		this.isLife = isLife;
		this.gs = gs;
	}
	
	//����
	public void drawSuperFire(Graphics g){
		if(isLife==true){
			g.drawImage(gs.superfire_image, sf_x, sf_y, sf_width,sf_height, gs);
			superFireMove();
		}
	}
	
	//�ƶ�
	public void superFireMove(){
		sf_y -= 6;
		if(sf_y<0){
			isLife=false;
		}
	}
	
	//��ȡ���
	public Rectangle getSuperFireSize(){
		Rectangle rtg = new Rectangle(sf_x,sf_y,sf_width,sf_height);
		return rtg;
	}
	
	//��л��ཻ
	public void subuEpIntersects(List<EnemyPlane> list){
		for (int i = 0; i < list.size(); i++) {
			EnemyPlane ep = list.get(i);
			if(this.isLife&&ep.isLife&&this.getSuperFireSize().intersects(ep.getEnemyPlaneSize())){
				ep.isLife=false;
				Boom boom = new Boom(ep.ep_x-30, ep.ep_y-20, ep.ep_width, ep.ep_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3",true);
				gs.score+=20;
			}
		}
	}
	
	//�����ս���ཻ
	public void subuEcpIntersects(List<EnemyCombatPlane> list){
		for (int i = 0; i < list.size(); i++) {
			EnemyCombatPlane ept = list.get(i);
			if(this.isLife&&ept.isLife&&this.getSuperFireSize().intersects(ept.getEnemyPlaneTSize())){
				ept.isLife=false;
				Boom boom = new Boom(ept.ecp_x-30, ept.ecp_y-20, ept.ecp_width, ept.ecp_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3",true);
				gs.score+=40;
			}
		}
	}
	//�����ս���ӵ��ཻ
	public void subuEbuIntersects(List<EnemyBullet> list){
		for (int i = 0; i < list.size(); i++) {
			EnemyBullet ebu = list.get(i);
			if(this.isLife&&ebu.isLife&&this.getSuperFireSize().intersects(ebu.getEnBulletSize())){
				ebu.isLife=false;
				gs.score+=5;
			}
		}
	}
	//��BOSS��ײ
	public void subuBossIntersects(List<Boss> list){
		for (int i = 0; i < list.size(); i++) {
			Boss boss = list.get(i);
			if(this.isLife==true&&boss.isLife==true&&this.getSuperFireSize().intersects(boss.getBossSize())){
				gs.boss.health-=2;
				if(gs.boss.health<=0){
					gs.boss.isLife=false;
					gs.score+=300;
				}
			}
		}
	}
	//��BOSS�ӵ���ײ
		public void subuBossBuIntersects(List<BossBullet> list){
			for (int i = 0; i < list.size(); i++) {
				BossBullet bossbu = list.get(i);
				if(this.isLife&&bossbu.isLife&&this.getSuperFireSize().intersects(bossbu.getBossBulletSize())){
					bossbu.isLife=false;
					gs.score+=5;
				}
			}
		}
}
