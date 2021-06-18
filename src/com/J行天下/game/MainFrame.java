package com.J行天下.game;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javazoom.jl.player.advanced.jlap;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainFrame extends JFrame implements MouseListener,KeyListener{
	GameSound gso = new GameSound();
	Toolkit tk=Toolkit.getDefaultToolkit();
	Image bg=tk.getImage("/images/background1.jpg");
	JPanel pan;
	JLabel userLabel;// 用户姓名
	JLabel pwdLabel;// 用户密码
	JTextField userText;
	JPasswordField pwdText;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	JButton jb5;
	JButton jb6;
	JButton jb7;
	static String username;
	String userpwd;
	GameStart gs;
	int num;
	JLabel back;
	public MainFrame(String title) {
		//pan=new MainPanel();
		//showBackground();
		this.setLayout(null);
		gso.playBgSound("./music/background_music.mp3",true);
		//this.setBackground(Color.BLUE);
		//this.add(pan);
		jb1=new JButton("登录并开始");
		jb2=new JButton("设置");
		jb3=new JButton("注册");
		jb4=new JButton("退出");
		jb1.addMouseListener(this);
		jb1.setBounds(110, 300, 180, 80);
		Font f=new Font("隶书",Font.BOLD,27);
		jb1.setFont(f);
		this.add(jb1);
		jb2.addMouseListener(this);
		jb2.setBounds(110, 500, 180, 80);
		jb2.setFont(f);
		this.add(jb2);
		jb3.addMouseListener(this);
		jb3.setBounds(110, 400, 180, 80);
		jb3.setFont(f);
		this.add(jb3);
		jb4.setBounds(50, 700, 300, 40);
		jb4.addMouseListener(this);
		jb4.setFont(f);
		jb4.setVisible(false);
		this.add(jb4);
		userLabel = new JLabel("用户名:");
		userLabel.setBounds(80, 160, 150, 30);
		Font f1 = new Font("黑体",Font.BOLD,20);
		userLabel.setFont(f1);
		this.add(userLabel);
		
		pwdLabel = new JLabel("密码:");
		pwdLabel.setBounds(100, 210, 150, 30);
		pwdLabel.setFont(f1);
		this.add(pwdLabel);
		
		
		jb5=new JButton("暂停");
		jb5.setBounds(10, 620, 100, 50);
		jb5.setFont(f1);
	    add(jb5);
	    //暂停开始按钮监听
	    jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gs.stop_start();//暂停开始方法

			}
		});
		jb6=new JButton("重开");
		jb6.setBounds(150, 620, 100, 50);
		jb6.setFont(f1);
		add(jb6);
		//重新开始
	    jb6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gs.flag=1;
				gs.score=0;
				gs.mp.isLife=true;
				gs.mp.mp_health=100;
				gs.isrunning=true;
				gs.getKeyListeners();
			}
		});
		jb7=new JButton("返回");
		jb7.setBounds(280, 620, 100, 50);
		jb7.setFont(f1);
		add(jb7);
	    jb7.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					gs.flag=0;
					gs.score=0;
					gs.mp.isLife=true;
					gs.mp.mp_health=100;
					gs.isrunning=true;
				}
			});
	    
		// 添加用户名输入框
		userText = new JTextField(10);
		userText.setBounds(160, 165, 120, 25);
		// 获取鼠标焦点
		userText.setFocusable(true);
		// 设置输入框边界凹陷效果
		userText.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(userText);

		// 添加密码输入框
		pwdText = new JPasswordField();
		pwdText.setBounds(160, 215, 120, 25);
		pwdText.setFocusable(true);
		// 设置输入框边界凹陷效果
		pwdText.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(pwdText);
		
		this.setTitle(title);
		this.setSize(400,720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				gs.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				gs.keyReleased(e);
			}
			
		});
		BackImg back = new BackImg();
		back.setBounds(0, 0, 400, 680);
		this.add(back);
	}
	class BackImg extends JPanel{
		Image background;
		public BackImg(){
			try {
				background = ImageIO.read(new File("C:\\Users\\50563\\Desktop\\ThunderCross\\src\\images\\Background.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(background, 0, 0,400,700,null);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		this.setFocusable(true);
		if(e.getSource() == jb4)
		{
			if(gs.flag==2) {
				new Dialog(this, 1);
			}
			userLabel.setVisible(true);
			pwdLabel.setVisible(true);
			userText.setVisible(true);
			pwdText.setVisible(true);
			jb1.setVisible(true);
			jb2.setVisible(true);
			jb3.setVisible(true);
			gs.flag=0;
			this.setFocusable(true);
			this.remove(gs);
			this.setSize(400, 720);
			repaint();
		}
		if(e.getSource()==jb1)
		{
			username = userText.getText();
			char[] chPWD = pwdText.getPassword();
			userpwd = new String(chPWD);
			if (username.length() == 0) {
				JOptionPane.showMessageDialog(null, "用户名不能为空");
			} else if(userpwd.length() == 0) {
				JOptionPane.showMessageDialog(null, "密码不能为空");
			} else if(new Operator().query(new User(username,userpwd))){
				JOptionPane.showMessageDialog(null, "登录成功");
				gs = new GameStart(jb5,jb6,jb7,gso);
				this.add(gs);
				userLabel.setVisible(false);
				pwdLabel.setVisible(false);
				userText.setVisible(false);
				pwdText.setVisible(false);
				jb1.setVisible(false);
				jb2.setVisible(false);
				jb3.setVisible(false);
				jb4.setVisible(true);
				this.setSize(400, 780);
				//this.setVisible(false);
				//dispose();// 关闭当前界面				
				} else {
					JOptionPane.showMessageDialog(null, "用户名或者密码错误");
			} 
			
		}
		if(e.getSource()==jb2)
		{
			new Dialog(this, 0);
		}
		if(e.getSource()==jb3)
		{
			new RegistFrame();
			dispose();
		}

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
