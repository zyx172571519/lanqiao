package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.service.UserService;
import org.taru.lanqiao.service.impl.UserServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/user/findById")
public class UserFindByIdServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult jr;
		UserService userService = new UserServiceImpl();
		try {
			String id = req.getParameter("userId");
			User user = userService.userFindById(id);
			jr = new JsonResult(Constants.STATUS_SUCCESS, "查询成功", user);
		}catch (Exception e) {
			jr = new JsonResult(Constants.STATUS_ERROR, "查询异常");
		}
		JsonWriter.writer(resp, jr);
	}
}
