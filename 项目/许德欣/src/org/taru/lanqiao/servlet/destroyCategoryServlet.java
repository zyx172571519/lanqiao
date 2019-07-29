package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.categoryIdServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
@WebServlet("/api/category/delById")
public class destroyCategoryServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String id=request.getParameter("categoryid");
		categoryIdServiceImpl impl=new  categoryIdServiceImpl();
		JsonResult result=null;
		try {
			result=new JsonResult("200","³É¹¦");
		}catch(Exception e) {
			e.printStackTrace();
			result=new JsonResult("404","Ê§°Ü");
		}
		JsonWriter.writer(response, result);
	}

}
