package com.liang.smis.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liang.smis.dao.IProductDAO;
import com.liang.smis.dao.IProductDirDAO;
import com.liang.smis.domin.Product;
import com.liang.smis.domin.ProductDir;
import com.liang.smis.template.IResultSetHandler;
import com.liang.smis.template.JdbcTemplate;
import com.liang.smis.util.JdbcUtil;

public class ProductDirDAOImpl implements IProductDirDAO {

	public void sava(ProductDir obj) {
		String sql = "INSERT INTO productdir(dirname, parentid) VALUES(?,?)";
		JdbcTemplate.update(sql, obj.getDirName(), obj.getParentid());
	}

	public void update(ProductDir obj) {
		String sql = "UPDATE productdir SET dirname=?, parentid=? WHERE id = ?";
//		System.out.println("==========================================");
		JdbcTemplate.update(sql, obj.getDirName(), obj.getParentid(), obj.getId());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM productdir WHERE id = ?";
		JdbcTemplate.update(sql, id);
	}

	public ProductDir get(Long id) {
		String sql = "SELECT * FROM productdir WHERE id = ?";
		List<ProductDir> list = JdbcTemplate.query(sql, new ProductDirResultSetHandler(), id);
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	public List<ProductDir> list() {
		String sql = "SELECT * FROM productdir";
		return JdbcTemplate.query(sql, new ProductDirResultSetHandler());
	}

	
	class ProductDirResultSetHandler implements IResultSetHandler<List<ProductDir>> {
		public List<ProductDir> handler(ResultSet resultSet) throws Exception {
			List<ProductDir> list = new ArrayList<>();
			while (resultSet.next()) {
				ProductDir dir = new ProductDir();
				list.add(dir);
				dir.setId(resultSet.getLong("id"));
				dir.setDirName(resultSet.getString("dirname"));
				dir.setParentid(resultSet.getInt("parentid"));
			}
			return list;
		}
		
	}
	

}
