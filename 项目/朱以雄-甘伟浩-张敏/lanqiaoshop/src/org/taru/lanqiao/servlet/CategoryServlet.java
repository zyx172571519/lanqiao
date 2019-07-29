package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.PageProduct;
import org.taru.lanqiao.service.productServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
/**
 * 根据类型查询商品
 * @author zm
 *
 */
@WebServlet("/api/product/selectByCatrgory")
public class CategoryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		productServiceImpl impl=new productServiceImpl();
		JsonResult jsonResult=null;
		try {
			System.out.println("pageNum"+request.getParameter("pageNum"));
			String categoryId=request.getParameter("categoryId");
			int pageNum=Integer.parseInt(request.getParameter("pageNum"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			PageProduct pageresult=impl.queryProductCid(categoryId, pageNum, pageSize);
			jsonResult=new JsonResult("200","根据类别查询商品成功",pageresult);
		}catch(Exception e) {
			e.printStackTrace();
		jsonResult=new JsonResult("500","根据类别查询商品失败",e.getMessage());
		}
		JsonWriter.writer(response, jsonResult);
	}
}
