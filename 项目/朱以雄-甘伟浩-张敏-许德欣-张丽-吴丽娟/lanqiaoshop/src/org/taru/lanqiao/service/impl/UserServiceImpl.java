package org.taru.lanqiao.service.impl;

import java.util.UUID;

import org.taru.lanqiao.dao.UserDao;
import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.UserService;
import org.taru.lanqiao.util.PageHelper;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDao();
	@Override
	public PageHelper userSelectAll(int pageNum, int pageSize, String telphone, String shopName) {
		
		PageHelper ph = userDao.userSelectAll(pageNum, pageSize, telphone, shopName);
		return ph;
	}

	@Override
	public User userFindById(String id) {
		User user = userDao.userFindById(id);
		return user;
	}

	@Override
	public int userAdd(User user) {
		String uuid= UUID.randomUUID().toString();
		user.setUserId(uuid);
		user.setUserStatus((byte) 1);
		int i = userDao.userAdd(user);
		return i;
	}
	
	@Override
	public int userDelete(String id) {
		int status = 0;
		int i = userDao.userDelete(id, status);
		return i;
	}

	@Override
	public int userUpdate(User user) {
		int i = userDao.userUpdate(user);
		return i;
	}



}
