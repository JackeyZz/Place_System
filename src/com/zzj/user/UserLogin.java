package com.zzj.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.zzj.db.PlaceBean;
import com.zzj.mainview.PlaceMain;
import com.zzj.mainview.PlaceMain1;

public class UserLogin extends UserInfo{
	String[] s=null;
	public UserLogin(){
		this.setTitle("登陆用户信息");
		this.setResizable(false);
		
		usernum.setEditable(true);
		username.setEditable(true);
		password.setEditable(true);
		
		//设置运行时窗口的位置
		Dimension screenSize=
			Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2+45);
	}
	public void downInit(){
		sureInfo.setText("登陆");
		sureInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(sureInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(clearInfo);
		exitInfo.setText("退出");
		exitInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(exitInfo);
		
		this.contentPane.add(downPanel, BorderLayout.SOUTH);
		
		registerInfo.addActionListener(this);
		sureInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==sureInfo){
			PlaceBean login=new PlaceBean();
			//PlaceMain1 placeMain=new PlaceMain1();
			s=login.UserSearch(usernum.getText());
			if(s[0].equals(username.getText())
					&&s[1].equals(password.getText())){
				JOptionPane.showMessageDialog(null, "成功登陆系统！");
				//placeMain.setIs(true);
				//System.out.println(placeMain.isIs());
				//设置运行风格
				try{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}catch(Exception err){
					err.printStackTrace();
				}
				new PlaceMain1(username.getText());
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "登陆失败！");
				setNull();
				//placeMain.setIs(false);
			}
		}
		if(obj==clearInfo){
			setNull();
		}
		if(obj==exitInfo){
			this.dispose();
		}
		if (obj==registerInfo) {
			UserRegister asi=new UserRegister();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);
		}
	}
}
