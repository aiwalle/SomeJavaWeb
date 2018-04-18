package ssh.dao.impl;

import ssh.dao.IEmployeeDAO;
import ssh.domain.Employee;


public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements IEmployeeDAO {



    public Employee checkLogin(String username, String password) {
        return queryForObject(" obj.name = ? AND obj.password = ?", username, password);
    }
}
