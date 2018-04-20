package com.zzj.mainview;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.UIManager;

public class PlaceMain1 {
	
	public PlaceMain1(String name){
		boolean packFrame=false;
		PlaceMain frame1=new PlaceMain(name);
		if(packFrame){
			frame1.pack();
		}
		else{
			frame1.validate();
		}
		
		//设置运行时窗口的位置
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=frame1.getSize();
		
		if(frameSize.height>screenSize.height){
			frameSize.height=screenSize.height;
		}
		if(frameSize.width>screenSize.width){
			frameSize.width=screenSize.width;
		}
		frame1.setLocation((screenSize.width-frameSize.width)/2,
				(screenSize.height-frameSize.height)/2);
		frame1.setVisible(true);
	}
}
