package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.PageProduct;
import org.taru.lanqiao.model.PageResult;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;
import org.taru.lanqiao.model.OrderDetail;
/**
 * 
 * 
 * @author zm
 *
 */
public class ProductDaoImpl {
	public Product queryById(String id){
		String sql="select * from product where PRODUCT_ID=?";   //根据id查询商品详情
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,id);
		System.out.println(list);
		Product product=null;
		if(list.size()>0) {
			product=new Product();
			product.setProductId(StringUtil.valueOf(list.get(0).get("PRODUCT_ID")));
			product.setProductName(StringUtil.valueOf(list.get(0).get("PRODUCT_NAME")));
			product.setProductPhoto(StringUtil.valueOf(list.get(0).get("PRODUCT_PHOTO")));
			product.setProductCode(StringUtil.valueOf(list.get(0).get("PRODUCT_CODE")));
			
		}
			return product;	
	}
	
	/**
	 * 
	 * 查询用户购买过的商品
	 */
	public Product queryUserId(String userId) {
		userId=UUID.randomUUID().toString();
		String sql="select * from order_detail where DETAIL_USER_ID=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql, userId);
		Product product=null;
		if(list.size()>0) {
			product=new Product();
			product.setDetailUserId(StringUtil.valueOf(list.get(0).get("DETAIL_USER_ID")));
		}
		return product;
	}
	
	/**
	 *根据类别查询商品 
	 * 
	 * 
	 */
	public PageProduct selectCategoryId(String categoryId,int pageNum,int pageSize) {
		String sql="select * from product where PRODUCT_CATEGORY_ID=? limit ?,?";
		//String sql="select * from product left join category on product.PRODUCT_CATEGORY_ID=category.CATEGORY_ID limit ?,?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql, categoryId, pageNum, pageSize);
		List<Product> list2=new ArrayList<Product>();
		PageProduct pageproduct=new PageProduct();
			for(int i=0;i<list.size();i++) {
				Product product=new Product();
				product.setProductId(StringUtil.valueOf(list.get(i).get("PRODUCT_ID")));
				product.setProductName(StringUtil.valueOf(list.get(i).get("PRODUCT_NAME")));
				product.setProductLargerUnit(StringUtil.valueOf(list.get(i).get("PRODUCT_LARGER_UNIT")));
				product.setProductPhoto(StringUtil.valueOf(list.get(i).get("PRODUCT_PHOTO")));
				list2.add(product);
			}
				pageproduct.setPageNum(pageNum);
				pageproduct.setPageSize(pageSize);
				String sql2="select count(*) as row from  product left join category on product.PRODUCT_CATEGORY_ID=category.CATEGORY_ID";
				List<HashMap<String, Object>> num=SqlUtil.executeQuery(sql2);
				String n=String.valueOf(num.get(0).get("row"));
				int row= Integer.parseInt(n);
				pageproduct.setTotal(row);
				pageproduct.setPages(row%pageSize==0?row/pageSize:row/pageSize+1);
				pageproduct.setList(list2);
				return pageproduct;			
	}
	/**
	 * 分页
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
//	public PageResult queryListByPage(int pageNum,int pageSize) {
//		String sql="select * from product limit ?,?";
//		List<HashMap<String,Object>> list=SqlUtil.executeQuery(sql, (pageNum-1)*pageSize,pageSize);
//		List<Product> list2=new ArrayList<Product>();
//		for(int i=0;i<list.size();i++){
//			Product product=new Product();
//			product.setProductId(StringUtil.valueOf(list.get(i).get("PRODUCT_ID")));
//			product.setProductName(StringUtil.valueOf(list.get(i).get("PRODUCT_NAME")));
//			product.setProductPhoto(StringUtil.valueOf(list.get(i).get("PRODUCT_PHOTO")));
//			list2.add(product);
//		}
//		PageResult pageResult=new PageResult();
//		pageResult.setList(list2);
//		pageResult.setPageNum(pageNum);
//		pageResult.setPageSize(pageSize);
//		
//		String sql2="select count(*) as row from product";
//		List<HashMap<String,Object>>  countList=SqlUtil.executeQuery(sql2);
//		String count=String.valueOf(countList.get(0).get("row"));
//		int size=Integer.parseInt(count);
//		return pageResult;
//	}

}

