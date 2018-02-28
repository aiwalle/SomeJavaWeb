package com.liang.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/login")
public class LogSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 普通情况
//		HttpSession session = req.getSession();
//		session.setAttribute("username", username);
//		System.out.println(session);
		
		// 对象情况
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		// session其实是基于cookie的，但是
		
		// 下面是session的代码
		HttpSession session = req.getSession();
		session.setAttribute("user", user);

		
		
//		if ("admin".equals(username) && "123".equals(password)) {
			out.println("欢迎" + username + "<br>");
			out.println("<a href='/session/list'>收件箱(5)</a>");
//		}
		
	}
}
