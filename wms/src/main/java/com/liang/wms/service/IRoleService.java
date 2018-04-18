package com.liang.wms.service;


import com.liang.wms.domain.Role;
import com.liang.wms.query.QueryObject;
import com.liang.wms.query.PageResult;

import java.util.List;

public interface IRoleService {
	void save(Role r);

	void update(Role r);
	
	void delete(Long id);
	
	Role get(Long id);
	
	List<Role> listAll();

	PageResult query(QueryObject qo);
}
