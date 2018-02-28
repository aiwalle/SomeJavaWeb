package com.liang.smis.test;


import static org.junit.Assert.*;

import java.util.List;

//import static org.junit.Assert.*;

import org.junit.Test;

import com.liang.smis.dao.IPersonDAO;
import com.liang.smis.dao.impl.PersonDAOImpl;
import com.liang.smis.domin.Person;

public class PersonDAOTest {
	private IPersonDAO dao = new PersonDAOImpl();
	
	
//	public static void main(String[] args) {
//		System.out.println("==========================================");
//		IPersonDAO dao = new PersonDAOImpl();
//		Person person = new Person();
//		person.setAge(20);
//		person.setName("张三");
//		System.out.println("==========================================");
//		dao.save(person);
//	}
	
	
	@Test
	public void testSave() throws Exception {

		Person person = new Person();
		person.setAge(20);
		person.setName("谢逊");
		dao.save(person);
	}
	
	@Test
	public void testDeletePerson() throws Exception {
		dao.delete(1L);
	}
	
	@Test
	public void testUpdatePerson() throws Exception {
		Person person = new Person();
		person.setAge(88);
		person.setName("大牛");
		dao.update(2L, person);
	}
	
	@Test
	public void testGetPerson() throws Exception {
		Object obj = dao.get(2L);
		System.out.println(obj);
	}
	
	@Test
	public void testlist() throws Exception {
		List<Person> list = dao.list();
		System.out.println(list);
	}
	
}
