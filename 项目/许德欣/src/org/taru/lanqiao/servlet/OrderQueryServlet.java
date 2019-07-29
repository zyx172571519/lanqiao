package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Detil;
import org.taru.lanqiao.model.Order;
import org.taru.lanqiao.service.orderServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
@WebServlet("/api/order/detail")
public class OrderQueryServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String id=request.getParameter("orderId");
		orderServiceImpl impl=new orderServiceImpl();
		JsonResult result=null;
		try {
			List<Detil> list=impl.queryOrderById(id);
			result=new JsonResult("200","查询订单成功",list);
		
	}catch(Exception e){
		e.printStackTrace();
		result=new JsonResult("404","查询订单失败",e.getMessage());
	}
		JsonWriter.writer(response, result);
}
}