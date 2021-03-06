package com.liang.smis.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.liang.smis.dao.IProductDAO;
import com.liang.smis.dao.impl.ProductDAOImpl;
import com.liang.smis.domin.Product;

public class ProductDAOTest {

	private IProductDAO dao = new ProductDAOImpl();
	
	
	@Test
	public void testSava() {
		Product product = dao.get(1L);
//		System.out.println(product);
		product.setProductName("机械键盘");
		product.setCostPrice(new BigDecimal("100"));
		product.setSalePrice(new BigDecimal("500"));
		dao.sava(product);
		
	}

	@Test
	public void testUpdate() {
		Product product = dao.get(23L);
		product.setProductName("大牛键盘");
		dao.update(product);
	}

	@Test
	public void testDelete() {
		dao.delete(22L);
	}

	@Test
	public void testGet() {
		Product product = dao.get(2L);
		System.out.println(product);
	}

	@Test
	public void testList() {
		List<Product> list = dao.list();
		for (Product product : list) {
			System.out.println(product);
		}
		
		
	}

}
