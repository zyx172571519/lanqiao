package org.taru.lanqiao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * ������ɾ�Ĳ� 
 * @author 
 *
 */
public class DbUtil {
	
	private static  Properties  properties =new Properties();
	//private  static  Connection conn =null; //??  ��̬�ĳ�Ա����  ��JVM ������һ��   �������ÿһ�� ����һ�������� ��
	private static ThreadLocal<Connection>   local =new ThreadLocal<Connection>();   //�̵߳ı��ر���
	
	
	
	static{
		
		try {
			properties.load(DbUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			System.out.println("��ʼ�������ļ��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * ��������
	 */
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ��һ������
	 * @return
	 */
  
	
	public  static Connection    openConnection(){
		
		Connection  conn=local.get();
		
		try {
			if(conn==null || conn.isClosed()){
				conn  =	DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
				
				System.out.println("�����ӳɹ�");
				local.set(conn);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * DML
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(String sql ,Object...params ){
		Connection  conn   =	openConnection();
		PreparedStatement  pst=null;
		int row=0;
		try {
			pst =	conn.prepareStatement(sql);
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
					
				}
			}
			row=	pst.executeUpdate();
			
		}catch(Exception ex){
			ex.printStackTrace();
			throw  new RuntimeException("ִ��dml����");
		}finally{
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return  row;
	}
	
	/**
	 * DQL
	 * @param sql  Student   Teacher
	 * @param params
	 * @return
	 */
	public static List<Map<String,Object>> query(String sql ,Object...params){
		Connection  conn   =	openConnection();
		PreparedStatement  pst=null;
		ResultSet  rs=null;
		List<Map<String,Object>>   list=null;
		try {
			pst =conn.prepareStatement(sql);
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
					
				}
			}
			rs=	pst.executeQuery();
			ResultSetMetaData    rsmd = rs.getMetaData(); //���Ԫ���� ��������У�
			int  count  =rsmd.getColumnCount();
			list  =new  ArrayList<Map<String,Object>>();
			while(rs.next()){
				Map<String,Object>  hashmap =new HashMap<String,Object>();
				for(int i=0;i<count;i++){
					hashmap.put(rsmd.getColumnLabel(i+1), rs.getObject(i+1)); //
				}
				list.add(hashmap);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			throw  new RuntimeException("ִ��Query����");
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return  list;
	}
	
	/**
	 * �ر�����
	 */
	public static void  close(){
		Connection conn =local.get();
		if(conn!=null){
			try {
				conn.close();
				local.remove();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
