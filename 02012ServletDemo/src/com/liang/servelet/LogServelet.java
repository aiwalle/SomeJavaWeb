package com.liang.servelet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LogServelet")
// 下面这些是在注解里加入一些参数
//@WebServlet(value= {"/anno", "/anno2" },
//			loadOnStartup= 0,
//			initParams= {@WebInitParam(name="encoding",value="UTF-8")})
public class LogServelet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("LogServelet.init()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("ServeletDemo.service()");
//		String name = req.getServerName();
//		System.out.println(name);
//		System.out.println(req.getContextPath());
//		System.out.println("==========================================");
//		System.out.println(req.getParameter("name"));
		
		
		req.setCharacterEncoding("UTF-8");
		
//		System.out.println("==========================================");
//		System.out.println(req.getParameter("username"));
//		System.out.println("==========================================");
//		System.out.println(req.getParameter("password"));
//		System.out.println("==========================================");
//		System.out.println(req.getParameter("gender"));
//		System.out.println("==========================================");
		System.out.println(req.getParameter("hobby"));
//		String[] hobbies = req.getParameterValues("hobby");
//		System.out.println(Arrays.toString(hobbies));
//		System.out.println("==========================================");
//		System.out.println(req.getParameter("age"));
		
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("Java spring");
		writer.print("哈哈哈哈123");
		
		System.out.println("==========================================");
		System.out.println(System.getProperty("file.encoding")); 
		System.out.println(Charset.defaultCharset());
		
		
		resp.setContentType("text/html; charset=UTF-8");
		// 设置响应的编码格式
		System.out.println("==========================================1");
		System.out.println(resp.getContentType());
		System.out.println("==========================================2");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("LogServelet.destroy()");
	}
	

}
