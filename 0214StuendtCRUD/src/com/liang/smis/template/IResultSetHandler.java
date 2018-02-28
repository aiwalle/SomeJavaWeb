package com.liang.smis.template;

import java.sql.ResultSet;

// 这个接口专门用来处理结果，解耦
public interface IResultSetHandler<T> {
	T handle(ResultSet set) throws Exception;
}
