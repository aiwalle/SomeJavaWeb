package com.liang.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie/login")
public class LogCookieServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
//		Cookie cookie = new Cookie("username", username);
		// 中文的处理
		Cookie cookie = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
		resp.addCookie(cookie);
		
//		if ("admin".equals(username) && "123".equals(password)) {
			out.println("欢迎" + username + "<br>");
			out.println("<a href='/cookie/list'>收件箱(5)</a>");
//		}
		
	}
}
