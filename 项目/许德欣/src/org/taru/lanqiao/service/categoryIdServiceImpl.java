package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.categoryIdDaoImpl;
import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.Detil;

public class categoryIdServiceImpl {
/**
 * �������id��ѯ���
 * @param categoryid
 * @return
 */
	public Category queryCategory(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.queryCategoryByid(categoryid);
	}
	/**
	 * ɾ�����
	 * @param categoryid
	 * @return
	 */
	public int destroy(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.destroyCategory(categoryid);
	}
	/**
	 * �޸����
	 * @param category
	 * @return
	 */
	public int update(Category category) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.updateCategory(category);
	}
	/**
	 * ��������
	 * @param categoryid
	 * @return
	 */
	public int updateorderjia(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.updateOrderjia(categoryid);
	}
	/**
	 * ��������
	 * @param categoryid
	 * @return
	 */
	public int updateorderjian(String categoryid) {
		categoryIdDaoImpl impl=new categoryIdDaoImpl();
		return impl.updateOrderjian(categoryid);
	}
}
