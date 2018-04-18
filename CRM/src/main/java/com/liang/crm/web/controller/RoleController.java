package com.liang.crm.web.controller;

import com.liang.crm.domain.Role;
import com.liang.crm.page.AjaxResult;
import com.liang.crm.page.PageResult;
import com.liang.crm.query.QueryObject;
import com.liang.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liang on 2018/4/17.
 */
@Controller
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/role")
    public String index() {
        return "role";
    }


    @RequestMapping("/role_list")
    @ResponseBody
    public PageResult list(QueryObject qo) {
        PageResult pageResult = roleService.queryByCondition(qo);
        return pageResult;
    }

    @RequestMapping("/role_save")
    @ResponseBody
    public AjaxResult save(Role role) {
        AjaxResult result = null;
        try {
            int effectCount = roleService.save(role);
            if (effectCount > 0) {
                result = new AjaxResult(true, "保存成功");
            } else {
                result = new AjaxResult(false, "保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("报错异常，请联系管理员");
        }
        return result;
    }

    @RequestMapping("/role_update")
    @ResponseBody
    public AjaxResult update(Role role) {
        AjaxResult result = null;
        try {
            int effectCount = roleService.update(role);
            if (effectCount > 0) {
                result = new AjaxResult(true, "更新成功");
            } else {
                result = new AjaxResult(false, "更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult("更新异常，请联系管理员");
        }
        return result;
    }


    @RequestMapping("/role_queryRoleByEmp")
    @ResponseBody
    public List<Role> queryRoleByEmp() {
        List<Role> result = null;
        result = roleService.selectAll();
        return result;
    }

    @RequestMapping("/role_queryRoleIdByEid")
    @ResponseBody
    public List<Role> queryRoleIdByEid(Long eid) {
        List<Role> result = null;
        result = roleService.queryRoleIdByEid(eid);
        return result;
    }

}
