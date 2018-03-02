package com.liang.smis.dao;

import java.math.BigDecimal;
import java.util.List;

import com.liang.smis.domin.Product;
import com.liang.smis.page.PageResult;
import com.liang.smis.query.ProductQueryObject;
import com.liang.smis.query.QueryObject;

public interface IProductDAO {
	void sava(Product obj);
	
	void update(Product obj);
	
	void delete(Long id);
	
	Product get(Long id);
	
	List<Product> list();
	
	
	/**
	 * 
	 * @param name 				商品名称 productName LIKE '%name%'
	 * @param minSalePrice		最低价格 salePrice >= minSalePrice
	 * @param maxSalePrice		最高价格 salePrice <= maxSalePrice
	 * @return
	 */
	List<Product> query(String name, BigDecimal minSalePrice, BigDecimal maxSalePrice);
	
	
	/**
	 * 
	 * @param name 				商品名称 productName LIKE '%name%'
	 * @param minSalePrice		最低价格 salePrice >= minSalePrice
	 * @param maxSalePrice		最高价格 salePrice <= maxSalePrice
	 * @return
	 */
	List<Product> query(ProductQueryObject obj);
	
	
	PageResult query(Integer currentPage, Integer pageSize);
	
	// 高级查询+分页
	PageResult queryMore(QueryObject obj);
	
}
