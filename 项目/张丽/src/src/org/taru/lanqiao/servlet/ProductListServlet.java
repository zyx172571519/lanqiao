package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.vo.PageResult;
/**
 * ��Ʒ�б��ѯ
 */
@WebServlet("/api/product/list")
public class ProductListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonResult result=null;
		try {
			int pageNum =Integer.parseInt(request.getParameter("pageNum"));
			int pageSize =Integer.parseInt(request.getParameter("pageSize"));
			ProductServiceImpl impl=new ProductServiceImpl();
			PageResult pageResult=impl.queryList(pageNum,pageSize);
			result=new JsonResult("200", "��ѯ�ɹ�",pageResult);
		} catch (Exception e) {
			e.printStackTrace();
			result=new JsonResult("500","��ѯ�쳣",null);
		}
		JsonWriter.writer(response, result);
	}
	
}
