package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Admin;
import org.taru.lanqiao.service.AdminService;
import org.taru.lanqiao.service.impl.AdminServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.Constants;
import org.taru.lanqiao.vo.JsonResult;

/**
 * 管理员登录
 * @author CoCo
 *
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult jr;
		Admin admin;
		AdminService adminService = new AdminServiceImpl();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			admin = adminService.adminLogin(username, password);
			if(admin != null) {
				jr = new JsonResult(Constants.STATUS_SUCCESS, "成功", admin);
			}else {
				jr = new JsonResult(Constants.STATUS_NOT_FOUND, "失败");
			}
			
		}catch (Exception e) {
			jr = new JsonResult(Constants.STATUS_FAIL, "异常");
		}
		JsonWriter.writer(resp, jr);
	}
}
