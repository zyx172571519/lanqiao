package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.ShopCarDaoImpl;

/**
 * 
 * 加入购物车
 * @author zm
 *
 */
public class ShopServiceImpl {
	public int shopAdd(	String detailProductId,String detailProductCount,String detailProductUnit,String detailProductPrice,String detailComment,String detailUserId) {
		ShopCarDaoImpl scdimpl=new ShopCarDaoImpl();
		int car=scdimpl.addShopCar(detailProductId, detailProductCount, detailProductUnit, detailProductPrice, detailComment, detailUserId);
		return car;
	}
}
