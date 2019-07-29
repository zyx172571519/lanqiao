package org.taru.lanqiao.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.UserServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/user/find")
public class UserQueryServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("userId");
		UserServiceImpl impl=new UserServiceImpl();
		JsonResult jsonResult=null;
		
		try {
		User user = impl.queryUserById(id);
		if(user!=null) {
			jsonResult=new JsonResult("200","查询用户详情成功",user);
		}else {
			jsonResult=new JsonResult("404","查询用户不存在",user);
		}
		
		}catch(Exception e) {
		jsonResult=new JsonResult("500","查询用户异常",e.getMessage());
		}
		JsonWriter.writer(response, jsonResult);
		
	}
}
