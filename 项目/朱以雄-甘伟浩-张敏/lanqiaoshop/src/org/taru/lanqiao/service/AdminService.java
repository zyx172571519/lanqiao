package org.taru.lanqiao.service;

import org.taru.lanqiao.model.Admin;

/**
 * ����ԱService��
 * @author CoCo
 *
 */
public interface AdminService {
	//	����Ա��¼
	Admin adminLogin(String username, String password);
	
	//����Աע��
	int adminRegist(Admin admin);
}
