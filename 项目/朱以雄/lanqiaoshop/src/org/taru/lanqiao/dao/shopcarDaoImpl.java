package org.taru.lanqiao.dao;

import org.taru.lanqiao.util.SqlUtil;

public class shopcarDaoImpl {
	public int deleteShop(String detailId) {
		String sql="delete from order_detail where DETAIL_ID=?";
		int row=SqlUtil.executeUpdate(sql, detailId);
		return row;
	}

}
