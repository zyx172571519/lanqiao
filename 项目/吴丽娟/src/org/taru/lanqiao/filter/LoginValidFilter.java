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

//@WebFilter("/api/*")
public class LoginValidFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		//如果是登录就放行
		String path =request.getRequestURI();
		System.out.println(path);
		if("/lanqiaoshop/api/user/login".equals(path)) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session =request.getSession(false);
		if(session!=null) {
			Object user=session.getAttribute("loginUserKey");
			if(user!=null) {
				chain.doFilter(request, response);
				return;
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
