package org.taru.lanqiao.service.impl;

import org.taru.lanqiao.dao.AdminDao;
import org.taru.lanqiao.model.Admin;
import org.taru.lanqiao.service.AdminService;


/**
 * ����ԱServiceImpl��
 * @author CoCo
 *
 */
public class AdminServiceImpl implements AdminService{
	AdminDao adminDao = new AdminDao();
	
	//����Ա��¼
	@Override
	public Admin adminLogin(String username, String password) {
		
		Admin admin = adminDao.adminLogin(username, password);
		
		return admin;
	}
	
	//����Աע��
	@Override
	public int adminRegist(Admin admin) {
		
		int status = adminDao.adminRegist(admin);
		
		return status;
	}
	
}
