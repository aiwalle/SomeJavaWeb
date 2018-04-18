package com.liang.wms.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.liang.wms.domain.Employee;
import com.liang.wms.util.PermissionUtil;
import com.liang.wms.util.RequiredPermission;
import com.liang.wms.util.UserContext;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * 权限检查拦截器
 * Created by liang on 2018/4/4.
 */
public class SecurityInterceptor extends AbstractInterceptor {

    // 检查session中是否存在user_in_session，如果没有重新回到登录界面
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Employee current = UserContext.getCurrentEmployee();
        // 1.如果是超级管理员，直接放行
        if (current != null && current.isAdmin()) {
            return actionInvocation.invoke();
        }
        //2.判断当前请求的Action上是否存在RequiredPermission标签，如果没有(不需要权限)，直接放行
        String methodName = actionInvocation.getProxy().getMethod();
        Method actionMethod = actionInvocation.getProxy().getAction().getClass().getDeclaredMethod(methodName);
        RequiredPermission rp = actionMethod.getAnnotation(RequiredPermission.class);
        if (rp == null) {
            return actionInvocation.invoke();
        }
        //3.获取当前Action方法对应的权限表达式
        String exp = PermissionUtil.buildExpression(actionMethod);
        //4.判断当前session方法中是否存在对应的权限表达式
        Set<String> permissions = UserContext.getPermissions();
        if (permissions.contains(exp)) {
            return actionInvocation.invoke();
        }
        return "nopermission";
    }
}
