package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.UserDaoImpl;
import org.taru.lanqiao.dao.productDaoImpl;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.model.User;

public class UserServiceImpl {
	/**
	 * ��ѯ�û��������ID
	 */

	
		public User queryUserById(String id) {
			UserDaoImpl daoimpl=new UserDaoImpl();
		return daoimpl.queryId(id);

	
}


}
