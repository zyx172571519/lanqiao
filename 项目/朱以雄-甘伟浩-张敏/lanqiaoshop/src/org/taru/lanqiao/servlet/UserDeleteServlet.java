package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.UserService;
import org.taru.lanqiao.service.impl.UserServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/user/del")
public class UserDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult jr;
		try {
			UserService userService = new UserServiceImpl();
			String id = req.getParameter("uid");
			int i = userService.userDelete(id);
			if(i == 1) {
				jr = new JsonResult(Constants.STATUS_SUCCESS, "É¾³ý³É¹¦");
			}else {
				jr = new JsonResult(Constants.STATUS_FAIL, "É¾³ýÊ§°Ü");
			}
		}catch (Exception e) {
			jr = new JsonResult(Constants.STATUS_ERROR, "É¾³ýÒì³£");
		}
		JsonWriter.writer(resp, jr);
	}
}
