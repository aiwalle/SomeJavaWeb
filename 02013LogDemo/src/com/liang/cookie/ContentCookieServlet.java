package com.liang.cookie;

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


@WebServlet("/cookie/content")
public class ContentCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		System.out.println("==========================================");
		String username = null;
		for (Cookie cook : req.getCookies()) {
			if ("username".equals(cook.getName())) {
				username  = cook.getValue();
			}
		}
		username = URLDecoder.decode(username, "UTF-8");
		PrintWriter out = resp.getWriter();
		System.out.println("username/list/" + username);
		out.print("欢迎:" + username + "<br>");
		out.println("<a href='#'>需要吃午饭了</a>");

	}

}
