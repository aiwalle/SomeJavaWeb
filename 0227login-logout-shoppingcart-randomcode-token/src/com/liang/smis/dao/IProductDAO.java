package com.liang.smis.dao;

import java.util.List;

import com.liang.smis.domin.Product;

public interface IProductDAO {
	void sava(Product obj);
	
	void update(Product obj);
	
	void delete(Long id);
	
	Product get(Long id);
	
	List<Product> list();
}
