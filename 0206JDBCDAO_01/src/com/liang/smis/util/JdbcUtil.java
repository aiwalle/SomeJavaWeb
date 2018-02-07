package com.liang.smis.util;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class JdbcUtil {
//	public static String driverClassName = "com.mysql.jdbc.Driver";
//	public static String url = "jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8";
//	public static String username = "root";
//	public static String password = "root";
	
	private static Properties p = new Properties();

	static {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("db.properties");
			p.load(stream);
		} catch (Exception e) {
			throw new RuntimeException("加载classpath路径下的db.properties文件失败", e);
		}
		
		
		try {
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("数据库加载驱动失败", e);
		}
	}
	
	
	
	public static Connection getConnect() {
		try {
			return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		throw new RuntimeException("数据库连接异常");
	}
	
	public static void close(Connection connection, Statement statement, ResultSet rSet) {
		try {
			if (rSet != null) {
				rSet.close();
			}
		} catch (Exception e5) {
			e5.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	private JdbcUtil() {}
}
