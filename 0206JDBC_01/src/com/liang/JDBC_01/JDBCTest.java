package com.liang.JDBC_01;

//import static org.junit.Assert.*;

//import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

//	一般开发的顺序:
//	   1):先建立模型对象:domain
//	   2):编写DAO接口.
//	   3):定义DAO实现类.
//	   4):生产DAO测试类.
//	   5):实现DAO实现类.
//	   6):在DAO测试类中测试DAO方法.

public class JDBCTest {
	
//	public static void main(String[] args) throws Exception {
//		JDBCTest jt = new JDBCTest();
//		jt.testCreateTable();
//	}
	
	
	@Test
	public void testCreateTable() {
		String sql = "CREATE TABLE IF NOT EXISTS t_student(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT)";
		// 2.获取连接对象
		Connection conn = null;
		// 3.创建语句对象
		Statement st = null; 
		try {
			// 1.加载注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo", "root", "root");
			st = conn.createStatement();
			// 4.执行sql语句
			int rows = st.executeUpdate(sql);
			System.out.println(rows);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 5.释放资源
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}		
		}
	}
	
	
	@Test
	public void testInsert() throws Exception {
		String sql = "INSERT INTO t_student(name, age) VALUES('乔峰',33)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		Statement st = conn.createStatement();
		int rows = st.executeUpdate(sql);
		System.out.println(rows);
		st.close();
		conn.close();
	}
	
	@Test
	public void testUpdate() throws Exception {
		String sql = "UPDATE t_student SET name = '郭靖', age = 44 where id = 4";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		Statement st = conn.createStatement();
		int rows = st.executeUpdate(sql);
		System.out.println(rows);
		st.close();
		conn.close();
	}
	
	@Test
	public void testDelete() throws Exception {
		String sql = "DELETE FROM t_student where id = 3";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		Statement st = conn.createStatement();
		int rows = st.executeUpdate(sql);
		System.out.println(rows);
		st.close();
		conn.close();
	}
	
	// 查询表中有多少条数据
	@Test
	public void testGetCount() throws Exception {
		String sql = "SELECT COUNT(id) count from t_student";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		Statement statement = conn.createStatement();
		ResultSet set = statement.executeQuery(sql);
		if (set.next()) {
			// 这种是普通方式，可以不加别名
			long totalCount = set.getLong(1);
			// 这种是别名方式，必须有别名
//			long totalCount = set.getLong("count");
			System.out.println(totalCount);
		}
		statement.close();
		conn.close();
	}
	
	@Test
	public void testQueryAll() throws Exception {
		String sql = "SELECT * FROM t_student";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		Statement statement = conn.createStatement();
		ResultSet rSet = statement.executeQuery(sql);
		while (rSet.next()) {
			long sid = rSet.getLong("id");
			String name = rSet.getString("name");
			int age = rSet.getInt("age");
			System.out.println(sid + "," + name + "," + age);
		}
		statement.close();
		conn.close();
	}
	
	@Test
	public void testQuerySingle() throws Exception {
		String sql = "SELECT * FROM t_student where id = 8";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8", "root", "root");
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		if (resultSet.next()) {
			// 这里的参数为结果集中的列名
			long sid = resultSet.getLong("id");
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			System.out.println(sid + "," + name + "," + age);
		}
		statement.close();
		conn.close();
	}
	
	
	
}
