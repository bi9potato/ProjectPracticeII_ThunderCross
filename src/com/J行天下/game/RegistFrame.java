package com.J������.game;
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
	JLabel userLabel;// �û�����
	JLabel pwdLabel;// �û�����
	JTextField userText;// �û����ı������
	JPasswordField pwdText;// ���������
	JButton registBtn, cancelBtn;// ע��,ȡ����ť
	String username;// �ı����������
	String userpwd;// ���������
	public RegistFrame() {
		//�����û�������������
		userLabel = new JLabel("�û���:");
		userLabel.setBounds(100, 160, 150, 30);
		this.add(userLabel);

		pwdLabel = new JLabel("��   ��:");
		pwdLabel.setBounds(100, 210, 150, 30);
		this.add(pwdLabel);

		// ����û��������
		userText = new JTextField(10);
		userText.setBounds(160, 165, 120, 25);
		// ��ȡ��꽹��
		userText.setFocusable(true);
		// ���������߽簼��Ч��
		userText.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(userText);

		// ������������
		pwdText = new JPasswordField();
		pwdText.setBounds(160, 215, 120, 25);
		pwdText.setFocusable(true);
		// ���������߽簼��Ч��
		pwdText.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(pwdText);
				
		registBtn = new JButton("ע��");
		registBtn.setBounds(100, 265, 55, 30);
		// ���ð�ťǰ����ɫ
		registBtn.setForeground(Color.BLUE);
		// ���ð�ť�߿���ɫ
		registBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		registBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				username = userText.getText();
				// ��ȡ����
				char[] chPWD = pwdText.getPassword();
				userpwd = new String(chPWD);
				
				User u = new User(username, userpwd);
				if (username.length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				}  
				else if (userpwd.length() == 0) 
				{
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
				}  
				else if (new Operator().insert(u)) 
				{
					JOptionPane.showMessageDialog(null, "ע��ɹ�");
					new MainFrame("�ɻ���ս");// ��������������
					dispose();// �رյ�ǰ����
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "���û����ѱ�ע��");
				}
			}
		});
					
		this.add(registBtn);
		
		cancelBtn = new JButton("ȡ��");
		cancelBtn.setBounds(225, 265, 55, 30);
		cancelBtn.setForeground(Color.blue);
		cancelBtn.setBorder(BorderFactory.createLineBorder(Color.blue));
		/**���ȡ����ť�¼�����**/
		cancelBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame("�ɻ���ս");// ��������������
				dispose();// �رյ�ǰ����
			}
		});
		this.add(cancelBtn);
		//��������
				this.setLayout(null);
				this.setSize(400, 600); // ���ô�С
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ĭ�Ϲرղ���
				this.setLocationRelativeTo(null); // ���ô����ʼλ��
				this.setVisible(true); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

