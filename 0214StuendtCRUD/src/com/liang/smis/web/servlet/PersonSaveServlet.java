package com.liang.smis.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liang.smis.dao.IPersonDAO;
import com.liang.smis.dao.impl.PersonDAOImpl;
import com.liang.smis.domin.Person;


@WebServlet("/person/save")
public class PersonSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IPersonDAO dao;
	
	public void init() throws ServletException {
		
		dao = new PersonDAOImpl();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.接受请求参数，封装对象
		String pid = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		Person person = new Person();
		person.setName(name);
		person.setAge(Integer.valueOf(age));
		//2.调用业务方法，处理请求
		if (hasLength(pid)) {
			dao.update(Long.valueOf(pid), person);
		} else {
			dao.save(person);
		}
		
		//3.控制页面跳转
		response.sendRedirect("/person/list");
	}
	
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
	
}
