package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.OrderService;
import org.taru.lanqiao.service.impl.OrderServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.Constants;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/order/selectTop")
public class OrderSelectTopServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult jr;
		try {
			String year = req.getParameter("year");
			if(year != null) {
				OrderService orderService = new OrderServiceImpl();
				List list = orderService.selectTop(year);
				jr = new JsonResult(Constants.STATUS_SUCCESS, "��ѯ�ɹ�", list);
			}else{
				jr = new JsonResult(Constants.STATUS_NOT_FOUND, "��ѯʧ�ܣ����������");
			}
			
		}catch (Exception e) {
			jr = new JsonResult(Constants.STATUS_ERROR, "��ѯ�쳣");
		}
		JsonWriter.writer(resp, jr);
	}
}
