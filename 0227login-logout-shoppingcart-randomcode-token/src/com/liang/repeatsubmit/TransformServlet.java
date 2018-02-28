package com.liang.repeatsubmit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/transform")
public class TransformServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	
		// 这里是防止表单重复提交的主要代码
		// 生成token的代码在jsp中
		String tokenInRequest = req.getParameter("token");
		String tokenInSession = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		
		if (tokenInRequest.equals(tokenInSession)) {
			// 这句是让token失效的关键代码
			req.getSession().removeAttribute("TOKEN_IN_SESSION");
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			String money = req.getParameter("money");
			System.out.println("转出"+money);
			out.println("转账成功");
		} else {
			System.out.println("提交失败");
		}
		
		
		
		
	}
}
