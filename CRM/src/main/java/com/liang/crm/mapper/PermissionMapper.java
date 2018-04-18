package com.liang.crm.mapper;

import com.liang.crm.domain.Permission;
import com.liang.crm.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    Long queryByConditionCount(QueryObject qo);

    List<Permission> queryByCondition(QueryObject qo);
}