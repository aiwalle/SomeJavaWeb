package com.liang.wms.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.liang.wms.dao.IGenericDAO;
import com.liang.wms.query.PageResult;
import com.liang.wms.query.QueryObject;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by liang on 2018/4/2.
 */
public class GenericDAOImpl<T> implements IGenericDAO<T> {

    protected SessionFactory sessionFactory;


    // 这里有个问题就是，当子类来调用父类方法的时候，有些方法是需要传入子类的class的，方法比如get方法
    // 那么如何能传入子类class呢，不要想着用T,因为T其实类似于一个字符串，并不是一个类，不是Employee.class,所以不能用

    private  Class<T> targetType; //哪一个domin字节码，用于解决上面的问题


    /*
    * class EmployeeDAOImpl extends GenericDAOImpl<Employee>
    * 获取    Employee
    */
    public GenericDAOImpl() {
        // 获取DAO实现类d带有泛型信息的父类
        ParameterizedType pType = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取泛型父类中的泛型参数
        targetType = (Class<T>) pType.getActualTypeArguments()[0];

        System.out.println("targetType"+ targetType);
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(T obj) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(obj);
    }

    public void update(T obj) {
        Session session = sessionFactory.getCurrentSession();
        session.update(obj);
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Object obj =  session.get(targetType,id);
        session.delete(obj);
    }

    public T get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (T) session.get(targetType, id);
    }


    public List<T> listAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(targetType).list();
    }

    public PageResult query(QueryObject qo) {
        int currentPage = qo.getCurrentPage();
        int pageSize = qo.getPageSize();

        Session session = sessionFactory.getCurrentSession();
        // 查询结果总数
        String countHql = "SELECT COUNT(obj) FROM " + targetType.getSimpleName() + " obj" + qo.getQuery();
        Query query = session.createQuery(countHql);

        setPlaceParameters(qo, query);
        int totalCount = ((Long) query.uniqueResult()).intValue();
        if (totalCount == 0) {
            return PageResult.empty(pageSize);
        }
        // 查询结果集
        String resultHql = "SELECT obj FROM " + targetType.getSimpleName() + " obj" + qo.getQuery();
        query = session.createQuery(resultHql);

        setPlaceParameters(qo, query);
        //分页
        if (currentPage > 0 && pageSize > 0) {
            query.setFirstResult((currentPage - 1) * pageSize);
            query.setMaxResults(pageSize);
        }


        List list = query.list();
        return new PageResult(totalCount, list, currentPage, pageSize);
    }

    public List<T> queryForList(String condition, Object[] parameters, int currentPage, int pageSize) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder hql = new StringBuilder(80);
        hql.append("SELECT obj FROM ").append(targetType.getSimpleName()).append(" obj");
        if (parameters != null && parameters.length > 0) {
            hql.append(" WHERE ").append(condition);
        }

        Query query = session.createQuery(hql.toString());
        // 设置占位符
        if (parameters != null) {
            for (int index = 0; index < parameters.length; index++) {
                query.setParameter(index, parameters[index]);
            }
        }
        //分页
        if (currentPage > 0 && pageSize > 0) {
            query.setFirstResult((currentPage - 1) * pageSize);
            query.setMaxResults(pageSize);
        }

        return query.list();
    }

    public List<T> queryForList(String condition, Object... parameters) {
        return queryForList(condition, parameters, -1, -1);
    }

    public T queryForObject(String condition, Object... parameters) {
        List<T> list = queryForList(condition, parameters);
        return list.size() == 1 ? list.get(0) : null;
    }

    // 设置占位符参数,将QueryObject中的参数设置到Query对象中
    private void setPlaceParameters(QueryObject qo, Query query) {
        for (int index = 0; index < qo.geParameters().size(); index++) {
            query.setParameter(index, qo.geParameters().get(index));
        }
    }
}
