package ssh.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import ssh.domain.Department;
import ssh.query.QueryObject;
import ssh.service.IDepartmentService;
import ssh.service.IEmployeeService;
import ssh.util.RequiredPermission;

public class DepartmentAction extends BaseAction {

    private IDepartmentService departmentService;

    private Department department = new Department();

	private QueryObject qo = new QueryObject();

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Department getDepartment() {
        return department;
    }

    public QueryObject getQo() {
        return qo;
    }

    // 查询列表
    @RequiredPermission("部门列表")
    public String execute() throws Exception {
        putContext("pageResult", departmentService.query(qo));
        return LIST;
    }

    // 进入录入界面
    @RequiredPermission("部门编辑")
    public String input() throws Exception {
        if (department.getId() != null) {
            department = departmentService.get(department.getId());
        }
        return INPUT;
    }

    // 删除操作
    @RequiredPermission("部门删除")
    public String delete() throws Exception {
        if (department.getId() != null) {
            departmentService.delete(department.getId());
        }
        return SUCCESS;
    }

    @RequiredPermission("部门保存或更新")
    public String saveOrUpdate() throws Exception {
        if (department.getId() == null) {
            departmentService.save(department);
        } else {
            departmentService.update(department);
        }
        return SUCCESS;
    }

}
