package org.taru.lanqiao.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.taru.lanqiao.model.OrderDetail;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/detail/cartDel")
public class DeleteOrderImpl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		JsonResult jsonResult=null;
		
		
		try {
			ProductServiceImpl impl=new ProductServiceImpl();
			String id=request.getParameter("detailId");
			int orderDetail=impl.deleteOrder(id);
			if(orderDetail == 1 ) {
				jsonResult=new JsonResult("200","ÒÆ³ý¹ºÎï³µ³É¹¦",orderDetail);
			}else {
				jsonResult=new JsonResult("400","ÒÆ³ý¹ºÎï³µÊ§°Ü");
			}
		}catch(Exception e) {
			jsonResult=new JsonResult("500","ÒÆ³ý¹ºÎï³µÊ§°Ü",e.getMessage());
		}
		JsonWriter.writer(response, jsonResult);
	}
}
