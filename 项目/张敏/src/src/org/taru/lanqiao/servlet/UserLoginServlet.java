package org.taru.lanqiao.servlet;

import java.io.IOException;
/**
 * 
 * 输入用户名和密码登录
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.UserServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
@WebServlet("/api/login")

public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	UserServiceImpl usimp=new UserServiceImpl();
	JsonResult jsonResult=null;
	try {
		User user=usimp.userLogin(username, password);
		
		if(user==null) {
			jsonResult=new JsonResult("404", "登录失败",null);	
		}else {
			jsonResult=new JsonResult("200", "登录成功",user);
			HttpSession session=request.getSession(true);
			session.setAttribute("loginUserKey", user);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		jsonResult=new JsonResult("500", "登录异常",e.getMessage());	
	}
		JsonWriter.writer(response,jsonResult);
	}		
}


