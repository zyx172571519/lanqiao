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
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.vo.productAll;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.util.JsonWriter;
/**
 * 管理员查询所有商品
 * @author Administrator
 *
 */
@WebServlet("/api/product/all")
public class producServlettAll extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonResult result=null;
		try {
			int pageNum=Integer.parseInt(request.getParameter("pageNum"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			String categoryId=request.getParameter("categoryId");
			String productName=request.getParameter("productName");
			String productisLack=request.getParameter("productisLack");
			productServiceImpl serviceImpl=new productServiceImpl();
			productAll productall=serviceImpl.queryProductAll(pageNum, pageSize, categoryId, productName, productisLack);
			result=new JsonResult(Constants.STATUS_SUCCESS,"成功",productall);
		}catch(Exception e) {
			//e.printStackTrace();
			result=new JsonResult(Constants.STATUS_ERROR,"失败");
		}
		JsonWriter.writer(response, result);
	}
}
