package com.liang.crm.service.impl;

import com.liang.crm.domain.Permission;
import com.liang.crm.mapper.PermissionMapper;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.PermissionQueryObject;
import com.liang.crm.query.QueryObject;
import com.liang.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liang on 2018/4/17.
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private PermissionMapper dao;


    public PageResult selectByCondition(PermissionQueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if (count > 0) {
            List<Permission> result = dao.queryByCondition(qo);
            return new PageResult(count, result);
        } else {
            return PageResult.EMPTY;
        }
    }


    public PageResult queryByRid(Long rid) {
        List<Permission> result = dao.queryByRid(rid);
        return new PageResult(Long.parseLong(result.size()+""), result);
    }

    public Permission queryByResource(String function) {
        return dao.queryByResource(function);
    }

    public List<Permission> queryPermissionByEid(Long id) {
        return dao.queryPermissionByEid(id);
    }
}
