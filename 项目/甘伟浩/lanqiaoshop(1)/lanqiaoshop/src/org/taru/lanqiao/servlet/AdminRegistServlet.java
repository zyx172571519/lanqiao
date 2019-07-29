package org.taru.lanqiao.servlet;

import java.io.IOException;

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
 * ¹ÜÀíÔ±×¢²á
 * @author CoCo
 *
 */
@WebServlet("/admin/regist")
public class AdminRegistServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JsonResult jr;
		int i;
		AdminService adminService = new AdminServiceImpl();
		Admin admin = new Admin();
		try {
			admin.setUsername(req.getParameter("username"));
			admin.setPassword(req.getParameter("password"));
			admin.setTelphone(req.getParameter("telphone"));
			admin.setEmail(req.getParameter("email"));
			admin.setRealname(req.getParameter("realname"));
			i = adminService.adminRegist(admin);
			if(i == 1) {
				jr = new JsonResult(Constants.STATUS_SUCCESS, "×¢²á³É¹¦");
			}else {
				jr = new JsonResult(Constants.STATUS_ERROR, "×¢²áÊ§°Ü");
			}
		}catch (Exception e) {
			jr = new JsonResult(Constants.STATUS_ERROR, "×¢²áÒì³£");
		}
		JsonWriter.writer(resp, jr);
	}
	
}
