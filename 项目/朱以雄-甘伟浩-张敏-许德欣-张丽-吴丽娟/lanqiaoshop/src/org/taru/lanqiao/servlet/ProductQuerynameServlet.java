package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.productServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
/**
 * ģ��������name������ģ����
 */
@WebServlet("/api/product/search")
public class ProductQuerynameServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=(request.getParameter("name")+"").trim();
		productServiceImpl impl=new productServiceImpl();
		JsonResult jaonResult;
		try {
			List<Product> product=impl.queryProductByname("%"+name+"%");
			jaonResult =new JsonResult("200","������Ʒ�ɹ�",product);
		} catch (Exception e) {
			jaonResult =new JsonResult("500","������Ʒʧ��",e.getMessage());
		}
		JsonWriter.writer(response, jaonResult);
	}
}
