package ssh.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色对象
 * Created by liang on 2018/4/4.
 */
public class Role extends BaseDomain {
    private String name;//角色名称

    private String sn; //角色编码

    //一个角色拥有多个权限，一个权限可以赋给多个角色
    private List<Permission> permissions = new ArrayList<Permission>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
