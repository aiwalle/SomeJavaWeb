import java.util.List;

import org.junit.Test;
import org.junit.internal.runners.TestMethod;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssh.domain.Department;
import ssh.domain.Employee;
import ssh.query.EmployeeQueryObject;
import ssh.query.PageResult;
import ssh.service.IDepartmentService;
import ssh.service.IEmployeeService;
import ssh.service.IPermissionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private IDepartmentService departmentService;

	@Autowired
	private IPermissionService permissionService;


	@Test
	public void testReload() throws Exception {
		permissionService.reload();

	}

	@Test
	public void testPageQuery() throws Exception {
		EmployeeQueryObject qo = new EmployeeQueryObject();
//		qo.setKeyword("test");
//		qo.setCurrentPage(2);
//		qo.setPageSize(2);

		PageResult pageResult = employeeService.query(qo);

		System.out.println(pageResult.getTotalCount());
		for (Object o : pageResult.getResult()) {
			System.out.println(o);
		}
	}

	@Test
	public void testAdvancedQuery() throws Exception {

//		EmployeeQueryObject qo = new EmployeeQueryObject();
////		qo.setDeptId(1L);
//		qo.setKeyword("i");
//		List<Employee> list = employeeService.query(qo);
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
	}

	@Test
	public void testSaveDept() {
		Department d = new Department();
		d.setName("name");
		d.setSn("sn");
		departmentService.save(d);
	}


	@Test
	public void testSave() {
		Employee employee = new Employee();
		for (int i = 0; i < 30; i++) {
			employee.setName("test_" + i);
			employee.setAge(10 + i);
			employeeService.save(employee);
		}

	}

	@Test
	public void testUpdate() {
//		Employee employee = new Employee();
//		employee.setId(1L);
//		employee.setName("哈哈哈哈");
//		employee.setAge(28);
//		employeeService.update(employee);
	}

	@Test
	public void testDelete() {
//		Employee employee = new Employee();
//		employee.setId(3L);
//		employeeService.delete(employee);;
	}

	@Test
	public void testGet() {
//		Employee employee = employeeService.get(1L);
//		System.out.println(employee);
	}

	@Test
	public void testListAll() {
//		List<Employee> list = employeeService.listAll();
//		System.out.println(list);
	
	}

}
