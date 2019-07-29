package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.CategoryService;
import org.taru.lanqiao.service.impl.CategoryServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/category/qryList")
public class CategoryFindAllServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 JsonResult jr;
		 try {
			 CategoryService categoryService = new CategoryServiceImpl();
			 List list = categoryService.categoryFindAll();
			 jr = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", list);
		 }catch (Exception e) {
			 jr = new JsonResult(Constants.STATUS_ERROR, "查询异常");
		}
		 JsonWriter.writer(resp, jr);
	}
}
