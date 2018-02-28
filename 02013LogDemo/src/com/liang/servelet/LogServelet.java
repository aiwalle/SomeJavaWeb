package com.liang.servelet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/param/login")
public class LogServelet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("LogServelet.init()");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		System.out.println("==========================================");
		System.out.println(req);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username/log/"+username);
		if ("admin".equals(username) && "123".equals(password)) {
			writer.println("欢迎" + username + "<br>");
			writer.println("<a href='/param/list?username=" + username +"'>收件箱(5)</a>");
		}
		
		
		
	}
	
	@Override
	public void destroy() {
		System.out.println("LogServelet.destroy()");
	}
}
