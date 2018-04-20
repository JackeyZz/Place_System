package com.zzj.search;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.Patch;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.zzj.db.PlaceBean;
import com.zzj.mainview.PlaceMain;

public class ResultPlace extends JFrame{
	JLabel jLabel1;
	JButton jBExit=new JButton();
	JScrollPane jScrollPane1;
	JTable jTable;
	Image icon;
	Dimension faceSize =new Dimension(800, 600);
	JButton button;
	
	String path;
	
	String pnum;
	String keyText;
	String[] colName={"号码","楼盘名","开发商","地址","图片"};
	String[][] colValue;
	String pColValue;
	String pColName;
	String pFromValue;
	String pToValue;
	
	/*
	 * 11111111111111111
	 */
	public ResultPlace(String colname,String colvalue){
		this.pColValue=colvalue;
		this.pColName=colname;
		
		this.setTitle("楼房信息查询结果");
		this.setSize(faceSize);
		//设置程序图标
		this.setIconImage(getImage("icon.gif"));
		//设置运行位置
		Dimension screenSize=
				Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-600)/2, (screenSize.height-650)/2+45);
		PlaceBean rPlaceBean=new PlaceBean();
		try {
			colValue=rPlaceBean.placeAllSearch(pColName, pColValue);
			if(colValue==null){
				JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				this.dispose();
			}else {
				jTable=new JTable(colValue,colName);
				
				jTable.getColumnModel().getColumn(4).setCellEditor(new MyRender());//设置编辑器
				jTable.getColumnModel().getColumn(4).setCellRenderer(new MyRender() );
				
				jScrollPane1=new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1, BorderLayout.NORTH);
				jScrollPane1.setPreferredSize(new Dimension(500, 150));
				
				//String picPath1="F:\\Android\\人物图片素材\\1.jpg";
		        Icon icon=new ImageIcon(ResultPlace.this.
						getClass().getResource("3.jpg"));
		        jLabel1=new JLabel(icon);
		        this.getContentPane().add(jLabel1, BorderLayout.CENTER);
		        jLabel1.setPreferredSize(new Dimension(800, 150));
		        
				this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * 222222222222222222222
	 */
	public ResultPlace(String colname,String fromvalue,String tovalue){
		this.pColName=colname;
		this.pFromValue=fromvalue;
		this.pToValue=tovalue;
		
		this.setTitle("楼房信息查询结果");
		this.setSize(faceSize);
		this.setIconImage(getImage("icon.gif"));
		//设置运行位置
		Dimension screenSize=
				Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((screenSize.width-600)/2, (screenSize.height-650)/2+45);
		PlaceBean rPlace=new PlaceBean();
		try {
			colValue=rPlace.placeAllSearch(pColName, pFromValue,pToValue);
			if(colValue==null){
				JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				this.dispose();
			}else {
				jTable=new JTable(colValue,colName);
				
				jTable.getColumnModel().getColumn(4).setCellEditor(new MyRender());//设置编辑器
				jTable.getColumnModel().getColumn(4).setCellRenderer(new MyRender() );
				
				jScrollPane1=new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1, BorderLayout.NORTH);
				jScrollPane1.setPreferredSize(new Dimension(500, 150));
				
				//String picPath1="F:\\Android\\人物图片素材\\1.jpg";
		        Icon icon=new ImageIcon(ResultPlace.this.
						getClass().getResource("3.jpg"));
		        jLabel1=new JLabel(icon);
		        this.getContentPane().add(jLabel1, BorderLayout.CENTER);
		        jLabel1.setPreferredSize(new Dimension(800, 150));
		        
				//this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/*
	 * 3333333333333333333333
	 */
	//按地址查询结果
	public ResultPlace(String text){
		this.keyText=text;
		
		this.setTitle("楼房信息查询结果");
		this.setSize(faceSize);
		//设置程序图标
		this.setIconImage(getImage("icon.gif"));
		//设置运行位置
		Dimension screenSize=
				Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width-600)/2, (screenSize.height-650)/2+45);
		PlaceBean rPlaceBean=new PlaceBean();
		try {
			colValue=rPlaceBean.placeAllSearchPaddress(keyText);
			if(colValue==null){
				JOptionPane.showMessageDialog(null, "没有符合条件的记录");
				this.dispose();
			}else {
				jTable=new JTable(colValue,colName);
				
				jTable.getColumnModel().getColumn(4).setCellEditor(new MyRender());//设置编辑器
				jTable.getColumnModel().getColumn(4).setCellRenderer(new MyRender() );
				
				jScrollPane1=new JScrollPane(jTable);
				this.getContentPane().add(jScrollPane1, BorderLayout.NORTH);
				jScrollPane1.setPreferredSize(new Dimension(500, 150));
				
				//String picPath1="F:\\Android\\人物图片素材\\1.jpg";
		        Icon icon=new ImageIcon(ResultPlace.this.
						getClass().getResource("3.jpg"));
		        jLabel1=new JLabel(icon);
		        this.getContentPane().add(jLabel1, BorderLayout.CENTER);
		        jLabel1.setPreferredSize(new Dimension(800, 150));
		        
				//this.pack();
				this.setVisible(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/*
	 * 44444444444444444444444444
	 */
	Image getImage(String filename){
		
		return icon;
	}
}

/*
 * 55555555555555555555555555555555555
 */
//渲染 器  编辑器
class MyRender extends AbstractCellEditor implements TableCellRenderer,ActionListener, TableCellEditor{

	private static final long serialVersionUID = 1L;
	private JButton button =null;
	private String label; 
	public MyRender(){
		button = new JButton();
		button.addActionListener(this);
	}

	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return new String(label);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		if (isSelected) {  
            button.setForeground(table.getSelectionForeground()); //setForeground设置前景色 
            button.setBackground(table.getSelectionBackground());  // getSelectionForeground() 返回用于绘制选定项的前景的颜色
        } else {  
            button.setForeground(table.getForeground());  
            button.setBackground(UIManager.getColor("UIManager"));  
        }  
        button.setText((value == null) ? "" : value.toString());  
        return button;  
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null, "渲染器学期", "消息", JOptionPane.OK_OPTION);
		//System.out.println(label);
		ImageView img=new ImageView();
		img.ImageView(label);
	}
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		 if (isSelected) {  
	            button.setForeground(table.getSelectionForeground());  
	            button.setBackground(table.getSelectionBackground());  
	        } else {  
	            button.setForeground(table.getForeground());  
	            button.setBackground(table.getBackground());  
	        }  
	        label = (value == null) ? "" : value.toString();  
	        button.setText(label);
			return button;  
	}
}
