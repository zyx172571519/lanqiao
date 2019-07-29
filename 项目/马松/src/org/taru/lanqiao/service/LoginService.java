package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.AddDao;
import org.taru.lanqiao.dao.ProductDaoImpl;

public class LoginService {
    
	public List login(String username,String password) {
		ProductDaoImpl ss=new ProductDaoImpl();
		 List list=ss.queryLogin(username, password);
		 return list;	 
	}
	
}
