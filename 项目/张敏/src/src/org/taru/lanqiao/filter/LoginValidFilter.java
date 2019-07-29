package org.taru.lanqiao.filter;

import java.io.IOException;

import java.util.logging.LogRecord;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.util.JsonWriter;

@WebFilter("/api/*")
public class LoginValidFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
			throws IOException,ServletException{
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String path=req.getRequestURI();
		System.out.println(path);
		if("/lanqiao-alls/api/login".equals(path)) {
			chain.doFilter(req, res);
			return;
		}
		HttpSession session=req.getSession(false);
		if(session!=null){
			Object user=session.getAttribute("loginUserKey");
			if(user!=null) {
				chain.doFilter(req, res);
				return;
			}
			
		}
		JsonResult jsonResult=new JsonResult("500", "没有登录，无法访问","");
		JsonWriter.writer(res, jsonResult);
			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
