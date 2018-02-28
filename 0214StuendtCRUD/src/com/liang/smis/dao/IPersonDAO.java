package com.liang.smis.dao;

import java.util.List;

import com.liang.smis.domin.Person;

public interface IPersonDAO {
	public void save(Person person);
	
	public void delete(Long id);
	
	public void update(Long id, Person person);
	
	public Person get(Long id);
	
	public List<Person> list();
}
