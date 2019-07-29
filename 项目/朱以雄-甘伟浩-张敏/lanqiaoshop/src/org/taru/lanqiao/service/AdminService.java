package org.taru.lanqiao.service;

import org.taru.lanqiao.model.Admin;

/**
 * 管理员Service层
 * @author CoCo
 *
 */
public interface AdminService {
	//	管理员登录
	Admin adminLogin(String username, String password);
	
	//管理员注册
	int adminRegist(Admin admin);
}
