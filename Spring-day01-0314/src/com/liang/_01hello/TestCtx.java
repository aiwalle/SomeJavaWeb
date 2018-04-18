package com.liang._01hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestCtx {
	
	
	
	@Test
	public void testName() throws Exception {
		Resource resource = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(resource);
		
		HelloWorld world = (HelloWorld) factory.getBean("helloWorld");
		
		
		
		world.sayHello();
	}
	
}
