package com.liang._03Ioc;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class HelloTest {
	
	@Test
	public void testBeanFactory() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		System.out.println(factory.getBean("helloWorld", HelloWorld.class));
	}
	
	
	@Test
	public void testApplicationContext() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context.getBean("helloWorld", HelloWorld.class));
	}
	
	public static void main(String[] args) {
		// 这个方法close不调用
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println(context.getBean("helloWorld", HelloWorld.class));

		
		// 这个方法close调用
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context.getBean("helloWorld", HelloWorld.class));
		context.registerShutdownHook();
	}
	
}
