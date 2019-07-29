package org.taru.lanqiao.servlet;

import java.io.IOException;
import org.taru.lanqiao.util.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.productServiceImpl;
import org.taru.lanqiao.vo.JsonResult;

import org.taru.lanqiao.util.Constants;

@WebServlet("/api/product/find")
public class productServletImpl extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		productServiceImpl impl=new productServiceImpl();
		JsonResult result=null;
		try {
			Product product=impl.queryById(productId);
			result=new JsonResult(Constants.STATUS_SUCCESS,"≥…π¶",product);
		}catch(Exception e) {
			result=new JsonResult(Constants.STATUS_ERROR,"“Ï≥£");
		}
		JsonWriter.writer(response, result);
	}
}
