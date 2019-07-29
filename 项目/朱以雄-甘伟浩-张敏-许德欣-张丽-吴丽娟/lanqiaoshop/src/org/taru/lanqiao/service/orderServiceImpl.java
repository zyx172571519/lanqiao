package org.taru.lanqiao.service;

import java.util.List;

import org.taru.lanqiao.dao.orderDaoImpl;
import org.taru.lanqiao.model.Detil;
import org.taru.lanqiao.model.Order;
import org.taru.lanqiao.model.OrderList;

public class orderServiceImpl {
	/**
	 * 
	 * @param orderid
	 * @��������
	 */
	public int orderSend(String orderid) {
		orderDaoImpl daoImpl=new orderDaoImpl();
		return daoImpl.orderSend(orderid);
	}
	
	/**
	 * 
	 * @param orderid
	 * @��������
	 */
	public int deleteOrderById(String orderid) {
		orderDaoImpl daoImpl=new orderDaoImpl();
		return daoImpl.deleteOrderById(orderid);
	}
	
	/**
	 * 
	 * @param orderid
	 * @��������
	 */
	public OrderList exportOrder(String orderid) {
		orderDaoImpl daoImpl=new orderDaoImpl();
		return daoImpl.queryOrderListById(orderid);
	}
	
	/**
	 * ���ݶ���id��ѯ��������
	 * @author Administrator
	 *
	 */
	public List<Detil> queryOrderById(String orderid) throws Exception{
		orderDaoImpl impl=new orderDaoImpl();
		return impl.queryDetailByOrderId(orderid);
			
	}
	
	/**
	 * ��ѯ��ʷ����
	 * @author Administrator
	 *
	 */
		public Order queryHisByUid(String userid) throws Exception {
			orderDaoImpl impl=new orderDaoImpl();
			return impl.queryHistory(userid);
		}
}
