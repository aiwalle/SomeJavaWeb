package com.liang.encode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 这行代码 应该放到 过滤器中
//		req.setCharacterEncoding("UTF-8");
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		System.out.println(username + "  " + password);
	}
	
}
