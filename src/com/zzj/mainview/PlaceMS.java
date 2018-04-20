package com.zzj.mainview;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

import com.zzj.user.UserLogin;


/*
 * 房地产管理系统运行主类
 */
public class PlaceMS {
	boolean packFrame=false;
	/*
	 * 构造函数
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
		
		//设置运行时窗口的位置
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
		//设置运行风格
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		new PlaceMS();
	}
}
