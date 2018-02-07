package com.liang.smis.dao02.template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.liang.smis.dao02.domin.Student;
import com.liang.smis.dao02.template.IResultSetHandler;

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {

	private Class<T> classType;
	
	public BeanListHandler(Class<T> classType) {
		this.classType = classType;
	}

	
	// 和Student耦合太严重，改造，❌
//	@Override
//	public Object handle(ResultSet set) throws Exception {
//		List<Student> list = new ArrayList<>();
//		while (set.next()) {
//			Student student = new Student();
//			student.setId(set.getLong("id"));
//			student.setName(set.getString("name"));
//			student.setAge(set.getInt("age"));
//			list.add(student);
//		}
//
//		return list;
//	}
	
	
	
	public List<T> handle(ResultSet set) throws Exception {
		List<T> list = new ArrayList<>();
		while (set.next()) {
			T obj = classType.newInstance();
			//stopClass代表不用从父类获取,也就是这里的Object.class
			// 获取bean的信息列表，内省机制
			BeanInfo beanInfo = Introspector.getBeanInfo(classType, Object.class);
			PropertyDescriptor[] descriptor = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : descriptor) {
				String name = propertyDescriptor.getName();
				String fieldName = name;	//表中的列名，属性名
//				System.out.println(fieldName);
				Object value = set.getObject(fieldName);
				propertyDescriptor.getWriteMethod().invoke(obj, value);
			}
			list.add(obj);
		}
		
		
		return list;
	}

}
