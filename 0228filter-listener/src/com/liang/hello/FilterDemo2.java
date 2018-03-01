package com.liang.hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo2 implements Filter {

	public void destroy() {
		System.out.println("FilterDemo2.destroy()");
	
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterDemo2.init()");
		
		
		
		
	}
	 
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("FilterDemo2.before");
		// 放行
		chain.doFilter(request, response);
		System.out.println("FilterDemo2.after");
	}
	
	
	
}
