package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.model.Product;

/**
 * ��Ʒҵ����
 * ���� ��ѯ��Ʒ    ������Ʒ  �ϼ���Ʒ  
 * @author Administrator
 *
 */
public class ProductServiceImpl {

	/**
	 * ��ѯ��Ʒ�������Id
	 * @param id   ��Ʒ���
	 * @return
	 */
	public  Product   queryProductById(String id){
		ProductDaoImpl   daoImpl  =new ProductDaoImpl();
		return daoImpl.queryById(id);
	}
}
