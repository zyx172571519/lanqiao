package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.service.LoginService;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.util.JsonWriter;


@WebServlet("/api/login/fod")
public class LoginServlet extends HttpServlet {
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String username=req.getParameter("username");
    	String password =req.getParameter("password");
    	LoginService ss=new LoginService();
    	List list=ss.login(username, password);
    	JsonResult  jsonResult=null;
    	if(list!=null&list.size()>0) {
    		
    		jsonResult=new JsonResult("200", "�û�����ɹ�", list);
    		
    	
    	}else {
    		jsonResult=new JsonResult("500", "�û�����ʧ��", list);
    		
    	}
    	
    	JsonWriter.writer(resp,jsonResult);

    			
    }
}