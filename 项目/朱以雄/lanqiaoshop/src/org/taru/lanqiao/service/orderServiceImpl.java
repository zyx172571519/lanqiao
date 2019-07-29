package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.orderDaoImpl;
import org.taru.lanqiao.model.OrderList;

public class orderServiceImpl {
	/**
	 * 
	 * @param orderid
	 * @订单发货
	 */
	public int orderSend(String orderid) {
		orderDaoImpl daoImpl=new orderDaoImpl();
		return daoImpl.orderSend(orderid);
	}
	
	/**
	 * 
	 * @param orderid
	 * @订单作废
	 */
	public int deleteOrderById(String orderid) {
		orderDaoImpl daoImpl=new orderDaoImpl();
		return daoImpl.deleteOrderById(orderid);
	}
	
	/**
	 * 
	 * @param orderid
	 * @导出订单
	 */
	public OrderList exportOrder(String orderid) {
		orderDaoImpl daoImpl=new orderDaoImpl();
		return daoImpl.queryOrderListById(orderid);
	}
}
