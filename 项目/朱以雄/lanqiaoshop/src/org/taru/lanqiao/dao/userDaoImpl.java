package org.taru.lanqiao.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class userDaoImpl {
	
	public int insertUser(String userId,String userUserName,String userPassword,String userTelphone,String userAddress,String userShopName) {
		userId=UUID.randomUUID().toString();
		String sql="insert into user(USER_ID,USER_USER_NAME,USER_PASSWORD,USER_TELPHONE,USER_ADDRESS,USER_SHOP_NAME) values(?,?,?,?,?,?)";
		int num=SqlUtil.executeUpdate(sql,userId,userUserName,userPassword,userTelphone,userAddress,userShopName);
		return num; 
	}
	
	public User queryByUnameAndPassword(String username,String password) {
		String sql="select * from user where USER_USER_NAME=? AND USER_PASSWORD=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql, username,password);
		User user=null;
		if(list!=null) {
			user=new User();
			user.setUserId(StringUtil.valueOf(list.get(0).get("USER_ID")));
			user.setUserUserName(StringUtil.valueOf(list.get(0).get("USER_USER_NAME")));
			user.setUserPassword(StringUtil.valueOf(list.get(0).get("USER_PASSWORD")));
			user.setUserStatus(Byte.parseByte(StringUtil.valueOf(list.get(0).get("USER_STATUS"))));
		}
		return user;
	}
}
