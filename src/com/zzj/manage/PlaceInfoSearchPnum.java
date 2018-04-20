package com.zzj.manage;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.zzj.db.PlaceBean;

/*
 * ��ȡ���벢���ò�ѯ��Ϣ
 */
public class PlaceInfoSearchPnum extends JDialog implements ActionListener{
	Container contentPane;
	String[] s;
	//��ܵĴ�С
	Dimension faceSize=new Dimension(300,100);
	JLabel jLabel1=new JLabel();
	JComboBox selectPnum;
	JButton searchInfo=new JButton();
	
	public PlaceInfoSearchPnum(JFrame frame){
		super(frame, true);
		this.setTitle("�����ѯ");
		this.setResizable(false);
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
	
	private void Init() throws Exception{
		this.setSize(faceSize);
		contentPane=this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		jLabel1.setText("���������ѡ�����:");
		jLabel1.setFont(new Font("Dialog", 0, 12));
		contentPane.add(jLabel1);
		
		PlaceBean getNum=new PlaceBean();
		s=getNum.getAllNum();
		
		selectPnum=new JComboBox(s);
		
		selectPnum.setEditable(true);
		selectPnum.setFont(new Font("Dialog", 0, 12));
		contentPane.add(selectPnum);
		
		searchInfo.setText("��ѯ");
		searchInfo.setFont(new Font("Dialog", 0, 12));
		contentPane.add(searchInfo);
		
		searchInfo.addActionListener(this);
	}

	/*
	 * �¼�����
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==selectPnum){
			this.dispose();
		}
		else if(obj==searchInfo){
			this.dispose();
		}
	}
	
	/*
	 * ����ѡ���ѧ��
	 */
	public String getPnum(){
		return (String)this.selectPnum.getSelectedItem();
	}
}
