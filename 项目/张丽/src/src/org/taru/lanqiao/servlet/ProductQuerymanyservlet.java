package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

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
 *��������ѯ��Ʒ
 */
@WebServlet("/api/product/searchList")
public class ProductQuerymanyservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryId=request.getParameter("categoryId");
		String productIsLack=request.getParameter("productIsLack");
		String orderStr=request.getParameter("orderStr");
		ProductServiceImpl impl=new ProductServiceImpl();
		JsonResult jsonResult;
		try {
			List<Product> product=impl.queryProductByManay(categoryId, productIsLack, orderStr);
			jsonResult =new JsonResult("200","������Ʒ�ɹ�",product);
		} catch (Exception e) {
			jsonResult =new JsonResult("500","������Ʒʧ��",e.getMessage());
		}
		JsonWriter.writer(response, jsonResult);
	}
}
