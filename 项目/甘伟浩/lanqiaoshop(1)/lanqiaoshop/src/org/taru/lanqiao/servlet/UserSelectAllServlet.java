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
import org.taru.lanqiao.util.PageHelper;
import org.taru.lanqiao.vo.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/user/list")
public class UserSelectAllServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult jr;
		UserService userService = new UserServiceImpl();
		try {
			String pageNum = req.getParameter("pageNum");
			int _pageNum = 1;
			String pageSize = req.getParameter("pageSize");
			int _pageSize = 8;
			String telphone = req.getParameter("userTelphone");
			String shopName = req.getParameter("userShopName");
			if(pageNum != null) {
				_pageNum = Integer.valueOf(pageNum);
			}
			if(pageSize != null) {
				_pageSize = Integer.valueOf(pageSize);
			}
			PageHelper ph = userService.userSelectAll(_pageNum, _pageSize, telphone, shopName);
			jr = new JsonResult(Constants.STATUS_SUCCESS, "≥…π¶", ph);
		}catch (Exception e) {
			e.printStackTrace();
			jr = new JsonResult(Constants.STATUS_ERROR, "“Ï≥£");
		}
		JsonWriter.writer(resp, jr);
	}
}
