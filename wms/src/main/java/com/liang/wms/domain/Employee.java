package com.liang.wms.domain;


//import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Data
public class Employee extends BaseDomain {
	private String name;
	private String password;
	private String email;
	private Integer age;
	private boolean admin = false;//是否是超级管理员
	private Department dept;

	//一个用户拥有多个角色，一个角色可以赋给多个用户
	private List<Role> roles = new ArrayList<Role>();

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Department getDept() {
		return dept;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				'}';
	}

	//获取用户的角色名称
	public String getRoleNames() {
		if (this.admin) {
			return "[超级管理员]";
		}

		if (this.roles.size() == 0) {
			return "[暂无角色]";
		}

		StringBuilder sb = new StringBuilder(40).append("[");
		for (Role role : roles) {
			sb.append(role.getName() + ",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	} 
}
