package com.liang._02springTest;

public class HelloWorld {
	
	private String username;

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void sayHello() {
		System.out.println("你好Spring，我是" + username);
	}
	
}
