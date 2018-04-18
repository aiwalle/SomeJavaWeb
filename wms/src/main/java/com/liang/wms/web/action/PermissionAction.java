package com.liang.wms.web.action;

import com.liang.wms.domain.Permission;
import com.liang.wms.query.QueryObject;
import com.liang.wms.service.IPermissionService;
import com.liang.wms.util.RequiredPermission;

public class PermissionAction extends BaseAction {

	private IPermissionService permissionService;

	private Permission employee = new Permission();

	private QueryObject qo = new QueryObject();

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public Permission getPermission() {
		return employee;
	}

	public QueryObject getQo() {
		return qo;
	}

	// 查询员工列表
	@RequiredPermission("权限列表")
	public String execute() throws Exception {
		putContext("pageResult",permissionService.query(qo));
		return LIST;
	}

	// 删除操作
	@RequiredPermission("权限删除")
	public String delete() throws Exception {
		if (employee.getId() != null) {
			permissionService.delete(employee.getId());
		}
		return SUCCESS;
	}

	// 加载权限
	@RequiredPermission("权限加载")
	public String reload() throws Exception {
		permissionService.reload();
		return NONE;
	}
}
