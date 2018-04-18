package com.liang.crm.service;

import com.liang.crm.domain.Department;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.QueryObject;

import java.util.List;

/**
 * Created by liang on 2018/4/15.
 */
public interface IDepartmentService {
    int save(Department dept);

    int update(Department dept);

    int delete(Long id);

    Department get(Long id);

    List<Department> selectAll();

    PageResult queryByCondition(QueryObject qo);

}
