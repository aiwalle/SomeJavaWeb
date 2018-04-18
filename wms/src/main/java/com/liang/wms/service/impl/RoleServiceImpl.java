package com.liang.wms.service.impl;

import com.liang.wms.dao.IRoleDAO;
import com.liang.wms.domain.Role;
import com.liang.wms.query.PageResult;
import com.liang.wms.query.QueryObject;
import com.liang.wms.service.IRoleService;

import java.util.List;

/**
 * Created by liang on 2018/4/4.
 */
public class RoleServiceImpl implements IRoleService {

    private IRoleDAO roleDAO;

    public void setRoleDAO(IRoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public void save(Role r) {
        roleDAO.save(r);
    }

    public void update(Role r) {
        roleDAO.update(r);
    }

    public void delete(Long id) {
        roleDAO.delete(id);
    }

    public Role get(Long id) {
        return roleDAO.get(id);
    }

    public List<Role> listAll() {
        return roleDAO.listAll();
    }

    public PageResult query(QueryObject qo) {
        return roleDAO.query(qo);
    }
}
