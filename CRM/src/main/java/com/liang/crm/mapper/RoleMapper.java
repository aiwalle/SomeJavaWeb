package com.liang.crm.mapper;

import com.liang.crm.domain.Role;
import com.liang.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    Long queryByConditionCount(QueryObject qo);

    List<Role> queryByCondition(QueryObject qo);

    // 由于这里是两个参数，因此这里必须要通过Param来指定对应的参数名
    int handlerRelation(@Param("rid")Long rid, @Param("pid") Long pid);

    int deletePermissionByRid(Long rid);


    List<Role> queryRoleIdByEid(Long eid);
}