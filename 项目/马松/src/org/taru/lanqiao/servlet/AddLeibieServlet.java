package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.LeibieService;
import org.taru.lanqiao.vo.JsonResult;

import org.taru.lanqiao.util.JsonWriter;

/**
 * int categoryId,String categoryName,int categoryStatus
 * @author Administrator
 *
 */
@WebServlet("/api/addleibie/fod")
public class AddLeibieServlet extends HttpServlet{
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId=  Integer.parseInt( req.getParameter("categoryId"));
		String categoryName= req.getParameter("categoryName");
		int categoryStatus=  Integer.parseInt( req.getParameter("categoryStatus"));
		LeibieService ll= new LeibieService();
		int s=ll.addleibie(categoryId, categoryName, categoryStatus);
		JsonResult  jsonResult=null;
			if(s==1) {
				 jsonResult =new JsonResult("200", "添加类别成功", s);
			}else {
				 jsonResult =new JsonResult("500", "添加类别失败", s);
			}
	
		 JsonWriter.writer(resp,jsonResult);
			
	}
}
