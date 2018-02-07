package com.liang.smis.dao02.dao;

import java.util.List;

import com.liang.smis.dao02.domin.Student;

public interface IStudentDAO {
    void saveStudent(Student student);
    
    void deleteStudent(Long id);
    
    void updateStudent(Long id, Student student);
    
    Student getStudent(Long id);
    
    List<Student> list();
    
 // 这里是基于事务的代码
 	void studentTransaction();
 	
 	
 	//使用模板重构的代码
 	void newSaveStudent(Student student);
 	
 	void newDeleteStudent(Long id);
 	
 	void newUpdateStudent(Long id, Student student);
 	
 	Student newGetStudent(Long id);
 	
 	List<Student> newList();
}
