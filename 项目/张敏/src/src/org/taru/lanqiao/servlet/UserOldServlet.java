package org.taru.lanqiao.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.dao.ProductDaoImpl;
import org.taru.lanqiao.dao.UserDaoImpl;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
@WebServlet("/api/product/selectHistoryProducts")
/**
 * 
 * 查询用户购买过的商品
 * @author zm
 *
 */
public class UserOldServlet extends HttpServlet{
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	String userId=request.getParameter("userId");
	ProductDaoImpl udimpl=new ProductDaoImpl ();
	JsonResult jsonResult=null;
	try {
		Product product=udimpl.queryUserId(userId);
		jsonResult=new JsonResult("200", "查询购买过的商品成功",product);
	} catch (Exception e) {
		e.printStackTrace();
		jsonResult=new JsonResult("500", "查询购买过的商品失败",e.getMessage());	
	}
	JsonWriter.writer(response,jsonResult);
	}

}
