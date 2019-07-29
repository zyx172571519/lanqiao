package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.Detil;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class categoryIdDaoImpl {
	/**
	 * ����id��ѯ���
	 * @param orderid
	 * @return
	 */
	public Category queryCategoryByid(String categoryid) {
	String sql="select * from category where CATEGORY_ID=?";
	ArrayList<HashMap<String,Object>> list=SqlUtil.executeQuery(sql, categoryid);
	Category category=null;
	if(list.size()>0) {
		category=new Category();
		category.setCategoryName(StringUtil.valueOf(list.get(0).get("CATEGORY_NAME")));
		Integer categoryorder=Integer.parseInt(StringUtil.valueOf(list.get(0).get("CATEGORY_ORDER")));
		category.setCategoryOrder(categoryorder);
		Integer categorystatus=Integer.parseInt(StringUtil.valueOf(list.get(0).get("CATEGORY_STATUS")));
		category.setCategoryStatus(categorystatus);
	}
	return category;
	}
	/**
	 * ɾ�����
	 * @param id
	 * @return
	 */
	public int destroyCategory(String id){
		String sql="update category set CATEGORY_STATUS=0 where CATEGORY_ID=?";
		int i=SqlUtil.executeUpdate(sql, id);
		return i;
	}
	/**
	 * �޸����
	 * @param category
	 * @return
	 */
	public int updateCategory(Category category){
		String sql="update category set CATEGORY_NAME=?,CATEGORY_ORDER=?,CATEGORY_STATUS=? where CATEGORY_ID=?";
		int i=SqlUtil.executeUpdate(sql,category.getCategoryName(),category.getCategoryOrder(),category.getCategoryStatus(),category.getCategoryId());
		return i;
	}
	/**
	 * ��������
	 * @param categoryid
	 * @return
	 */
	public int updateOrderjia(String categoryid) {
		String sql="update category set CATEGORY_ORDER=CATEGORY_ORDER+1 where CATEGORY_ID=?";
		int  i=SqlUtil.executeUpdate(sql,categoryid);
		return i;
	}
	/**
	 * ��������
	 * @param categoryid
	 * @return
	 */
	public int updateOrderjian(String categoryid) {
		String sql="update category set CATEGORY_ORDER=CATEGORY_ORDER-1 where CATEGORY_ID=?";
		int i=SqlUtil.executeUpdate(sql, categoryid);
		return i;
	}
}
