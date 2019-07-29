package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Dingdan;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.DingdanService;
import org.taru.lanqiao.service.ProductServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/dingdan/find")
public class DingdanQueryServlet extends HttpServlet{

@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//获取参数int pageNum,int pageSize
	int  pageNum = Integer.parseInt(req.getParameter("pagenum"));  
   int  pageSize= Integer.parseInt( req.getParameter("pagesize"));
     DingdanService dd=new DingdanService();
	 JsonResult  jsonResult=null;
	try{
		Dingdan dingdan =dd.queryDingdan(pageNum, pageSize);
		jsonResult =new JsonResult("200", "查询商品详情成功", dingdan);
	}catch (Exception e) {
		e.printStackTrace();
		jsonResult =new JsonResult("500", "查询商品详情失败",e.getMessage());
	}
	JsonWriter.writer(resp, jsonResult);

}
}
