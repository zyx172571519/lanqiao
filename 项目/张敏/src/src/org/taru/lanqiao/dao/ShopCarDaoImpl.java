package org.taru.lanqiao.dao;

import java.util.UUID;

import org.taru.lanqiao.model.ShopCar;
import org.taru.lanqiao.util.SqlUtil;

public class ShopCarDaoImpl {
	/**
	 * 加入购物车
	 */
	public  int  addShopCar(String detailProductId,String detailProductCount,String detailProductUnit,String detailProductPrice,String detailComment,String detailUserId) {
		String detailId=UUID.randomUUID().toString();
		String sql="insert into order_detail(DETAIL_ID,DETAIL_PRODUCT_ID,DETAIL_PRODUCT_COUNT,DETAIL_PRODUCT_UNIT,DETAIL_PRODUCT_PRICE,DETAIL_COMMENT,DETAIL_USER_ID) values(?,?,?,?,?,?,?)";
	int car=SqlUtil.executeUpdate(sql,detailId,detailProductId,detailProductCount,detailProductUnit,detailProductPrice,detailComment,detailUserId);
	return car;
	}

}
