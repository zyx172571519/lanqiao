package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.categoryIdDaoImpl;
import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.Detil;

public class categoryIdServiceImpl {
/**
 * 根据类别id查询类别
 * @param categoryid
 * @return
 */
	public Category queryCategory(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.queryCategoryByid(categoryid);
	}
	/**
	 * 删除类别
	 * @param categoryid
	 * @return
	 */
	public int destroy(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.destroyCategory(categoryid);
	}
	/**
	 * 修改类别
	 * @param category
	 * @return
	 */
	public int update(Category category) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.updateCategory(category);
	}
	/**
	 * 类别排序加
	 * @param categoryid
	 * @return
	 */
	public int updateorderjia(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.updateOrderjia(categoryid);
	}
	/**
	 * 类别排序减
	 * @param categoryid
	 * @return
	 */
	public int updateorderjian(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.updateOrderjian(categoryid);
	}
}
