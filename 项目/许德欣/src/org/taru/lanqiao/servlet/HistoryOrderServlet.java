package org.taru.lanqiao.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Order;
import org.taru.lanqiao.service.historyServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
/**
 * 查询历史订单
 * @author Administrator
 *
 */
@WebServlet("/api/order/selectHistory")
public class HistoryOrderServlet extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String id=request.getParameter("userid");
		historyServiceImpl impl=new historyServiceImpl();
		JsonResult result=null;
		try {
			Order order=impl.queryHisByUid(id);
			result=new JsonResult("200","查询历史订单成功",order);
		}catch(Exception e){
			e.printStackTrace();
			result=new JsonResult("404","查询历史订单失败",e.getMessage());
		}
		JsonWriter.writer(response, result);
	}

}
