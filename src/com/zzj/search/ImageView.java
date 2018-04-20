package com.zzj.search;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageView extends JFrame{
	
	public void ImageView(String path){
		JFrame frame=new JFrame();
		frame.setTitle("图片信息");
		frame.setSize(new Dimension(800,600));
		JLabel jLabel1;
		
		Icon icon=new ImageIcon(path);
        jLabel1=new JLabel(icon);
        frame.getContentPane().add(jLabel1);
        jLabel1.setPreferredSize(new Dimension(700, 500));
        
        frame.pack();
		frame.setVisible(true);
		
		//设置运行位置
		Dimension screenSize=
				Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-600)/2, (screenSize.height-650)/2+45);
	}
}
