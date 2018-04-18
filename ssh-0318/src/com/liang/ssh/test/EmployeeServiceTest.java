package com.liang.ssh.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liang.ssh.dao.IEmployeeDAO;
import com.liang.ssh.domain.Employee;
import com.liang.ssh.service.IEmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	public void testSave() {
		Employee employee = new Employee();
		employee.setName("张小猪");
		employee.setAge(28);
		employeeService.save(employee);
	}

	@Test
	public void testUpdate() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("哈哈哈哈");
		employee.setAge(28);
		employeeService.update(employee);
	}

	@Test
	public void testDelete() {
		Employee employee = new Employee();
		employee.setId(3L);
		employeeService.delete(employee);;
	}

	@Test
	public void testGet() {
		Employee employee = employeeService.get(1L);
		System.out.println(employee);
	}

	@Test
	public void testListAll() {
		List<Employee> list = employeeService.listAll();
		System.out.println(list);
	
	}

}
