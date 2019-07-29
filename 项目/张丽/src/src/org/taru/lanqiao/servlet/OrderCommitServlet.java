package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.OrderDetail;
import org.taru.lanqiao.service.OderServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
/**
 * �ύ����
 */
@WebServlet("/api/order/commit")
public class OrderCommitServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderUserId=(request.getParameter("orderUserId"));
		String orderTotalPrice=(request.getParameter("orderTotalPrice"));
		String orderComment=(request.getParameter("orderComment"));
		OderServiceImpl impl=new OderServiceImpl();
		JsonResult jsonResult;
		try {
			String row=impl.oderCommit(orderUserId, orderTotalPrice, orderComment);
			if(row!=null){
				jsonResult =new JsonResult("200","����ɹ�",row);
			}else{
				jsonResult =new JsonResult("404","����ʧ��",null);
			}
		} catch (Exception e) {
			jsonResult =new JsonResult("500","�����ύ�쳣",e.getMessage());
		}
		JsonWriter.writer(response, jsonResult);
	}
}
