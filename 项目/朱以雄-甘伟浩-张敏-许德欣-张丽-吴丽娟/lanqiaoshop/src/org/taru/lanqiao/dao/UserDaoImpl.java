package org.taru.lanqiao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.model.User;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

/**
 * 
 * 
 * @author zm
 */
public class UserDaoImpl {
	//输入用户名，密码进行用户登录
	public User querylogin(String username,String password) {
		String sql="select * from user where USER_USER_NAME=? and USER_PASSWORD=?";
		List<HashMap<String,Object>>  list=SqlUtil.executeQuery(sql,username,password);
		System.out.println(list);
		User user=null;
		if(list.size()>0) {
			user=new User();
			user.setUserId(StringUtil.valueOf(list.get(0).get("USER_ID")));
			user.setUserUserName(StringUtil.valueOf(list.get(0).get("USER_USER_NAME")));
			user.setUserPassword(StringUtil.valueOf(list.get(0).get("USER_PASSWORD")));	
		}	
		return  user;
	}

	
	//注册用户
	public int queryRegister(String userId,String userUserName,String userPassword,String userTelphone,String userAddress,String userShopName) {
		userId=UUID.randomUUID().toString();
		String sql="insert into user(USER_ID,USER_USER_NAME,USER_PASSWORD,USER_TELPHONE,USER_ADDRESS,USER_SHOP_NAME) values(?,?,?,?,?,?)";
		int  u=SqlUtil.executeUpdate(sql, userId,userUserName,userPassword,userTelphone,userAddress,userShopName);
		return u;
	}
	
	/**
	 * 根据用户ID查详情
	 */ 
	public User queryId(String id) {
		String sql="select * from user where USER_ID=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,id);
		User user=null;
		if(list.size()>0) {
			user=new User();
			user.setUserId(StringUtil.valueOf(list.get(0).get("USER_ID")));//判断是否有空
			user.setUserUserName(StringUtil.valueOf(list.get(0).get("USER_USER_NAME")));
			user.setUserTelphone(StringUtil.valueOf(list.get(0).get("USER_TELPHONE")));
			user.setUserAddress(StringUtil.valueOf(list.get(0).get("USER_ADDRESS")));
		}
		return user;
	}
}
