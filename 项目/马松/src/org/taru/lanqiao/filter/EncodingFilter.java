package org.taru.lanqiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ���ñ��������
 * @author 
 *
 */
public class EncodingFilter  implements  Filter {
	String   encodingValue ="utf-8";
	
	
	@Override
	public void destroy() {
		System.out.println("destroy  filter");
	}

	/**
	 * ���˷���
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encodingValue);//ֻ���POST��ʽ
		response.setCharacterEncoding(encodingValue);
		chain.doFilter(request, response); //ִ����һ��������
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		if(config.getInitParameter("encodingKey")!=null){
			encodingValue=	config.getInitParameter("encodingKey");
		}
		
		
	}

}
