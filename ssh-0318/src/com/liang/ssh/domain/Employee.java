package com.liang.ssh.domain;

import lombok.Data;

@Data
public class Employee {
	private Long id;
	private String name;
	private Integer age;
	private Department dept;
}
