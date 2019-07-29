package org.taru.lanqiao.servlet;

import java.io.IOException;
/**
 * 
 * ����id��ѯ��Ʒ����
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.util.JsonWriter;

@WebServlet("/api/product/find")
public class ProductQueryServlet extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	String id=request.getParameter("productId");
	ProductServiceImpl impl=new ProductServiceImpl();
	JsonResult jsonResult=null;
	try {
		Product product=impl.queryProductById(id);
		jsonResult=new JsonResult("200", "����id��ѯ��Ʒ����ɹ�",product);
	} catch (Exception e) {
		e.printStackTrace();
		jsonResult=new JsonResult("500", "����id��ѯ��Ʒ����ʧ��",e.getMessage());	
	}
	JsonWriter.writer(response,jsonResult);
	}

}
