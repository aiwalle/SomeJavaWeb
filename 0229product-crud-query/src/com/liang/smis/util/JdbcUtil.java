package com.liang.smis.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtil {
	private JdbcUtil() {}
	
	private static Properties properties = new Properties();
	private static DataSource dataSource = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			dataSource = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		}
	}
}
