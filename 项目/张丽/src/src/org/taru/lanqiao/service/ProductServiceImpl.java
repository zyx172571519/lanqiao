package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.vo.PageResult;

/**
 * ��Ʒҵ����
 * �����ѯ��Ʒ ������Ʒ �ϼ���Ʒ
 * @author LENOVE
 *
 */
public class ProductServiceImpl {
	
	/**
	 * ��Ʒ��ҳ��ѯ
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult queryList(int pageNum, int pageSize) {
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.querListByPage(pageNum,pageSize);
	}
	/**
	 * ����ID��ѯ��Ʒ����
	 * idΪ��Ʒ���
	 */
	public Product queryProductById(String id){
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.queryById(id);
	}
	/**
	 * ģ��������Ʒ
	 */
	public List<Product> queryProductByname(String name){
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.queryByName("%"+name+"%");
		
	}
	/**
	 *��������ѯ
	 */
	public List<Product> queryProductByManay(String categoryId,String productIsLack,String orderStr){
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.queryByMany(categoryId,productIsLack,orderStr);
	}
} 
