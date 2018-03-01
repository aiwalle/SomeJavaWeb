package com.liang.hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo3 implements Filter {

	public void destroy() {
		System.out.println("FilterDemo3.destroy()");
	
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterDemo3.init()");
		
		
		
		
	}
	 
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo3.before");
		// 放行
		chain.doFilter(request, response);
		System.out.println("FilterDemo3.after");
	}
	
	
	
}
