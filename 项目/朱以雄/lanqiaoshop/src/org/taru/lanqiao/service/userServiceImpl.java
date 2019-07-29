package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.userDaoImpl;
import org.taru.lanqiao.model.User;

public class userServiceImpl {
	public int insertUser(String userId,String userUserName,String userPassword,String userTelphone,String userAddress,String userShopName) {
		userDaoImpl dao=new userDaoImpl();
		int num= dao.insertUser(userId,userUserName, userPassword, userTelphone, userAddress, userShopName); 
		return num;
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @ÓÃ»§µÇÂ¼
	 */
	public User login(String username,String password) {
		userDaoImpl daoImpl=new userDaoImpl();
		return daoImpl.queryByUnameAndPassword(username, password);
	}
}
