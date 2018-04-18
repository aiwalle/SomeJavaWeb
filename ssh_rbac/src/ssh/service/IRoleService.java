package ssh.service;


import ssh.domain.Role;
import ssh.query.QueryObject;
import ssh.query.PageResult;

import java.util.List;

public interface IRoleService {
	void save(Role r);

	void update(Role r);
	
	void delete(Long id);
	
	Role get(Long id);
	
	List<Role> listAll();

	PageResult query(QueryObject qo);
}
