package com.liang.crm.service.impl;

import com.liang.crm.domain.Permission;
import com.liang.crm.domain.Role;
import com.liang.crm.mapper.RoleMapper;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.QueryObject;
import com.liang.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liang on 2018/4/18.
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper dao;

    public int save(Role role) {
        int effectCount = dao.insert(role);
        //处理中间表关系
        List<Permission> permissions = role.getPermissions();
        if (permissions != null) {
            for (Permission permission : permissions) {
                dao.handlerRelation(role.getId(), permission.getId());
            }
        }
        return effectCount;
    }

    public int update(Role role) {
        int effectCount = dao.updateByPrimaryKey(role);
        // 处理中间表关系
        // 先删除
        dao.deletePermissionByRid(role.getId());
        // 后新增
        List<Permission> permissions = role.getPermissions();
        if (permissions != null) {
            for (Permission permission : permissions) {
                dao.handlerRelation(role.getId(), permission.getId());
            }
        }
        return effectCount;
    }

    public Role get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public List<Role> selectAll() {
        return dao.selectAll();
    }

    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Role> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }

    public List<Role> queryRoleIdByEid(Long eid) {
        return dao.queryRoleIdByEid(eid);
    }


}
