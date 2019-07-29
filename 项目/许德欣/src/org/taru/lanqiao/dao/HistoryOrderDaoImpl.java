package org.taru.lanqiao.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.taru.lanqiao.model.Order;
import org.taru.lanqiao.util.SqlUtil;

public class HistoryOrderDaoImpl {
/**
 * 查询历史订单
 * @author Administrator
 *
 */
	public Order queryHistory(String userid) throws ParseException {
		String sql="select * from order_list where ORDER_USER_ID=?";
		ArrayList<HashMap<String,Object>> list=SqlUtil.executeQuery(sql,userid);
		Order order=null;
		if(list.size()>0) {
			order=new Order();
			order.setOrderUserId(list.get(0).get("ORDER_USER_ID").toString());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
			order.setOrderDateTime(format.parse(list.get(0).get("ORDER_DATE_TIME").toString()));
			order.setOrderComment(list.get(0).get("ORDER_COMMENT").toString());
		}
		return order;
	}
}
