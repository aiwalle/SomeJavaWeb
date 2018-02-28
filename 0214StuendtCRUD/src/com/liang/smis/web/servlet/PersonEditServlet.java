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

@WebServlet("/person/edit")
public class PersonEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPersonDAO dao;
	
	public void init() throws ServletException {
		
		dao = new PersonDAOImpl();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("==========================================");
		//1.接受请求参数，封装对象
		String id = request.getParameter("id");
//		System.out.println(id);
		//2.调用业务方法，处理请求
		if (hasLength(id)) {
//			System.out.println(id);
			Person person = dao.get(Long.valueOf(id));
			request.setAttribute("person", person);
		}
//		System.out.println(person);
		//3.控制页面跳转
		request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);
	}
	
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
