package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.QueryYearDao;
import org.taru.lanqiao.model.Dingdan;

public class QueryDd1Service {
	  public Dingdan queryDd1(String orderid) {
	    	QueryYearDao s = new QueryYearDao();
	    	   return  s.Queryorder1(orderid);	
	    }

	
	
}
