package org.taru.lanqiao.util;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DbUtil {
	private static Properties properties=new Properties();
	private static ThreadLocal<Connection> local =new ThreadLocal<Connection>();
	public static List<Map<String, Object>> query(String sql, String id) {
		// TODO �Զ����ɵķ������
		return null;
	}
	static{
		try {
			properties.load(DbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			System.out.println("�����ļ��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��������
	 */
	
}
