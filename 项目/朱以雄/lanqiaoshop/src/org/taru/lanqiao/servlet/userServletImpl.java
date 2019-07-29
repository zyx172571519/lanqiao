package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.userServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.util.Constants;
@WebServlet("/api/user/insert")
public class userServletImpl extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String userUserName=request.getParameter("userUserName");
		String userPassword=request.getParameter("userPassword");
		String userTelphone=request.getParameter("userTelphone");
		String userAddress=request.getParameter("userAddress");
		String userShopName=request.getParameter("userShopName");
		userServiceImpl impl=new userServiceImpl();
		int num=0;
		JsonResult result=null;
		try {
			num=impl.insertUser(userId,userUserName, userPassword, userTelphone, userAddress, userShopName);
			result=new JsonResult(Constants.STATUS_SUCCESS,"×¢²á³É¹¦",num);
		}catch(Exception e) {
			result=new JsonResult(Constants.STATUS_ERROR,"×¢²áÊ§°Ü",num);
		}
		JsonWriter.writer(response, result);
	}

}
