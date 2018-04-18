package com.liang.crm.service;

import com.liang.crm.domain.Role;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.QueryObject;

import java.util.List;

/**
 * Created by liang on 2018/4/18.
 */
public interface IRoleService {
    int save(Role role);

    int update(Role role);

    Role get(Long id);

    List<Role> selectAll();

    PageResult queryByCondition(QueryObject qo);

    List<Role> queryRoleIdByEid(Long eid);
}
