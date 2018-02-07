package com.liang.smis.dao01.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.liang.smis.dao01.dao.IStudentDAO;
import com.liang.smis.dao01.domin.Student;
import com.liang.smis.util.JdbcUtil;

public class StudentDAOImpl implements IStudentDAO{

	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/jdbcDemo?useUnicode=true&characterEncoding=UTF-8";
	private String username = "root";
	private String password = "root";
	
	
	public void saveStudent(Student student) {
		StringBuilder sql = new StringBuilder(80);
		sql.append("INSERT INTO t_student(name, age) VALUES(");
		sql.append("'").append(student.getName()).append("'");
		sql.append(",").append(student.getAge());
		sql.append(")");
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(this.driverClassName);
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			statement = connection.createStatement();
			statement.executeUpdate(sql.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
	}


	public void deleteStudent(Long id) {
		String sql = "DELETE FROM t_student WHERE id =" + id.toString();
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(this.driverClassName);
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
	}


	public void updateStudent(Long id, Student student) {
		StringBuilder sql = new StringBuilder(80);
		sql.append("UPDATE t_student SET name =");
		sql.append("'").append(student.getName()).append("'");
		sql.append(",").append("age =").append(student.getAge());
		// 这里的where前面有一个空格
		sql.append(" where id =").append(id);
//		System.out.println(sql.toString());
		
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName(this.driverClassName);
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			statement = connection.createStatement();
			statement.executeUpdate(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();		
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
		
	}


	public Student getStudent(Long id) {
		String sql = "SELECT * FROM t_student WHERE id =" + id;
		Connection connection = null;
		Statement statement = null;
		ResultSet rSet = null;
		try {
			Class.forName(this.driverClassName);
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			statement = connection.createStatement();
		    rSet = statement.executeQuery(sql);
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
			JdbcUtil.close(connection, statement, rSet);
		}
		return null;
	}

	public List<Student> list() {
		String sql = "SELECT * FROM t_student";
		List<Student> list = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rSet = null;
		try {
			Class.forName(this.driverClassName);
			connection = DriverManager.getConnection(this.url, this.username, this.password);
			statement = connection.createStatement();
			rSet = statement.executeQuery(sql);
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
			JdbcUtil.close(connection, statement, rSet);
		}
		return list;
	}

}
