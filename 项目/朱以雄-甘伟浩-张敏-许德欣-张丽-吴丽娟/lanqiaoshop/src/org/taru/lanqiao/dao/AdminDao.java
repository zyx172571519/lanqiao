package org.taru.lanqiao.dao;

import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.Admin;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

/**
 * ¹ÜÀíÔ±DAO²ã
 * @author CoCo
 *
 */
public class AdminDao {
	
	//µÇÂ¼
	public Admin adminLogin(String username, String password) {
		Admin admin = null;
		String sql = "select * from admin where username=? and password=?";
		List<HashMap<String, Object>> list  = SqlUtil.executeQuery(sql, "admin", "admin_123456");
		if(list.size()>0) {
			admin = new Admin();
			admin.setUsername(StringUtil.isnull(list.get(0).get("username")).toString());
			admin.setPassword(StringUtil.isnull(list.get(0).get("password")).toString());
			admin.setId(Integer.valueOf(StringUtil.isnull(list.get(0).get("id")).toString()));
			admin.setEmail(StringUtil.isnull(list.get(0).get("realname")).toString());
			admin.setRealname(StringUtil.isnull(list.get(0).get("username")).toString());
			admin.setTelphone(StringUtil.isnull(list.get(0).get("telphone")).toString());
		}
		SqlUtil.close();
		return admin;
	}
	
	//×¢²á
	public int adminRegist(Admin admin) {
		String username = StringUtil.isnull(admin.getUsername()).toString();
		String password = StringUtil.isnull(admin.getPassword()).toString();
		String realname = StringUtil.isnull(admin.getRealname()).toString();
		String telphone = StringUtil.isnull(admin.getTelphone()).toString();
		String email = StringUtil.isnull(admin.getEmail()).toString();
		String sql = "insert into admin (username,password,telphone,email,realname) values(?,?,?,?,?)";
		int status = SqlUtil.executeUpdate(sql, username, password, telphone, email, realname);
		SqlUtil.close();
		return status;
	}
}
