package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

/**
 * 类别DAO层
 * @author CoCo
 *
 */
public class CategoryDao {
	
	//查询类别列表
	public List categoryFindAll() {
		String sql = "select * from category order by CATEGORY_ORDER asc";
		List list = SqlUtil.executeQuery(sql);
		SqlUtil.close();
		return list;
	}
	
	/**
	 * 根据id查询类别
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
		Byte categorystatus=Byte.parseByte(StringUtil.valueOf(list.get(0).get("CATEGORY_STATUS")));
		category.setCategoryStatus(categorystatus);
	}
	return category;
	}
	/**
	 * 删除类别
	 * @param id
	 * @return
	 */
	public int destroyCategory(String id){
		String sql="update category set CATEGORY_STATUS=0 where CATEGORY_ID=?";
		int i=SqlUtil.executeUpdate(sql, id);
		return i;
	}
	/**
	 * 修改类别
	 * @param category
	 * @return
	 */
	public int updateCategory(Category category){
		String sql="update category set CATEGORY_NAME=?,CATEGORY_ORDER=?,CATEGORY_STATUS=? where CATEGORY_ID=?";
		int i=SqlUtil.executeUpdate(sql,category.getCategoryName(),category.getCategoryOrder(),category.getCategoryStatus(),category.getCategoryId());
		return i;
	}
	/**
	 * 类别排序加
	 * @param categoryid
	 * @return
	 */
	public int updateOrderjia(String categoryid) {
		String sql="update category set CATEGORY_ORDER=CATEGORY_ORDER+1 where CATEGORY_ID=?";
		int  i=SqlUtil.executeUpdate(sql,categoryid);
		return i;
	}
	/**
	 * 类别排序减
	 * @param categoryid
	 * @return
	 */
	public int updateOrderjian(String categoryid) {
		String sql="update category set CATEGORY_ORDER=CATEGORY_ORDER-1 where CATEGORY_ID=?";
		int i=SqlUtil.executeUpdate(sql, categoryid);
		return i;
	}
	
	/**
	 * 查询所有的产品类别
	 */
	public List queryCategoryId() {
		String sql="select * from Category ";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql);
		Category category=null;
		List<Category> list2=new ArrayList<Category>();
		for(int i=0;i<list.size();i++) {
			category=new Category();
			category.setCategoryId(StringUtil.valueOf(list.get(i).get("CATEGORY_ID")));//判断是否有空
			category.setCategoryName(StringUtil.valueOf(list.get(i).get("CATEGORY_NAME")));
			category.setCategoryOrder(Integer.parseInt(StringUtil.valueOf(list.get(i).get("CATEGORY_ORDER"))));
			category.setCategoryStatus(Byte.parseByte((StringUtil.valueOf(list.get(i).get("CATEGORY_STATUS")))));
			list2.add(category);
		}
		return list2;
	}
}
