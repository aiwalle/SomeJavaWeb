package com.liang.crm.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liang.crm.domain.Employee;
import com.liang.crm.domain.SystemLog;
import com.liang.crm.service.ISystemLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by liang on 2018/4/17.
 */
public class LogUtil {
    @Autowired
    private ISystemLogService systemLogService;

    public void writeLog(JoinPoint joinpoint) throws Exception {
        // 如果目标对象是ISystemLogService，那么就应该放行
        if (joinpoint.getTarget() instanceof ISystemLogService) {
            return;
        }


        SystemLog systemLog = new SystemLog();
        systemLog.setOptime(new Date());

        HttpServletRequest request = UserContext.get();
        Employee employee = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);

        systemLog.setOpuser(employee);

        systemLog.setOpip(request.getRemoteAddr());


        Object target = joinpoint.getTarget(); // 目标对象
        Signature signature = joinpoint.getSignature();// 方法签名
        String function = target.getClass().getName() + ":" + signature.getName();
        systemLog.setFunction(function);


        Object[] args = joinpoint.getArgs();

        ObjectMapper mapper = new ObjectMapper();
        //空的值就不要序列号了
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String paramStr = mapper.writeValueAsString(args);
        systemLog.setParams(paramStr);

        systemLogService.save(systemLog);
//        System.out.println(paramStr);
//        System.out.println(function);
        System.out.println("日志编写.....");
    }
}
