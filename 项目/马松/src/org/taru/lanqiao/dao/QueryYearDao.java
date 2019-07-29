package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.taru.lanqiao.model.Dingdan;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.model.Year;
import org.taru.lanqiao.util.DbUtil;
import org.taru.lanqiao.vo.JsonResult;

public class QueryYearDao {
	
	
	/**
	 * 按年度统计商品销售排行
	 * @author Administrator
	 *
	 */

     public List QueryYear(String year) {
    	 String Q=year+"-01-01";
    	 String H=year+"-12-31";
    	     String sql="select PRODUCT_NAME,SUM(DETAIL_TOTAL_PRICE) as SUMER from order_detail \r\n" + 
    	     		"left join product on order_detail.DETAIL_PRODUCT_ID =product.PRODUCT_ID\r\n" + 
    	     		"WHERE DETAIL_DATE_TIME between? and ?\r\n" + 
    	     		"GROUP BY DETAIL_PRODUCT_ID \r\n" + 
    	     		"ORDER BY SUMER DESC  limit 0,8  ";
    	     List<Map<String,Object>>   list=  DbUtil.query(sql, Q,H);
    	     List<Year> list2=new ArrayList<Year>();
    	     for(int i=0;i<list.size();i++) {
    				Year year1 =new Year();
    				year1.setProductName(list.get(i).get("PRODUCT_NAME").toString());
    				year1.setSumer(list.get(i).get("SUMER").toString());
    				 list2.add(year1);
    			}	
    	   
    	     return  list2;
    	     
     }
     /**
      * 根据订单id查询订单购买详情
      */
     
     public Dingdan Queryorder(String orderid) {
    		 String sql="SELECT DETAIL_ID,DETAIL_PRODUCT_ID,DETAIL_PRODUCT_COUNT,DETAIL_PRODUCT_UNIT,DETAIL_PRODUCT_PRICE,DETAIL_TOTAL_PRICE,DETAIL_COMMENT,DETAIL_STATUS,DETAIL_ORDER_ID,DETAIL_USER_ID,DETAIL_DATE_TIME from order_detail WHERE DETAIL_ID=?";
    		 List<Map<String, Object>> list=DbUtil.query(sql, orderid);
  		  String s=list.get(0).get("DETAIL_PRODUCT_ID").toString();
  		  String sql1="SELECT PRODUCT_ID,PRODUCT_CODE,PRODUCT_NAME,PRODUCT_STANDARD,PRODUCT_SMALL_UNIT,PRODUCT_SMALL_PRICE,PRODUCT_LARGER_UNIT,PRODUCT_LARGER_PRICE,PRODUCT_CATEGORY_ID,PRODUCT_BRAND_ID,PRODUCT_PHOTO,PRODUCT_IS_SALE,PRODUCT_IS_LACK,PRODUCT_STATUS,PRODUCT_ORDER,PRODUCT_DATE_TIME,PRODUCT_LARGER_STANDARD,PRODUCT_SUGGEST_PRICE\r\n" + 
   		 	"from product  WHERE PRODUCT_ID=?";
   	         List list2=DbUtil.query(sql1, s);
    		 Dingdan dingdan=new Dingdan();
    	  
    		
    		if(list.size()>0) {
    			 dingdan.setDetailId(list.get(0).get("DETAIL_ID").toString());
    			 dingdan.setDetailProductId(list.get(0).get("DETAIL_PRODUCT_ID").toString());
    			 dingdan.setDetailProductCount(list.get(0).get("DETAIL_PRODUCT_COUNT").toString());
    			 dingdan.setDetailProductUnit(list.get(0).get("DETAIL_PRODUCT_UNIT").toString());
    			 dingdan.setDetailProductPrice(list.get(0).get("DETAIL_PRODUCT_PRICE").toString());
    			 dingdan.setDetailTotalPrice(list.get(0).get("DETAIL_TOTAL_PRICE").toString());
    			 dingdan.setDetailComment(list.get(0).get("DETAIL_COMMENT").toString());
    			 dingdan.setDetailStatus(list.get(0).get("DETAIL_STATUS").toString());
    			 dingdan.setDetailOrderId(list.get(0).get("DETAIL_ORDER_ID").toString());
    			 dingdan.setDetailUserId(list.get(0).get("DETAIL_USER_ID").toString());
    			 dingdan.setDetailDateTime(list.get(0).get("DETAIL_DATE_TIME").toString());
    		     dingdan.setList(list2);
    			 
    		}
    		 
    		return dingdan;
     }
     
     
     /**
      * 根据订单id查询单个订单信息
      */
     
     public Dingdan Queryorder1(String orderid) {
		 String sql="SELECT * FROM  order_list where  ORDER_ID=?";
		 List<Map<String, Object>> list=DbUtil.query(sql, orderid);
		  String s=list.get(0).get("ORDER_USER_ID").toString();
		  System.out.println(s);
		  String sql1="SELECT * from user  where USER_ID=?";
	         List list2=DbUtil.query(sql1, s);
		 Dingdan dingdan=new Dingdan();
	  
		
		if(list.size()>0) {
			 dingdan.setOrderId(list.get(0).get("ORDER_ID").toString());
			 dingdan.setOrderUserId(list.get(0).get("ORDER_USER_ID").toString());
			 dingdan.setOrderDateTime(list.get(0).get("ORDER_DATE_TIME").toString());
			 dingdan.setOrderIsSend(list.get(0).get("ORDER_IS_SEND").toString());
			 dingdan.setOrderIsValid(list.get(0).get("ORDER_IS_VALID").toString());
			 dingdan.setOrderTotalPrice(list.get(0).get("ORDER_TOTAL_PRICE").toString());
			 dingdan.setOrderStatus(list.get(0).get("ORDER_STATUS").toString());
			 dingdan.setOrderComment(list.get(0).get("ORDER_COMMENT").toString());
		     dingdan.setUser(list2); 
		}
		 
		return dingdan;
 }

     
     
} 

