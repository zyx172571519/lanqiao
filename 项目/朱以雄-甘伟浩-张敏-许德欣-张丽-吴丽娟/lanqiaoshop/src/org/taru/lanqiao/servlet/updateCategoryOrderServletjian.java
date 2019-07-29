package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.service.impl.CategoryServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
/**
  *  类别排序减
 * @author Administrator
 *
 */
@WebServlet("/api/category/downdateById")
public class updateCategoryOrderServletjian extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		String id=request.getParameter("categoryId");
		Category category=new Category();
		CategoryServiceImpl impl=new CategoryServiceImpl();
		int num=impl.updateorderjian(id);
		JsonResult result=null;
		try {
			if(num>0) {
				result=new JsonResult("200","成功",num);
			}
		}catch(Exception e) {
			e.printStackTrace();
			result=new JsonResult("404","失败");
		}
		JsonWriter.writer(response, result);
	}
		
	}


