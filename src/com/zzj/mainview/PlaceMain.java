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
	//��ܴ�С
	Dimension faceSize =new Dimension(600, 500);
	//����ͼ��
	Image icon;
	private JLabel backLabel;
	private Container contentPane;
	private boolean is=false;
	ImageIcon background;
	
	//�����˵���
	JMenuBar mainMenu =new JMenuBar();
	//������ϵͳ�����˵���
	JMenu menuSystem=new JMenu();
	JMenuItem itemExit=new JMenuItem();
	JMenuItem itemLogin=new JMenuItem();
	JMenuItem itemRegister=new JMenuItem();
	//������¥�̹����˵���
	JMenu menuPlace=new JMenu();
	JMenuItem itemAddP=new JMenuItem();
	JMenuItem itemEditP=new JMenuItem();
	JMenuItem itemDeleteP=new JMenuItem();
	//��������Ϣ��ѯ���˵���
	JMenu menuSearch=new JMenu();
	JMenuItem itemSearchPlaceByNum=new JMenuItem();
	JMenuItem itemSearchPlaceByHouse=new JMenuItem();
	JMenuItem itemSearchPlaceByPeople=new JMenuItem();
	JMenuItem itemSearchPlaceByAddress=new JMenuItem();
	/*
	 * �����ʼ������
	 */
	public PlaceMain(String name){
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		
		//��ӿ�ܵĹر��¼�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
		//���ÿ�ܵĴ�С
		this.setSize(faceSize);
		//���ñ���
		this.setTitle("���ز�����ϵͳ-��ӭ"+name+"!!");
		//����ͼ��
		icon=getImage("icon.gif");
		this.setIconImage(icon);//���ó���ͼ��
				
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
		
		//��Ӳ˵���
		menuSystem.setText("ϵͳ����");
		menuSystem.setFont(new Font("Dialog", 0, 12));
		menuPlace.setText("¥�̹���");
		menuPlace.setFont(new Font("Dialog", 0, 12));
		menuPlace.setEnabled(true);
		menuSearch.setText("��Ϣ��ѯ");
		menuSearch.setFont(new Font("Dialog", 0, 12));
		menuSearch.setEnabled(true);
		//���ɡ�ϵͳ�����˵���ѡ��
		itemExit.setText("�˳�");
		itemExit.setFont(new Font("Dialog", 0, 12));
		itemLogin.setText("��½");
		itemLogin.setFont(new Font("Dialog", 0, 12));
		itemRegister.setText("ע��");
		itemRegister.setFont(new Font("Dialog", 0, 12));
		//���ɡ�¥�̹����˵���ѡ��
		itemAddP.setText("����");
		itemAddP.setFont(new Font("Dialog", 0, 12));
		itemEditP.setText("�޸�");
		itemEditP.setFont(new Font("Dialog", 0, 12));
		itemDeleteP.setText("ɾ��");
		itemDeleteP.setFont(new Font("Dialog", 0, 12));
		//���ɡ���Ϣ��ѯ���˵���ѡ��
		itemSearchPlaceByNum.setText("�������ѯ");
		itemSearchPlaceByNum.setFont(new Font("Dialog", 0, 12));
		itemSearchPlaceByHouse.setText("��¥������ѯ");
		itemSearchPlaceByHouse.setFont(new Font("Dialog", 0, 12));
		itemSearchPlaceByPeople.setText("�������̲�ѯ");
		itemSearchPlaceByPeople.setFont(new Font("Dialog", 0, 12));
		itemSearchPlaceByAddress.setText("��¥�̵�ַ��ѯ");
		itemSearchPlaceByAddress.setFont(new Font("Dialog", 0, 12));
		
		//��ӡ�ϵͳ�����˵���
		menuSystem.add(itemExit);
		menuSystem.add(itemLogin);
		menuSystem.add(itemRegister);
		//��ӡ�¥�̹����˵���
		menuPlace.add(itemAddP);
		menuPlace.add(itemEditP);
		menuPlace.add(itemDeleteP);
		//��ӡ���Ϣ�����˵���
		menuSearch.add(itemSearchPlaceByNum);
		menuSearch.add(itemSearchPlaceByHouse);
		menuSearch.add(itemSearchPlaceByPeople);
		menuSearch.add(itemSearchPlaceByAddress);
		//������еĲ˵���
		mainMenu.add(menuSystem);
		mainMenu.add(menuPlace);
		mainMenu.add(menuSearch);
		this.setJMenuBar(mainMenu);
		
		//��Ӽ���
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
		
		//�رճ���ʱ �Ĳ���
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	/*
	 * �¼�����
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
