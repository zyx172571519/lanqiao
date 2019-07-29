package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.YearService;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/year/fod")

public class YearServlet  extends HttpServlet{
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  String year=req.getParameter("year");
	  YearService ss=new YearService();
	  JsonResult  jsonResult=null;
		try {
			List list=ss.queryYear(year);
			jsonResult =new JsonResult("200", "查询成功", list);
		}catch (Exception e) {
			e.printStackTrace();
			jsonResult =new JsonResult("500", "查询失败",e.getMessage());
		}
		JsonWriter.writer(resp, jsonResult);

	}
	
	
}
