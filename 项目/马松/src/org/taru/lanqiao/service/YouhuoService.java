package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ModifyDao;

public class YouhuoService {
	public void youhuo(String id) {
		ModifyDao  dao=new ModifyDao();
		dao.ModifyById1(id);
	    System.out.println("³É¹¦");
	}
}
