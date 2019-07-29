package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.OrderDetail;
import org.taru.lanqiao.service.productServiceImpl;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.vo.shopCar;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.util.JsonWriter;;
@WebServlet("/api/query/shopcar")
public class queryServletShopCar extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		productServiceImpl serviceImpl=new	productServiceImpl();
		JsonResult jsonresult=null;
		try {
			List<shopCar> product=serviceImpl.queryByUid(uid);
			jsonresult=new JsonResult(Constants.STATUS_SUCCESS,"³É¹¦",product);
		}catch(Exception e) {
			e.printStackTrace();
			jsonresult=new JsonResult(Constants.STATUS_ERROR,"Ê§°Ü");
		}
		JsonWriter.writer(response, jsonresult);
	}
}
