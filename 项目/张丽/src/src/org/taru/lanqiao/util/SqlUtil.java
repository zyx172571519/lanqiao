package org.taru.lanqiao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;

/**
 * 负责连接数据库 
 * 如何封装 ？？ 那些是变的 ？  SQL是变化   参数是变化     查询和 DML是不同的   那些是不变的 ？     驱动是不变化  连接是不变的  关闭 也是不变的
 * @author SZT
 *
 */
public class SqlUtil {
	
	private  static  final  String  DRIVER="driver";
	private  static  final  String  URL ="url";
	private  static  final  String  USERNAME="username";
	private  static  final  String  PASSWORD="password";
	static  Properties proper =new Properties();
	//本地变量  或者线程变量
	static  ThreadLocal<Connection>   container=new  ThreadLocal<Connection>();
	
	//首先
	static{
		
		try {
			//通过类加载器 加载在类跟路径下的属性配置文件
			proper.load(SqlUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//1、加载驱动
	static {
		try {
			System.out.println("scu");
			Class.forName(proper.getProperty(DRIVER));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2、获取连接
	public static Connection   getConnection(){
		Connection  conn =container.get();
		try {
			if(conn==null  || conn.isClosed()){
				conn =	DriverManager.getConnection(proper.getProperty(URL),
						proper.getProperty(USERNAME),proper.getProperty(PASSWORD));
				container.set(conn);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  conn;
	}
	//执行DQL语句 ResultSet 关闭之后 数据无法取出来了
	public  static ArrayList<HashMap<String,Object>>    executeQuery(String sql,Object ... params){
		ArrayList<HashMap<String,Object>>  list=new  ArrayList<HashMap<String,Object>>();
		Connection conn =	getConnection();
		PreparedStatement pst=null;
		ResultSet  rs=null;
		try {
			pst  =	conn.prepareStatement(sql);
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			rs =  pst.executeQuery();
			//解析ResultSet 解析成HashMap 和ArrayList的组合  一条数据HashMap 多条数据是ArrayList
			int count = rs.getMetaData().getColumnCount(); //获取列的数量
			System.out.println(count);
			while(rs.next()){
				HashMap<String ,Object>  row =new  HashMap<String ,Object> ();
				for(int i=0;i<count;i++){
					String key =rs.getMetaData().getColumnLabel(i+1);
					Object  value =rs.getObject(key);
					row.put(key, value);
				}
				list.add(row);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	
	//执行DML语句
	public  static int    executeUpdate(String sql,Object ... params){
		Connection conn =	getConnection();
		int row=0;
		PreparedStatement pst=null;
		
		try {
			pst  =	conn.prepareStatement(sql);
			if(params!=null){
				for(int i =0;i<params.length;i++){
					pst.setObject(i+1, params[i]);
				}
			}
			row =  pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pst!=null){
				try {
					pst.close();
					pst=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return  row;
		
		
	}
	
	//关闭资源
	public  static void   close(){
		if(container.get()!=null){
			try {
				container.get().close();
				container.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
}
