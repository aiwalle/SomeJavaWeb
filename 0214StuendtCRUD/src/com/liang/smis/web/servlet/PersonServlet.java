package com.liang.smis.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.liang.smis.dao.IPersonDAO;
import com.liang.smis.dao.impl.PersonDAOImpl;
import com.liang.smis.domin.Person;


@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IPersonDAO dao;
	
	public void init() throws ServletException {
		dao = new PersonDAOImpl();
	}
	
	// 分发
	// http://localhost/student?cmd=save 	保存操作
	// http://localhost/student?cmd=delete 	删除操作
	// http://localhost/student?cmd=edit 	编辑操作
	// http://localhost/student			 	列表操作
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		

		
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if ("save".equals(cmd)) {
			this.saveOrUpdate(request, response);
		} else if ("delete".equals(cmd)) {
			System.out.println("delete");
			this.delete(request, response);
		} else if ("edit".equals(cmd)) {
			this.edit(request, response);
		} else {
			this.list(request, response);
		}
	}
	
	// 列表操作
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("PersonServlet.list()");
		List<Person> list = dao.list();
		request.setAttribute("people", list);
		request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
	}
	
	// 编辑操作
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (hasLength(id)) {
			Person person = dao.get(Long.valueOf(id));
			request.setAttribute("person", person);
		}
		request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);
	}
	
	// 删除操作
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		dao.delete(id);
		response.sendRedirect(request.getContextPath() + "/person");
	}
	
	// 保存和更新操作
	protected void saveOrUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		Person person = new Person();
		person.setName(name);
		person.setAge(Integer.valueOf(age));
		if (hasLength(pid)) {
			dao.update(Long.valueOf(pid), person);
		} else {
			dao.save(person);
		}
		response.sendRedirect(request.getContextPath() + "/person");
	}
	
	
	
	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
