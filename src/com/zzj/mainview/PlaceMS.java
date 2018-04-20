package com.zzj.mainview;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

import com.zzj.user.UserLogin;


/*
 * ���ز�����ϵͳ��������
 */
public class PlaceMS {
	boolean packFrame=false;
	/*
	 * ���캯��
	 */
	public PlaceMS(){
		
		//PlaceMain frame1=new PlaceMain();
		UserLogin user=new UserLogin();
		if(packFrame){
			user.pack();
		}
		else{
			user.validate();
			user.downInit();
		}
		
		//��������ʱ���ڵ�λ��
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=user.getSize();
		
		if(frameSize.height>screenSize.height){
			frameSize.height=screenSize.height;
		}
		if(frameSize.width>screenSize.width){
			frameSize.width=screenSize.width;
		}
		user.setLocation((screenSize.width-frameSize.width)/2,
				(screenSize.height-frameSize.height)/2);
		user.setVisible(true);
	}
	
	public static void main(String[] args) {
		//�������з��
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		new PlaceMS();
	}
}
