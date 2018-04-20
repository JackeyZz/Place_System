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

public class PlaceSearchPhouse extends JFrame implements ActionListener{
	Container contentPane;
	Image icon;
	//��ܵĴ�С
	 Dimension faceSize=new Dimension(300, 100);
	 JLabel jLabel=new JLabel();
	 JTextField phouse=new JTextField(30);
	 JButton searchInfo=new JButton();
	 
	 public PlaceSearchPhouse(){
		 //���ñ���
		 this.setTitle("��¥������ѯ");
		 this.setResizable(false);
		 //���ó���ͼ��
		 this.setIconImage(getImage("icon.gif"));
		 
		 try {
			Init();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 //��������λ��
		Dimension screenSize=
				Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2+45);
	 }
	 
	 private void Init()throws Exception{
		 this.setSize(faceSize);
		 contentPane=this.getContentPane();
		 contentPane.setLayout(new FlowLayout());
		 
		 jLabel.setText("������¥������");
		 jLabel.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(jLabel);
		 
		 phouse.setText(null);
		 phouse.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(phouse);
		  
		 searchInfo.setText("ȷ��");
		 searchInfo.setFont(new Font("Dialog", 0, 12));
		 contentPane.add(searchInfo);
		 
		 searchInfo.addActionListener(this);
	 }
	 Image getImage(String filename){
			
			return icon;
	}
	 
	 /*
	  * �¼�����
	  */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==searchInfo){
			ResultPlace rs=new ResultPlace("phouse",phouse.getText());
			this.dispose();
		}
	}
}
