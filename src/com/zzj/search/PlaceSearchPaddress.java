package com.zzj.search;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlaceSearchPaddress extends JFrame implements ActionListener{
	Container contentPane;
	Image icon;
	//框架的大小
	 Dimension faceSize=new Dimension(300, 100);
	 JLabel jLabel=new JLabel();
	 JTextField paddress=new JTextField(30);
	 JButton searchInfo=new JButton();
	 
	 public PlaceSearchPaddress(){
		 //设置标题
		 this.setTitle("按楼盘地址查询");
		 this.setResizable(false);
		 //设置程序图标
		 this.setIconImage(getImage("icon.gif"));
		 
		 try {
			Init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 //设置运行位置
		Dimension screenSize=
				Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2+45);
	 }
	 
	 private void Init()throws Exception{
		 this.setSize(faceSize);
		 contentPane=this.getContentPane();
		 contentPane.setLayout(new FlowLayout());
		 
		 jLabel.setText("请输入楼盘地址名：");
		 jLabel.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(jLabel);
		 
		 paddress.setText(null);
		 paddress.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(paddress);
		  
		 searchInfo.setText("确定");
		 searchInfo.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(searchInfo);
		 
		 searchInfo.addActionListener(this);
	 }
	 Image getImage(String filename){
			
			return icon;
	}
	 
	 /*
	  * 事件处理
	  */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==searchInfo){
			ResultPlace rs=new ResultPlace(paddress.getText());
			this.dispose();
		}
	}
}
