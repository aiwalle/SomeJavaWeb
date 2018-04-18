package ssh.service.impl;

import ssh.dao.IDepartmentDAO;
import ssh.domain.Department;
import ssh.query.PageResult;
import ssh.query.QueryObject;
import ssh.service.IDepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {

	private IDepartmentDAO departmentDAO;

	public void setDepartmentDAO(IDepartmentDAO DepartmentDAO) {
		this.departmentDAO = DepartmentDAO;
	}

	public void save(Department e) {
		departmentDAO.save(e);
	}

	public void update(Department e) {
		departmentDAO.update(e);
	}

	public void delete(Long id) {
		departmentDAO.delete(id);
	}

	public Department get(Long id) {
		return departmentDAO.get(id);
	}

	public List<Department> listAll() {
		return departmentDAO.listAll();
	}

    public PageResult query(QueryObject qo) {
        return departmentDAO.query(qo);
    }

}
