package com.liang.smis.test;

import static org.junit.Assert.*;

import java.io.DataOutput;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import com.liang.smis.dao.IProductDAO;
import com.liang.smis.dao.impl.ProductDAOImpl;
import com.liang.smis.domin.Product;
import com.liang.smis.page.PageResult;
import com.liang.smis.query.ProductQueryObject;
import com.liang.smis.query.QueryObject;
import com.liang.smis.template.IResultSetHandler;
import com.liang.smis.template.JdbcTemplate;
import com.liang.smis.template.handler.BeanHandler;
import com.liang.smis.template.handler.BeanListHandler;

public class PageTest {

	private IProductDAO dao = new ProductDAOImpl();
	
	@Test
	public void testQueryMore() throws Exception {
		ProductQueryObject queryObject = new ProductQueryObject();
		queryObject.setCurrentPage(0);
		queryObject.setPageSize(10);
		queryObject.setName("M");
		
		queryObject.setMinSalePrice(new BigDecimal(100));
		queryObject.setMaxSalePrice(new BigDecimal(200));
		
		PageResult result = dao.queryMore(queryObject);
		System.out.println("========================size" + result.getListData().size());
		for (Object product : result.getListData()) {
			System.out.println(product);
		}
		
	}
	
	
	
	
	
	@Test
	public void testUsePageResultQuery() throws Exception {
		
		PageResult result = dao.query(1, 5);
		
		for (Object product : result.getListData()) {
			System.out.println(product);
		}
		
//		System.out.println(result.getListData());
		
	}
	
	
	
	@Test
	public <T> void testQuery() {
		Integer currentPage = 6;
		Integer pageSize = 5;
		
		String countSql = "SELECT COUNT(*) FROM product";
		
		
		Integer totalCount = JdbcTemplate.query(countSql, new IResultSetHandler<Long>() {
			public Long handler(ResultSet resultSet) throws Exception {
				if (resultSet.next()) {
					return resultSet.getLong(1);
				}
				return 0L;
			}
		}).intValue();
		
		System.out.println("totalCount:" + totalCount);
		//=============================================================
		String resultSql = "SELECT * FROM product LIMIT ?,?";
		
		Object[] params = {(currentPage - 1) * pageSize, pageSize};
		
		List<Product> list = JdbcTemplate.query(resultSql, new BeanListHandler<>(Product.class), params);
		
		for (Product product : list) {
			System.out.println(product);
		}
		
	}
	
	
}
