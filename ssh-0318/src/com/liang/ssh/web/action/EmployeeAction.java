package com.liang.ssh.web.action;

import com.liang.ssh.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

public class EmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Setter
	private IEmployeeService employeeService;
	
	
	public String execute() throws Exception {
		ActionContext.getContext().put("employees", employeeService.listAll());
		
		System.out.println("EmployeeAction......");
		return "list";
	}
	
}
