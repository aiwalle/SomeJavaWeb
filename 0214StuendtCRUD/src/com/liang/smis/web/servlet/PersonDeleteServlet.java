package com.liang.smis.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liang.smis.dao.IPersonDAO;
import com.liang.smis.dao.impl.PersonDAOImpl;
import com.liang.smis.domin.Person;

@WebServlet("/person/delete")
public class PersonDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPersonDAO dao;
	
	public void init() throws ServletException {
		
		dao = new PersonDAOImpl();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受请求参数，封装对象
		Long id = Long.valueOf(request.getParameter("id"));
		//2.调用业务方法，处理请求
//		System.out.println(id);
		dao.delete(id);
		//3.控制页面跳转
		response.sendRedirect("/person/list");
	}
}
