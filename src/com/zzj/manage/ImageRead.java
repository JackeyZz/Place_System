package com.zzj.manage;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageRead extends JFrame{
	
	String path;
	 public String ImageRead()
	 {
		 JFileChooser chooser = new JFileChooser();
		  FileNameExtensionFilter filter = new FileNameExtensionFilter(
		          "图片文件", "jpg", "gif");
		  FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
		          "Txt文件","txt");
		  chooser.setFileFilter(filter);
		  chooser.setFileFilter(filter2);
		  int returnVal = chooser.showOpenDialog(this);
		  if(returnVal == JFileChooser.APPROVE_OPTION) {
			  
		      path=chooser.getSelectedFile().getAbsolutePath();
		      path=path.replace("\\", "\\\\");
		  }
		  return path;
	 }
}
