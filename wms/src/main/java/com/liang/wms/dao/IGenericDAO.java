package com.liang.wms.dao;

import com.liang.wms.query.PageResult;
import com.liang.wms.query.QueryObject;

import java.util.List;

/**
 * Created by liang on 2018/4/2.
 * 泛型DAO接口
 */
public interface IGenericDAO<T> {
    void save(T obj);

    void update(T obj);

    void delete(Long id);

    T get(Long id);

    List<T> listAll();

    PageResult query(QueryObject qo);


    /**
     * 查询符合条件的多条数据（留给DAO子类使用）
     * @param condition 查询条件，如: obj.name LIKE ? AND obj.age > ?
     * @param parameters 查询条件的占位符
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<T> queryForList(String condition, Object[] parameters, int currentPage, int pageSize);


    List<T> queryForList(String condition, Object... parameters);

    /**
     * 查询符合条件的单条数据（留给DAO子类使用）
     * @param condition
     * @param parameters
     * @return
     */
    T queryForObject(String condition, Object... parameters);
}
