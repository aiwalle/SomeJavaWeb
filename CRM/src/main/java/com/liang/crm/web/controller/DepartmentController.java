package com.liang.crm.web.controller;

import com.liang.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liang on 2018/4/15.
 */
@Controller
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/department_queryForEmp")
    @ResponseBody
    public List queryForEmp() {
        List result = null;
        result = departmentService.selectAll();
        return result;
    }
}
