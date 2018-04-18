package ssh.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import ssh.domain.Employee;
import ssh.query.EmployeeQueryObject;
import ssh.service.IDepartmentService;
import ssh.service.IEmployeeService;
import ssh.service.IRoleService;
import ssh.util.RequiredPermission;

public class EmployeeAction extends BaseAction {


	private IEmployeeService employeeService;
	private IRoleService roleService;

	private IDepartmentService departmentService;

	private Employee employee = new Employee();

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	private EmployeeQueryObject qo = new EmployeeQueryObject();

	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public EmployeeQueryObject getQo() {
		return qo;
	}

	// 查询员工列表
	@RequiredPermission("员工列表")
	public String execute() throws Exception {
		putContext("depts", departmentService.listAll());
		putContext("pageResult",employeeService.query(qo));
		return LIST;
	}

	// 进入录入界面
	@RequiredPermission("员工编辑")
	public String input() throws Exception {
		putContext("roles", roleService.listAll());
		putContext("depts", departmentService.listAll());
		System.out.println(employee);
		if (employee.getId() != null) {
			employee = employeeService.get(employee.getId());
			System.out.println(employee);
		}

		return INPUT;
	}

	// 删除操作
	@RequiredPermission("员工删除")
	public String delete() throws Exception {
		if (employee.getId() != null) {
			employeeService.delete(employee.getId());
		}

		return SUCCESS;
	}

	@RequiredPermission("员工保存或更新")
	public String saveOrUpdate() throws Exception {
		if (employee.getId() == null) {
			employeeService.save(employee);
			System.out.println(employee);
		} else {
			employeeService.update(employee);
			System.out.println(employee);
		}
		return SUCCESS;
	}

	// 这里是为了保证在修改员工资料的过程中，不会去将对应员工的密码设置为null
	// 因为这里是先通过id来查出数据库中对应的对象，在设置那些改过的字段，而不是通过id来创建对象，再覆盖该对象的其他字段
	// 这里需要修改struct2的参数 <default-interceptor-ref name="paramsPrepareParamsStack"/>
	public void prepareSaveOrUpdate() throws Exception {
		if (employee.getId() != null) {
			employee = employeeService.get(employee.getId());
			employee.setDept(null);
		}
		employee.getRoles().clear();
	}
}
