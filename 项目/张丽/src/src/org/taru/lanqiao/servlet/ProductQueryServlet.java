package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
/**
 * 根据ID查询商品
 */
@WebServlet("/api/product/find")
public class ProductQueryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productId");
		ProductServiceImpl impl=new ProductServiceImpl();
		JsonResult jaonResult;
		try {
			Product product=impl.queryProductById(id);
			jaonResult =new JsonResult("200","查询商品成功",product);
		} catch (Exception e) {
			jaonResult =new JsonResult("500","查询商品失败",e.getMessage());
		}
		JsonWriter.writer(response, jaonResult);
	}
}
