package ssh.dao;

import ssh.domain.Employee;
import ssh.query.EmployeeQueryObject;
import ssh.query.PageResult;

public interface IEmployeeDAO extends IGenericDAO<Employee> {


    Employee checkLogin(String username, String password);
}
