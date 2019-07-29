package org.taru.lanqiao.service;

import java.math.BigDecimal;
import java.util.List;

import org.taru.lanqiao.dao.productDaoImpl;
import org.taru.lanqiao.model.OrderDetail;
import org.taru.lanqiao.model.PageProduct;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.vo.PageResult;
import org.taru.lanqiao.vo.productAll;
import org.taru.lanqiao.vo.shopCar;

public class productServiceImpl {
	/**
	 * 
	 * @param productId
	 * @������ƷID��ѯ��Ʒ����
	 */
	public Product queryById(String productId) {
		productDaoImpl product=new productDaoImpl();
		return product.queryById(productId);
	}
	
	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @��ѯ������Ʒ�������з�ҳ
	 */
	public PageResult productList(int pageNum,int pageSize) {
		productDaoImpl daoImpl=new productDaoImpl();
		return daoImpl.productList(pageNum, pageSize);
	}
	
	/**
	 * 
	 * @param uId
	 * @��ѯ���ﳵ
	 */
	public shopCar queryByUid(String uId) {
		productDaoImpl daoImpl=new productDaoImpl();
		return daoImpl.queryByUid(uId); 
	}
	
	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param categoryId
	 * @param productName
	 * @param isLack
	 * @����Ա��ѯ������Ʒ
	 */
	public productAll queryProductAll(int pageNum,int pageSize,String categoryId,String productName,String productisLack) {
		productDaoImpl daoImpl=new productDaoImpl();
		return daoImpl.queryProductAll(pageNum, pageSize, categoryId, productName, productisLack);
	}
	
	/**
	 * 
	 * @param product
	 * @������Ʒ
	 */
	public int insertProduct(String id,Product product) {
		productDaoImpl daoImpl=new productDaoImpl();
		return daoImpl.insertProduct(id, product);
	}
	
	/**
	 * 
	 * @param productId
	 * @����Ա�Ƴ���Ʒ���ϳ���Ʒ
	 */
	public int deleteProductById(String productId) {
		productDaoImpl daoImpl=new productDaoImpl();
		return daoImpl.deleteProductById(productId);
	}
	
	/**
	 * 
	 * @param productId
	 * @����id��ѯ������Ʒ
	 */
	public Product queryProductOne(String productId) {
		productDaoImpl daoImpl=new productDaoImpl();
		return daoImpl.queryProductOne(productId);
	}
	
	/**
	 * ��ѯ�û����������Ʒ
	 * @param userId
	 * @return
	 */
	public Product userOld(String userId) {
		productDaoImpl pdimpl=new productDaoImpl();   
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
		productDaoImpl  daoImpl=new productDaoImpl();
		return daoImpl.selectCategoryId(categoryId, pageNum, pageSize);
	}
	
}
