package org.taru.lanqiao.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.deleteShop;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.util.JsonWriter;
/**
 * 移除购物车
 * @author Administrator
 *
 */
@WebServlet("/api/delete/shopcar")
public class deleteShopServiceImpl extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String detailId=request.getParameter("detailId");
		deleteShop serImpl=new deleteShop();
		int rom=0;
		JsonResult result=null;
		try {
			rom=serImpl.deleteShopCar(detailId);
			result=new JsonResult(Constants.STATUS_SUCCESS,"成功",rom);
		}catch(Exception e) {
			e.getStackTrace();
			result=new JsonResult(Constants.STATUS_ERROR,"失败");
		}
		JsonWriter.writer(response, result);
	}
}
