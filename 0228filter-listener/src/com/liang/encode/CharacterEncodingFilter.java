package com.liang.encode;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {

	
	private String encoding;
	
	private Boolean forceEncoding;
	
	public void init(FilterConfig filterConfig) throws ServletException {

		 this.encoding = filterConfig.getInitParameter("encoding");
		 // 是否强制使用编码，哪怕已经有编码
		 this.forceEncoding = Boolean.valueOf(filterConfig.getInitParameter("force"));
		 
		 
	}
	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.类型转换
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		
		
		//2.设置编码 这里写死了 不好
		// 通过web.xml中的初始化信息来动态配置
		if (hasLength(encoding) && (request.getCharacterEncoding() == null || forceEncoding)) {
			request.setCharacterEncoding(encoding);
		}
		
		//3.放行，
		chain.doFilter(httpServletRequest, httpServletResponse);
	}
	
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
	
	
	public void destroy() {

	}

	
	
}
