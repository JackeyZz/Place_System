package com.zzj.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Database {
		//定义mysql的数据库驱动程序
		public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
		//定义mysql数据库的连接地址
		public static final String DBURL="jdbc:mysql://localhost:3306/place_system";
		//mysql数据库 的用户连接名
		public static final String DBUSER="root";
		//mysql数据库的连接密码
		public static final String DBPASS="123456789";
		
		private Connection conn=null;
		ResultSet rs=null;
		private Statement stmt=null;
		String sql;
		
		public Database(){
		}
		
		/*
		 * 打开数据库连接
		 */
		public void OpenConn()throws Exception{
			try {
				Class.forName(DBDRIVER);
				conn=(Connection) DriverManager.getConnection(DBURL,DBUSER, DBPASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * 执行sql语句，返回结果集rs
		 */
		public ResultSet executeQuery(String sql){
			stmt=null;
			rs=null;
			try{
				stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rs=stmt.executeQuery(sql);
			}catch(SQLException e){
				System.err.println("executeQuery:"+e.getMessage());
			}
			return rs;
		}
		
		/*
		 * 执行sql语句
		 */
		public void executeUpdate(String sql){
			stmt=null;
			rs=null;
			try{
				stmt=(Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				stmt.executeUpdate(sql);
				conn.commit();
			}catch(SQLException e){
				System.err.println("executeUpdate:"+e.getMessage());
			}
		}
		
		public void closeStmt(){
			try{
				stmt.close();
			}catch(SQLException e){
				System.err.println("closeStmt:"+e.getMessage());
			}
		}
		
		/*
		 * 关闭数据库连接
		 */
		public void closeConn(){
			try{
				conn.close();
			}catch(SQLException ex){
				System.err.println("aq.closeConn:"+ex.getMessage());
			}
		}
		
		/*
		 * 转换编码
		 */
		public static String toGBK(String str){
			try{
				if(str==null)
					str="";
				else {
					str=new String(str.getBytes("ISO-8859-1"),"GBK");
				}
			}catch(Exception e){
				System.out.println(e);
			}
			return str;
		}
}
