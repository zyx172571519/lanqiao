package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.UserServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

/**
 * 注册用户
 * @author zm
 *
 */
@WebServlet("/api/user/add")
public class UserRegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String userId=request.getParameter("userId");
		String userUserName=request.getParameter("userUserName");
		String userPassword=request.getParameter("userPassword");
		String userTelphone=request.getParameter("userTelphone");
		String userAddress=request.getParameter("userAddress");
		String userShopName=request.getParameter("userShopName");
		UserServiceImpl usimp=new UserServiceImpl();
		JsonResult jsonResult=null;
		try {
			int user=usimp.userRegister(userId, userUserName, userPassword, userTelphone, userAddress, userShopName);
				jsonResult=new JsonResult("200", "成功",user);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult=new JsonResult("500", "异常",e.getMessage());	
		}
		JsonWriter.writer(response,jsonResult);
		
	}

}
