package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Dingdan;
import org.taru.lanqiao.service.QueryDd1Service;
import org.taru.lanqiao.service.QueryDdService;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/Dd1/fod")
public class QueryDd1Servlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String orderid= req.getParameter("orderid");
		  QueryDd1Service s=new QueryDd1Service();
		  JsonResult jsonResult=null;
			try{
				Dingdan dingdan= s.queryDd1(orderid);
				
				jsonResult =new JsonResult("200", "查询订单详情成功", dingdan);
			}catch (Exception e) {
				e.printStackTrace();
				jsonResult =new JsonResult("500", "查询商品详情失败",e.getMessage());
			}
			JsonWriter.writer(resp, jsonResult);
					
	}
}
