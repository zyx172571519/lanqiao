package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.Detil;
import org.taru.lanqiao.service.categoryIdServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
@WebServlet("/api/category/selectById")
public class categoryByIdServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String id=request.getParameter("categoryId");
		categoryIdServiceImpl impl=new categoryIdServiceImpl();
		JsonResult jsonResult=null;
		try {
			Category category=impl.queryCategory(id);
			jsonResult=new JsonResult("200","查询成功",category);
			
		}catch(Exception e){
			e.printStackTrace();
			jsonResult=new JsonResult("404","查询失败",e.getMessage());
	}
		JsonWriter.writer(response, jsonResult);
}
}

