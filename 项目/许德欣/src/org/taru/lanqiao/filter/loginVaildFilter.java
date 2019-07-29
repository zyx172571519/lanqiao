package org.taru.lanqiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginVaildFilter implements Filter{
	public void destroy() {
		
	}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws ServletException,IOException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		String path=request.getRequestURI();
		System.out.println(path);
		if("/lanqiaoshop/api/login".equals(path)) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session=request.getSession(false);
		if(session != null) {
			Object user=session.getAttribute("loginUserKey");
			if(user!=null) {
				chain.doFilter(request, response);
				return;
			}
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
