package com.J行天下.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class Dialog extends JDialog{
	
	private JLabel jl01, jl02, jima01, jima02, jima03, jima04, jima05;
	private JRadioButton jr01, jr02, jr03, jr04, jr05;
	JButton queren;
	public Dialog(JFrame j, int i) {
		super(j, true);
		this.setLayout(null);
		setResizable(false);//设置对话框不可拉
		if(i == 1)
			showFail(j);//显示挑战失败
		else
			showSetting(j);//显示设置对话框
		setVisible(true);//设置对话框可见

	}
	private void showSetting(JFrame j) {
		setTitle("设置");
		setBounds(j.getBounds().x, j.getBounds().y+100, 800, 400);//设置对话框位置以及大小
		jl01 = new JLabel("选择战机皮肤");
		jl01.setFont(new Font("acefont-family", Font.BOLD, 15));
		jl01.setBounds(10, 10, 80, 20);
		add(jl01);
		
		ImageIcon i01 = new ImageIcon(getClass().getResource("/images/Plane01.png"));
		int w01 = i01.getIconWidth(), h01 = i01.getIconHeight();
		jr01 = new JRadioButton("1");
		jr01.setBounds(10, 40, 40, 20);
		add(jr01);
		if(MyPlane.planeID == 1)
			jr01.setSelected(true);
		jr01.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPlane.planeID = 1;
			}
		});
		
		ImageIcon i02 = new ImageIcon(getClass().getResource("/images/Plane02.png"));
		int w02 = i02.getIconWidth(), h02 = i02.getIconHeight();
		jr02 = new JRadioButton("2");
		jr02.setBounds(40+w01, 40, 40, 20);
		add(jr02);
		if(MyPlane.planeID == 2)
			jr02.setSelected(true);
		jr02.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPlane.planeID = 2;
			}
		});
		
		ImageIcon i03 = new ImageIcon(getClass().getResource("/images/Plane03.png"));
		int w03 = i03.getIconWidth(), h03 = i03.getIconHeight();
		jr03 = new JRadioButton("3");
		jr03.setBounds(70+w01+w02, 40, 40, 20);
		add(jr03);
		if(MyPlane.planeID == 3)
			jr03.setSelected(true);
		jr03.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPlane.planeID = 3;
			}
		});
		
		ImageIcon i04 = new ImageIcon(getClass().getResource("/images/Plane04.png"));
		int w04 = i04.getIconWidth(), h04 = i04.getIconHeight();
		jr04 = new JRadioButton("4");
		jr04.setBounds(100+w01+w02+w03, 40, 40, 20);
		add(jr04);
		if(MyPlane.planeID == 4)
			jr04.setSelected(true);
		jr04.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPlane.planeID = 4;
			}
		});
		
		ImageIcon i05 = new ImageIcon(getClass().getResource("/images/Plane05.png"));
		int w05 = i05.getIconWidth(), h05 = i05.getIconHeight();
		jr05 = new JRadioButton("5");
		jr05.setBounds(130+w01+w02+w03+w04, 40, 40, 20);
		add(jr05);
		if(MyPlane.planeID == 5)
			jr05.setSelected(true);
		jr05.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPlane.planeID = 5;
			}
		});
		//图片标签
				jima01 = new JLabel(i01);
				jima01.setBounds(10, 60, w01, h01);
				add(jima01);
						
				jima02 = new JLabel(i02);
				jima02.setBounds(40+w01, 60, w02, h02);
				add(jima02);
						
				jima03 = new JLabel(i03);
				jima03.setBounds(70+w01+w02, 60, w03, h03);
				add(jima03);
				
				jima04 = new JLabel(i04);
				jima04.setBounds(100+w01+w02+w03, 60, w04, h04);
				add(jima04);		
				
				jima05 = new JLabel(i05);
				jima05.setBounds(130+w01+w02+w03+w04, 60, w05, h05);
				add(jima05);
				
				//将按钮加进按钮组�?
				ButtonGroup bg = new ButtonGroup();
				bg.add(jr01);
				bg.add(jr02);
				bg.add(jr03);
				bg.add(jr04);
				bg.add(jr05);
	}
	
	private void showFail(JFrame j) {
		setTitle("提示");
		setBounds(j.getBounds().x+150, j.getBounds().y+150, 500, 300);//设置对话框位置大小
		//设置标签
		jl01 = new JLabel("挑战失败！！");
		jl01.setFont(new Font("acefont-family", Font.BOLD, 50));
		jl01.setForeground(Color.BLACK);//设置前景颜色
		jl01.setBounds(65, 40, 400, 50);
		add(jl01);
		
		jl02 = new JLabel("分数" + GameStart.score);
		jl02.setFont(new Font("acefont-family", Font.BOLD, 30));
		jl02.setForeground(Color.BLUE);//设置前景颜色
		jl02.setBounds(65, 120, 400, 50);
		add(jl02);
		String context1,context2;
		String order;
		User u = new User(MainFrame.username,GameStart.score);
		if(GameStart.score>new Operator().selectScore(MainFrame.username))
			new Operator().updateScore(u.getName(),GameStart.score);
		context1 = String.format("%8s%20s\n", "用户名","分数");
		order = new Operator().queryOrderScore();
		context2 = String.format("\n\n%15s%5d\n", "你的分数是：",GameStart.score);
		
		JOptionPane.showMessageDialog(null, context1 + order + context2, "排行榜", 1);
	}
}
