package com.liang.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/param/list")
public class ListServlet extends HttpServlet {


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
		System.out.println(req);
//		System.out.println(Arrays.toString(req.getParameterNames()));
		System.out.println("username/list/" + username);
		out.print("欢迎:" + username + "<br>");
		out.println("<a href='/param/content?username="+ username +"'>邮件一</a><br>");
		out.println("<a href='/param/content?username=" + username +"'>邮件二</a><br>");
		out.println("<a href='/param/content'>邮件三</a><br>");
	}

}
