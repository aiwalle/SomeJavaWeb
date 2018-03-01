package com.liang.shoppingcart.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liang.shoppingcart.domin.CartItem;
import com.liang.shoppingcart.domin.ShoppingCart;


@WebServlet("/shoppingcart")
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			this.save(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		}
		
		resp.sendRedirect("/shoppingcart/cart_list.jsp");
	}
	
	protected void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String num = req.getParameter("num");
		CartItem item = new CartItem();
		item.setName(name);
		item.setNum(Integer.valueOf(num));
		if ("IPhone".equals(name)) {
			item.setId("123");
			item.setPrice(new BigDecimal(5000));
		} else if ("IMac".equals(name)) {
			item.setId("456");
			item.setPrice(new BigDecimal(10000));
		} else {
			item.setId("789");
			item.setPrice(new BigDecimal(3000));
		}
		
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
		if (cart == null) {
			cart = new ShoppingCart();
			req.getSession().setAttribute("SHOPPINGCART_IN_SESSION", cart);
		}
		cart.save(item);
	}
	
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
		cart.delete(id);
	}
	
	

}
