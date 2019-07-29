package org.taru.lanqiao.servlet;

import java.io.IOException;
/**
 * 
 * 加入购物车
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.dao.ShopCarDaoImpl;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
@WebServlet("/api/detail/join")
public class ShopAddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String detailProductId=request.getParameter("detailProductId");
		String detailProductCount=request.getParameter("detailProductCount");
		String detailProductUnit=request.getParameter("detailProductUnit");
		String detailProductPrice=request.getParameter("detailProductPrice");
		String detailComment=request.getParameter("detailComment");
		String detailUserId=request.getParameter("detailUserId");
		ShopCarDaoImpl shopcar=new ShopCarDaoImpl();
		JsonResult jsonResult=null;
		try {
			ProductServiceImpl impl=new ProductServiceImpl();
			int car=shopcar.addShopCar(detailProductId, detailProductCount, detailProductUnit, detailProductPrice, detailComment, detailUserId);
			if(car==1) {
				jsonResult=new JsonResult("200", "加入购物车成功",shopcar);	
			}else {
				jsonResult=new JsonResult("404", "加入购物车失败",shopcar);	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult=new JsonResult("500", "加入购物车异常",e.getMessage());	
		}
			JsonWriter.writer(response,jsonResult);
	}

}
