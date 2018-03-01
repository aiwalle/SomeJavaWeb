package com.liang.smis.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.liang.smis.domin.Product;
import com.liang.smis.util.JdbcUtil;

public class JdbcTemplate {
	private JdbcTemplate() {}
	
	//DML
	public static int update(String sql, Object...params) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcUtil.getConn();
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i+1, params[i]);
			}
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
		return 0;
	}
	
	
	//DQL
	public static <T> T query(String sql, IResultSetHandler<T> rsh,Object...params) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getConn();
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i+1, params[i]);
			}
			resultSet = statement.executeQuery();
			return rsh.handler(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, resultSet);
		}
		return null;
	}
}
