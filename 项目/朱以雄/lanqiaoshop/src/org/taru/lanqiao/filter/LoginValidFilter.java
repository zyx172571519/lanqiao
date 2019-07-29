package org.taru.lanqiao.filter;

import java.io.IOException;

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
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.vo.JsonResult;

//@WebFilter("/api/*")
public class LoginValidFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request=(HttpServletRequest)req;
			HttpServletResponse response=(HttpServletResponse)res;
			HttpSession session=request.getSession(false);
			if(session!=null) {
				Object user = session.getAttribute("loginUserKey");
				if(user!=null) {
					chain.doFilter(request, response);
					return;
					
				}
			}
			JsonResult result=new JsonResult(Constants.STATUS_ERROR,"ÎÞ·¨µÇÂ½");
			JsonWriter.writer(response, result);
			
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
