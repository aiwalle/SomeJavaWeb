package ssh.web.action;

import ssh.domain.Role;
import ssh.query.QueryObject;
import ssh.service.IPermissionService;
import ssh.service.IRoleService;
import ssh.util.RequiredPermission;

public class RoleAction extends BaseAction {

	private IPermissionService permissionService;

	private IRoleService roleService;

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	private Role role = new Role();

	private QueryObject qo = new QueryObject();

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public QueryObject getQo() {
		return qo;
	}

	// 查询列表
	@RequiredPermission("角色列表")
	public String execute() throws Exception {
		putContext("pageResult",roleService.query(qo));
		return LIST;
	}

	// 进入录入界面
	@RequiredPermission("角色编辑")
	public String input() throws Exception {

		putContext("permissions", permissionService.listAll());
		if (role.getId() != null) {
			role = roleService.get(role.getId());
		}
		return INPUT;
	}

	// 删除操作
	@RequiredPermission("角色删除")
	public String delete() throws Exception {
		if (role.getId() != null) {
			roleService.delete(role.getId());
		}

		return SUCCESS;
	}

	@RequiredPermission("角色保存或更新")
	public String saveOrUpdate() throws Exception {
		if (role.getId() == null) {
			roleService.save(role);
		} else {
			roleService.update(role);
		}
		return SUCCESS;
	}

	public void prepareSaveOrUpdate() throws Exception {
		if (role.getId() != null) {
			role = roleService.get(role.getId());
		}
		role.getPermissions().clear();//清除第一次传递的权限

	}
}
