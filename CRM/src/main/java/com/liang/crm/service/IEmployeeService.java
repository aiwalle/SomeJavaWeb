package com.liang.crm.service;

import com.liang.crm.domain.Employee;
import com.liang.crm.domain.Role;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.QueryObject;

import java.util.List;

/**
 * Created by liang on 2018/4/14.
 */
public interface IEmployeeService {
    int save(Employee emp);

    int update(Employee emp);

    int delete(Long id);

    int updateState(Long id);

    Employee get(Long id);

    List<Employee> selectAll();

    PageResult queryByCondition(QueryObject qo);

    Employee queryByLogin(String username, String password);



}
