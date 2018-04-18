package com.liang.wms.service;


import com.liang.wms.domain.Department;
import com.liang.wms.query.PageResult;
import com.liang.wms.query.QueryObject;

import java.util.List;

public interface IDepartmentService {
	void save(Department e);

	void update(Department e);
	
	void delete(Long id);
	
	Department get(Long id);
	
	List<Department> listAll();

	PageResult query(QueryObject qo);
}
