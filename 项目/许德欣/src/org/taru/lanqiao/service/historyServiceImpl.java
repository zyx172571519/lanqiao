package org.taru.lanqiao.service;

import java.text.ParseException;

import org.taru.lanqiao.dao.HistoryOrderDaoImpl;
import org.taru.lanqiao.model.Order;

public class historyServiceImpl {
/**
 * 查询历史订单
 * @author Administrator
 *
 */
	public Order queryHisByUid(String userid) throws ParseException {
		HistoryOrderDaoImpl impl=new HistoryOrderDaoImpl();
		return impl.queryHistory(userid);
	}
}
