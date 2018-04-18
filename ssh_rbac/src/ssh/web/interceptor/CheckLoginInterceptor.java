package ssh.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import ssh.domain.Employee;
import ssh.util.UserContext;

/**
 * 登录检查拦截器
 * Created by liang on 2018/4/4.
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

    // 检查session中是否存在user_in_session，如果没有重新回到登录界面
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Employee current = UserContext.getCurrentEmployee();
        if (current == null) {
            return Action.LOGIN;
        }
        return actionInvocation.invoke();
    }
}
