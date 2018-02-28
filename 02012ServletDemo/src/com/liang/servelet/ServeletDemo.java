package com.liang.servelet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServeletDemo")
public class ServeletDemo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("ServeletDemo.init()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("ServeletDemo.service()");
//		String name = req.getServerName();
//		System.out.println(name);
//		System.out.println(req.getContextPath());
//		System.out.println("==========================================");
//		System.out.println(req.getParameter("name"));
		
		
		System.out.println(req.getParameter("username"));
		
	}
	
	@Override
	public void destroy() {
		System.out.println("ServeletDemo.destroy()");
	}
}
