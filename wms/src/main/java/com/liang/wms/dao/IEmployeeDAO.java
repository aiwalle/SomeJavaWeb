package com.liang.wms.dao;

import com.liang.wms.domain.Employee;
import com.liang.wms.query.EmployeeQueryObject;
import com.liang.wms.query.PageResult;

public interface IEmployeeDAO extends com.liang.wms.dao.IGenericDAO<Employee> {


    Employee checkLogin(String username, String password);
}
