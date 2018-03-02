package com.liang.smis.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.liang.smis.dao.IUserDAO;
import com.liang.smis.domin.User;
import com.liang.smis.template.IResultSetHandler;
import com.liang.smis.template.JdbcTemplate;

public class UserDAOImpl implements IUserDAO {

	public User getUserByUsername(String username) {
		
		String sql = "SELECT * FROM t_user WHERE username = ?";
		return JdbcTemplate.query(sql, new IResultSetHandler<User>() {
			public User handler(ResultSet resultSet) throws Exception {
				if (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getLong("id"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					return user;
				}
				return null;
			}
		}, username);
	}

}
