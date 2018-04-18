package com.liang.wms.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//贴在方法上
@Retention(RetentionPolicy.RUNTIME)//可以存活在JVM,可以使用反射赋予RequiredPermission功能
public @interface RequiredPermission {
    String value();//表示权限的名称


}
