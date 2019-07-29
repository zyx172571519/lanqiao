package org.taru.lanqiao.service.impl;

import org.taru.lanqiao.dao.AdminDao;
import org.taru.lanqiao.model.Admin;
import org.taru.lanqiao.service.AdminService;


/**
 * 管理员ServiceImpl层
 * @author CoCo
 *
 */
public class AdminServiceImpl implements AdminService{
	AdminDao adminDao = new AdminDao();
	
	//管理员登录
	@Override
	public Admin adminLogin(String username, String password) {
		
		Admin admin = adminDao.adminLogin(username, password);
		
		return admin;
	}
	
	//管理员注册
	@Override
	public int adminRegist(Admin admin) {
		
		int status = adminDao.adminRegist(admin);
		
		return status;
	}
	
}
