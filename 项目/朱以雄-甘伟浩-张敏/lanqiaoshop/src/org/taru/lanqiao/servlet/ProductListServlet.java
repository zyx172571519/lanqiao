package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.productServiceImpl;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.vo.PageResult;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.util.JsonWriter;

@WebServlet("/api/product/list")
public class ProductListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonResult result=null;
		try {
			int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			productServiceImpl Impl=new productServiceImpl();
			PageResult pageResult= Impl.productList(pageNum, pageSize);
			result=new JsonResult(Constants.STATUS_SUCCESS, "³É¹¦",pageResult);
			
		}catch(Exception e) {
			result=new JsonResult(Constants.STATUS_ERROR, "Ê§°Ü");
		}
		
		JsonWriter.writer(response, result);
	}
}
