package org.taru.lanqiao.service;

import java.text.ParseException;
import java.util.List;

import org.taru.lanqiao.dao.OrderDaoImpl;
import org.taru.lanqiao.model.Detil;
import org.taru.lanqiao.model.Order;

public class orderServiceImpl {
/**
 * ���ݶ���id��ѯ��������
 * @author Administrator
 *
 */
	public List<Detil> queryOrderById(String orderid) throws ParseException{
		OrderDaoImpl impl=new OrderDaoImpl();
		return impl.queryDetailByOrderId(orderid);
		
	}
}
