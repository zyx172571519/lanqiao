package org.taru.lanqiao.service;

import java.util.UUID;

import org.taru.lanqiao.dao.UserDaoImpl;
import org.taru.lanqiao.model.User;
/**
 * 
 * 根据用户名密码登录
 * @author zm
 *
 */
public class UserServiceImpl {
	public User userLogin(String username,String password) {
		UserDaoImpl uimpl=new UserDaoImpl();
		return  uimpl.querylogin(username, password);
	}
	

	
/**
 * 
 * 注册用户	
 * @param userId
 * @param userUserName
 * @param userPassword
 * @param userTelphone
 * @param userAddress
 * @param userShopName
 * @return
 */
public int userRegister(String userId,String userUserName,String userPassword,String userTelphone,String userAddress,String userShopName) {
		UserDaoImpl uimpl=new UserDaoImpl();
		int u=uimpl.queryRegister(userId, userUserName, userPassword, userTelphone, userAddress, userShopName);
		return  u; 
	}

}
