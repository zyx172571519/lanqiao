package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.UserLoginServinceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;


@WebServlet("/api/user/login")
public class LoginServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-------------------");
			JsonResult 	jsonResult=new JsonResult("405","协议不对 请使用POST","");
			JsonWriter.writer(resp, jsonResult);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		UserLoginServinceImpl impl=new UserLoginServinceImpl();
		JsonResult jsonResult=null;
		try {
		User user = impl.queryUserById(username, password);
		if(user==null) {
			
			jsonResult=new JsonResult("404","用户名或密码错误",null);
		}else {
			
			jsonResult=new JsonResult("200","用户登录成功",user);
		}
		
		}catch(Exception e) {
		e.printStackTrace();
		jsonResult=new JsonResult("500","用户登录异常",e.getMessage());
		}
		JsonWriter.writer(resp, jsonResult);
	}
}
