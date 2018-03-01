package com.liang.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 通过访问 http://localhost:8080/hello 然后通过下面的方法重定向到hello.jsp的话，
		// 会有两个请求，dofilter方法也会执行两次
//		resp.sendRedirect("/hello.jsp");
		
		
		// web.xml中如果是REQUEST的话，那么dofilter方法会执行一次，也就是说只拦截了request，没有拦截dispatch
		// 加上<dispatcher>FORWARD</dispatcher>那么会对请求转发做拦截，dofilter方法会执行两次
		req.getRequestDispatcher("/hello.jsp").forward(req, resp);;
	}
	
	
}
