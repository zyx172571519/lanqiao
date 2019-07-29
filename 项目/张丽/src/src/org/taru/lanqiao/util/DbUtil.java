package org.taru.lanqiao.util;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DbUtil {
	private static Properties properties=new Properties();
	private static ThreadLocal<Connection> local =new ThreadLocal<Connection>();
	public static List<Map<String, Object>> query(String sql, String id) {
		// TODO 自动生成的方法存根
		return null;
	}
	static{
		try {
			properties.load(DbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			System.out.println("配置文件成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 加载驱动
	 */
	
}
