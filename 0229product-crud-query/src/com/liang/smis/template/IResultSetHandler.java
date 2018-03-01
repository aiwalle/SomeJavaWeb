package com.liang.smis.template;

import java.sql.ResultSet;
import java.sql.SQLException;

// 处理结果集规范
public interface IResultSetHandler<T> {
	T handler(ResultSet resultSet) throws SQLException;
	
	
}
