package ssh.domain;

/**
 * 权限对象
 * Created by liang on 2018/4/4.
 */
public class Permission extends BaseDomain {
    private String name;//权限名称，如:员工删除

    private String expression; //权限表达式，如：ssh.web.action.EmployeeAction:delete

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
