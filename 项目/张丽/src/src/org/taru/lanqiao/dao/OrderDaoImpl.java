package org.taru.lanqiao.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.OrderDetail;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.IdUtil;
import org.taru.lanqiao.util.SqlUtil;
/**
 * Ã·Ωª∂©µ•
 */
public class OrderDaoImpl {
	public String orderCommit(String orderUserId,String orderTotalPrice,String orderComment){
		
		String sql="update order_detail set DETAIL_ORDER_ID=? where DETAIL_USER_ID=? and DETAIL_ORDER_ID='' or DETAIL_USER_ID=? and DETAIL_ORDER_ID is null ";
		String orderid=IdUtil.getDateId();
		int status = SqlUtil.executeUpdate(sql, orderid,orderUserId, orderUserId);
		String sql2="INSERT INTO order_list(ORDER_ID,ORDER_USER_ID,ORDER_DATE_TIME,ORDER_IS_SEND,ORDER_IS_VALID,ORDER_TOTAL_PRICE,ORDER_STATUS,ORDER_COMMENT) VALUES (?,?,?,0,1,?,0,?) ";
		Date  data=new Date();
		int row=SqlUtil.executeUpdate(sql2, orderid,orderUserId,data,orderTotalPrice,orderComment);
		return orderid;
	}
}
