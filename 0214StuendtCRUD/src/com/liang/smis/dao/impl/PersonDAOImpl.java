package com.liang.smis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.liang.smis.dao.IPersonDAO;
import com.liang.smis.template.JdbcTemplate;
import com.liang.smis.template.handler.BeanHandler;
import com.liang.smis.template.handler.BeanListHandler;
import com.liang.smis.domin.Person;
import com.liang.smis.util.DbcpUtil;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public void save(Person person) {
//		String sql = "INSERT INTO t_person (name, age) VALUES(?,?)";
//		Connection connection = null;
//		PreparedStatement statement = null;
//		try {
//			connection = DbcpUtil.getConnect();
//			statement = connection.prepareStatement(sql);
//			statement.setString(1, person.getName());
//			statement.setInt(2, person.getAge());
//			statement.executeUpdate();
//			System.out.println(person);
//			System.out.println(sql.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DbcpUtil.close(connection, statement, null);
//		}
		
		
		String sql = "INSERT INTO t_person(name, age) VALUES(?, ?)";
		Object[] paramters = {person.getName(), person.getAge()};
		JdbcTemplate.update(sql, paramters);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_person WHERE id = ?";
		Object[] paramters = {id};
		JdbcTemplate.update(sql, paramters);
	}

	@Override
	public void update(Long id, Person person) {
		String sql = "UPDATE t_person SET name = ?, age = ? WHERE id = ?";
		Object[] paramters = {person.getName(), person.getAge(), id};
		JdbcTemplate.update(sql, paramters);
	}

	@Override
	public Person get(Long id) {
		String sql = "SELECT * FROM t_person WHERE id = ?";
		Person person = JdbcTemplate.query(sql, new BeanHandler<>(Person.class), id);
		return person;
	}

	@Override
	public List<Person> list() {
		String sql = "SELECT * FROM t_person";
		return JdbcTemplate.query(sql, new BeanListHandler<>(Person.class));
	}

}
