package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.dao.UserDaoImpl;
import org.taru.lanqiao.model.PageProduct;
import org.taru.lanqiao.model.PageResult;
import org.taru.lanqiao.model.Product;


/**
 * 
 * 根据id查询商品详情
 */
public class ProductServiceImpl {
	public Product queryProductById(String id) {
		ProductDaoImpl  daoImpl=new ProductDaoImpl();
		return daoImpl.queryById(id);	
	}
	
//	public PageResult queryListByPage(int pageNum,int pageSize) {
//		ProductDaoImpl  daoImpl=new ProductDaoImpl();
//		return daoImpl.queryListByPage(pageNum, pageSize);
//	}

	
	public PageResult queryList(int pageNum, int pageSize) {
		return null;
	}

	public int addOrder(String detailProductId) {

		return 0;
	}
	
	/**
	 * 查询用户购买过的商品
	 * @param userId
	 * @return
	 */
	public Product userOld(String userId) {
		ProductDaoImpl pdimpl=new ProductDaoImpl();   
		return pdimpl.queryUserId(userId);
	}
	
	/**
	 * 
	 * 根据类型查询商品
	 * @param categoryId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageProduct queryProductCid(String categoryId,int pageNum,int pageSize) {
		ProductDaoImpl  daoImpl=new ProductDaoImpl();
		return daoImpl.selectCategoryId(categoryId, pageNum, pageSize);
	}

		
}
