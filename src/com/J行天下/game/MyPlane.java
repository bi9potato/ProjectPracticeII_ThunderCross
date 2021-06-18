package com.J������.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

//�Ҿ��ɻ�����
public class MyPlane {
	
	protected static int planeID=1;
	/***����***/
	//����
	int mp_x,mp_y;
	//��С
	int mp_width,mp_height;
	//����ֵ
	int mp_health;
	//˫���ӵ�����
	int doublefire_num;
	//�����ӵ�����
	int dartsfire_num;
	//������������
	int superfire_num;
	//����״̬
	boolean isLife;
	//����
	GameStart gs;
	
	//���巽�򣺳�ʼ����Ϊֹͣ
	Direction dir = Direction.STOP;
	//�Լ��̰������ж�
	boolean isUp,isDown,isLeft,isRight;
	
	
	
	/***����***/
	//����
	public void fire(){
		Bullet bl = new Bullet(mp_x+35, mp_y-40, 15, 25, true, gs);
		gs.bl_list.add(bl);
	}
	//���������ӵ�
	public void doublefire(){
		Bullet bl_left = new Bullet(mp_x+10, mp_y-40, 15, 25, true, gs);
		Bullet bl_right = new Bullet(mp_x+60, mp_y-40, 15, 25, true, gs);
		gs.bl_list.add(bl_left);
		gs.bl_list.add(bl_right);
	}
	//�������������ӵ�
	public void dartsfire(){
		DartsBullet dbl_left = new DartsBullet(mp_x-15, mp_y-40, 25, 25, true, gs);
		DartsBullet dbl_right = new DartsBullet(mp_x+70, mp_y-40, 25, 25, true, gs);
		DartsBullet dbl_middle = new DartsBullet(mp_x+30, mp_y-40, 25, 25, true, gs);
		gs.dbl_list.add(dbl_left);
		gs.dbl_list.add(dbl_right);
		gs.dbl_list.add(dbl_middle);
	}
	//������������
		public void superfire(){
			SuperFire spf = new SuperFire(0,500, 400, 50, true, gs);
			gs.spf_list.add(spf);
		}
	//�ƶ�
	public void mpMove(){
		//�õ��ɻ����ƶ�����
		getDirection();
		//���ݷ������ƶ��ɻ�
		if(dir == Direction.UP){
				mp_y -= 5;
		}else if(dir == Direction.DOWN){
				mp_y+= 5;
		}else if(dir == Direction.LEFT){
				mp_x-= 5;
		}else if(dir == Direction.RIGHT){
				mp_x+= 5;
		}else if(dir == Direction.Left_UP){
				mp_x -= 5;
				mp_y -= 5;
		}else if(dir == Direction.Left_Down){
				mp_x -= 5;
				mp_y += 5;
		}else if(dir == Direction.Right_UP){
				mp_x += 5;
				mp_y -= 5;
		}else if(dir == Direction.Right_Down){
				mp_x += 5;
				mp_y += 5;
		}
		
		//�÷ɻ���Ҫ�����߽�
		if(mp_y >= 530){
			mp_y = 530;
		}
		if(mp_x >= 355){
			mp_x = 355;
		}
		if(mp_y <= 25){
			mp_y = 25;
		}
		if(mp_x <= -35){
			mp_x = -35;
		}
	}
	
	//int bulletcount=0;
	//����
	public void drawMyPlane(Graphics g){
		//�ж�����״̬
		if(isLife){
			g.drawImage(gs.plane_image, mp_x, mp_y, mp_width, mp_height, gs);
			mpMove();
			if(System.currentTimeMillis()-gs.bullet_time>=200){
				if(doublefire_num>0){
					gs.bullet_image=gs.doublebullet_image;
					doublefire();
					gs.gso.playSound("./music/DoubleBullet.mp3",true);
					gs.bullet_time = System.currentTimeMillis();
					doublefire_num--;
				}else if(dartsfire_num>0){
					dartsfire();
					gs.gso.playSound("./music/DartsFire.mp3",true);
					gs.bullet_time = System.currentTimeMillis();
					dartsfire_num--;
				}else{
					gs.bullet_image=gs.bullet_image_tmp;
					fire();
					gs.gso.playSound("./music/Bullet.mp3",true);
					gs.bullet_time = System.currentTimeMillis();
				}
			}
		}
	}
	
	//���¼���
	public void keyPressed(KeyEvent e){
		//�õ�����ֵ
		int num = e.getKeyCode();
		if(num == KeyEvent.VK_W){
			isUp = true;
		}else if(num == KeyEvent.VK_S){
			isDown = true;
		}else if(num == KeyEvent.VK_A){
			isLeft = true;
		}else if(num == KeyEvent.VK_D){
			isRight = true;
		}
		else if(num == KeyEvent.VK_P){
			if(gs.isrunning==true)
			{
				gs.isrunning=false;
			}
			else if(gs.isrunning==false)
			{
				gs.isrunning=true;
                gs.createthread();
			}
		}
		else if(gs.flag==0 && num == KeyEvent.VK_ENTER){
			gs.setSize(400,600);
			gs.flag++;
		}else if(gs.flag==2 && num == KeyEvent.VK_ESCAPE){
			
			gs.flag=0;
			gs.score=0;
			gs.mp.isLife=true;
			gs.mp.mp_health=100;
		}else if(gs.flag==1 && num == KeyEvent.VK_SPACE){
			if(superfire_num>0){
				superfire();
				gs.gso.playSound("./music/SuperFire.mp3",true);
				superfire_num--;
			}
		}
	}
	//�ɿ�����
	public void keyReleased(KeyEvent e){
		//�õ�����ֵ
		int num = e.getKeyCode();
		if(num == KeyEvent.VK_W){
			isUp = false;
		}else if(num == KeyEvent.VK_S){
			isDown = false;
		}else if(num == KeyEvent.VK_A){
			isLeft = false;
		}else if(num == KeyEvent.VK_D){
			isRight = false;
		}
	}
	//�������������״̬��ȷ���ɻ��ƶ��ķ���
	public void getDirection(){
		if(isUp && !isDown && !isLeft && !isRight){
			dir = Direction.UP;
		}else if(!isUp && isDown && !isLeft && !isRight){
			dir = Direction.DOWN;
		}else if(!isUp && !isDown && isLeft && !isRight){
			dir = Direction.LEFT;
		}else if(!isUp && !isDown && !isLeft && isRight){
			dir = Direction.RIGHT;
		}else if(isUp && !isDown && isLeft && !isRight){
			dir = Direction.Left_UP;
		}else if(!isUp && isDown && isLeft && !isRight){
			dir = Direction.Left_Down;
		}else if(isUp && !isDown && !isLeft && isRight){
			dir = Direction.Right_UP;
		}else if(!isUp && isDown && !isLeft && isRight){
			dir = Direction.Right_Down;
		}else if(!isUp && !isDown && !isLeft && !isRight){
			dir = Direction.STOP;
		}
	}
	
	/***���캯��***/
	public MyPlane(int mp_x, int mp_y, int mp_width, int mp_height,
			int mp_health,int doublefire_num,int dartsfire_num,int superfire_num,boolean isLife, GameStart gs) {
		super();
		this.mp_x = mp_x;
		this.mp_y = mp_y;
		this.mp_width = mp_width;
		this.mp_height = mp_height;
		this.mp_health = mp_health;
		this.doublefire_num = doublefire_num;
		this.dartsfire_num = dartsfire_num;
		this.superfire_num = superfire_num;
		this.isLife = isLife;
		this.gs = gs;
	}
	
	//��ȡ�ɻ����
	public Rectangle getMyPlaneSize(){
		Rectangle rtg = new Rectangle(mp_x,mp_y,mp_width,mp_height);
		return rtg;
	}
	
}
