package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.QueryYearDao;
import org.taru.lanqiao.model.Dingdan;

public class QueryDdService {
    public Dingdan queryDd(String orderid) {
    	QueryYearDao s = new QueryYearDao();
    	   return  s.Queryorder(orderid);
    		
    }

}
