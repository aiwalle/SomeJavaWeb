package com.liang.smis.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liang.smis.dao.IProductDAO;
import com.liang.smis.dao.IProductDirDAO;
import com.liang.smis.dao.impl.ProductDAOImpl;
import com.liang.smis.dao.impl.ProductDirDAOImpl;
import com.liang.smis.domin.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	// 商品dao
	private IProductDAO dao;
	// 商品类别dao
	private IProductDirDAO dirDao;
	
	
	public void init() throws ServletException {
		dao = new ProductDAOImpl();
		dirDao = new ProductDirDAOImpl();
	}
	
	
	
	//product?cmd=请求操作名称
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//只对POST有效，必须放在获取第一个参数之前
		String cmd = req.getParameter("cmd");
		if ("edit".equals(cmd)) {
			this.edit(req, resp);
		} else if ("delete".equals(cmd)) {
			this.delete(req, resp);
		} else if ("save".equals(cmd)) {
			this.saveOrUpdate(req, resp);
		} else {
			this.list(req, resp);
		}
		
	}

	//显示商品列表
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接受
		//2.调用
		List<Product> list = dao.list();
		//3.跳转
		req.setAttribute("products", list);
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
	}

	//删除指定商品
	protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (hasLength(id)) {
			dao.delete(Long.valueOf(id));
		}
		resp.sendRedirect("/product");
	}

	//编辑指定商品 
	protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (hasLength(id)) {
			Product product = dao.get(Long.valueOf(id));
			req.setAttribute("product", product);
		}
		req.setAttribute("productdir", dirDao.list());
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
	}

	//保存或更新指定商品
	protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Product product = new Product();
		this.request2obj(req,product);
		if (product.getId() != null) {
			dao.update(product);
			System.out.println("update");
		} else {
			dao.sava(product);
			System.out.println("save");
		}
		//statuscode 302 这里跳转到首页的时候响应为302，不知道原因
		resp.sendRedirect("/product");
	}


	//把请求中的参数封装成Product对象
	private void request2obj(HttpServletRequest req,Product product) {
		String id = req.getParameter("id");
		
		String productName = req.getParameter("productName");
		String brand = req.getParameter("brand");
		String supplier = req.getParameter("supplier");
		String dir_id = req.getParameter("dir_id");
		String costPrice = req.getParameter("costPrice");
		String salePrice = req.getParameter("salePrice");
//		System.out.println(salePrice);
		String cutoff = req.getParameter("cutoff");
		
		
		
		if (hasLength(id)) {
			product.setId(Long.valueOf(id));
		}
		
		product.setProductName(productName);
		product.setBrand(brand);
		product.setSupplier(supplier);
		product.setCostPrice(new BigDecimal(costPrice));
		product.setSalePrice(new BigDecimal(salePrice));
		product.setCutoff(Double.valueOf(cutoff));
		product.setDir_id(Long.valueOf(dir_id));
		System.out.println("==========================================");
		
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

}
