package com.liang._02springTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration
public class HelloTest {
	
	// 这里是自动注入标签
	@Autowired
	private BeanFactory factory;
	
	@Test
	public void test() throws Exception {
		HelloWorld bean = factory.getBean("helloWorld", HelloWorld.class);
		bean.sayHello();
	}
	
}
