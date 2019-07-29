package org.taru.lanqiao.dao;

import org.taru.lanqiao.util.DbUtil;

public class AddDao {
   
/**
 * Ìí¼ÓÀà±ð
 * @author Administrator
 *
 */
   public int AddCategory(int categoryId,String categoryName,int categoryStatus) {
	   String sql="insert into category (CATEGORY_ID,CATEGORY_NAME,CATEGORY_STATUS) values (?,?,?)";
	   int i= DbUtil.update(sql, categoryId,categoryName, categoryStatus);
	   return i;
   }
}
