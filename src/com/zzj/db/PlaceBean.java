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
	
	String colName;//列名
	String colValue;//列值
	String colValue2;
	String keytext;//关键字
	
	/*
	 * 添加房子信息
	 */
	public void placeAdd(String house,String people,
			String address,String imagePath){
		Database DB=new Database();
		
		this.phouse=house;
		this.ppeople=people;
		this.paddress=address;
		this.pimagePath=imagePath;
		
		if(phouse==null||phouse.equals("")){
			JOptionPane.showMessageDialog(null, "请输入楼盘名","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			sql="insert into place( phouse, people, paddress, imagepath)" 
					+"values( '"+phouse+"','"+ppeople+"'," +
							"'"+paddress+"','"+pimagePath+"')";
									
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功添加一条新的纪录！");
			}catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "保存失败","错误",
						JOptionPane.ERROR_MESSAGE);
			}
			finally{
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}
	/*
	 * 修改房子信息
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
			JOptionPane.showMessageDialog(null, "请输入楼盘名","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			sql="update place set phouse = '"+phouse+"', people = '"+ppeople+"', " +
					" paddress = '"+paddress+"', imagepath = '"+pimagePath+"'" +
							" where pnum = "+Integer.parseInt(pnum)+"";
			try {
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功修改一条新的纪录！");
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "更新失败","错误",
						JOptionPane.ERROR_MESSAGE);
			}
			finally{
				DB.closeConn();
				DB.closeStmt();
			}
		}
	}
	/*
	 * 删除房子信息
	 */
	public void PlaceDel(String num){
		Database DB=new Database();
		this.pnum=num;
		
		sql="delete from place where pnum = "+Integer.parseInt(pnum)+"";
		
		try {
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "成功删除一条纪录！");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "更新失败","错误",
					JOptionPane.ERROR_MESSAGE);
		}
		finally{
			DB.closeConn();
			DB.closeStmt();
		}
	}
	/*
	 * 按号码查询房子信息
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
	 * 注册
	 */
	public void userRegister(String num,String name,
			String password){
		Database DB=new Database();
		
		this.usernum=num;
		this.username=name;
		this.password=password;
		
		if(username==null||username.equals("")){
			JOptionPane.showMessageDialog(null, "请输入用户名","错误",
					JOptionPane.ERROR_MESSAGE);
			return;
		}else{
			sql="insert into users( usernum, username, password)" 
					+"values( '"+usernum+"','"+username+"'," +
							"'"+password+"')";
									
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "成功添加用户！");
			}catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "保存失败","错误",
						JOptionPane.ERROR_MESSAGE);
			}
			finally{
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}
	
	/*
	 * 登陆
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
	 * 按照一个条件进行查询
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
	 * 查询某范围内的记录
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
	 * 按地址的关键字查询
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
	 * 获得place表中的所有号码pnum
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
