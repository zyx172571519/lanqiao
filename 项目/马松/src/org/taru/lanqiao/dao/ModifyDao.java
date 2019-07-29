package org.taru.lanqiao.dao;

import java.util.List;
import java.util.Map;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.DbUtil;

public class ModifyDao {

/**
 * 商品缺货设置
 * @author Administrator
 *
 */

	 public void ModifyById(String id){
		 String  sql="UPDATE product SET PRODUCT_IS_LACK =0 WHERE  PRODUCT_ID=? ";
			int  list=  DbUtil.update(sql,id);
			System.out.println(list);	
		}
	 

/**
 * 商品上货
 * @author Administrator
 *
 */
	 public void ModifyById1(String id){
		 String  sql="UPDATE product SET PRODUCT_IS_LACK =1 WHERE  PRODUCT_ID=? ";
			int  list=  DbUtil.update(sql,id);
			System.out.println(list);	
		}
	 
	 }

