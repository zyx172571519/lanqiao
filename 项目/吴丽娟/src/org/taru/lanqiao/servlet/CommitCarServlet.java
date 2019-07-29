package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.service.UserLoginServinceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/order/commit")
public class CommitCarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-------------------");
			JsonResult 	jsonResult=new JsonResult("405","协议不对 请使用POST","");
			JsonWriter.writer(resp, jsonResult);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderUserId=req.getParameter("orderUserId");
		String orderTotalPrice=req.getParameter("orderTotalPrice");
	String	orderComment=req.getParameter("orderComment");
		ProductServiceImpl impl=new ProductServiceImpl();
		JsonResult jsonResult=null;
		try {
		int row = impl.commint(orderUserId,orderTotalPrice,orderComment);
		if(row==1) {
			jsonResult=new JsonResult("200","提交成功",row);
			
		}else {
			jsonResult=new JsonResult("404","提交失败");
			
		}
		
		}catch(Exception e) {
		e.printStackTrace();
		jsonResult=new JsonResult("500","提交订单异常",e.getMessage());
		}
		JsonWriter.writer(resp, jsonResult);
	}
}
