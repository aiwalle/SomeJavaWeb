package com.liang.crm.mapper;

import com.liang.crm.domain.Employee;
import com.liang.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int updateState(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Long queryByConditionCount(QueryObject qo);

    List<Employee> queryByCondition(QueryObject qo);

    Employee queryByLogin(@Param("username") String username, @Param("password") String password);

    int handlerRelation(@Param("eid") Long eid, @Param("rid") Long rid);

    int deleteRolesByEid(Long eid);
}