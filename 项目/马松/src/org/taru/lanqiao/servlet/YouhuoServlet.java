package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.WuhuoService;
import org.taru.lanqiao.service.YouhuoService;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;



@WebServlet("/api/youhuo/fod")
public class YouhuoServlet extends HttpServlet{
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	          String id =req.getParameter("id");
	          YouhuoService ss =new YouhuoService();
	          JsonResult  jsonResult=null;
				try{
					ss.youhuo(id);
					jsonResult =new JsonResult("200", "修改商品有货状态成功",id);
				}catch (Exception e) {
					e.printStackTrace();
					jsonResult =new JsonResult("500", "修改商品有货状态失败",e.getMessage());
				}
				JsonWriter.writer(resp, jsonResult);				
		}
}
