package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.dao.UserDaoImpl;
import org.taru.lanqiao.model.PageProduct;
import org.taru.lanqiao.model.PageResult;
import org.taru.lanqiao.model.Product;


/**
 * 
 * ����id��ѯ��Ʒ����
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
	 * ��ѯ�û����������Ʒ
	 * @param userId
	 * @return
	 */
	public Product userOld(String userId) {
		ProductDaoImpl pdimpl=new ProductDaoImpl();   
		return pdimpl.queryUserId(userId);
	}
	
	/**
	 * 
	 * �������Ͳ�ѯ��Ʒ
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
