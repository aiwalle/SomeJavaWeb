package com.liang.smis.dao01.dao;

import java.util.List;

import com.liang.smis.dao01.domin.Student;

public interface IStudentDAO {
    void saveStudent(Student student);
    
    void deleteStudent(Long id);
    
    void updateStudent(Long id, Student student);
    
    Student getStudent(Long id);
    
    List<Student> list();

//	void studentTransaction();
    
    
}
