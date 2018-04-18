package com.liang.crm.web.interceptor;

import com.liang.crm.domain.Employee;
import com.liang.crm.util.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这个类是专门用来做登录权限检查的，我觉得非常重要，写完代码还要记得配置到Spring中
 * Created by liang on 2018/4/14.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        UserContext.set(httpServletRequest);
        Employee user = (Employee) httpServletRequest.getSession().getAttribute(UserContext.USER_IN_SESSION);
        if (user == null) {
            httpServletResponse.sendRedirect("/login.jsp");
            return false;
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
