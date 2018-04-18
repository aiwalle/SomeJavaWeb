package com.liang._03Ioc;

public class HelloWorld {
	
	private String username;
	
	public HelloWorld() {
		System.out.println("构建对象");
	}
	
	public void open() {
		System.out.println("初始化的方法");
	}
	
	public void close() {
		System.out.println("关闭资源");
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void sayHello() {
		System.out.println("你好Spring，我是" + username);
	}
	
}
