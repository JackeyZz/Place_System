package com.zzj.manage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.zzj.db.PlaceBean;

public class EditPlaceInfo extends PlaceInfo{
	String sNum_str="";
	public EditPlaceInfo(){
		this.setTitle("修改楼房信息");
		this.setResizable(false);
		
		Phouse.setEditable(false);
		Ppeople.setEditable(false);
		Paddress.setEditable(false);
		PimagePath.setEditable(false);
		
		//设置运行时窗口的位置
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2+45);
	}
	public void downInit(){
		searchInfo.setText("号码查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		exitInfo.setText("退出");
		exitInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(exitInfo);
		
		searchInfo.setEnabled(true);
		fileInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		exitInfo.setEnabled(true);
		
		//添加事件监听
		fileInfo.addActionListener(this);
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		this.contentPane.add(downPanel, BorderLayout.SOUTH);
	}
	/*
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		String[] s=new String[8];
		
		if(obj==exitInfo){
			//退出
			this.dispose();
		}
		else if(obj==modifyInfo){
			//修改
			PlaceBean modifyPlace=new PlaceBean();
			modifyPlace.PlaceModify(sNum_str, Phouse.getText(), Ppeople.getText(), 
					Paddress.getText(), PimagePath.getText());
	
			Phouse.setText("");
			Ppeople.setText("");
			Paddress.setText("");
			PimagePath.setText("");
		}
		else if(obj==clearInfo){
			//清空
			setNull();
		}
		else if(obj==searchInfo){
			//学号查询
			PlaceInfoSearchPnum siss=new PlaceInfoSearchPnum(this);
			siss.pack();
			siss.setVisible(true);
			try {
				sNum_str=siss.getPnum();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "没有查找到该学号！");
			}
			
			PlaceBean searchPlace=new PlaceBean();
			s=searchPlace.PlaceSearch(sNum_str);
			if(s==null){
				JOptionPane.showMessageDialog(null, "记录不存在！");
	
				Phouse.setText("");
				Ppeople.setText("");
				Paddress.setText("");
				PimagePath.setText("");
				
				Phouse.setEditable(false);
				Ppeople.setEditable(false);
				Paddress.setEditable(false);
				PimagePath.setEditable(false);
				modifyInfo.setEnabled(false);
				return;
			}
			else{
				Phouse.setText(s[0]);
				Ppeople.setText(s[1]);
				Paddress.setText(s[2]);
				PimagePath.setText(s[3]);
				
				Phouse.setEditable(true);
				Ppeople.setEditable(true);
				Paddress.setEditable(true);
				PimagePath.setEditable(true);
				modifyInfo.setEnabled(true);
				fileInfo.setEnabled(true);
			}
		}
		else if(obj==fileInfo){
			ImageRead imageRead=new ImageRead();
			String imagepath=imageRead.ImageRead();
			PimagePath.setText(imagepath);
		}
	}
}
