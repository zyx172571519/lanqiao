package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.productDaoImpl;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.vo.PageResult;

public class productServiceImpl {

	/**
	 * ÐÞ¸ÄÉÌÆ·
	 * @param product
	 * @return
	 */
	public int update(Product product){
		productDaoImpl impl=new productDaoImpl();
		return impl.updateProduct(product);
	}
	}
