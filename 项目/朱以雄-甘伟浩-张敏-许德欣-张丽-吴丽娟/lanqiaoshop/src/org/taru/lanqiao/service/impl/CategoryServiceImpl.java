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
	 * �������id��ѯ���
	 * @param categoryid
	 * @return
	 */
		public Category queryCategory(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.queryCategoryByid(categoryid);
		}
		/**
		 * ɾ�����
		 * @param categoryid
		 * @return
		 */
		public int destroy(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.destroyCategory(categoryid);
		}
		/**
		 * �޸����
		 * @param category
		 * @return
		 */
		public int update(Category category) {
			CategoryDao impl=new CategoryDao();
			return impl.updateCategory(category);
		}
		/**
		 * ��������
		 * @param categoryid
		 * @return
		 */
		public int updateorderjia(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.updateOrderjia(categoryid);
		}
		/**
		 * ��������
		 * @param categoryid
		 * @return
		 */
		public int updateorderjian(String categoryid) {
			CategoryDao impl=new CategoryDao();
			return impl.updateOrderjian(categoryid);
		}

		
		/**
		 * ��ѯ��Ʒ���
		 */
		public List queryCategoryList() {
			CategoryDao daoimpl=new CategoryDao();
			return daoimpl.queryCategoryId();

		}
		
}
