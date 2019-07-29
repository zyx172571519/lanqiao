package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.shopcarDaoImpl;

public class deleteShop {
	public int deleteShopCar(String detailId) {
		shopcarDaoImpl daoImpl=new shopcarDaoImpl();
		return daoImpl.deleteShop(detailId);
	}
}
