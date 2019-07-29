package org.taru.lanqiao.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.OrderList;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class orderDaoImpl {
	
	/**
	 * 
	 * @param orderid
	 * @订单发货
	 */
	public int orderSend(String orderid) {
		String sql="update order_list set ORDER_IS_SEND=1 where ORDER_ID=?";
		int row=SqlUtil.executeUpdate(sql, orderid);
		return row;
	}
	
	/**
	 * 
	 * @param orderid
	 * @订单作废
	 */
	public int deleteOrderById(String orderid) {
		String sql="update order_list set ORDER_STATUS=0 where ORDER_ID=?";
		int row=SqlUtil.executeUpdate(sql, orderid);
		return row;
	}
	
	/**
	 * 
	 * @param orderid
	 * @导出订单
	 */
	public OrderList queryOrderListById(String orderid) {
		String sql="select * from order_list where ORDER_ID=?";
		List<HashMap<String,Object>> list=SqlUtil.executeQuery(sql, orderid);
		OrderList orderlist=null;
		if(list.size()>0) {
			orderlist=new OrderList();
			orderlist.setOrderId(StringUtil.valueOf(list.get(0).get("ORDER_ID")));
			orderlist.setOrderUserId(StringUtil.valueOf(list.get(0).get("ORDER_USER_ID")));
			orderlist.setOrderIsSend(Byte.parseByte(StringUtil.valueOf(list.get(0).get("ORDER_IS_SEND"))));
			orderlist.setOrderIsValid(Byte.parseByte(StringUtil.valueOf(list.get(0).get("ORDER_IS_VALID"))));
			orderlist.setOrderStatus(Byte.parseByte(StringUtil.valueOf(list.get(0).get("ORDER_STATUS"))));
			//double ordertotalprice=DoubleTo.value(StringUtil.valueOf(list.get(0).get("ORDER_TOTAL_PRICE")));
			//orderlist.setOrderTotalPrice(ordertotalprice);
		}
		return orderlist;
	}
}
