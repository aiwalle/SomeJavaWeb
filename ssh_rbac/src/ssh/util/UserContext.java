package ssh.util;

import com.opensymphony.xwork2.ActionContext;
import ssh.domain.Employee;

import java.util.Set;

/**
 * 用户上下文
 * Created by liang on 2018/4/5.
 */
public class UserContext {

    public static final String USER_IN_SESSION = "user_in_session";

    public static final String PERMISSIONS_IN_SESSION = "permissions_in_session";
    /**
     * 保存登录信息到session中，或从session中移除
     * @param current
     */
    public static void setEmployee(Employee current) {
        if (current != null) {
            ActionContext.getContext().getSession().put(USER_IN_SESSION,current);
        } else {
            ActionContext.getContext().getSession().clear();
        }

    }

    /**
     * 保存登录用户的权限表达式到session中
     * @param permissionSet
     */
    public static void setPermissions(Set<String> permissionSet) {
        ActionContext.getContext().getSession().put(PERMISSIONS_IN_SESSION,permissionSet);
    }


    /**
     * 获取session中的登录信息
     * @return
     */
    public static Employee getCurrentEmployee() {
        return (Employee) ActionContext.getContext().getSession().get(USER_IN_SESSION);
    }

    /**
     * 获取session中的权限表达式
     * @return
     */
    public static Set<String> getPermissions() {
        return (Set<String>)ActionContext.getContext().getSession().get(PERMISSIONS_IN_SESSION);
    }
}
