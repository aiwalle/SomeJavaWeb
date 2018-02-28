package com.liang.jdbcTest;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

import java.sql.Connection;;


/**
 * 测试sql注入问题
 * @author liang
 *
 */
public class TestLog {
	
	@Test
	public void testLogin() {
		try {
//			login("zs", "zs");
			// 这是一段错误的，但是也可以正常执行成功
//			login("zs' or 'zs", "zs");
			// 下面为最优做法
			login1("zs' or 'zs", "zs");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户登录方法
	 * @param username
	 * @param password
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void login(String username, String password) throws Exception {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// 3.创建执行sql语句的对象
		Statement stmt = conn.createStatement();
		// 4.书写sql语句
		// select * from tbl_user where uname='zs' and upassword='zs'    对的
		// select * from tbl_user where uname=zs and upassword=zs		    错的
		// select * from tbl_user where uname='zs' or 'zs' and upassword='zs'   错误
		String sql = "select * from tbl_user where " + "uname='" + username + "' and upassword='" + password + "'";
		// 5.打印sql
		System.out.println(sql);
		// 6.执行sql
		ResultSet rs = stmt.executeQuery(sql);
		// 7.对结果集进行处理
		if (rs.next()) {
			System.out.println("恭喜您" + username + "，登录成功");
//			System.out.println(username);
		} else {
			System.out.println("账号或密码错误");
		}
		// 8.关闭对应的资源
		if (rs != null) {
			rs.close();
		}
		
		if (stmt != null) {
			stmt.close();
		}
		
		if (conn != null) {
			conn.close();
		}
		
	}
	
	
	public void login1(String username, String password) throws ClassNotFoundException, SQLException {
		// 1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08", "root", "root");
		// 3.编写sql语句
		String sql = "select * from tbl_user where uname=? and upassword=?";
		// 4.创建预处理对象
		PreparedStatement ppst = conn.prepareStatement(sql);
		// 5.给占位符设置参数
		ppst.setString(1, username);
		ppst.setString(2, password);
		// 6.执行查询操作
		ResultSet rs = ppst.executeQuery();
		// 7.对结果集进行处理
		if (rs.next()) {
			System.out.println("恭喜您" + username + "，登录成功");
//			System.out.println(username);
		} else {
			System.out.println("账号或密码错误");
		}
		// 8.关闭对应的资源
		if (rs != null) {
			rs.close();
		}
		
		if (ppst != null) {
			ppst.close();
		}
		
		if (conn != null) {
			conn.close();
		}
		
	}
}
