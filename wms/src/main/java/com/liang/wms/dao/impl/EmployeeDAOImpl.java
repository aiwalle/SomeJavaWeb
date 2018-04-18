package com.liang.wms.dao.impl;

import com.liang.wms.dao.IEmployeeDAO;
import com.liang.wms.domain.Employee;


public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements IEmployeeDAO {



    public Employee checkLogin(String username, String password) {
        return queryForObject(" obj.name = ? AND obj.password = ?", username, password);
    }
}
