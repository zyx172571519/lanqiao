package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.vo.PageResult;

/**
 * 商品业务类
 * 负责查询商品 废弃商品 上架商品
 * @author LENOVE
 *
 */
public class ProductServiceImpl {
	
	/**
	 * 商品分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult queryList(int pageNum, int pageSize) {
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.querListByPage(pageNum,pageSize);
	}
	/**
	 * 根据ID查询商品详情
	 * id为商品编号
	 */
	public Product queryProductById(String id){
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.queryById(id);
	}
	/**
	 * 模糊搜索商品
	 */
	public List<Product> queryProductByname(String name){
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.queryByName("%"+name+"%");
		
	}
	/**
	 *多条件查询
	 */
	public List<Product> queryProductByManay(String categoryId,String productIsLack,String orderStr){
		ProductDaoImpl daoImpl =new ProductDaoImpl();
		return daoImpl.queryByMany(categoryId,productIsLack,orderStr);
	}
} 
