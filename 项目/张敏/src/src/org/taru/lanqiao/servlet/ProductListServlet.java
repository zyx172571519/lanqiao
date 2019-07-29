package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.PageResult;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/category/list")
public class ProductListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductServiceImpl impl=new ProductServiceImpl();
		JsonResult jsonResult=null;
		try {
			int pageNum=Integer.parseInt(request.getParameter("pageNum"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			PageResult pageResult=impl.queryList(pageNum, pageSize);
		jsonResult=new JsonResult("200","查询商品类型成功",pageResult);
		}catch(Exception e) {
		jsonResult=new JsonResult("500","查询商品类型失败",e.getMessage());
		}
		JsonWriter.writer(response, jsonResult);
	}
	
}
