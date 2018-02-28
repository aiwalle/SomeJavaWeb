package com.liang.smis.dao;

import java.util.List;

import com.liang.smis.domin.ProductDir;

public interface IProductDirDAO {
	void sava(ProductDir obj);
	
	void update(ProductDir obj);
	
	void delete(Long id);
	
	ProductDir get(Long id);
	
	List<ProductDir> list();
}
