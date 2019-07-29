package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.OrderDaoImpl;
import org.taru.lanqiao.model.OrderDetail;
/**
 * Ã·Ωª∂©µ•
 */
public class OderServiceImpl {
	public String oderCommit(String orderUserId,String orderTotalPrice,String orderComment){
		OrderDaoImpl daoImpl =new OrderDaoImpl();
		return daoImpl.orderCommit(orderUserId,orderTotalPrice,orderComment);
	}
}
