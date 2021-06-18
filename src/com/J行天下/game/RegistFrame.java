package com.J行天下.game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistFrame extends JFrame implements ActionListener{
	JLabel userLabel;// 用户姓名
	JLabel pwdLabel;// 用户密码
	JTextField userText;// 用户名文本输入框
	JPasswordField pwdText;// 密码输入框
	JButton registBtn, cancelBtn;// 注册,取消按钮
	String username;// 文本输入框内容
	String userpwd;// 密码框内容
	public RegistFrame() {
		//设置用户名，密码属性
		userLabel = new JLabel("用户名:");
		userLabel.setBounds(100, 160, 150, 30);
		this.add(userLabel);

		pwdLabel = new JLabel("密   码:");
		pwdLabel.setBounds(100, 210, 150, 30);
		this.add(pwdLabel);

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
				
		registBtn = new JButton("注册");
		registBtn.setBounds(100, 265, 55, 30);
		// 设置按钮前景颜色
		registBtn.setForeground(Color.BLUE);
		// 设置按钮边框颜色
		registBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		registBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username = userText.getText();
				// 获取密码
				char[] chPWD = pwdText.getPassword();
				userpwd = new String(chPWD);
				
				User u = new User(username, userpwd);
				if (username.length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "用户名不能为空");
				}  
				else if (userpwd.length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "密码不能为空");
				}  
				else if (new Operator().insert(u)) 
				{
					JOptionPane.showMessageDialog(null, "注册成功");
					new MainFrame("飞机大战");// 创建生成主界面
					dispose();// 关闭当前界面
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "该用户名已被注册");
				}
			}
		});
					
		this.add(registBtn);
		
		cancelBtn = new JButton("取消");
		cancelBtn.setBounds(225, 265, 55, 30);
		cancelBtn.setForeground(Color.blue);
		cancelBtn.setBorder(BorderFactory.createLineBorder(Color.blue));
		/**添加取消按钮事件监听**/
		cancelBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame("飞机大战");// 创建生成主界面
				dispose();// 关闭当前界面
			}
		});
		this.add(cancelBtn);
		//窗口设置
				this.setLayout(null);
				this.setSize(400, 600); // 设置大小
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 默认关闭操作
				this.setLocationRelativeTo(null); // 设置窗体初始位置
				this.setVisible(true); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

