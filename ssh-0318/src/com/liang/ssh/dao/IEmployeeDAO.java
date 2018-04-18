package com.liang.ssh.dao;

import java.util.List;

import com.liang.ssh.domain.Employee;

public interface IEmployeeDAO {
	void save(Employee e);

	void update(Employee e);
	
	void delete(Employee e);
	
	Employee get(Long id);
	
	List<Employee> listAll();
}
