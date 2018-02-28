package com.liang.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.jar.Attributes.Name;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/list")
public class ListSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		System.out.println("==========================================2");
		PrintWriter out = resp.getWriter();
		// 普通情况
//		HttpSession session = req.getSession();
//		String username = (String) session.getAttribute("username");
//		System.out.println(username);
		
		// 对象情况
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");

		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println(user);
		
		
		out.print("欢迎:" + username + "<br>");
		out.println("<a href='/session/content'>邮件一</a><br>");
		out.println("<a href='/session/content'>邮件二</a><br>");
		out.println("<a href='/session/content'>邮件三</a><br>");

	}

}
