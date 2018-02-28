package com.liang.repeatsubmit;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = UUID.randomUUID().toString();
		req.getSession().setAttribute("TOKEN_IN_SESSION", token);
		req.setAttribute("token", token);
		req.getRequestDispatcher("/repeatsubmit/input.jsp").forward(req, resp);
	}
	
	
}
