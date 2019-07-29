package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

/**
 * ���DAO��
 * @author CoCo
 *
 */
public class CategoryDao {
	
	//��ѯ����б�
	public List categoryFindAll() {
		String sql = "select * from category order by CATEGORY_ORDER asc";
		List list = SqlUtil.executeQuery(sql);
		SqlUtil.close();
		return list;
	}
	
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
		Byte categorystatus=Byte.parseByte(StringUtil.valueOf(list.get(0).get("CATEGORY_STATUS")));
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
	
	/**
	 * ��ѯ���еĲ�Ʒ���
	 */
	public List queryCategoryId() {
		String sql="select * from Category ";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql);
		Category category=null;
		List<Category> list2=new ArrayList<Category>();
		for(int i=0;i<list.size();i++) {
			category=new Category();
			category.setCategoryId(StringUtil.valueOf(list.get(i).get("CATEGORY_ID")));//�ж��Ƿ��п�
			category.setCategoryName(StringUtil.valueOf(list.get(i).get("CATEGORY_NAME")));
			category.setCategoryOrder(Integer.parseInt(StringUtil.valueOf(list.get(i).get("CATEGORY_ORDER"))));
			category.setCategoryStatus(Byte.parseByte((StringUtil.valueOf(list.get(i).get("CATEGORY_STATUS")))));
			list2.add(category);
		}
		return list2;
	}
}
