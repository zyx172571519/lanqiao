package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.dao.QueryYearDao;
import org.taru.lanqiao.model.Dingdan;

public class YearService {
	public List  queryYear(String year) {
	 QueryYearDao yy= new QueryYearDao();
	 return yy.QueryYear(year);
	}
}
