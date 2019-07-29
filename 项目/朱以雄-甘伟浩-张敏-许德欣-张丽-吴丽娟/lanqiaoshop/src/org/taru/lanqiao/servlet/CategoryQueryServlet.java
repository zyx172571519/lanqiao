package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Category;

import org.taru.lanqiao.model.User;

import org.taru.lanqiao.service.UserServiceImpl;
import org.taru.lanqiao.service.impl.CategoryServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;


@WebServlet("/api/category/list")
public class CategoryQueryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryServiceImpl impl=new CategoryServiceImpl();
		JsonResult jsonResult=null;
		
		try {
		List category = impl.queryCategoryList();
		jsonResult=new JsonResult("200","查询商品类型成功",category);
		}catch(Exception e) {
		jsonResult=new JsonResult("500","查询商品类型失败",e.getMessage());
		}
		JsonWriter.writer(response, jsonResult);
	}
	
}
