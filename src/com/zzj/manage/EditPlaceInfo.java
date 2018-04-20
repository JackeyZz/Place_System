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
		this.setTitle("�޸�¥����Ϣ");
		this.setResizable(false);
		
		Phouse.setEditable(false);
		Ppeople.setEditable(false);
		Paddress.setEditable(false);
		PimagePath.setEditable(false);
		
		//��������ʱ���ڵ�λ��
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-400)/2, (screenSize.height-300)/2+45);
	}
	public void downInit(){
		searchInfo.setText("�����ѯ");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		modifyInfo.setText("�޸�");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		clearInfo.setText("���");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		exitInfo.setText("�˳�");
		exitInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(exitInfo);
		
		searchInfo.setEnabled(true);
		fileInfo.setEnabled(false);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		exitInfo.setEnabled(true);
		
		//����¼�����
		fileInfo.addActionListener(this);
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		exitInfo.addActionListener(this);
		
		this.contentPane.add(downPanel, BorderLayout.SOUTH);
	}
	/*
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		String[] s=new String[8];
		
		if(obj==exitInfo){
			//�˳�
			this.dispose();
		}
		else if(obj==modifyInfo){
			//�޸�
			PlaceBean modifyPlace=new PlaceBean();
			modifyPlace.PlaceModify(sNum_str, Phouse.getText(), Ppeople.getText(), 
					Paddress.getText(), PimagePath.getText());
	
			Phouse.setText("");
			Ppeople.setText("");
			Paddress.setText("");
			PimagePath.setText("");
		}
		else if(obj==clearInfo){
			//���
			setNull();
		}
		else if(obj==searchInfo){
			//ѧ�Ų�ѯ
			PlaceInfoSearchPnum siss=new PlaceInfoSearchPnum(this);
			siss.pack();
			siss.setVisible(true);
			try {
				sNum_str=siss.getPnum();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "û�в��ҵ���ѧ�ţ�");
			}
			
			PlaceBean searchPlace=new PlaceBean();
			s=searchPlace.PlaceSearch(sNum_str);
			if(s==null){
				JOptionPane.showMessageDialog(null, "��¼�����ڣ�");
	
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
