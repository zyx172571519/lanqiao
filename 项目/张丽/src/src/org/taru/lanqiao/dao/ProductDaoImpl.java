package org.taru.lanqiao.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;
import org.taru.lanqiao.vo.PageResult;

public class ProductDaoImpl {
	/**
	 * 查询商品带分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageResult  querListByPage(int pageNum,int pageSize){
		String sql="select * from product limit ?,?";
		List<HashMap<String, Object>> list =SqlUtil.executeQuery(sql,(pageNum-1)*pageSize,pageSize);
		List<Product> list2=new ArrayList<Product>();
		for(int i=0;i<list.size();i++){
			Product product=new Product();
			product.setProductId(StringUtil.valueOf(list.get(i).get("PRODUCT_ID")));
			product.setProductName(StringUtil.valueOf(list.get(i).get("PRODUCT_NAME")));
			product.setProductPhoto(StringUtil.valueOf(list.get(i).get("PRODUCT_PHOTO")));
			list2.add(product);
		}
		PageResult pageResult=new PageResult();
		pageResult.setList(list2);
		pageResult.setPageNum(pageNum);
		pageResult.setPageSize(pageSize);
		String sql2="select count(*) as row from product";
		List<HashMap<String, Object>> counlist =SqlUtil.executeQuery(sql2);
		String count =String .valueOf(counlist.get(0).get("row"));
		int size =Integer.parseInt(count);
		pageResult.setTotal(size);
		pageResult.setPages(size%pageSize==0?size/pageSize:size/pageSize+1);
		return pageResult;
	}
	/**
	 *根据ID查询商品详情
	 */
	public Product queryById(String id){
		
		String sql="select * from product where PRODUCT_ID =?";
		List<HashMap<String, Object>> list =SqlUtil.executeQuery(sql, id);
		Product product=null;
		if(list.size()>0){
			product=new Product();
			product.setProductId(list.get(0).get("PRODUCT_ID").toString());
			product.setProductName(list.get(0).get("PRODUCT_NAME").toString());
			product.setProductPhoto(list.get(0).get("PRODUCT_PHOTO").toString());
		}
		return product;
	}
	/**
	 * 模糊搜索商品
	 */
	public List<Product> queryByName(String name){
		
		String sql="select * from product where PRODUCT_NAME like ?";
		List<HashMap<String, Object>> list =SqlUtil.executeQuery(sql, name);
		List<Product> list2=new ArrayList<Product>();
		Product product=null;
		for(int i=0;i<list.size();i++){
			product=new Product();
			product.setProductId(list.get(i).get("PRODUCT_ID").toString());
			product.setProductName(list.get(i).get("PRODUCT_NAME").toString());
			product.setProductPhoto(list.get(i).get("PRODUCT_PHOTO").toString());
			list2.add(product);
		}
		return list2;
	}
	/**
	 * 多条件查询商品 
	 */
	public List<Product> queryByMany(String categoryId,String productIsLack ,String orderStr){
		String sql = null;
		if(orderStr!=null){
			if(orderStr.equals("desc")){
				sql="select * from product where PRODUCT_CATEGORY_ID = ? and PRODUCT_IS_LACK =? ORDER BY PRODUCT_SMALL_PRICE DESC";
			}else if(orderStr.equals("asc")){
				sql="select * from product where PRODUCT_CATEGORY_ID = ? and PRODUCT_IS_LACK =? ORDER BY PRODUCT_SMALL_PRICE ASC";
			}
		}else{
			sql="select * from product where PRODUCT_CATEGORY_ID = ? and PRODUCT_IS_LACK =? ";
		}
		List<HashMap<String, Object>> list =SqlUtil.executeQuery(sql,categoryId,productIsLack);
		List<Product> list2=new ArrayList<Product>();
		Product product=null;
		for(int i=0;i<list.size();i++){
			product=new Product();
			product.setProductId(list.get(i).get("PRODUCT_ID").toString());
			product.setProductName(list.get(i).get("PRODUCT_NAME").toString());
			product.setProductPhoto(list.get(i).get("PRODUCT_PHOTO").toString());
			product.setProductSmallPrice((BigDecimal) list.get(i).get("PRODUCT_SMALL_PRICE"));
			product.setProductCategoryId(list.get(i).get("PRODUCT_CATEGORY_ID").toString());
			list2.add(product);
		}
		return list2;
		
	}
	
	
}
