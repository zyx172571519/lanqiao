package org.taru.lanqiao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/*
 * ת�������
 */
public class encodingFilter implements Filter{
	
	String encoding="utf-8";
	
	/**
	 * ��ȡweb.xml����init-parm���õ�ֵ
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		 encoding=filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		System.out.println(1);
		chain.doFilter(request, response);
		System.out.println(2);
	}
	@Override
	public void destroy() {	
	}

}
