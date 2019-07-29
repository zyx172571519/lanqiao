package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.userServiceImpl;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.util.JsonWriter;

@WebServlet("/api/user/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		userServiceImpl serviceImpl=new userServiceImpl();
		JsonResult result=null;
		try {
			User user=serviceImpl.login(username, password);
			HttpSession session=request.getSession(true);
			session.setAttribute("loginKey",user);
			result=new JsonResult(Constants.STATUS_SUCCESS, "³É¹¦",user);
		}catch(Exception e) {
			e.printStackTrace();
			result=new JsonResult(Constants.STATUS_ERROR, "Ê§°Ü");
		}
		JsonWriter.writer(response, result);
		
	}
}
