package com.liang.smis.template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com.liang.smis.template.IResultSetHandler;
public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> classType;

	public BeanHandler(Class<T> classType) {
		this.classType = classType;
	}
	
	public T handler(ResultSet set) throws Exception {
		if (set.next()) {
			T obj = classType.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(classType, Object.class);
			PropertyDescriptor[] properts = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : properts) {
				String name = propertyDescriptor.getName();
				Object value = set.getObject(name);
				propertyDescriptor.getWriteMethod().invoke(obj, value);
			}
			return obj;
		}
		return null;
	}

	
}
