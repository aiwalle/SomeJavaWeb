package com.liang.smis.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DbcpUtil {
	private static DataSource dataSource;
	
	static {
		try {
			Properties properties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream inputStream = loader.getResourceAsStream("dbcp.properties");
			// 这里少写一句，走了不少弯路
			properties.load(inputStream);
			// 这里是德鲁伊连接池
			dataSource = DruidDataSourceFactory.createDataSource(properties);
			
			System.out.println(properties);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("加载classpath路径下的dbcp.properties文件失败", e);
		}
	}
	
	public static Connection getConnect() {
		try {
			return dataSource.getConnection();
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
	
	private DbcpUtil() { }
}
