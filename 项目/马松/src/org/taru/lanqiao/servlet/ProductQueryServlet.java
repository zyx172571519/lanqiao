package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Dingdan;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.DingdanService;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/product/find")
public class ProductQueryServlet  extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			
			String id =request.getParameter("productId");
			ProductServiceImpl  impl =new ProductServiceImpl();
			JsonResult  jsonResult=null;
			try{
				Product  product =impl.queryProductById(id);
				jsonResult =new JsonResult("200", "查询商品详情成功", product);
			}catch (Exception e) {
				e.printStackTrace();
				jsonResult =new JsonResult("500", "查询商品详情失败",e.getMessage());
			}
			JsonWriter.writer(response, jsonResult);

					
	}

}
