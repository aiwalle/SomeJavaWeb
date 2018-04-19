package com.liang.crm.web.controller;

import com.liang.crm.domain.Menu;
import com.liang.crm.service.IMenuService;
import com.liang.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by liang on 2018/4/19.
 */
@Controller
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @RequestMapping("/menu")
    @ResponseBody
    public List<Menu> menu(HttpSession session) {
        List<Menu> menus = (List<Menu>) session.getAttribute(UserContext.MENU_IN_SESSION);
        return menus;
    }

}
