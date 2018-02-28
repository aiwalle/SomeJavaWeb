package com.liang.smis.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liang.smis.dao.IUserDAO;
import com.liang.smis.dao.impl.UserDAOImpl;
import com.liang.smis.domin.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private IUserDAO dao;
	
	public void init() throws ServletException {
		dao = new UserDAOImpl();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//1.接受请求参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//2.调用业务方法处理请求
		User user = dao.getUserByUsername(username);
		//3.
		if (user == null) {
			req.setAttribute("errorMsg", "账号或者密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		
		if (!password.equals(user.getPassword())) {
			req.setAttribute("errorMsg", "账号或者密码错误哈哈哈");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		// 登录成功跳转商品列表
		req.getSession().setAttribute("USER_IN_SESSION", user);
		resp.sendRedirect("/product");
		
	}

}
