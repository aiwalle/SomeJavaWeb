package com.liang.wms.util;

import java.lang.reflect.Method;

/**
 * Created by liang on 2018/4/4.
 */
public class PermissionUtil {
    // 拼接方法的权限表达式
    public static String buildExpression(Method method) {
        // 获取当前method所在类的全限定名称
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();

        return className + ":" + methodName;
    }


}
