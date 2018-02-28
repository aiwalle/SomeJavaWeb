package com.liang.practice01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Person {
	public static void main(String[] args) {
		System.out.println("hello, world!");
	}
	
	@Test
	public void testJunit() {
		System.out.println("hello Junit");
	}
	
	@Before
	public void testBefore() {
		System.out.println("hello before");
	}
	
	@After
	public void testAfter() {
		System.out.println("hello after");
	}
}
