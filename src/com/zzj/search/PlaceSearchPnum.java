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

/*
 * 根据号码查询信息
 */
public class PlaceSearchPnum extends JFrame implements ActionListener{
	Container contentPane;
	Image icon;
	//框架的大小
	 Dimension faceSize=new Dimension(300, 100);
	 JLabel jLabel1=new JLabel();
	 JLabel jLabel2=new JLabel();
	 JTextField sFrom=new JTextField(4);
	 JTextField sTo=new JTextField(4);
	 JButton searchInfo=new JButton();
	 
	 public PlaceSearchPnum(){
		 //设置标题
		 this.setTitle("按号码查询");
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
		 
		 jLabel1.setText("请输入号码范围：从");
		 jLabel1.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(jLabel1);
		 
		 sFrom.setText(null);
		 sFrom.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(sFrom);
		 
		 jLabel2.setText("到");
		 jLabel2.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(jLabel2);
		 
		 sTo.setText(null);
		 sTo.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(sTo);
		 
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
			ResultPlace rs=new ResultPlace("pnum",sFrom.getText(),sTo.getText());
			this.dispose();
		}
	}
}
