package com.liang.crm.web.interceptor;

import com.liang.crm.domain.Employee;
import com.liang.crm.util.PermissionUtils;
import com.liang.crm.util.UserContext;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 这个类是专门用来做登录权限检查的，我觉得非常重要，写完代码还要记得配置到Spring中
 * Created by liang on 2018/4/14.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        // 保存request对象，方便来获取session及session中的对象
        UserContext.set(httpServletRequest);
        // 根据session来判断用户是否登录
        Employee user = (Employee) httpServletRequest.getSession().getAttribute(UserContext.USER_IN_SESSION);
        if (user == null) {
            httpServletResponse.sendRedirect("/login.jsp");
            return false;
        }


        // 对应的静态资源handler对应的类为DefaultServletHttpRequestHandler，此时不需要加入URL权限控制

        // 当handler为HandlerMethod的时候，此时才表示需要访问控制器的方法，此时才需要URL权限控制

        if (handler instanceof HandlerMethod) {
            // URL权限控制
            // 1.将权限请求封装成权限表达式
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Object bean = handlerMethod.getBean();
            Method method = handlerMethod.getMethod();
            String function = bean.getClass().getName() + ":" + method.getName();
            // 2.返回true,用户有该权限
            // 3.返回false,用户没有该权限，拦截
            if (PermissionUtils.checkPermission(function)) {
                System.out.println("ljljlj=====放行");
                return true;
            } else {
                System.out.println("wrong======拒绝放行");
                // 跳转到noPermission.jsp
                if (method.isAnnotationPresent(ResponseBody.class)) {
                    httpServletResponse.sendRedirect("noPermission.json");
                } else {
                    httpServletResponse.sendRedirect("noPermission.jsp");
                }

                return false;
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
