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


@WebServlet("/person/list")
public class PersonListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IPersonDAO dao;
	
	public void init() throws ServletException {
		
		dao = new PersonDAOImpl();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接受请求参数，封装对象
		List<Person> list = dao.list();
//		System.out.println(list);
		//2.调用业务方法，处理请求
		request.setAttribute("people", list);
		//3.控制页面跳转
		request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
	}
}
