package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.service.categoryIdServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
@WebServlet("/api/category/update")
public class updateCategoryServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	    String id=request.getParameter("categoryid");
	    String name=request.getParameter("categoryname");
	    String order=request.getParameter("order");
	    String status=request.getParameter("status");
	    Integer order1=Integer.getInteger("order");
	    Integer status1=Integer.getInteger("status");
	    Category category=new Category();
	    category.setCategoryId(id);
	    category.setCategoryName(name);
	    category.setCategoryOrder(order1);
	    category.setCategoryStatus(status1);
		categoryIdServiceImpl impl=new  categoryIdServiceImpl();
		int num=impl.update(category);
		JsonResult result=null;
		try {
			if(num>0) {
				result=new JsonResult("200","³É¹¦");
			}
		}catch(Exception e) {
			e.printStackTrace();
			result=new JsonResult("404","Ê§°Ü");
		}
		JsonWriter.writer(response, result);
	
}
}
