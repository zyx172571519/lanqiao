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
import org.taru.lanqiao.util.StringUtil;
import org.taru.lanqiao.vo.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/user/add")
public class UserAddServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult jr;
		try {
			UserService userService = new UserServiceImpl();
			User user = new User();
			user.setUserUserName(req.getParameter("userUserName"));
			user.setUserPassword(req.getParameter("userPassword"));
			user.setUserTelphone(req.getParameter("userTelphone"));
			user.setUserAddress(req.getParameter("userAddress"));
			user.setUserShopName(req.getParameter("userShopName"));
			if(req.getParameter("userComment") == null) {
				user.setUserComment(" ");
			}else {
				user.setUserComment(req.getParameter("userComment"));
			}
			int i = userService.userAdd(user);
			if(i == 1) {
				jr = new JsonResult(Constants.STATUS_SUCCESS, "添加成功");
			}else {
				jr = new JsonResult(Constants.STATUS_FAIL, "添加失败");
			}
		}catch (Exception e) {
			e.printStackTrace();
			jr = new JsonResult(Constants.STATUS_ERROR, "添加异常");
		}
		JsonWriter.writer(resp, jr);
		
	}
}
