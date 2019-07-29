package org.taru.lanqiao.dao;

import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class UserLoginDaoImpl {
	/**
	 * 根据用户名和密码登录
	 */ 
	public User queryId(String username,String password) {
		
		String sql="select * from user where USER_USER_NAME=? and USER_PASSWORD=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,username,password);
		User user=null;
		if(list.size()>0) {
			user=new User();
			user.setUserId(StringUtil.valueOf(list.get(0).get("USER_ID")));//判断是否有空
			user.setUserUserName(StringUtil.valueOf(list.get(0).get("USER_USER_NAME")));
			user.setUserPassword(StringUtil.valueOf(list.get(0).get("USER_PASSWORD")));
			user.setUserTelphone(StringUtil.valueOf(list.get(0).get("USER_TELPHONE")));
			user.setUserAddress(StringUtil.valueOf(list.get(0).get("USER_ADDRESS")));
		}
		return user;
	}
}
