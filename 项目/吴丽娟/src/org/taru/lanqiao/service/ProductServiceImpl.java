package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.productDaoImpl;
import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.PageResult;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;

/**
 * ��ѯ��Ʒ�������ID
 */

public class ProductServiceImpl {
	public Product queryProductById(String id) {
	productDaoImpl daoimpl=new productDaoImpl();
	return daoimpl.queryId(id);
}
	
	/**
	 * ��Ʒ��ҳ
	 */
	public PageResult queryList(int pageNum,int pageSize) {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.queryListByPage(pageNum, pageSize);

	}
	
	/**
	 * ��ѯ��Ʒ���
	 */
	public List queryCategoryList() {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.queryCategoryId();

	}
	

	/**
	 * �Ƴ����ﳵ
	 */
	
	public int deleteOrder(String id) {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.deleteOrderById(id);

	}
	
	/**
	 * �ύ����
	 */
	public int commint(String orderUserId,String orderTotalPrice,String orderComment) {
		productDaoImpl daoimpl=new productDaoImpl();
		return daoimpl.commentCar(orderUserId, orderTotalPrice, orderComment);
	}
	
	
	
	
	
	
	
	
	
	
	
}