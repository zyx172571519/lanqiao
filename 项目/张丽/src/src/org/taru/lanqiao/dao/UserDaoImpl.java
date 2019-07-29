package org.taru.lanqiao.dao;

import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class UserDaoImpl {
	/**
	 * ÓÃ»§µÇÂ¼
	 */
	public User queryByUandPwd(String username,String password){
		String sql="select * from user where user_user_name=? and user_password=?";
		List<HashMap<String, Object>> list =SqlUtil.executeQuery(sql, username,password);
		User user=null;
		if(list.size()>0){
			user=new User();
			user.setUserId(StringUtil.valueOf(list.get(0).get("USER_ID")));
			user.setUserUserName(StringUtil.valueOf(list.get(0).get("USER_USER_NAME")));
			user.setUserShopName(StringUtil.valueOf(list.get(0).get("USER_SHOP_NAME")));
			user.setUserPassword(StringUtil.valueOf(list.get(0).get("USER_PASSWORD")));
		}
		return user;
		
	}
}
