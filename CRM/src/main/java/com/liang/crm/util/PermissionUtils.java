package com.liang.crm.util;

import com.liang.crm.domain.Employee;
import com.liang.crm.domain.Menu;
import com.liang.crm.domain.Permission;
import com.liang.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by liang on 2018/4/19.
 */
@Component
public class PermissionUtils {
    // 注意，这里的修饰符为static
    private static IPermissionService permissionService;

    public static boolean checkPermission(String function) {
        // 超级管理员，所有都放行
        HttpSession session = UserContext.get().getSession();
        Employee employee = (Employee) session.getAttribute(UserContext.USER_IN_SESSION);
        if (employee.getAdmin()) {
            return true;
        }

        // 需要查询权限表，来看是否需要权限控制
        Permission p = permissionService.queryByResource(function);
        System.out.println(function);
        if (p != null) {
            // 该请求需要权限控制(注意这里获取request的方式)
            HttpServletRequest request = UserContext.get();
            List<Permission> userPermission = (List<Permission>) request.getSession().getAttribute(UserContext.PERMISSION_IN_SESSION);
            // 获取all方法，判断有没有All权限
            String allFunction = function.split(":")[0] + ":" + "All";
            for (Permission permission : userPermission) {
                if (permission.getResource().equals(function) || permission.getResource().equals(allFunction)){
                    // 能找到，说明用户有这个权限
                    return true;
                }
            }
            return false;
        } else {
            // 该请求不需要权限控制，放行
            return true;
        }
    }

    // 这里需要注意，这里是往静态字段中进行注入
    @Autowired
    public void setPermissionService(IPermissionService permissionService) {
        PermissionUtils.permissionService = permissionService;
    }


    public static void getMenuForPermission(List<Menu> allMenu) {
        Menu menu = null;
        for (int i = allMenu.size() - 1; i >= 0 ; i--) {
            menu = allMenu.get(i);
            if (checkPermission(menu.getResource())) {
                // 用户有这样的菜单权限
                if (menu.getChildren() != null && menu.getChildren().size() > 0) {
                    getMenuForPermission(menu.getChildren());
                }
            } else {
                allMenu.remove(i);
            }
        }
    }

}
