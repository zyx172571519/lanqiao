package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.UserDaoImpl;
import org.taru.lanqiao.dao.UserLoginDaoImpl;
import org.taru.lanqiao.model.User;

public class UserLoginServinceImpl {
	/**
	 * 根据用户名和密码登录
	 */

	
		public User queryUserById(String username,String password) {
			UserLoginDaoImpl daoimpl=new UserLoginDaoImpl();
		return daoimpl.queryId(username,password);
	
}
}
