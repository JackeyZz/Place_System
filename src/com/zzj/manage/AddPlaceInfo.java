package com.zzj.manage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import com.zzj.db.PlaceBean;

public class AddPlaceInfo extends PlaceInfo{
	
	public AddPlaceInfo(){
		this.setTitle("添加楼房信息");
		this.setResizable(false);
		
		Phouse.setEditable(true);
		Ppeople.setEditable(true);
		Paddress.setEditable(true);
		PimagePath.setEditable(true);
		fileInfo.setEnabled(true);
		
		//设置运行时窗口的位置
		Dimension screenSize=
			Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2+45);
	}
	public void downInit(){
		addInfo.setText("增加");
		addInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(addInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(clearInfo);
		exitInfo.setText("退出");
		exitInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(exitInfo);
		
		this.contentPane.add(downPanel, BorderLayout.SOUTH);
		
		fileInfo.addActionListener(this);
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==addInfo){
			Phouse.setEditable(false);
			Ppeople.setEditable(false);
			Paddress.setEditable(false);
			PimagePath.setEditable(false);
			
			addInfo.setFocusable(false);
			clearInfo.setFocusable(false);
			exitInfo.setFocusable(false);
			
			PlaceBean addPlace=new PlaceBean();
			addPlace.placeAdd(Phouse.getText(), Ppeople.getText(),
					Paddress.getText(), PimagePath.getText());
			
			this.dispose();
			AddPlaceInfo asi=new AddPlaceInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);
		}
		if(obj==clearInfo){
			setNull();
		}
		if(obj==exitInfo){
			this.dispose();
		}
		if(obj==fileInfo){
			ImageRead imageRead=new ImageRead();
			String imagepath=imageRead.ImageRead();
			PimagePath.setText(imagepath);
		}
	}
}
