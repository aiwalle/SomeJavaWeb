package com.liang.crm.service.impl;

import com.liang.crm.domain.Department;
import com.liang.crm.mapper.DepartmentMapper;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.QueryObject;
import com.liang.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liang on 2018/4/15.
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper dao;

    public int save(Department dept) {
        return dao.insert(dept);
    }

    public int update(Department dept) {
        return dao.updateByPrimaryKey(dept);
    }

    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public Department get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public List<Department> selectAll() {
        return dao.selectAll();
    }

    public PageResult queryByCondition(QueryObject qo) {
        return null;
    }

}
