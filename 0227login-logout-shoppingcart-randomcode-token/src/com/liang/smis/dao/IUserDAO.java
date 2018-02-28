package com.liang.smis.dao;

import com.liang.smis.domin.User;

public interface IUserDAO {
	public User getUserByUsername(String username);
}
