package com.liang.wms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.liang.wms.dao.IEmployeeDAO;
import com.liang.wms.domain.Employee;
import com.liang.wms.domain.Permission;
import com.liang.wms.domain.Role;
import com.liang.wms.query.EmployeeQueryObject;
import com.liang.wms.query.PageResult;
import com.liang.wms.service.IEmployeeService;
import com.liang.wms.util.MD5;
import com.liang.wms.util.UserContext;

public class EmployeeServiceImpl implements IEmployeeService {

	private IEmployeeDAO employeeDAO;

	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public void save(Employee e) {
		e.setPassword(MD5.encode(e.getPassword()));
		employeeDAO.save(e);
	}

	public void update(Employee e) {
		employeeDAO.update(e);
	}

	public void delete(Long id) {
		employeeDAO.delete(id);
	}

	public Employee get(Long id) {
		return employeeDAO.get(id);
	}

	public List<Employee> listAll() {
		return employeeDAO.listAll();
	}


	public PageResult query(EmployeeQueryObject qo) {
		return employeeDAO.query(qo);
	}

	public void checkLogin(String username, String password) {
		//1.根据username和password来查询用户
		Employee current = employeeDAO.checkLogin(username, MD5.encode(password));
		if (current == null) {
			throw new RuntimeException("亲，账号或密码不正确！");
		}
		//2.把当前用户存到session中
		UserContext.setEmployee(current);
		if (!current.isAdmin()) {
			//3.把当前用户的权限查询出来，存到session中
			Set<String> permissionSet = new HashSet<String>();//存放当前用户拥有的权限
			List<Role> roles = current.getRoles();
			for (Role role : roles) {
				List<Permission> ps = role.getPermissions();
				for (Permission p : ps) {
					permissionSet.add(p.getExpression());
				}
			}
			UserContext.setPermissions(permissionSet);
		}
	}

}
