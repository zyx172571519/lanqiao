package org.taru.lanqiao.service;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.util.PageHelper;

public interface UserService {
	//查询用户列表
	PageHelper userSelectAll(int pageNum,int pageSize, String telphone, String shopName);
	
	//根据ID查询用户
	User userFindById(String id);
	
	//添加用户
	int userAdd(User user);
	
	//删除用户
	int userDelete(String id);
	
	//商城用户修改
	int userUpdate(User user);
}
