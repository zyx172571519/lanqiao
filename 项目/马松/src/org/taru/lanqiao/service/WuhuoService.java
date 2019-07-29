package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ModifyDao;
import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.model.Dingdan;

public class WuhuoService {
	public void Wuhuo(String id) {
		ModifyDao  dao=new ModifyDao();
		dao.ModifyById(id);
	    System.out.println("³É¹¦");
	}
}
