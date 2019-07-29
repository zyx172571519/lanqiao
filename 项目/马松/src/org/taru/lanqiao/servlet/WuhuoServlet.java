package org.taru.lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.WuhuoService;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/wuhuo/find")
public class WuhuoServlet  extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String id =req.getParameter("id");
          WuhuoService ss =new WuhuoService();
          JsonResult  jsonResult=null;
			try{
				ss.Wuhuo(id);
				jsonResult =new JsonResult("200", "修改商品无货状态成功", "测试成功");
			}catch (Exception e) {
				e.printStackTrace();
				jsonResult =new JsonResult("500", "修改商品无货状态失败",e.getMessage());
			}
			JsonWriter.writer(resp, jsonResult);				
	}
          
    }
