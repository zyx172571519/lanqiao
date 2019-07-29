package org.taru.lanqiao.service;

import java.text.ParseException;
import java.util.List;

import org.taru.lanqiao.dao.OrderDaoImpl;
import org.taru.lanqiao.model.Detil;
import org.taru.lanqiao.model.Order;

public class orderServiceImpl {
/**
 * 根据订单id查询订单详情
 * @author Administrator
 *
 */
	public List<Detil> queryOrderById(String orderid) throws ParseException{
		OrderDaoImpl impl=new OrderDaoImpl();
		return impl.queryDetailByOrderId(orderid);
		
	}
}
