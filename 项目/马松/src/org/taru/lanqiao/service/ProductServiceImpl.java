package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.model.Product;

/**
 * 商品业务类
 * 负责 查询商品    废弃商品  上架商品  
 * @author Administrator
 *
 */
public class ProductServiceImpl {

	/**
	 * 查询商品详情根据Id
	 * @param id   商品编号
	 * @return
	 */
	public  Product   queryProductById(String id){
		ProductDaoImpl   daoImpl  =new ProductDaoImpl();
		return daoImpl.queryById(id);
	}
}
