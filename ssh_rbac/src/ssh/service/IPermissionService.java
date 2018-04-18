package ssh.service;


import ssh.domain.Permission;
import ssh.query.PageResult;
import ssh.query.QueryObject;

import java.util.List;

public interface IPermissionService {


	/**
	 * 删除指定的权限
	 * @param id
	 */
	void delete(Long id);


	/**
	 * 查询出所有的权限
	 * @return
	 */
	List<Permission> listAll();


	/**
	 * 分页查询所有的权限
	 * @param qo
	 * @return
	 */
	PageResult query(QueryObject qo);

	/**
	 * 加载权限
	 */
	void reload();
}
