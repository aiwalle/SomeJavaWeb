package com.liang.crm.service.impl;

import com.liang.crm.domain.Employee;
import com.liang.crm.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


/**
 * Created by liang on 2018/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class EmployeeServiceImplTest {

    @Autowired
    private IEmployeeService service;

    @Test
    public void testSave() throws Exception {
        Employee e = new Employee();
        e.setUsername("hello");
        e.setAdmin(false);
        e.setEmail("123@qq.com");
        e.setInputtime(new Date());
        e.setPassword("123456");
        e.setState(true);
        e.setTel("13888888888");
        e.setRealname("超级管理员");
        service.save(e);
    }

    @Test
    public void testUpdate() throws Exception {
    }

    @Test
    public void testDelete() throws Exception {
    }

    @Test
    public void testGet() throws Exception {
    }

    @Test
    public void testSelectAll() throws Exception {
    }

    @Test
    public void testSelectByCondition() throws Exception {
    }

}