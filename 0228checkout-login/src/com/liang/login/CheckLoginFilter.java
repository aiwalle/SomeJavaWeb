package com.liang.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletRequest.setCharacterEncoding("UTF-8");
		
		System.out.println("当前请求的资源"+httpServletRequest.getRequestURI());
		
		String requestUri = httpServletRequest.getRequestURI();
		
		//==============================这里是防止死循环的代码===============================
		// 这里其实也不好，因为下面的字符串都是写死的，耦合太高，
		// 好的做法是将某些需要权限的资源的路径配置为"/system/*"
		if (!"/login.jsp".equals(requestUri) && !"/login".equals(requestUri)) {
			Object username = httpServletRequest.getSession().getAttribute("USER_IN_SESSION");
			if (username == null) {
				System.out.println("没用户");
				httpServletResponse.sendRedirect("/login.jsp");
				return;
			} 
		}
		//=============================================================
		
		// 当我们访问login.jsp的时候，会进入下面的方法，判断出没用户，又会继续走login.jsp，那么这么不断的走
		// 就会产生死循环，不断地访问login.jsp，不断的判断，不断地重定向
//		Object username = httpServletRequest.getSession().getAttribute("USER_IN_SESSION");
//		if (username == null) {
//			System.out.println("没用户");
//			httpServletResponse.sendRedirect("/login.jsp");
//			return;
//		} 
		
		chain.doFilter(httpServletRequest, httpServletResponse);
		
		
	}
	
	
	

}
