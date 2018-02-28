package com.liang.smis.dao02.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import com.liang.smis.dao02.dao.IStudentDAO;
import com.liang.smis.dao02.dao.impl.StudentDAOImpl;
import com.liang.smis.dao02.domin.Student;
import com.liang.smis.util.DbcpUtil;
import com.liang.smis.util.JdbcUtil;
//import com.mysql.jdbc.PreparedStatement;

public class StudentDAOTest {
	private IStudentDAO dao = new StudentDAOImpl();
	
	@Test
	public void testSave() throws Exception {
		Student student = new Student();
		student.setName("张飞");
		student.setAge(12);
		dao.saveStudent(student);
	}
	
	@Test
	public void testDelete() throws Exception {
//		Student student = new Student();
		dao.deleteStudent(20L);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Student student = new Student();
		student.setAge(99);
		student.setName("大牛");
		dao.updateStudent(30L, student);
	}
	
	@Test
	public void testGet() throws Exception {
		Student student = dao.getStudent(25L);
		System.out.println(student);
	}
	
	@Test
	public void testList() throws Exception {
		List<Student> list = dao.list();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testStudentTransaction() throws Exception {
		dao.studentTransaction();
	}
	
	
	// 使用statement，没有批量操作
	// InnoDB 1642ms
	@Test
	public void testSaveByStatement() throws Exception {
		Connection connection = JdbcUtil.getConnect();
		Statement statement = connection.createStatement();
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			String sql = "INSERT INTO t_student (name, age) VALUES('A'," + i + ")";
			statement.executeUpdate(sql);
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
		JdbcUtil.close(connection, statement, null);
	}
	
	// 使用statement，有批量操作
	// InnoDB 2268ms
	@Test
	public void testBatchSaveByStatement() throws Exception {
		Connection connection = JdbcUtil.getConnect();
		Statement statement = connection.createStatement();
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			String sql = "INSERT INTO t_student (name, age) VALUES('A'," + i + ")";
//			statement.executeUpdate(sql);
			statement.addBatch(sql);
			if (i % 200 == 0) {
				statement.executeBatch();
				statement.clearBatch();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
		JdbcUtil.close(connection, statement, null);
	}
	
	// 使用prepareStatement，没有批量操作
	// InnoDB 1332ms
	@Test
	public void testSaveByParperStatement() throws Exception {
		Connection connection = JdbcUtil.getConnect();
		String sql = "INSERT INTO t_student (name, age) VALUES('A',?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			statement.setInt(1, i);
			statement.executeUpdate();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
		JdbcUtil.close(connection, statement, null);
	}
	
	// 使用prepareStatement，有批量操作
	// InnoDB 1333ms
	@Test
	public void testBatchSaveByParperStatement() throws Exception {
		Connection connection = JdbcUtil.getConnect();
		String sql = "INSERT INTO t_student (name, age) VALUES('A',?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			statement.setInt(1, i);
			statement.addBatch();
			if (i % 200 == 0) {
				statement.executeBatch();
				statement.clearBatch();
				statement.clearParameters();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - beginTime);
		JdbcUtil.close(connection, statement, null);
	}
	
	// 获取插入数据后自动生成的主键 Statement
	@Test
	public void testGetStatementPK() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES('小倩', 88)";
		Connection connection = JdbcUtil.getConnect();
		Statement statement = connection.createStatement();
		statement.execute(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet set = statement.getGeneratedKeys();
		if (set.next()) {
			long pk = set.getLong(1);
			System.out.println(pk);
		}
		JdbcUtil.close(connection, statement, set);
	}
	
	// 获取插入数据后自动生成的主键 PreparedStatement
	@Test
	public void testGetParStatementPK() throws Exception {
		String sql = "INSERT INTO t_student (name, age) VALUES(?, ?)";
		Connection connection = JdbcUtil.getConnect();
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, "小猪️");
		statement.setInt(2, 44);
		statement.executeUpdate();
		ResultSet set = statement.getGeneratedKeys();
		if (set.next()) {
			long pk = set.getLong(1);
			System.out.println(pk);
		}
		JdbcUtil.close(connection, statement, set);
	}

	
	// 使用连接池
	@Test
	public void testPoolFirst() throws Exception {
		Connection connection = DbcpUtil.getConnect();
		String sql = "SELECT * FROM t_student";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();
		while (set.next()) {
			String name = set.getString("name");
			int age = set.getInt("age");
			System.out.println("name:" + name + "," + "age:" + age);
		}
		JdbcUtil.close(connection, statement, set);
	}
	
	//======================以下是经过模板重构后的======================/
	@Test
	public void testNewSave() throws Exception {
		Student student = new Student();
		student.setAge(99);
		student.setName("大牛");
		dao.newSaveStudent(student);
	}
	
	@Test
	public void testNewDelete() throws Exception {
		dao.newDeleteStudent(24642L);
	}
	
	@Test
	public void testNewUpdateStudent() throws Exception {
		Student student = new Student();
		student.setName("haha");
		student.setAge(11);
		dao.newUpdateStudent(24640L, student);
	}
	
	@Test
	public void testNewGetStudent() throws Exception {
		Object obj = dao.newGetStudent(24640L);
		System.out.println(obj);
	}
	
	@Test
	public void testNewAllStudent() throws Exception {
		List<Student> list = dao.newList();
		System.out.println(list);
//		System.out.println("这里是重构后获取所有的");
	}
	
	
}
