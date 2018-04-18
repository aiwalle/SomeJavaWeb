package com.liang.ssh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.liang.ssh.dao.IEmployeeDAO;
import com.liang.ssh.domain.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void save(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.save(e);
	}

	public void update(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.update(e);
	}

	public void delete(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(e);
	}

	public Employee get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Employee) session.get(Employee.class, id);
	}

	public List<Employee> listAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Employee.class).list();
//		return session.createQuery("SELECT e FROM Employee e").list();
	}

}
