package com.liang.smis.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class QueryObject {
	//封装占位符参数
	private List<Object> parameters = new ArrayList<>();
		
	private List<String> conditions = new ArrayList<>();
	
	// 是否已经构建过SQL了，如果构建过就为true
	private Boolean isBuild = false;
	
	private void init() {
		if (!isBuild) {
			this.customizedQuery();
			isBuild = true;
		}
	}
	
	public String getQuery() {
		StringBuilder sql = new StringBuilder(80);
		this.init();
		// 有了init方法，就不再害怕多次调用getQuery而参数变多的问题了
//		this.customizedQuery();
		if (conditions.size() == 0) {
			return "";
		}
		
		//==========================工具拼接===================================
		String queryStr = StringUtils.join(conditions	, " AND ");
		System.out.println(sql);
		return sql.append(" WHERE ").append(queryStr).toString();
	}
	
	
	public List<Object> getParameters() {
		this.init();
		return parameters;
	}
	
	// 看到这里的protected
	// 暴露给子类，让子类编写自个的查询方式
	protected void customizedQuery() {
		
		
	}
	
	// 让子类在customizedQuery中调用，添加自己的查询条件和参数
	protected void addQuery(String condition, Object...params) {
		conditions.add(condition);
		parameters.addAll(Arrays.asList(params));
	}
	
}
