package com.liang.wms.service.impl;

import com.liang.wms.dao.IDepartmentDAO;
import com.liang.wms.domain.Department;
import com.liang.wms.query.PageResult;
import com.liang.wms.query.QueryObject;
import com.liang.wms.service.IDepartmentService;

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
