package com.liang.wms.service;


import com.liang.wms.domain.Employee;
import com.liang.wms.query.EmployeeQueryObject;
import com.liang.wms.query.PageResult;

import java.util.List;

public interface IEmployeeService {
	void save(Employee e);

	void update(Employee e);
	
	void delete(Long id);
	
	Employee get(Long id);
	
	List<Employee> listAll();

	PageResult query(EmployeeQueryObject qo);

	void checkLogin(String usernmae, String password);
}
