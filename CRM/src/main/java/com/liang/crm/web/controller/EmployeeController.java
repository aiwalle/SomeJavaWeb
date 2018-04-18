package com.liang.crm.web.controller;

import com.liang.crm.domain.Employee;
import com.liang.crm.domain.Role;
import com.liang.crm.page.AjaxResult;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.EmployeeQueryObject;
import com.liang.crm.service.IEmployeeService;
import com.liang.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by liang on 2018/4/14.
 */
@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    // 所有的方法都会先经过这个方法，这个方法在mybatis中用不到
    @ModelAttribute
    public void before(){

    }

    @RequestMapping("/employee")
    public String index() {
        return "employee";
    }

    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(String username, String password, HttpServletRequest request) {
        UserContext.set(request);
        Employee user = employeeService.queryByLogin(username, password);
        AjaxResult result = null;
        if (user != null) {
            request.getSession().setAttribute(UserContext.USER_IN_SESSION,user);
            result = new AjaxResult(true, "登录成功");
        } else {
            result = new AjaxResult("账号密码有误");
        }
        return result;
    }

    @RequestMapping("/employee_list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        PageResult pageResult = employeeService.queryByCondition(qo);
        return pageResult;
    }

    @RequestMapping("/employee_save")
    @ResponseBody
    public AjaxResult save(Employee emp) {
        AjaxResult result = null;
        try {
            emp.setAdmin(false);
            emp.setInputtime(new Date());
            emp.setState(true);
            emp.setPassword("1");
            int effectCount = employeeService.save(emp);
            if (effectCount>0) {
                result = new AjaxResult(true, "保存成功");
            } else {
                result = new AjaxResult("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("保存异常，请联系管理员");
        }
        return result;
    }

    @RequestMapping("/employee_update")
    @ResponseBody
    public AjaxResult update(Employee emp) {
        AjaxResult result = null;
        try {
            int effectCount = employeeService.update(emp);
            if (effectCount>0) {
                result = new AjaxResult(true, "更新成功");
            } else {
                result = new AjaxResult("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更新异常，请联系管理员");
        }

        return result;
    }

    @RequestMapping("/employee_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = employeeService.updateState(id);
            if (effectCount>0) {
                result = new AjaxResult(true, "离职成功");
            } else {
                result = new AjaxResult("离职失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("离职异常，请联系管理员");
        }
        return result;
    }



}
