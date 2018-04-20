package com.zzj.db;

import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class PlaceBean {
	String sql;
	ResultSet rs=null;
	
	String usernum;
	String username;
	String password;
	
	String pnum;
	String phouse;
	String ppeople;
	String paddress;
	String pimagePath;
	
	String colName;//����
	String colValue;//��ֵ
	String colValue2;
	String keytext;//�ؼ���
	
	/*
	 * ��ӷ�����Ϣ
	 */
	public void placeAdd(String house,String people,
			String address,String imagePath){
		Database DB=new Database();
		
		this.phouse=house;
		this.ppeople=people;
		this.paddress=address;
		this.pimagePath=imagePath;
		
		if(phouse==null||phouse.equals("")){
			JOptionPane.showMessageDialog(null, "������¥����","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			sql="insert into place( phouse, people, paddress, imagepath)" 
					+"values( '"+phouse+"','"+ppeople+"'," +
							"'"+paddress+"','"+pimagePath+"')";
									
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "�ɹ����һ���µļ�¼��");
			}catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ��","����",
						JOptionPane.ERROR_MESSAGE);
			}
			finally{
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}
	/*
	 * �޸ķ�����Ϣ
	 */
	public void PlaceModify(String num,String house,String people,
			String address,String imagePath){
		Database DB=new Database();
		
		this.pnum=num;
		this.phouse=house;
		this.ppeople=people;
		this.paddress=address;
		this.pimagePath=imagePath;
		
		if(phouse==null||phouse.equals("")){
			JOptionPane.showMessageDialog(null, "������¥����","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			sql="update place set phouse = '"+phouse+"', people = '"+ppeople+"', " +
					" paddress = '"+paddress+"', imagepath = '"+pimagePath+"'" +
							" where pnum = "+Integer.parseInt(pnum)+"";
			try {
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "�ɹ��޸�һ���µļ�¼��");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ��","����",
						JOptionPane.ERROR_MESSAGE);
			}
			finally{
				DB.closeConn();
				DB.closeStmt();
			}
		}
	}
	/*
	 * ɾ��������Ϣ
	 */
	public void PlaceDel(String num){
		Database DB=new Database();
		this.pnum=num;
		
		sql="delete from place where pnum = "+Integer.parseInt(pnum)+"";
		
		try {
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "�ɹ�ɾ��һ����¼��");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "����ʧ��","����",
					JOptionPane.ERROR_MESSAGE);
		}
		finally{
			DB.closeConn();
			DB.closeStmt();
		}
	}
	/*
	 * �������ѯ������Ϣ
	 */
	public String[] PlaceSearch(String num){
		Database DB=new Database();
		this.pnum=num;
		String[] s=new String[4];
		sql="select * from place where pnum=" +
				""+Integer.parseInt(pnum)+"";
		
		try {
			DB.OpenConn();
			rs=DB.executeQuery(sql);
			if(rs.next()){
				s[0]=rs.getString("phouse");
				s[1]=rs.getString("people");
				s[2]=rs.getString("paddress");
				s[3]=rs.getString("imagepath");
			}
			else {
				s=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}
	
	/*
	 * ע��
	 */
	public void userRegister(String num,String name,
			String password){
		Database DB=new Database();
		
		this.usernum=num;
		this.username=name;
		this.password=password;
		
		if(username==null||username.equals("")){
			JOptionPane.showMessageDialog(null, "�������û���","����",
					JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			sql="insert into users( usernum, username, password)" 
					+"values( '"+usernum+"','"+username+"'," +
							"'"+password+"')";
									
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "�ɹ�����û���");
			}catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "����ʧ��","����",
						JOptionPane.ERROR_MESSAGE);
			}
			finally{
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}
	
	/*
	 * ��½
	 */
	public String[] UserSearch(String num){
		Database DB=new Database();
		this.pnum=num;
		String[] s=new String[4];
		sql="select * from users where usernum=" +
				""+Integer.parseInt(pnum)+"";
		
		try {
			DB.OpenConn();
			rs=DB.executeQuery(sql);
			if(rs.next()){
				s[0]=rs.getString("username");
				s[1]=rs.getString("password");
			}
			else {
				s=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}
	
	/*
	 * ����һ���������в�ѯ
	 */
	public String[][] placeAllSearch(String colname,String colvalue){
		this.colName=colname;
		this.colValue=colvalue;
		
		Database DB=new Database();
		String[][] sn=null;
		int row=0;
		int i=0;
		
		DB.toGBK(colvalue);
		if(colValue==null||colValue.equals("")){
			sql="select * from place";
		}else {
			sql="select * from place where "+colName+"" +
					"='"+colValue+"'";
		}
		try {
			DB.OpenConn();
			rs=DB.executeQuery(sql);
			
			if(rs.last()){
				row=rs.getRow();
			}
			if(row==0){
				sn=null;
			}
			else {
				sn=new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("pnum");
					sn[i][1]=rs.getString("phouse");
					sn[i][2]=rs.getString("people");
					sn[i][3]=rs.getString("paddress");
					sn[i][4]=rs.getString("imagepath");
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}
	/*
	 * ��ѯĳ��Χ�ڵļ�¼
	 */
	public String[][] placeAllSearch(String colname,String colvalue,
			String colvalue2){
		this.colName=colname;
		this.colValue=colvalue;
		this.colValue2=colvalue2;
		
		Database DB=new Database();
		String[][] sn=null;
		int row=0;
		int i=0;
		
		sql="select * from place where "+colName+" between " +
				""+colValue+" and "+colValue2+"";
		try {
			DB.OpenConn();
			rs=DB.executeQuery(sql);
			
			if(rs.last()){
				row=rs.getRow();
			}
			if(row==0){
				sn=null;
			}else {
				sn=new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("pnum");
					sn[i][1]=rs.getString("phouse");
					sn[i][2]=rs.getString("people");
					sn[i][3]=rs.getString("paddress");
					sn[i][4]=rs.getString("imagepath");
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}
	/*
	 * ����ַ�Ĺؼ��ֲ�ѯ
	 */
	public String[][] placeAllSearchPaddress(String text){
		this.keytext=text;
		
		Database DB=new Database();
		String[][] sn=null;
		int row=0;
		int i=0;
		
		DB.toGBK(text);
		if(keytext==null||keytext.equals("")){
			sql="select * from place";
		}else {
			sql="select * from place where paddress like" +
					" '%"+keytext+"%'";
		}
		try {
			DB.OpenConn();
			rs=DB.executeQuery(sql);
			
			if(rs.last()){
				row=rs.getRow();
			}
			if(row==0){
				sn=null;
			}
			else {
				sn=new String[row][5];
				rs.first();
				rs.previous();
				while(rs.next()){
					sn[i][0]=rs.getString("pnum");
					sn[i][1]=rs.getString("phouse");
					sn[i][2]=rs.getString("people");
					sn[i][3]=rs.getString("paddress");
					sn[i][4]=rs.getString("imagepath");
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
		return sn;
	}
	/*
	 * ���place���е����к���pnum
	 */
	public String[] getAllNum(){
		String[] s=null;
		int row=0;
		int i=0;
		Database DB=new Database();
		sql="select pnum from place";
		
		try {
			DB.OpenConn();
			rs=DB.executeQuery(sql);
			if(rs.last()){
				row=rs.getRow();
			}
			if(row==0){
				s=null;
			}
			else {
				s=new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					s[i]=rs.getString(1);
					i++;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		finally{
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}
}
