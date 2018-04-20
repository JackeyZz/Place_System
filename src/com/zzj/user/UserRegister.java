package com.zzj.user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.zzj.db.PlaceBean;
import com.zzj.mainview.PlaceMain;

public class UserRegister extends UserInfo{
	String[] s=null;
	public UserRegister(){
		this.setTitle("��½�û���Ϣ");
		this.setResizable(false);
		
		usernum.setEditable(true);
		username.setEditable(true);
		password.setEditable(true);
		
		//��������ʱ���ڵ�λ��
		Dimension screenSize=
			Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2+45);
	}
	public void downInit(){
		sureInfo.setText("ע��");
		sureInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(sureInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(clearInfo);
		exitInfo.setText("�˳�");
		exitInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(exitInfo);
		
		this.contentPane.add(downPanel, BorderLayout.SOUTH);
		
		sureInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==sureInfo){
			PlaceBean register=new PlaceBean();
			register.userRegister(usernum.getText(),
					username.getText(), password.getText());
			this.dispose();
		}
		if(obj==clearInfo){
			setNull();
		}
		if(obj==exitInfo){
			this.dispose();
		}	
	}
}
