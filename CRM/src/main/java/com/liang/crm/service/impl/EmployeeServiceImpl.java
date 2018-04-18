package com.liang.crm.service.impl;

import com.liang.crm.domain.Employee;
import com.liang.crm.mapper.EmployeeMapper;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.QueryObject;
import com.liang.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liang on 2018/4/14.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper dao;

    public int save(Employee emp) {
        return dao.insert(emp);
    }

    public int update(Employee emp) {
        return dao.updateByPrimaryKey(emp);
    }

    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int updateState(Long id){
        return dao.updateState(id);
    }

    public Employee get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public List<Employee> selectAll() {
        return dao.selectAll();
    }

    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Employee> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }

    public Employee queryByLogin(String username, String password) {
        return dao.queryByLogin(username, password);
    }
}
