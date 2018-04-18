package ssh.service;


import ssh.domain.Department;
import ssh.query.PageResult;
import ssh.query.QueryObject;

import java.util.List;

public interface IDepartmentService {
	void save(Department e);

	void update(Department e);
	
	void delete(Long id);
	
	Department get(Long id);
	
	List<Department> listAll();

	PageResult query(QueryObject qo);
}
