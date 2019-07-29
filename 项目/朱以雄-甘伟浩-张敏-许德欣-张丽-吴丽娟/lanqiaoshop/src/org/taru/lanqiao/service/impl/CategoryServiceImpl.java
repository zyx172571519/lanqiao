package org.taru.lanqiao.service.impl;

import java.util.List;

import org.taru.lanqiao.dao.CategoryDao;
import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDao();
	
	@Override
	public List categoryFindAll() {
		List list = categoryDao.categoryFindAll();
		return list;
	}
	
	/**
	 * 根据类别id查询类别
	 * @param categoryid
	 * @return
	 */
		public Category queryCategory(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.queryCategoryByid(categoryid);
		}
		/**
		 * 删除类别
		 * @param categoryid
		 * @return
		 */
		public int destroy(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.destroyCategory(categoryid);
		}
		/**
		 * 修改类别
		 * @param category
		 * @return
		 */
		public int update(Category category) {
			CategoryDao impl=new CategoryDao();
			return impl.updateCategory(category);
		}
		/**
		 * 类别排序加
		 * @param categoryid
		 * @return
		 */
		public int updateorderjia(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.updateOrderjia(categoryid);
		}
		/**
		 * 类别排序减
		 * @param categoryid
		 * @return
		 */
		public int updateorderjian(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.updateOrderjian(categoryid);
		}

		
		/**
		 * 查询商品类别
		 */
		public List queryCategoryList() {
			CategoryDao daoimpl=new CategoryDao();
			return daoimpl.queryCategoryId();

		}
		
}
