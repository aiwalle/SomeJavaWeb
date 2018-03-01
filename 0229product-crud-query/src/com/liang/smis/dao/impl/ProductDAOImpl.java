package com.liang.smis.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.liang.smis.dao.IProductDAO;
import com.liang.smis.domin.Product;
import com.liang.smis.query.ProductQueryObject;
import com.liang.smis.template.IResultSetHandler;
import com.liang.smis.template.JdbcTemplate;
import com.liang.smis.util.JdbcUtil;

public class ProductDAOImpl implements IProductDAO {

	public void sava(Product obj) {
		String sql = "INSERT INTO product(productName,brand,supplier,salePrice,costPrice,cutoff,dir_id) VALUES(?,?,?,?,?,?,?)";
		Object[] params = {obj.getProductName(), obj.getBrand(), obj.getSupplier(),obj.getSalePrice(),obj.getCostPrice(),obj.getCutoff(),obj.getDir_id()};
		JdbcTemplate.update(sql, params);
	}

	public void update(Product obj) {
		String sql = "UPDATE product SET productName=?,brand=?,supplier=?,salePrice=?,costPrice=?,cutoff=?,dir_id=? WHERE id=?";
		Object[] params = {obj.getProductName(), obj.getBrand(), obj.getSupplier(),obj.getSalePrice(),obj.getCostPrice(),obj.getCutoff(),obj.getDir_id(),obj.getId()};
		JdbcTemplate.update(sql, params);
	}

	public void delete(Long id) {
		String sql = "DELETE FROM product WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id = ?";
		List<Product> list = JdbcTemplate.query(sql, new ProductResultSetHandler(), id);
		return list.size() == 1 ? list.get(0) : null;
	}

	
	
	//贾琏欲执事
	public List<Product> list() {
		String sql = "SELECT * FROM product";
		return JdbcTemplate.query(sql, new ProductResultSetHandler());
	}
	
	class ProductResultSetHandler implements IResultSetHandler<List<Product>> {
		public List<Product> handler(ResultSet resultSet) throws SQLException {
			List<Product> list = new ArrayList<>();
			while (resultSet.next()) {
				Product product = new Product();
				list.add(product);
				product.setId(resultSet.getLong("id"));
				product.setProductName(resultSet.getString("productName"));
				product.setBrand(resultSet.getString("brand"));
				product.setSupplier(resultSet.getString("supplier"));
				product.setCutoff(resultSet.getDouble("cutoff"));
				product.setCostPrice(resultSet.getBigDecimal("costPrice"));
				product.setSalePrice(resultSet.getBigDecimal("salePrice"));
				product.setDir_id(resultSet.getLong("dir_id"));
			}
			return list;
		}
	}

	public List<Product> query(String name, BigDecimal minSalePrice, BigDecimal maxSalePrice) {
		//=========================第一版====================================
//		String sql = "SELECT * FROM product WHERE 1=1";
//		List<Object> parameters = new ArrayList<>();
//		// 商品名称
//		if (StringUtils.isNotBlank(name)) {
//			sql += " AND productName LIKE ?";
//			parameters.add("%" + name + "%");
//		}
//		// 最低价格
//		if (minSalePrice != null) {
//			sql += " AND salePrice >= ?";
//			parameters.add(minSalePrice);
//		}
//		// 最高价格
//		if (maxSalePrice != null) {
//			sql += " AND salePrice <= ?";
//			parameters.add(maxSalePrice);
//		}
//		// ⚠️这里需要的是一个object数组，而不是一个List，因此需要通过toArray进行转换
//		return JdbcTemplate.query(sql, new ProductResultSetHandler(),parameters.toArray());
		
		
		//===============================第一版改良==============================
		// StringBuilder比较高效
		StringBuilder sql = new StringBuilder(80);
		sql.append("SELECT * FROM product WHERE 1=1");
		List<Object> parameters = new ArrayList<>();
		// 商品名称
		if (StringUtils.isNotBlank(name)) {
			sql.append(" AND productName LIKE ?");
			parameters.add("%" + name + "%");
		}
		// 最低价格
		if (minSalePrice != null) {
			sql.append(" AND salePrice >= ?");
			parameters.add(minSalePrice);
		}
		// 最高价格
		if (maxSalePrice != null) {
			sql.append(" AND salePrice <= ?");
			parameters.add(maxSalePrice);
		}
		// ⚠️这里需要的是一个object数组，而不是一个List，因此需要通过toArray进行转换
		return JdbcTemplate.query(sql.toString(), new ProductResultSetHandler(),parameters.toArray());
		
	}
	
	public List<Product> query(ProductQueryObject obj) {
		//=============================第二版================================
		// 对应的最终的sql和parameters放到了ProductQueryObject中
		String sql = "SELECT * FROM product" + obj.getQuery();
		
		obj.getQuery();
		System.out.println(obj.getQuery());
		System.out.println("查询参数  " + obj.getParameters());
		// ⚠️这里需要的是一个object数组，而不是一个List，因此需要通过toArray进行转换
		return JdbcTemplate.query(sql, new ProductResultSetHandler(), obj.getParameters().toArray());
	}
	

}
