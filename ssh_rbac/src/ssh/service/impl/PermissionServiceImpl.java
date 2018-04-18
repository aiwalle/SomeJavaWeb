package ssh.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import ssh.dao.IPermissionDAO;
import ssh.domain.Permission;
import ssh.query.PageResult;
import ssh.query.QueryObject;
import ssh.service.IPermissionService;
import ssh.util.PermissionUtil;
import ssh.util.RequiredPermission;
import ssh.web.action.BaseAction;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by liang on 2018/4/4.
 */
public class PermissionServiceImpl implements IPermissionService, ApplicationContextAware {

    private IPermissionDAO permissionDAO;

    private ApplicationContext ctx;

    public void setPermissionDAO(IPermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    public void delete(Long id) {
        permissionDAO.delete(id);
    }

    public List<Permission> listAll() {
        return permissionDAO.listAll();
    }

    public PageResult query(QueryObject qo) {
        return permissionDAO.query(qo);
    }

    public void reload() {
        //0.查询出数据库所有的权限表达
        List<Permission> ps = permissionDAO.listAll();
        Set<String> expressions = new HashSet<>();// 数据库中已经存在的权限表达式
        for (Permission p : ps) {
            expressions.add(p.getExpression());
        }


        //1.扫描所有的BaseAction的子类
        // 获取到的Map,{employeeAction=ssh.web.action.EmployeeAction@13e9f2e2, departmentAction=ssh.web.action.DepartmentAction@673bb956}
        Map<String, BaseAction> beansMap = ctx.getBeansOfType(BaseAction.class);
        Collection<BaseAction> actions = beansMap.values();
        //2.迭代每一个Action类
        for (BaseAction action : actions) {
            //3.迭代每一个Action中的方法
            Method[] ms = action.getClass().getDeclaredMethods();
            for (Method m : ms) {
                //4.判断当前方法上是否存在RequiredPermission标签
                RequiredPermission rp = m.getAnnotation(RequiredPermission.class);
                String exp = PermissionUtil.buildExpression(m);//获取该方法的权限表达式
                if (!expressions.contains(exp)) {
                    if (rp != null) {
                        String name = rp.value();//权限名称
                        Permission p = new Permission();
                        p.setName(name);
                        p.setExpression(exp);
                        permissionDAO.save(p);
                    }
                }
            }
        }
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
}
