package com.zzj.mainview;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.plaf.DesktopPaneUI;

import com.zzj.manage.AddPlaceInfo;
import com.zzj.manage.DeletePlaceInfo;
import com.zzj.manage.EditPlaceInfo;
import com.zzj.search.PlaceSearchPaddress;
import com.zzj.search.PlaceSearchPhouse;
import com.zzj.search.PlaceSearchPnum;
import com.zzj.search.PlaceSearchPpeople;
import com.zzj.user.UserLogin;
import com.zzj.user.UserRegister;

public class PlaceMain extends JFrame implements ActionListener{
	//框架大小
	Dimension faceSize =new Dimension(600, 500);
	//程序图标
	Image icon;
	private JLabel backLabel;
	private Container contentPane;
	private boolean is=false;
	ImageIcon background;
	
	//建立菜单栏
	JMenuBar mainMenu =new JMenuBar();
	//建立“系统管理”菜单组
	JMenu menuSystem=new JMenu();
	JMenuItem itemExit=new JMenuItem();
	JMenuItem itemLogin=new JMenuItem();
	JMenuItem itemRegister=new JMenuItem();
	//建立“楼盘管理”菜单组
	JMenu menuPlace=new JMenu();
	JMenuItem itemAddP=new JMenuItem();
	JMenuItem itemEditP=new JMenuItem();
	JMenuItem itemDeleteP=new JMenuItem();
	//建立“信息查询”菜单组
	JMenu menuSearch=new JMenu();
	JMenuItem itemSearchPlaceByNum=new JMenuItem();
	JMenuItem itemSearchPlaceByHouse=new JMenuItem();
	JMenuItem itemSearchPlaceByPeople=new JMenuItem();
	JMenuItem itemSearchPlaceByAddress=new JMenuItem();
	/*
	 * 程序初始化函数
	 */
	public PlaceMain(String name){
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		
		//添加框架的关闭事件处理
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
		//设置框架的大小
		this.setSize(faceSize);
		//设置标题
		this.setTitle("房地产管理系统-欢迎"+name+"!!");
		//程序图标
		icon=getImage("icon.gif");
		this.setIconImage(icon);//设置程序图标
				
		try{
			Init();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void Init()throws Exception{
		
		//frame=new JFrame();
		contentPane=this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//String picPath1="F:\\Android\\M8QQ.png";
        //Icon icon=new ImageIcon(picPath1);
		background=new ImageIcon(PlaceMain.this.
				getClass().getResource("1.jpg"));
        backLabel=new JLabel(background);
        //JDesktopPane desktopPane=new JDesktopPane();
        //desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
        contentPane.add(backLabel);
        /*
        backLabel.setVerticalAlignment(SwingConstants.TOP);
        backLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateBackImage();
        JDesktopPane desktopPane=new JDesktopPane();
        desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
        contentPane.add(desktopPane);*/
		
		//添加菜单组
		menuSystem.setText("系统管理");
		menuSystem.setFont(new Font("Dialog", 0, 12));
		menuPlace.setText("楼盘管理");
		menuPlace.setFont(new Font("Dialog", 0, 12));
		menuPlace.setEnabled(true);
		menuSearch.setText("信息查询");
		menuSearch.setFont(new Font("Dialog", 0, 12));
		menuSearch.setEnabled(true);
		//生成“系统管理”菜单组选项
		itemExit.setText("退出");
		itemExit.setFont(new Font("Dialog", 0, 12));
		itemLogin.setText("登陆");
		itemLogin.setFont(new Font("Dialog", 0, 12));
		itemRegister.setText("注册");
		itemRegister.setFont(new Font("Dialog", 0, 12));
		//生成“楼盘管理”菜单组选项
		itemAddP.setText("增加");
		itemAddP.setFont(new Font("Dialog", 0, 12));
		itemEditP.setText("修改");
		itemEditP.setFont(new Font("Dialog", 0, 12));
		itemDeleteP.setText("删除");
		itemDeleteP.setFont(new Font("Dialog", 0, 12));
		//生成“信息查询”菜单组选项
		itemSearchPlaceByNum.setText("按号码查询");
		itemSearchPlaceByNum.setFont(new Font("Dialog", 0, 12));
		itemSearchPlaceByHouse.setText("按楼盘名查询");
		itemSearchPlaceByHouse.setFont(new Font("Dialog", 0, 12));
		itemSearchPlaceByPeople.setText("按开发商查询");
		itemSearchPlaceByPeople.setFont(new Font("Dialog", 0, 12));
		itemSearchPlaceByAddress.setText("按楼盘地址查询");
		itemSearchPlaceByAddress.setFont(new Font("Dialog", 0, 12));
		
		//添加“系统管理”菜单组
		menuSystem.add(itemExit);
		menuSystem.add(itemLogin);
		menuSystem.add(itemRegister);
		//添加“楼盘管理”菜单组
		menuPlace.add(itemAddP);
		menuPlace.add(itemEditP);
		menuPlace.add(itemDeleteP);
		//添加“信息管理”菜单组
		menuSearch.add(itemSearchPlaceByNum);
		menuSearch.add(itemSearchPlaceByHouse);
		menuSearch.add(itemSearchPlaceByPeople);
		menuSearch.add(itemSearchPlaceByAddress);
		//添加所有的菜单组
		mainMenu.add(menuSystem);
		mainMenu.add(menuPlace);
		mainMenu.add(menuSearch);
		this.setJMenuBar(mainMenu);
		
		//添加监听
		itemExit.addActionListener(this);
		itemLogin.addActionListener(this);
		itemRegister.addActionListener(this);
		itemAddP.addActionListener(this);
		itemEditP.addActionListener(this);
		itemDeleteP.addActionListener(this);
		itemSearchPlaceByNum.addActionListener(this);
		itemSearchPlaceByHouse.addActionListener(this);
		itemSearchPlaceByPeople.addActionListener(this);
		itemSearchPlaceByAddress.addActionListener(this);
		
		//关闭程序时 的操作
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	/*
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj=e.getSource();
		if(obj==itemExit){
			System.exit(0);
		}else if (obj==itemLogin) {
			//UserLogin asi=new UserLogin();
			//asi.downInit();
			//asi.pack();
			//asi.setVisible(true);
		}else if (obj==itemRegister) {
			//UserRegister asi=new UserRegister();
			//asi.downInit();
			//asi.pack();
			//asi.setVisible(true);
		}else if(obj==itemAddP){
			AddPlaceInfo asi=new AddPlaceInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);
		}else if(obj==itemEditP){
			EditPlaceInfo asi=new EditPlaceInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);
		}else if(obj==itemDeleteP){
			DeletePlaceInfo asi=new DeletePlaceInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);
		}else if(obj==itemSearchPlaceByNum){
			PlaceSearchPnum ppNum=new PlaceSearchPnum();
			ppNum.pack();
			ppNum.setVisible(true);
		}else if(obj==itemSearchPlaceByHouse){
			PlaceSearchPhouse pphouse=new PlaceSearchPhouse();
			pphouse.pack();
			pphouse.setVisible(true);
		}else if(obj==itemSearchPlaceByPeople){
			PlaceSearchPpeople pphouse=new PlaceSearchPpeople();
			pphouse.pack();
			pphouse.setVisible(true);
		}else if(obj==itemSearchPlaceByAddress){
			PlaceSearchPaddress ppaddress=new PlaceSearchPaddress();
			ppaddress.pack();
			ppaddress.setVisible(true);
		}
	}
	
	Image getImage(String filename){
		
		return icon;
	}
	private void updateBackImage(){
		if(backLabel!=null){
			int backw=PlaceMain.this.contentPane.getWidth();
			int backh=contentPane.getHeight();
			backLabel.setSize(backw, backh);
			backLabel.setText("<html><body><image width='"+backw+
					"'height='"+backh+"'src="
					+PlaceMain.this.getClass().getResource("1.jpg")
					+"'></img></body></html>");
			backLabel.validate();
		}
	}
	public boolean isIs() {
		return is;
	}
	public void setIs(boolean is) {
		this.is = is;
	}
}
