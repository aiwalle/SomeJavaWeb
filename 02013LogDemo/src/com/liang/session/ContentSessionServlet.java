package com.liang.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session/content")
public class ContentSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		System.out.println("==========================================3");

		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		
		PrintWriter out = resp.getWriter();
		System.out.println("username/list/" + username);
		out.print("欢迎:" + username + "<br>");
		out.println("<a href='#'>需要吃午饭了</a>");

	}

}
