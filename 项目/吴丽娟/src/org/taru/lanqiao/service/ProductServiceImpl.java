package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.productDaoImpl;
import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.PageResult;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;

/**
 * 查询商品详情根据ID
 */

public class ProductServiceImpl {
	public Product queryProductById(String id) {
	productDaoImpl daoimpl=new productDaoImpl();
	return daoimpl.queryId(id);
}
	
	/**
	 * 商品分页
	 */
	public PageResult queryList(int pageNum,int pageSize) {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.queryListByPage(pageNum, pageSize);

	}
	
	/**
	 * 查询商品类别
	 */
	public List queryCategoryList() {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.queryCategoryId();

	}
	

	/**
	 * 移除购物车
	 */
	
	public int deleteOrder(String id) {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.deleteOrderById(id);

	}
	
	/**
	 * 提交订单
	 */
	public int commint(String orderUserId,String orderTotalPrice,String orderComment) {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.commentCar(orderUserId, orderTotalPrice, orderComment);
	}
	
	
	
	
	
	
	
	
	
	
	
}