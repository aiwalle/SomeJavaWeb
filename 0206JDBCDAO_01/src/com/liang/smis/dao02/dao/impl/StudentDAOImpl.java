package com.liang.smis.dao02.dao.impl;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.liang.smis.dao02.dao.IStudentDAO;
import com.liang.smis.dao02.domin.Student;
import com.liang.smis.dao02.template.IResultSetHandler;
import com.liang.smis.dao02.template.JdbcTemplate;
import com.liang.smis.dao02.template.handler.BeanListHandler;
import com.liang.smis.util.DbcpUtil;
import com.liang.smis.util.JdbcUtil;


public class StudentDAOImpl implements IStudentDAO{

	public void saveStudent(Student student) {
//		StringBuilder sql = new StringBuilder(80);
//		sql.append("INSERT INTO t_student(name, age) VALUES(?,?)");
//		sql.append("'").append(student.getName()).append("'");
//		sql.append(",").append(student.getAge());
//		sql.append(")");
		String sql = "INSERT INTO t_student (name, age) VALUES(?,?)";
		Connection connection = null;
//		Statement statement = null;
		PreparedStatement statement = null;
		try {
			connection = DbcpUtil.getConnect();
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
//			System.out.println(student);
//			System.out.println(sql.toString());
			statement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
	}


	public void deleteStudent(Long id) {
		String sql = "DELETE FROM t_student WHERE id = ?";
		Connection connection = null;
//		Statement statement = null;
		PreparedStatement statement = null;
		try {
			connection = DbcpUtil.getConnect();
//			statement = connection.createStatement();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();		
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


	public void updateStudent(Long id, Student student) {
//		StringBuilder sql = new StringBuilder(80);
//		sql.append("UPDATE t_student SET name =");
//		sql.append("'").append(student.getName()).append("'");
//		sql.append(",").append("age =").append(student.getAge());
		// 这里的where前面有一个空格
//		sql.append(" where id =").append(id);
		String sql = "UPDATE t_student SET name = ?, age = ? where id = ?";
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbcpUtil.getConnect();
			statement = connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setLong(3, id);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();		
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


	public Student getStudent(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?";
		Connection connection = null;
//		Statement statement = null;
		PreparedStatement statement = null;
		try {
//			Class.forName(this.driverClassName);
//			connection = DriverManager.getConnection(this.url, this.username, this.password);
			connection = DbcpUtil.getConnect();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
//			statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery();
			if (rSet.next()) {
				Student student = new Student();
				student.setId(rSet.getLong("id"));
				student.setName(rSet.getString("name"));
				student.setAge(rSet.getInt("age"));
				return student;
			}
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
		}
		return null;
	}

	public List<Student> list() {
		String sql = "SELECT * FROM t_student";
		List<Student> list = new ArrayList<>();
		Connection connection = null;
//		Statement statement = null;
		PreparedStatement statement = null;
		try {
//			Class.forName(this.driverClassName);
//			connection = DriverManager.getConnection(this.url, this.username, this.password);
			connection = DbcpUtil.getConnect();
//			statement = connection.createStatement();
			statement = connection.prepareStatement(sql);
			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				Student student = new Student();
				list.add(student);
				student.setId(rSet.getLong("id"));
				student.setName(rSet.getString("name"));
				student.setAge(rSet.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
		}
		return list;
	}
	
	// 这里是基于事务的代码
	public void studentTransaction() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet set = null;
		String sql = "SELECT * FROM t_student WHERE name = ? AND balance >= ?";
		try {
			connection = DbcpUtil.getConnect();
			statement = connection.prepareStatement(sql);
			statement.setString(1, "张无忌");
			statement.setInt(2, 1000);
			set = statement.executeQuery();
			if (!set.next()) {
				throw new RuntimeException("账户余额不足");
			}
			// 事务的代码，设置取消事务的自动提交 事务1️⃣
			connection.setAutoCommit(false);
			
			sql = "UPDATE t_student SET balance = balance - ? WHERE name = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 1000);
			statement.setString(2, "张无忌");
			statement.executeUpdate();
//			int a = 1 / 0;
			sql = "UPDATE t_student SET balance = balance + ? WHERE name = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 1000);
			statement.setString(2, "赵敏");
			statement.executeUpdate();
			// 提交事务 事务2️⃣
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				// 事务3️⃣
				connection.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} finally {
			DbcpUtil.close(connection, statement, set);
		}
		
	}
	
	//======================以下是经过模板重构后的======================/
	public void newSaveStudent(Student student) {
		String sql = "INSERT INTO t_student(name, age) VALUES(?, ?)";
		Object[] paramters = {student.getName(), student.getAge()};
		JdbcTemplate.update(sql, paramters);
	}
	
	public void newDeleteStudent(Long id){
		String sql = "DELETE FROM t_student WHERE id = ?";
		Object[] paramters = {id};
		JdbcTemplate.update(sql, paramters);
	}
	
	public void newUpdateStudent(Long id, Student student) {
		String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ?";
		Object[] paramters = {student.getName(), student.getAge(), id};
		JdbcTemplate.update(sql, paramters);
	}
	
	public Student newGetStudent(Long id) {
		String sql = "SELECT * FROM t_student WHERE id = ?";
//		List<Student> list = JdbcTemplate.query(sql, id);
		IResultSetHandler rHandler = new BeanListHandler<>(Student.class);
		// 这里需要强制转换，不好
//		List<Student> list = JdbcTemplate.query(sql, rHandler, id);
		List<Student> list = JdbcTemplate.query(sql, new BeanListHandler<>(Student.class), id);
		return list.size() == 1 ? list.get(0) : null;
	}
	
	public List<Student> newList() {
		String sql = "SELECT * FROM t_student";
		return JdbcTemplate.query(sql, new BeanListHandler<>(Student.class));
	}

}
