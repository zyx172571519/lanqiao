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
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/user/update")
public class UserUpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult jr;
		try {
			UserService userServie = new UserServiceImpl();
			String userId = req.getParameter("userId");
			String userUserName = req.getParameter("userUserName");
			String userPassword = req.getParameter("userPassword");
			String userTelphone = req.getParameter("userTelphone");
			String userAddress = req.getParameter("userAddress");
			String userShopName = req.getParameter("userShopName");
			String userComment = req.getParameter("userComment");
			
			User user = new User();
			user.setUserId(userId);
			user.setUserUserName(userUserName);
			user.setUserPassword(userPassword);
			user.setUserTelphone(userTelphone);
			user.setUserAddress(userAddress);
			user.setUserShopName(userShopName);
			user.setUserComment(userComment);
			int i = userServie.userUpdate(user);
			if(i == 1) {
				jr = new JsonResult(Constants.STATUS_SUCCESS, "修改成功");
			}else {
				jr = new JsonResult(Constants.STATUS_FAIL, "修改失败");
			}
			
		}catch (Exception e) {
			jr = new JsonResult(Constants.STATUS_ERROR, "修改异常");
		}
		JsonWriter.writer(resp, jr);
		
	}
}
