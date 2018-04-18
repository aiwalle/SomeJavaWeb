package ssh.service;


import ssh.domain.Employee;
import ssh.query.EmployeeQueryObject;
import ssh.query.PageResult;

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
