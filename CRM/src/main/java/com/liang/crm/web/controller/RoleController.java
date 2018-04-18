package com.liang.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liang on 2018/4/17.
 */
@Controller
public class RoleController {

    @RequestMapping("/role")
    public String index() {
        return "role";
    }




}
