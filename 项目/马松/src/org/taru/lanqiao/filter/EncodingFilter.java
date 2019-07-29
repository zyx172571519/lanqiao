package org.taru.lanqiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 设置编码过滤器
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
	 * 过滤方法
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encodingValue);//只解决POST方式
		response.setCharacterEncoding(encodingValue);
		chain.doFilter(request, response); //执行下一个过滤器
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		if(config.getInitParameter("encodingKey")!=null){
			encodingValue=	config.getInitParameter("encodingKey");
		}
		
		
	}

}
