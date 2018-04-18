package ssh.service.impl;

import ssh.dao.IRoleDAO;
import ssh.domain.Role;
import ssh.query.PageResult;
import ssh.query.QueryObject;
import ssh.service.IRoleService;

import java.util.List;

/**
 * Created by liang on 2018/4/4.
 */
public class RoleServiceImpl implements IRoleService {

    private IRoleDAO roleDAO;

    public void setRoleDAO(IRoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public void save(Role r) {
        roleDAO.save(r);
    }

    public void update(Role r) {
        roleDAO.update(r);
    }

    public void delete(Long id) {
        roleDAO.delete(id);
    }

    public Role get(Long id) {
        return roleDAO.get(id);
    }

    public List<Role> listAll() {
        return roleDAO.listAll();
    }

    public PageResult query(QueryObject qo) {
        return roleDAO.query(qo);
    }
}
