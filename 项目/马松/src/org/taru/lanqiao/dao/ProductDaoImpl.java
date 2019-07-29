package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.taru.lanqiao.model.Dingdan;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.DbUtil;
import org.taru.lanqiao.vo.PageResult;

/**
 * 商品dao
 * 商品的增删改查
 * @author 
 *
 */
public class ProductDaoImpl {
	
	/**
	 * 根据ID查询商品详情
	 * @param id
	 * @return
	 */
	public Product  queryById(String id){
		String  sql="select *   from   product  where  PRODUCT_ID =?";
		List<Map<String,Object>>   list=  DbUtil.query(sql, id);
		System.out.println(list);
		Product  product=null;
		if(list.size()>0){
			product =new Product();
			product.setProductId(list.get(0).get("PRODUCT_ID").toString());  //没有判断是否为null值
			product.setProductName(list.get(0).get("PRODUCT_NAME").toString());
			product.setProductPhoto(list.get(0).get("PRODUCT_PHOTO").toString());
			product.setProductDateTime(list.get(0).get("PRODUCT_DATE_TIME").toString());
			product.setProductId(list.get(0).get("PRODUCT_BRAND_ID").toString());
			product.setProductLargerStandard(list.get(0).get("PRODUCT_LARGER_STANDARD").toString());
		}
		return   product;	
	}
	/**
	 * 
	 * 查询所有订单
	 * detailTotalPrice;
	private String detailUserId;
	private String detailDateTime;
	 */
	public Dingdan queryDingdan(int pageNum,int pageSize) {
		String  sql="select  *  from  order_detail  limit ?,?";
		List<Map<String,Object>>  list=  DbUtil.query(sql,pageNum,pageSize);
		List<Dingdan> list2=new ArrayList<Dingdan>();
		
		for(int i=0;i<list.size();i++) {
			Dingdan dingdan =new Dingdan();
			 dingdan.setDetailId(list.get(i).get("DETAIL_ID").toString());
			 dingdan.setDetailTotalPrice(list.get(i).get("DETAIL_TOTAL_PRICE").toString());
			 dingdan.setDetailUserId(list.get(i).get("DETAIL_USER_ID").toString());
			 dingdan.setDetailDateTime(list.get(i).get("DETAIL_DATE_TIME").toString());
			 list2.add(dingdan);
		}
		Dingdan dingdan=new Dingdan();
		dingdan.setList(list2);
		String sql2="select count(*) as row from product";
		List<Map<String,Object>> countList =DbUtil.query(sql2);
		String count=String.valueOf(countList.get(0).get("row"));
		int size=Integer.parseInt(count);
		dingdan.setPages(size%pageSize==0?size/pageSize:size/pageSize+1);
		dingdan.setTotal(size);
		return  dingdan;
	}
	
	/**
	 * 查询用户登入
	 */
	
	  public List queryLogin(String username,String password) {
		  String sql="SELECT * FROM user where USER_USER_NAME=? and USER_PASSWORD=?";
		  List list=  DbUtil.query(sql,username,password);
		  return list;
	  }
}
