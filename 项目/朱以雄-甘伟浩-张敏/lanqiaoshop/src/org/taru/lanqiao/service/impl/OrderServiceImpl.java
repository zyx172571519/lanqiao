package org.taru.lanqiao.service.impl;

import java.text.ParseException;
import java.util.List;

import org.taru.lanqiao.dao.YearDao;
import org.taru.lanqiao.service.OrderService;

public class OrderServiceImpl implements OrderService {
	YearDao yearDao = new YearDao();
	
	@Override
	public List selectTop(String year) {
		List list ;
		
		try {
			list = yearDao.selectTop(year);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list = null;
		}
		return list;
	}

}
