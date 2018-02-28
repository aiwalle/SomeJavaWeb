package com.liang.cookie;

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


@WebServlet("/cookie/list")
public class ListCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		System.out.println("==========================================");
		PrintWriter out = resp.getWriter();
		String username = null;
		for (Cookie cook : req.getCookies()) {
			if ("username".equals(cook.getName())) {
				username  = cook.getValue();
			}
		}
		
		username = URLDecoder.decode(username, "UTF-8");
		out.print("欢迎:" + username + "<br>");
		out.println("<a href='/cookie/content'>邮件一</a><br>");
		out.println("<a href='/cookie/content'>邮件二</a><br>");
		out.println("<a href='/cookie/content'>邮件三</a><br>");

	}

}
