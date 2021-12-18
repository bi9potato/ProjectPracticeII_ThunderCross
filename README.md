# ProjectPracticeII_ThunderCross
# 一、项目实践的目的和要求
>## （1）本次项目实践具体目的如下：
>>1.	了解Java的应用领域的作用，能够配置和搭建Java平台的开发环境；
>>2.	了解Java项目开发的基本过程；
>>3.	能够运用Java面向过程的方法进行程序开发；
>>4.	能够运用面向对象的方法进行程序开发；
>>5.	掌握Java界面开发技术，能够运用哪个Java常用组件编写具有图形化界面的程序；
>>6.	掌握Java的时间处理机制，能够实现正确响应和处理用户的操作和输入；
>>7.	掌握建立和访问数据库的方法；
>>8.	掌握Java项目的运行调试方法；
>## （2）本次实训要求如下：
>>1.	认真阅读、理解培训老师的任务要求，理解任务目的与要求，要个按照实训内容完成实训项目；
>>2.	实训着重培养学生自主发现问题、思考问题、解决问题的能力，实训过程前期培训教师教授基础制作程序所需的基础知识，后期以学生自主学习为主，教师主要以大一解惑方式提供指导。
>>3.	为培养学生团队合作精神，参加实训学生以6~8人为单位组成实训小组，协同完成实训任务；
>>4.	实训学生应注意培养自己的独立发现问题、查找资料和解决问题的能力，以独立完成本人负责模块为主，小组成员讨论为辅的方式进行团队合作；
>>5.	实训报告是实训过程的重压组成部分，学生均应独立完成本人实训报告，报告内容应真实、严谨，报告结构应合理、紧凑，报告格式应规范、完整。






# 二、总体设计方案
游戏有24个类，分别是：背景类，爆炸类，boss类，boss子弹类，子弹类，大招类，药类，大招盒类，子弹升级类，飞镖子弹类，飞镖子弹升级类，登录界面类，方向类，我的飞机类、敌机子弹类，敌方小飞机类，敌方战斗机类，获取声音类，游戏开始类，主窗体类，用户类，登录类，注册类，运行（测试）类。
首先构建前端，以及各游戏窗体类，对象类（飞机，掉落物品，子弹），和gameover之后的结算类。其次各组在各自的框架上进行扩充，登录界面扩充注册、登录、设置（更换飞机贴图）按钮，游戏窗体界面扩充暂停，返回和重开按钮，各个对象设计移动规则和各自移动逻辑，结算界面扩充分数登记判定并显示。

# 三、软件流程图

主界面：							      
 <img src="https://github.com/bi9potato/ProjectPracticeII_ThunderCross/blob/main/ScreenShoot/%E4%B8%BB%E7%95%8C%E9%9D%A2.png?raw=true" width="400" height="720" />

注册界面：  

 <img src="https://github.com/bi9potato/ProjectPracticeII_ThunderCross/blob/main/ScreenShoot/%E4%B8%BB%E7%95%8C%E9%9D%A2.png?raw=true" width="400" height="720" />

设置界面：  

 <img src="https://github.com/bi9potato/ProjectPracticeII_ThunderCross/blob/main/ScreenShoot/%E8%AE%BE%E7%BD%AE%E7%95%8C%E9%9D%A2.png?raw=true" width="800" height="400" />

登录成功弹窗：  

 <img src="https://github.com/bi9potato/ProjectPracticeII_ThunderCross/blob/main/ScreenShoot/%E7%99%BB%E5%BD%95%E6%88%90%E5%8A%9F%E5%BC%B9%E7%AA%97.png?raw=true" width="400" height="720" />

进入游戏界面：  

 <img src="https://github.com/bi9potato/ProjectPracticeII_ThunderCross/blob/main/ScreenShoot/%E8%BF%9B%E5%85%A5%E6%B8%B8%E6%88%8F%E7%95%8C%E9%9D%A2.png?raw=true" width="400" height="720" />

游戏界面：  

 <img src="https://github.com/bi9potato/ProjectPracticeII_ThunderCross/blob/main/ScreenShoot/%E6%B8%B8%E6%88%8F%E7%95%8C%E9%9D%A2.png?raw=true" width="400" height="720" />
 
结算界面：  

 <img src="https://github.com/bi9potato/ProjectPracticeII_ThunderCross/blob/main/ScreenShoot/%E7%BB%93%E7%AE%97%E7%95%8C%E9%9D%A2.png?raw=true" width="400" height="720" />


# 四、程序及程序段功能分析
我负责的是本机、战斗机，小飞机类，子弹类，音乐播放类，游戏机制设计。  

音乐播放类：
功能：  

函数可循环播放一首歌，若读取下一首歌，会停止上一首歌的线程。Boolean参数控制是否允许播放：  
```Java
public void playSound(String mp3, Boolean isRuning)
```
函数将音乐播放一遍就结束。Boolean参数控制是否允许播放：  
```Java
public void playSound(String mp3, Boolean isRuning)
```

源码：  
```Java
public class GameSound {
	BgSoundThread bst = null;
	// 播放背景音乐的代码
	@SuppressWarnings("deprecation")
	public void playBgSound(String mp3, Boolean isRuning) {
		if (isRuning) {
			// 1. 首先需要将原来的背景音乐停止
			if (bst != null) {
				bst.stop();
			}
			bst = new BgSoundThread(mp3);
			bst.start();
		} else {
			if (bst != null) {
				bst.stop();
			}
		}
	}
	// 使用多线程来播放爆炸和发射子弹的声音
	public void playSound(String mp3, Boolean isRuning) {
		if (isRuning) {
			SoundThread st = new SoundThread(mp3);
			st.start();
		} else {
			if (bst != null) {
				bst.stop();
			}
		}
	}
	// 循环播放背景声音
	class BgSoundThread extends Thread {
		public String mp3Url;
		public BgSoundThread(String mp3Url) {
			this.mp3Url = mp3Url;
		}
		public void run() {
			for (;;) {
				// 测试声音的播放
				// 1. 加载MP3文件
				InputStream in = GameSound.class.getClassLoader().getResourceAsStream(mp3Url);
				// 2. 根据文件流，创建播放类的对象
				AdvancedPlayer ad;
				try {
					ad = new AdvancedPlayer(in);
					// 3. 播放
					ad.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// 只播放一次
	class SoundThread extends Thread {

		public String mp3Url;

		public SoundThread(String mp3Url) {
			this.mp3Url = mp3Url;
		}

		public void run() {
			// 测试声音的播放
			// 1. 加载MP3文件
			InputStream in = GameSound.class.getClassLoader().getResourceAsStream(mp3Url);

			// 2. 根据文件流，创建播放类的对象
			AdvancedPlayer ad;
			try {
				ad = new AdvancedPlayer(in);
				// 3. 播放
				ad.play();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}
}
```  

我的飞机类：  
功能：通过键盘WASD与SPACE案件控制飞机移动  
函数控制单发子弹开火: public void fire()  
函数控制双发子弹开火: public void doublefire()；  
函数控制三发飞镖子弹开火: public void dartsfire()；  
函数控制大招发动: public void superfire()；  
函数控制本机移动: public void mpMove()；  
绘制飞机: public void drawMyPlane(Graphics g)；  
函数构造飞机: public MyPlane(int mp_x, int mp_y, int mp_width, int mp_height,
int mp_health,int doublefire_num,int dartsfire_num,int superfire_num,
boolean isLife, GameStart gs)；

源码：  
```java
package com.J行天下.game;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
  
//我军飞机的类
public class MyPlane {
	
	protected static int planeID=1;
	/***属性***/
	//坐标
	int mp_x,mp_y;
	//大小
	int mp_width,mp_height;
	//生命值
	int mp_health;
	//双发子弹数量
	int doublefire_num;
	//飞镖子弹数量
	int dartsfire_num;
	//超级武器数量
	int superfire_num;
	//生命状态
	boolean isLife;
	//窗体
	GameStart gs;
	
	//定义方向：初始方向为停止
	Direction dir = Direction.STOP;
	//对键盘按键的判断
	boolean isUp,isDown,isLeft,isRight;
	
	/***方法***/
	//开火
	public void fire(){
		Bullet bl = new Bullet(mp_x+35, mp_y-40, 15, 25, true, gs);
		gs.bl_list.add(bl);
	}
	//发射两发子弹
	public void doublefire(){
		Bullet bl_left = new Bullet(mp_x+10, mp_y-40, 15, 25, true, gs);
		Bullet bl_right = new Bullet(mp_x+60, mp_y-40, 15, 25, true, gs);
		gs.bl_list.add(bl_left);
		gs.bl_list.add(bl_right);
	}
	//发射三发特殊子弹
	public void dartsfire(){
		DartsBullet dbl_left = new DartsBullet(mp_x-15, mp_y-40, 25, 25, true, gs);
		DartsBullet dbl_right = new DartsBullet(mp_x+70, mp_y-40, 25, 25, true, gs);
		DartsBullet dbl_middle = new DartsBullet(mp_x+30, mp_y-40, 25, 25, true, gs);
		gs.dbl_list.add(dbl_left);
		gs.dbl_list.add(dbl_right);
		gs.dbl_list.add(dbl_middle);
	}
	//超级武器发射
		public void superfire(){
			SuperFire spf = new SuperFire(0,500, 400, 50, true, gs);
			gs.spf_list.add(spf);
		}
	//移动
	public void mpMove(){
		//得到飞机的移动方向
		getDirection();
		//根据方向来移动飞机
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
		
		//让飞机不要超出边界
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
	//绘制
	public void drawMyPlane(Graphics g){
		//判断生命状态
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
	
	//按下键盘
	public void keyPressed(KeyEvent e){
		//得到键的值
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
	//松开键盘
	public void keyReleased(KeyEvent e){
		//得到键的值
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
	//根据这个按键的状态来确定飞机移动的方向
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
	/***构造函数***/
	public MyPlane(int mp_x, int mp_y, int mp_width, int mp_height,
int mp_health,int doublefire_num,int dartsfire_num,int superfire_num,
boolean isLife, GameStart gs) {
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
	//获取飞机二维模型
	public Rectangle getMyPlaneSize(){
		Rectangle rtg = new Rectangle(mp_x,mp_y,mp_width,mp_height);
		return rtg;
	}
}
```

普通子弹类：  
功能：  
函数构造子弹：public Bullet(int bl_x, int bl_y, int bl_width, int bl_height, boolean isLife, GameStart gs)；  
函数绘制子弹：public void drawBullet(Graphics g)；  
函数控制子弹移动：public void bulletMove()；  
函数获取子弹模型：public Rectangle getBulletSize()；  
函数判断所有子弹是否与敌方小飞机相撞：public void buEpIntersects(List<EnemyPlane> list)；  
函数判断所有子弹是否与敌方战机相撞：public void buEcpIntersects(List<EnemyCombatPlane> list)；  
函数判断所有子弹是否与Boss相撞：public void buBossIntersects(List<Boss> list)；  

源码：  
```java
package com.J行天下.game;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Bullet {
	/*** 属性 ***/
	// 坐标
	int bl_x, bl_y;
	// 大小
	int bl_width, bl_height;
	// 生命状态
	boolean isLife;
	// 窗体
	GameStart gs;

	public Bullet(int bl_x, int bl_y, int bl_width, int bl_height, boolean isLife, GameStart gs) {
		super();
		this.bl_x = bl_x;
		this.bl_y = bl_y;
		this.bl_width = bl_width;
		this.bl_height = bl_height;
		this.isLife = isLife;
		this.gs = gs;
	}

	public void drawBullet(Graphics g) {
		if (isLife == true) {
			g.drawImage(gs.bullet_image, bl_x, bl_y, bl_width, bl_height, gs);
			bulletMove();
		}
	}

	public void bulletMove() {
		bl_y -= 5;
		if (bl_y < 0) {
			isLife = false;
		}
	}

	// 获取子弹模型
	public Rectangle getBulletSize() {
		Rectangle rtg = new Rectangle(bl_x, bl_y, bl_width, bl_height);
		return rtg;
	}

	// 子弹与敌机碰撞(相交)
	public void buEpIntersects(List<EnemyPlane> list) {
		for (int i = 0; i < list.size(); i++) {
			EnemyPlane ep = list.get(i);
			if (this.isLife && ep.isLife && this.getBulletSize().intersects
(ep.getEnemyPlaneSize())) {
				gs.ep.lifeCount--;
				if (gs.ep.lifeCount == 0) {
					ep.isLife = false;
				}
				this.isLife = false;
				Boom boom = new Boom(ep.ep_x - 30, ep.ep_y - 20, ep.ep_width, ep.ep_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3", true);
				gs.score += 20;
			}
		}
	}

	// 子弹与敌人战机碰撞(相交)
	public void buEcpIntersects(List<EnemyCombatPlane> list) {
		for (int i = 0; i < list.size(); i++) {
			EnemyCombatPlane ept = list.get(i);
			if (this.isLife && ept.isLife && this.getBulletSize().intersects(ept.getEnemyPlaneTSize())) {
				this.isLife = false;
				ept.isLife = false;
				Boom boom = new Boom(ept.ecp_x - 30, ept.ecp_y - 20, ept.ecp_width, ept.ecp_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3", true);
				gs.score += 40;
			}
		}
	}

	// 子弹与BOSS碰撞
	public void buBossIntersects(List<Boss> list) {
		for (int i = 0; i < list.size(); i++) {
			Boss boss = list.get(i);
			if (this.isLife && boss.isLife && this.getBulletSize().intersects(boss.getBossSize())) {
				this.isLife = false;
				boss.health -= 5;
				if (gs.boss.health <= 0) {
					boss.health = 0;
					gs.boss.isLife = false;
					gs.score += 300;
				}
				Boom boom = new Boom(boss.boss_x - 30, boss.boss_y - 20, boss.boss_width, boss.boss_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3", true);
			}
		}
	}
}
```
	
飞镖子弹类：  
功能：  

函数构造飞镖子弹：public DartsBullet(int dbl_x, int dbl_y, int dbl_width, int dbl_height,
			boolean isLife, GameStart gs)  
函数绘制飞镖子弹：public void drawBullet(Graphics g)  
函数控制子弹移动：public void dartsbulletMove()  
函数获取子弹模型：public Rectangle getDartsBulletSize()  
函数判断所有子弹是否与敌方小飞机相撞：public Rectangle getDartsBulletSize()  
函数判断所有子弹是否与敌方战机相撞：public void dbuEpIntersects(List<EnemyPlane> list)  
函数判断所有子弹是否与敌方战机相撞：public void dbuEcpIntersects(List<EnemyCombatPlane> list)  
函数判断所有子弹是否与Boss相撞：public void dbuBossIntersects(List<Boss> list)  
```java
package com.J行天下.game;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class DartsBullet {
	/***属性***/
	//坐标
	int dbl_x,dbl_y;
	//大小
	int dbl_width,dbl_height;
	//生命状态
	boolean isLife;
	//窗体
	GameStart gs;
	public DartsBullet(int dbl_x, int dbl_y, int dbl_width, int dbl_height,
			boolean isLife, GameStart gs) {
		super();
		this.dbl_x = dbl_x;
		this.dbl_y = dbl_y;
		this.dbl_width = dbl_width;
		this.dbl_height = dbl_height;
		this.isLife = isLife;
		this.gs = gs;
	}
	//绘制
	public void drawBullet(Graphics g) {
		if(isLife==true){
			g.drawImage(gs.darts_image, dbl_x, dbl_y, dbl_width,dbl_height, gs);
			dartsbulletMove();
		}
	}
	//移动
	public void dartsbulletMove(){
		dbl_y -= 5;
		if(dbl_y<0){
			isLife=false;
		}
	}
	//获取大小
	public Rectangle getDartsBulletSize(){
		Rectangle rtg = new Rectangle(dbl_x,dbl_y,dbl_width,dbl_height);
		return rtg;
	}
	//与敌机的碰撞检测
	public void dbuEpIntersects(List<EnemyPlane> list){
		for (int i = 0; i < list.size(); i++) {
			EnemyPlane ep = list.get(i);
			if(this.isLife&&ep.isLife&&this.getDartsBulletSize().intersects(ep.getEnemyPlaneSize())){
				ep.isLife=false;
				Boom boom = new Boom(ep.ep_x-30, ep.ep_y-20, ep.ep_width, ep.ep_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3",true);
				gs.score+=20;
			}
			
		}
	}
	//与敌人战机的碰撞检测
	public void dbuEcpIntersects(List<EnemyCombatPlane> list){
		for (int i = 0; i < list.size(); i++) {
			EnemyCombatPlane ept = list.get(i);
			if(this.isLife&&ept.isLife&&this.getDartsBulletSize().intersects(ept.getEnemyPlaneTSize())){
				ept.isLife=false;
				Boom boom = new Boom(ept.ecp_x-30, ept.ecp_y-20, ept.ecp_width, ept.ecp_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3",true);
				gs.score+=40;
			}
			
		}
	}
	//与BOSS的碰撞检测
	public void dbuBossIntersects(List<Boss> list){
		for (int i = 0; i < list.size(); i++) {
			Boss boss = list.get(i);
			if(this.isLife&&boss.isLife&&this.getDartsBulletSize().intersects(boss.getBossSize())){
				boss.health-=1;
				if(gs.boss.health<=0){
					boss.health=0;
					gs.boss.isLife=false;
					gs.score+=300;
				}
				Boom boom = new Boom(boss.boss_x-30, boss.boss_y-20, boss.boss_width, boss.boss_height, true, gs);
				gs.boom_list.add(boom);
				gs.gso.playSound("./music/Enemy_Boom.mp3",true);
			}
		}
	}
}
```
	
# 五、总结  
## 1. 项目总结：  
>实训培养了我的综合运用所学知识,发现,提出,分析和解决实际问题,锻炼实践能力的重要环节,是对学生实际工作能力的具体训练和考察过程.。
>这次课程设计终于顺利完成了,在设计中遇到了很多编程问题,最后在组员的齐心协力与互相帮助下,终于迎刃而解。在此我表示感谢!同时,对给过我帮劣的所有同学和各位指导老师再次表示忠心的感谢! 
## 2. 心得体会：  
>回想起实训,至今我仍感慨颇多,的确,在这两周的日子里,可以说得是苦多于甜,但是可以学到很多很多的东西,同时不仅可以巩固了以前所学过的知识,比如类的继承，线程的构造与运行逻辑，如何在JPannel>上绘制图片，图片碰撞检测等，更深刻的理解JAVA中封装特性与“一切皆对象”的含义，学到了很多在书本上所没有学到过的知识。通过这次课程设计使我懂得了理论不实际相结合是很重要的,只有理论知识是远远不够的,只有把所学的理论知识不实践相结合起来,从理论中得出结论,从而提高自己的实际劢手能力和独立思考的能力，例如在处理界面切换并且切换音乐的问题上，我想到模仿在操作系统中学到的“锁”的原理，即在不同页面做上flag=0，切换页面后当前页面的flag置1并判断页面的标志是否为1，为1则播放bgm，且将其他页面的flag清零。后来发现bgm播放函数在无限循环，只要一次进入当前页面flag就会置1后，判断为1就会重启这个音乐，故音乐只会循环播放当前的sleep空挡中的几秒。将flag=1改为flag++就可解决此问题。  
此外我还参与了小飞机和战斗机的移动逻辑制作，我一开始设计小飞机移动前会判断与我的飞机横向距离是否相等，相等就撞过来，后来发现没有意义，因为正常飞机为不被集中或是为了吃到掉落物品不得不保持一直移动，就算与小飞机横坐标相等也只能保持一瞬间，甚至小于paint的刷新频率，因此小飞机几乎不会向前冲，后将小飞机移动前会判断与我的飞机横向距离的绝对值是否小于25，小于25就会向我方飞机冲过来撞击我们，但也发现小飞机被打一下就死，冲过来没有意义，于是增加小飞机血量参数，血量为2，发现游戏难度极大提升。战斗机的移动逻辑是会检测我们的位置，并向我们的位置移动，直至与我们横向坐标相等，这样条件有点苛刻，日后可能会优化成移动到我们位置的左右的随机位置。

