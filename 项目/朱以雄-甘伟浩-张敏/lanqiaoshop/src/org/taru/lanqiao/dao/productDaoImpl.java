package org.taru.lanqiao.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.taru.lanqiao.util.StringUtil;
import org.taru.lanqiao.vo.PageResult;
import org.taru.lanqiao.vo.productAll;

import org.taru.lanqiao.vo.shopCar;
import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.OrderDetail;
import org.taru.lanqiao.model.Other_Data;
import org.taru.lanqiao.model.PageProduct;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;

public class productDaoImpl {
	/**
	 * 
	 * @param productId
	 * @根据商品ID查询商品详情
	 */
	public Product queryById(String productId) {
		String sql="select * from product where PRODUCT_ID=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,productId);
		Product product=null;
			if(list.size()>0) {
				product=new Product();
				product.setProductId(StringUtil.valueOf(list.get(0).get("PRODUCT_ID")));
				product.setProductName(StringUtil.valueOf(list.get(0).get("PRODUCT_NAME")));
				product.setProductLargerUnit(StringUtil.valueOf(list.get(0).get("PRODUCT_LARGER_UNIT")));
				product.setProductIsLack(Byte.parseByte(StringUtil.valueOf(list.get(0).get("PRODUCT_IS_SALE").toString())));
				product.setProductIsSale(Byte.parseByte(StringUtil.valueOf(list.get(0).get("PRODUCT_IS_SALE").toString())));
				
			}
			SqlUtil.close();
		return product;
	}
	
	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @查询商品列表并带分页(客户端)
	 */
	public PageResult productList(int pageNum,int pageSize) {
		String sql="select * from product limit ?,?";
		ArrayList<HashMap<String, Object>> list=SqlUtil.executeQuery(sql, (pageNum-1)*pageSize,pageSize);
		List<Product> list2=new ArrayList<Product>();
		
		for(int i=0;i<list.size();i++) {
			Product product=new Product();
			product.setProductId(StringUtil.valueOf(list.get(i).get("PRODUCT_ID")));
			product.setProductName(StringUtil.valueOf(list.get(i).get("PRODUCT_NAME")));
			product.setProductSmallUnit(StringUtil.valueOf(list.get(0).get("PRODUCT_SMALL_UNIT")));
			list2.add(product);
		}
		PageResult pageresult=new PageResult();
		pageresult.setList(list2);
		pageresult.setPageNum(pageNum);
		pageresult.setPageSize(pageSize);
		
		String sql2="select count(*) as row from product";
		List<HashMap<String, Object>> countList=SqlUtil.executeQuery(sql2);
		String count=String.valueOf(countList.get(0).get("row"));
		int size=Integer.parseInt(count);
		pageresult.setTotal(size);
		pageresult.setPages(size%pageSize==0?size/pageSize:size/pageSize+1);
		return pageresult;
		
		
	}
	
	/**
	 * 
	 * @param uId
	 * @关联关系 查询购物车
	 */
	public shopCar queryByUid(String uId) {
		String sql="select * from  product left join order_detail on order_detail.DETAIL_PRODUCT_ID=product.PRODUCT_ID left join user on order_detail.DETAIL_USER_ID=user.USER_ID where USER_ID=?";
		List<HashMap<String,Object>> list=SqlUtil.executeQuery(sql, uId);
		List<Product> list2=new ArrayList<Product>();
		if(list.size()>0) {
		for(int i=0;i<list.size();i++) {
			Product product=new Product();
			product.setProductName(StringUtil.valueOf(list.get(i).get("PRODUCT_NAME")));
			product.setProductPhoto(StringUtil.valueOf(list.get(i).get("PRODUCT_PHOTO")));
			product.setProductBrandId(StringUtil.valueOf(list.get(i).get("PRODUCT_BRAND_ID")));
			product.setProductCategoryId(StringUtil.valueOf(list.get(i).get("PRODUCT_CATEGORY_ID")));
			product.setProductCode(StringUtil.valueOf(list.get(i).get("PRODUCT_CODE")));
			//product.setProductDateTime( (StringUtil.valueOf(list.get(i).get("PRODUCT_DATE_TIME"))));
			product.setProductId(StringUtil.valueOf(list.get(i).get("PRODUCT_ID")));
			product.setProductIsLack(Byte.parseByte(StringUtil.valueOf(list.get(i).get("PRODUCT_IS_LACK"))));
			product.setProductIsSale(Byte.parseByte(StringUtil.valueOf(list.get(i).get("PRODUCT_IS_SALE"))));
			product.setProductLargerStandard(StringUtil.valueOf(list.get(i).get("PRODUCT_LARGER_STANDARD")));
			product.setProductLargerUnit(StringUtil.valueOf(list.get(i).get("PRODUCT_LARGER_UNIT")));
			product.setProductOrder(Integer.parseInt(StringUtil.valueOf(list.get(i).get("PRODUCT_ORDER"))));
			product.setProductSmallUnit(StringUtil.valueOf(list.get(i).get("PRODUCT_SMALL_UNIT")));
			product.setProductStatus(Byte.parseByte(StringUtil.valueOf(list.get(i).get("PRODUCT_STATUS"))));
			list2.add(product);
		}
		}
		shopCar shopcar=new shopCar();
		shopcar.setDetailId(StringUtil.valueOf(list.get(0).get("DETAIL_ID")));
		shopcar.setDetailOrderId(StringUtil.valueOf(list.get(0).get("DETAIL_ORDER_ID")));
		shopcar.setDetailComment(StringUtil.valueOf(list.get(0).get("DETAIL_COMMENT")));
		shopcar.setDetailProductCount(Integer.parseInt(StringUtil.valueOf(list.get(0).get("DETAIL_PRODUCT_COUNT"))));
		shopcar.setDetailProductId(StringUtil.valueOf(list.get(0).get("DETAIL_PRODUCT_ID")));
		shopcar.setDetailProductUnit(StringUtil.valueOf(list.get(0).get("DETAIL_PRODUCT_UNIT")));
		shopcar.setDetailStatus(Byte.parseByte(StringUtil.valueOf(list.get(0).get("DETAIL_STATUS"))));
		shopcar.setDetailUserId(StringUtil.valueOf(list.get(0).get("DETAIL_USER_ID")));
		shopcar.setList(list2);
		return shopcar;
	}
	
	/**
	 * 
	 * @param uId
	 * @HashMap查询购物车
	 */
	public List queryByUid2(String uId) {
		String sql="select * from  product left join order_detail on order_detail.DETAIL_PRODUCT_ID=product.PRODUCT_ID left join user on order_detail.DETAIL_USER_ID=user.USER_ID where USER_ID=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql, uId);
		List<shopCar> list2=new ArrayList<shopCar>();
		return list2;
	}
	
	/**
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param categoryId
	 * @param productName
	 * @param isLack
	 * @管理员查询所有商品
	 */
	public productAll queryProductAll(int pageNum,int pageSize,String categoryId,String productName,String productisLack) {
		String sql="select * from  product left join category on product.PRODUCT_CATEGORY_ID=category.CATEGORY_ID limit ?,?";
		List<HashMap<String, Object>> list= SqlUtil.executeQuery(sql,(pageNum-1)*pageSize,pageSize/*,categoryId,productisLack*/);
		List list2=new ArrayList();
		for(int i=0;i<list.size();i++) {
			Product product=new Product();
			product.setProductId(StringUtil.valueOf(list.get(i).get("PRODUCT_ID")));
			product.setProductName(StringUtil.valueOf(list.get(i).get("PRODUCT_NAME")));
			product.setProductPhoto(StringUtil.valueOf(list.get(i).get("PRODUCT_PHOTO")));
			product.setProductBrandId(StringUtil.valueOf(list.get(i).get("PRODUCT_BRAND_ID")));
			product.setProductCategoryId(StringUtil.valueOf(list.get(i).get("PRODUCT_CATEGORY_ID")));
			product.setProductCode(StringUtil.valueOf(list.get(i).get("PRODUCT_CODE")));
			//product.setProductDateTime( (StringUtil.valueOf(list.get(i).get("PRODUCT_DATE_TIME"))));
			product.setProductIsLack(Byte.parseByte(StringUtil.valueOf(list.get(i).get("PRODUCT_IS_LACK"))));
			product.setProductIsSale(Byte.parseByte(StringUtil.valueOf(list.get(i).get("PRODUCT_IS_SALE"))));
			product.setProductLargerStandard(StringUtil.valueOf(list.get(i).get("PRODUCT_LARGER_STANDARD")));
			product.setProductLargerUnit(StringUtil.valueOf(list.get(i).get("PRODUCT_LARGER_UNIT")));
			product.setProductOrder(Integer.parseInt(StringUtil.valueOf(list.get(i).get("PRODUCT_ORDER"))));
			product.setProductSmallUnit(StringUtil.valueOf(list.get(i).get("PRODUCT_SMALL_UNIT")));
			product.setProductStatus(Byte.parseByte(StringUtil.valueOf(list.get(i).get("PRODUCT_STATUS"))));
			Category category=new Category();
			category.setCategoryId(StringUtil.valueOf(list.get(i).get("CATEGORY_ID")));
			category.setCategoryName(StringUtil.valueOf(list.get(i).get("CATEGORY_NAME")));
			category.setCategoryOrder(Integer.parseInt(StringUtil.valueOf(list.get(i).get("CATEGORY_ORDER"))));
			category.setCategoryStatus(Byte.parseByte(StringUtil.valueOf(list.get(i).get("CATEGORY_STATUS"))));
			product.setCategory(category);
			list2.add(product);
		}
		productAll productall=new productAll();
		productall.setPageNum(pageNum);
		productall.setPageSize(pageSize);
		String sql1="select count(*) as row from  product left join category on product.PRODUCT_CATEGORY_ID=category.CATEGORY_ID";
		List<HashMap<String, Object>> num=SqlUtil.executeQuery(sql1);
		String n=String.valueOf(num.get(0).get("row"));
		int row= Integer.parseInt(n);
		productall.setTotal(row);
		productall.setPages(row%pageSize==0?row/pageSize:row/pageSize+1);
		productall.setList(list2);
		return productall;
	}
	
	/**
	 * 
	 * @param product
	 * @管理员新增商品
	 */
	public int insertProduct(String id,Product product) {
		id=UUID.randomUUID().toString();
		String sql="insert into product(PRODUCT_ID,PRODUCT_CODE,PRODUCT_NAME,PRODUCT_STANDARD,PRODUCT_SMALL_UNIT,PRODUCT_SMALL_PRICE,PRODUCT_LARGER_UNIT,PRODUCT_LARGER_PRICE,PRODUCT_CATEGORY_ID,PRODUCT_BRAND_ID,PRODUCT_PHOTO,PRODUCT_IS_SALE,PRODUCT_IS_LACK,PRODUCT_STATUS,PRODUCT_ORDER,PRODUCT_LARGER_STANDARD,PRODUCT_SUGGEST_PRICE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int row=SqlUtil.executeUpdate(sql,id,product.getProductCode(),product.getProductName(),product.getProductLargerStandard(),product.getProductSmallUnit(),product.getProductSmallPrice(),product.getProductLargerUnit(),product.getProductLargerPrice(),product.getProductCategoryId(),product.getProductBrandId(),product.getProductPhoto(),product.getProductIsSale(),product.getProductIsLack(),product.getProductStatus(),product.getProductOrder(),product.getProductLargerStandard(),product.getProductSuggestPrice());
		return row;
	}
	
	/**
	 * 
	 * @param productId
	 * @管理员商品作废或删除
	 */
	public int deleteProductById(String productId) {
		String sql="update product set PRODUCT_STATUS=0 where PRODUCT_ID=?";
		int row=SqlUtil.executeUpdate(sql, productId);
		return row;
	}
	
/**
 * 
 * @param productId
 * @根据id查询单个商品
 */
	public Product queryProductOne(String productId) {
		String sql="select * from product left join other_data on product.PRODUCT_ID=other_data.data_product_id where product.PRODUCT_ID=?";
		List<HashMap<String,Object>> list=SqlUtil.executeQuery(sql,productId);
		List<Other_Data> list2=new ArrayList<Other_Data>();
		Product product=null;
		if(list.size()>0) {
			product=new Product();
			Other_Data other_data=new Other_Data();
			product.setProductId(StringUtil.valueOf(list.get(0).get("PRODUCT_ID")));
			product.setProductName(StringUtil.valueOf(list.get(0).get("PRODUCT_NAME")));
			product.setProductPhoto(StringUtil.valueOf(list.get(0).get("PRODUCT_PHOTO")));
			product.setProductBrandId(StringUtil.valueOf(list.get(0).get("PRODUCT_BRAND_ID")));
			product.setProductCategoryId(StringUtil.valueOf(list.get(0).get("PRODUCT_CATEGORY_ID")));
			product.setProductCode(StringUtil.valueOf(list.get(0).get("PRODUCT_CODE")));
			//product.setProductDateTime( (StringUtil.valueOf(list.get(i).get("PRODUCT_DATE_TIME"))));
			product.setProductIsLack(Byte.parseByte(StringUtil.valueOf(list.get(0).get("PRODUCT_IS_LACK"))));
			product.setProductIsSale(Byte.parseByte(StringUtil.valueOf(list.get(0).get("PRODUCT_IS_SALE"))));
			product.setProductLargerStandard(StringUtil.valueOf(list.get(0).get("PRODUCT_LARGER_STANDARD")));
			product.setProductLargerUnit(StringUtil.valueOf(list.get(0).get("PRODUCT_LARGER_UNIT")));
			product.setProductOrder(Integer.parseInt(StringUtil.valueOf(list.get(0).get("PRODUCT_ORDER"))));
			product.setProductSmallUnit(StringUtil.valueOf(list.get(0).get("PRODUCT_SMALL_UNIT")));
			product.setProductStatus(Byte.parseByte(StringUtil.valueOf(list.get(0).get("PRODUCT_STATUS"))));
			other_data.setData_id(StringUtil.valueOf(list.get(0).get("data_id")));
			other_data.setData_name(StringUtil.valueOf(list.get(0).get("data_name")));
			other_data.setData_product_id(StringUtil.valueOf(list.get(0).get("data_product_id")));
			other_data.setData_value(StringUtil.valueOf(list.get(0).get("data_value")));
			list2.add(other_data);
			product.setList(list2);
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
		
}
