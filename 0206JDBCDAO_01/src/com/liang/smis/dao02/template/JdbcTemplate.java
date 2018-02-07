package com.liang.smis.dao02.template;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.liang.smis.dao02.domin.Student;
import com.liang.smis.util.JdbcUtil;

public class JdbcTemplate {
	
	/**
	 * DML操作模板
	 * @param sql 可以是INSERT DELETE UPDATE
	 * @param paramters 具体的参数数组
	 * @return 受影响的行数
	 */
	public static int update(String sql, Object... paramters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcUtil.getConnect();
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < paramters.length; i++) {
				statement.setObject(i+1, paramters[i]);
			}
			return statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
		return 0;
	}
	
	
	// 这里耦合太严重，不好 ❌，改造
//	/**
//	 * DQL操作模板
//	 * @param sql SELECT
//	 * @param paramters 
//	 * @return 返回对应的对象列表
//	 */
//	public static List<Student> query(String sql, Object... paramters) {
//		List<Student> list = new ArrayList<Student>();
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet set = null;
//		try {
//			connection = JdbcUtil.getConnect();
//			statement = connection.prepareStatement(sql);
//			for (int i = 0; i < paramters.length; i++) {
//				statement.setObject(i+1, paramters[i]);
//			}
//			
//			set = statement.executeQuery();
//			while (set.next()) {
//				// 这里不好，写死了对象
//				Student student = new Student();
//				student.setId(set.getLong("id"));
//				student.setName(set.getString("name"));
//				student.setAge(set.getInt("age"));
//				list.add(student);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(connection, statement, set);
//		}
//		
//		return list;
//	}
	
	// 这里返回出去的Object需要强制转换，不好 ❌，继续改造
	/**
	 * DQL操作模板==============这里是改进后的
	 * @param sql SELECT
	 * @param paramters 
	 * @return 返回对应的对象列表
	 */
//	public static Object query(String sql, IResultSetHandler rHandler,Object... paramters) {
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet set = null;
//		try {
//			connection = JdbcUtil.getConnect();
//			statement = connection.prepareStatement(sql);
//			for (int i = 0; i < paramters.length; i++) {
//				statement.setObject(i+1, paramters[i]);
//			}
//			
//			set = statement.executeQuery();
//			
//			return rHandler.handle(set);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(connection, statement, set);
//		}
//		
//		return null;
//	}
	
	
	// 这里通过泛型来解决强制转换的问题 ✅
	/**
	 * DQL操作模板==============这里是改进后的
	 * @param sql SELECT
	 * @param paramters 
	 * @return 返回对应的对象列表
	 */
	// 这里为什么T<T>不行啊，疯了？⚠️
	// 我曹，这里应该是<T>T，反了啊
	public static <T> T query(String sql, IResultSetHandler<T> rHandler,Object... paramters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			connection = JdbcUtil.getConnect();
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < paramters.length; i++) {
				statement.setObject(i+1, paramters[i]);
			}
			
			set = statement.executeQuery();
			
			return rHandler.handle(set);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, set);
		}
		
		return null;
	}
	
}
