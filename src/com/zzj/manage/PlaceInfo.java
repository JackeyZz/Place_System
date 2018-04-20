package com.zzj.manage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlaceInfo extends JFrame implements ActionListener{
	Container contentPane;
	JPanel centerPanel=new JPanel();
	JPanel upPanel=new JPanel();
	JPanel downPanel=new JPanel();
	
	//��ܵĴ�С
	Dimension faceSize=new Dimension(800, 500);
	
	JLabel jLabel1=new JLabel();
	JLabel jLabel2=new JLabel();
	JLabel jLabel3=new JLabel();
	JLabel jLabel4=new JLabel();
	
	JTextField Phouse=new JTextField(50);
	JTextField Ppeople=new JTextField(50);
	JTextField Paddress=new JTextField(50);
	JTextField PimagePath=new JTextField(50);
	
	JButton addInfo=new JButton();
	JButton clearInfo=new JButton();
	JButton exitInfo=new JButton();
	JButton searchInfo=new JButton();
	JButton modifyInfo=new JButton();
	JButton deleteInfo=new JButton();
	JButton fileInfo=new JButton();
	
	GridBagLayout gridBag=new GridBagLayout();
	GridBagConstraints gridBagCon;
	
	public PlaceInfo(){
		//���ÿ�ܵĴ�С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("¥����Ϣ����");
		this.setResizable(false);
		
		try{
			Init();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void Init() throws Exception{
		contentPane=this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//�в����Ĳ���
		centerPanel.setLayout(gridBag);
		
		jLabel1.setText("¥       ��       ����");
		jLabel1.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridx=0;
		gridBagCon.gridy=0;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel1, gridBagCon);
		centerPanel.add(jLabel1);
		
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridx=1;
		gridBagCon.gridy=0;
		gridBagCon.insets=new Insets(10, 1, 10, 10);
		gridBag.setConstraints(Phouse, gridBagCon);
		centerPanel.add(Phouse);
		
		jLabel2.setText("��       ��       �̣�");
		jLabel2.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridx=0;
		gridBagCon.gridy=1;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel2, gridBagCon);
		centerPanel.add(jLabel2);
		
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridx=1;
		gridBagCon.gridy=1;
		gridBagCon.insets=new Insets(10, 1, 10, 10);
		gridBag.setConstraints(Ppeople, gridBagCon);
		centerPanel.add(Ppeople);
		
		jLabel3.setText("��                   ַ��");
		jLabel3.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridx=0;
		gridBagCon.gridy=2;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel3, gridBagCon);
		centerPanel.add(jLabel3);
		
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridx=1;
		gridBagCon.gridy=2;
		gridBagCon.insets=new Insets(10, 1, 10, 10);
		gridBag.setConstraints(Paddress, gridBagCon);
		centerPanel.add(Paddress);
		
		jLabel4.setText("ͼ                   Ƭ��");
		jLabel4.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=1;
		gridBagCon.gridy=3;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(jLabel4, gridBagCon);
		centerPanel.add(jLabel4);
		
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=1;
		gridBagCon.gridy=3;
		gridBagCon.insets=new Insets(10, 1, 10, 10);
		gridBag.setConstraints(PimagePath, gridBagCon);
		centerPanel.add(PimagePath);
		
		fileInfo.setText("�  ��");
		fileInfo.setFont(new Font("Dialog",0,12));
		gridBagCon=new GridBagConstraints();
		gridBagCon.gridwidth=0;
		gridBagCon.gridy=3;
		gridBagCon.insets=new Insets(10, 10, 10, 1);
		gridBag.setConstraints(fileInfo, gridBagCon);
		centerPanel.add(fileInfo);
		
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		Phouse.setEditable(false);
		Ppeople.setEditable(false);
		Paddress.setEditable(false);
		PimagePath.setEditable(false);
	}
	/*
	 * �²����Ĳ���
	 */
	public void downInit(){
		addInfo.setText("����");
		addInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(addInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(clearInfo);
		exitInfo.setText("�˳�");
		exitInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(exitInfo);
		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(searchInfo);
		modifyInfo.setText("�޸�");
		modifyInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(modifyInfo);
		deleteInfo.setText("ɾ��");
		deleteInfo.setFont(new Font("Dialog", 0, 12));
		downPanel.add(deleteInfo);
		
		deleteInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		fileInfo.setEnabled(false);
		contentPane.add(downPanel, BorderLayout.SOUTH);
		
		deleteInfo.addActionListener(this);
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		fileInfo.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==addInfo){
			
		}
		if(obj==clearInfo){
			setNull();
		}
		if(obj==exitInfo){
			this.dispose();
		}
		if(obj==deleteInfo){
			
		}
		if(obj==fileInfo){
			
		}
	}
	/*
	 * ���ı������
	 */
	void setNull(){
		Phouse.setText(null);
		Ppeople.setText(null);
		Paddress.setText(null);
		PimagePath.setText(null);
	}
}
