package com.zzj.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zzj.mainview.PlaceMain;

public class UserInfo extends JFrame implements ActionListener{
	
	Container contentPane;
	JPanel upPanel=new JPanel();
	JPanel centerPanel=new JPanel();
	JPanel downPanel=new JPanel();
	ImageIcon background1;
	ImageIcon background2;
	
	Dimension faceSize=new Dimension(800,500);
	
	JLabel jLabel=new JLabel();
	
	JLabel jLabel0=new JLabel();
	JLabel jLabel1=new JLabel();
	JLabel jLabel2=new JLabel();
	JLabel jLabel3=new JLabel();
	JLabel jLabel4=new JLabel();
	
	JTextField usernum=new JTextField(50);
	JTextField username=new JTextField(50);
	JPasswordField password=new JPasswordField(50);
	
	JButton sureInfo=new JButton();
	JButton clearInfo=new JButton();
	JButton exitInfo=new JButton();
	JButton registerInfo=new JButton();
	
	GridBagLayout gridBag=new GridBagLayout();
	GridBagConstraints gridBagCon;
	
	public UserInfo(){
		//���ÿ�ܵĴ�С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("��½/ע��");
		//this.setResizable(false);
		
		try{
			Init();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void Init() throws Exception{
		contentPane=(JPanel) this.getContentPane();
		((JPanel) contentPane).setOpaque(false);
		contentPane.setLayout(new BorderLayout());
		
		//�ϲ����
		upPanel.setLayout(new BorderLayout());
		
		background1=new ImageIcon(UserInfo.this.
				getClass().getResource("2.jpg"));
		jLabel=new JLabel(background1);
		jLabel.setPreferredSize(new Dimension(500, 200));
		upPanel.add(jLabel,BorderLayout.NORTH);
		
		jLabel0.setText("��  ��  ��  ��  ��  ϵ  ͳ");
		jLabel0.setFont(new Font("Dialog",1,30));
		jLabel0.setForeground(Color.BLUE);
		jLabel0.setVerticalTextPosition(JLabel.CENTER);
		upPanel.add(jLabel0,BorderLayout.SOUTH);
		
		contentPane.add(upPanel, BorderLayout.NORTH);
		
		//�в����Ĳ���
		centerPanel.setLayout(gridBag);
		
		
		background2=new ImageIcon(UserInfo.this.
				getClass().getResource("5.png"));
		background2.setImage(background2.getImage()
				.getScaledInstance(150,150,Image.SCALE_DEFAULT));
		jLabel4=new JLabel(background2);
		//jLabel.setPreferredSize(new Dimension(50, 10));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=1;
		gridBagCon.gridheight=3;
		//gridBagCon.weighty=1;
		//gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel4, gridBagCon);
		centerPanel.add(jLabel4);
		
		jLabel1.setText("�� �� �� �ţ�");
		jLabel1.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=1;
		gridBagCon.gridheight=1;
		gridBagCon.gridx=1;
		gridBagCon.gridy=0;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel1, gridBagCon);
		centerPanel.add(jLabel1);
		
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=2;
		gridBagCon.gridheight=1;
		gridBagCon.gridx=2;
		gridBagCon.gridy=0;
		gridBagCon.insets=new Insets(10, 1, 10, 10);
		gridBag.setConstraints(usernum, gridBagCon);
		centerPanel.add(usernum);
		
		registerInfo.setText("ע���˺�");
		registerInfo.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		//gridBagCon.gridwidth=0;
		gridBagCon.gridy=0;
		gridBagCon.gridheight=1;
		gridBagCon.gridwidth=GridBagConstraints.REMAINDER;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(registerInfo, gridBagCon);
		centerPanel.add(registerInfo);
		
		jLabel2.setText("�� �� �� ����");
		jLabel2.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=1;
		gridBagCon.gridheight=1;
		gridBagCon.gridx=1;
		gridBagCon.gridy=1;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel2, gridBagCon);
		centerPanel.add(jLabel2);
		
		gridBagCon=new GridBagConstraints();
		//gridBagCon.gridheight=1;
		//gridBagCon.gridwidth=0;
		gridBagCon.gridx=2;
		gridBagCon.gridy=1;
		gridBagCon.insets=new Insets(10, 1, 10, 10);
		gridBag.setConstraints(username, gridBagCon);
		centerPanel.add(username);
		
		jLabel3.setText("��             �룺");
		jLabel3.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=1;
		gridBagCon.gridheight=1;
		gridBagCon.gridx=1;
		gridBagCon.gridy=2;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel3, gridBagCon);
		centerPanel.add(jLabel3);
		
		gridBagCon=new GridBagConstraints();
		//gridBagCon.gridheight=1;
		//gridBagCon.gridwidth=GridBagConstraints.REMAINDER;
		gridBagCon.gridx=2;
		gridBagCon.gridy=2;
		gridBagCon.insets=new Insets(10, 1, 10, 10);
		gridBag.setConstraints(password, gridBagCon);
		centerPanel.add(password);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		usernum.setEditable(false);
		username.setEditable(false);
		password.setEditable(false);
		
	}
	/*
	 * �²����Ĳ���
	 */
	public void downInit(){
		sureInfo.setText("��½");
		sureInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(sureInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(clearInfo);
		exitInfo.setText("�˳�");
		exitInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(exitInfo);
		
		//downPanel.setOpaque(false);
		contentPane.add(downPanel, BorderLayout.SOUTH);
		
		registerInfo.addActionListener(this);
		sureInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==sureInfo){
			
		}
		if(obj==clearInfo){
			setNull();
		}
		if(obj==exitInfo){
			this.dispose();
		}	
		if (obj==registerInfo) {
			
		}
	}
	/*
	 * ���ı������
	 */
	void setNull(){
		usernum.setText(null);
		username.setText(null);
		password.setText(null);
	}
}
