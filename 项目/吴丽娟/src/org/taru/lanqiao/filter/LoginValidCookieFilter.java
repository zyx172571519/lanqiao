package org.taru.lanqiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.util.SecurityUtl;
import org.taru.lanqiao.vo.JsonResult;

//@WebFilter("/api/*")
public class LoginValidCookieFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
		throws IOException,ServletException{
		HttpServletRequest request =(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		String path = request.getRequestURI();
		if("/lanqiaoshop/api/user/login".equals(path)) {
			chain.doFilter(request, response);
			return;
		}
		Cookie[] cookies=request.getCookies();
		if(cookies!=null && cookies.length>0) {
			for(Cookie c:cookies) {
				if(c.getName().equals("token")) {
					if(c.getValue().equals(SecurityUtl.getMd5String("lanqiao"))) {
						chain.doFilter(request, response);
					}
				}
			}
		}
		JsonResult result=new JsonResult("500","没有登录，无法访问","");
		JsonWriter.writer(response, result);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
