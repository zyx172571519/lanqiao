package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.model.Dingdan;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.vo.PageResult;

public class DingdanService {
	
	
	public Dingdan queryDingdan(int pageNum,int pageSize){
		ProductDaoImpl   daoImpl  =new ProductDaoImpl();
		return daoImpl.queryDingdan(pageNum, pageSize);
		}
	
}
