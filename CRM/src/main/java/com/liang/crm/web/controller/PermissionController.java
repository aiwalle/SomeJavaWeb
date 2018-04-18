package com.liang.crm.web.controller;

import com.liang.crm.page.PageResult;
import com.liang.crm.query.PermissionQueryObject;
import com.liang.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liang on 2018/4/17.
 */
@Controller
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/permission_list")
    @ResponseBody
    public PageResult list(PermissionQueryObject qo) {
        return permissionService.selectByCondition(qo);
    }

    @RequestMapping("/permission_queryByRid")
    @ResponseBody
    public PageResult queryByRid(Long rid) {
        return permissionService.queryByRid(rid);
    }
}
