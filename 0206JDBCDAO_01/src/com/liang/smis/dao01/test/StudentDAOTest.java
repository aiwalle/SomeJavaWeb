package com.liang.smis.dao01.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.liang.smis.dao01.dao.IStudentDAO;
import com.liang.smis.dao01.dao.impl.StudentDAOImpl;
import com.liang.smis.dao01.domin.Student;

public class StudentDAOTest {
	private IStudentDAO dao = new StudentDAOImpl();
	
	@Test
	public void testSave() throws Exception {
		Student student = new Student();
		student.setName("张飞");
		student.setAge(12);
		dao.saveStudent(student);
	}
	
	@Test
	public void testDelete() throws Exception {
//		Student student = new Student();
		dao.deleteStudent(18L);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Student student = new Student();
		student.setAge(99);
		student.setName("大牛");
		dao.updateStudent(25L, student);
	}
	
	@Test
	public void testGet() throws Exception {
		Student student = dao.getStudent(25L);
		System.out.println(student);
	}
	
	@Test
	public void testList() throws Exception {
		List<Student> list = dao.list();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
}
