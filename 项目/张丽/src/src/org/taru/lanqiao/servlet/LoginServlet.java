package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.UserServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.util.SecurityUtl;
import org.taru.lanqiao.vo.JsonResult;

/**
 *用户登录
 */
@WebServlet("/api/user/login")
public class LoginServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
		String username=requset.getParameter("username");
		String password=requset.getParameter("password");
		UserServiceImpl impl=new UserServiceImpl();
		JsonResult result;
		try {
			User user=impl.login(username,password);
			if(user==null){
				result=new JsonResult("404","用户名或密码错误",null);
			}else{
				result=new JsonResult("200","登录成功",user);
				//把登陆信息存储到session中，记录登陆状态
				HttpSession s = requset.getSession(true);
				s.setAttribute("loginUserKey", user);
				
				//使用cookie存储用户的状态，下次来的时候验证是否有这个标志（token）
				Cookie token=new Cookie("token",SecurityUtl.getMd5String("lanqiao"));
				Cookie nameStr =new Cookie("username",username);
				token.setMaxAge(60*60);
				nameStr.setMaxAge(60*60);
				token.setPath("/");
				nameStr.setPath("/");
				response.addCookie(token);
				response.addCookie(nameStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result=new JsonResult("500","登录异常",e.getMessage());
		}
		JsonWriter.writer(response, result);
	}
}
