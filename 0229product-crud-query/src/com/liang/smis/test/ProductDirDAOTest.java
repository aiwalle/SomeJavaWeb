package com.liang.smis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.liang.smis.dao.IProductDirDAO;
import com.liang.smis.dao.impl.ProductDirDAOImpl;
import com.liang.smis.domin.ProductDir;

public class ProductDirDAOTest {

	private IProductDirDAO dao = new ProductDirDAOImpl();
	@Test
	public void testSava() {
		ProductDir dir = new ProductDir();
		dir.setDirName("哈哈");
		dir.setParentid(11);
		dao.sava(dir);
	}

	@Test
	public void testUpdate() {
		ProductDir dir = new ProductDir();
		dir.setId(6L);
		dir.setDirName("大大");
		dir.setParentid(40);
		dao.update(dir);
	}

	@Test
	public void testDelete() {
		dao.delete(6L);
	}

	@Test
	public void testGet() {
		ProductDir dir = dao.get(1L);
		System.out.println(dir);
	}

	@Test
	public void testList() {
		List<ProductDir> list = dao.list();
		for (ProductDir productDir : list) {
			System.out.println(productDir);
		}
		
	}

}
