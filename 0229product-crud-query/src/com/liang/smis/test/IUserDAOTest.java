package com.liang.smis.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.liang.smis.dao.IUserDAO;
import com.liang.smis.dao.impl.UserDAOImpl;
import com.liang.smis.domin.User;

public class IUserDAOTest {

	private IUserDAO dao = new UserDAOImpl();
	
	@Test
	public void testGetUserByUsername() {
		User user = dao.getUserByUsername("admin");
		System.out.println(user);
		
	}

}
