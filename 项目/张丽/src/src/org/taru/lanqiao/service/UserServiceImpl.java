package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.UserDaoImpl;
import org.taru.lanqiao.model.User;
/**
 * �û���¼
 */
public class UserServiceImpl {
	public User login(String username,String password){
		UserDaoImpl daoImpl =new UserDaoImpl();
		return daoImpl.queryByUandPwd(username, password);
		
	}
}
