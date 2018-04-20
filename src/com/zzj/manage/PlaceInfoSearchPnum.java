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
 * 获取号码并调用查询信息
 */
public class PlaceInfoSearchPnum extends JDialog implements ActionListener{
	Container contentPane;
	String[] s;
	//框架的大小
	Dimension faceSize=new Dimension(300,100);
	JLabel jLabel1=new JLabel();
	JComboBox selectPnum;
	JButton searchInfo=new JButton();
	
	public PlaceInfoSearchPnum(JFrame frame){
		super(frame, true);
		this.setTitle("号码查询");
		this.setResizable(false);
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
	
	private void Init() throws Exception{
		this.setSize(faceSize);
		contentPane=this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		jLabel1.setText("请输入或者选择号码:");
		jLabel1.setFont(new Font("Dialog", 0, 12));
		contentPane.add(jLabel1);
		
		PlaceBean getNum=new PlaceBean();
		s=getNum.getAllNum();
		
		selectPnum=new JComboBox(s);
		
		selectPnum.setEditable(true);
		selectPnum.setFont(new Font("Dialog", 0, 12));
		contentPane.add(selectPnum);
		
		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog", 0, 12));
		contentPane.add(searchInfo);
		
		searchInfo.addActionListener(this);
	}

	/*
	 * 事件处理
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
	 * 返回选择的学号
	 */
	public String getPnum(){
		return (String)this.selectPnum.getSelectedItem();
	}
}
