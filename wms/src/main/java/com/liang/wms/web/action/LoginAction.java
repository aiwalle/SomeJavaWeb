package com.liang.wms.web.action;

import com.liang.wms.service.IEmployeeService;

// 处理登录请求
public class LoginAction extends BaseAction {


    private String username;

    private String password;

    private IEmployeeService employeeService;

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String execute() {
        try {
            employeeService.checkLogin(username, password);
        } catch (RuntimeException e) {
            super.addActionError(e.getMessage());
            System.out.println(e.getMessage());
            System.out.println("1111111");
            return LOGIN;
        }

        System.out.println("222222");
        return SUCCESS;
    }
}
