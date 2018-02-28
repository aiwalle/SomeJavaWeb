package com.liang.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/param/content")
public class ContentServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		System.out.println("==========================================");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		System.out.println("username/list/" + username);
		out.print("欢迎:" + username + "<br>");
		out.println("<a href='#'>需要吃午饭了</a>");
		
	}
	
}
