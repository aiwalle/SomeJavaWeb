package ssh.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liang on 2018/4/3.
 */
public class EmployeeQueryObject extends QueryObject {

    private String keyword;//查询名称或邮箱

    private Long deptId = -1L;//所在部门的编号



    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }



    public void customizedQuery() {
        if (hasLength(keyword)) {
            String key = "%"+keyword+"%";
            super.addQuery("(obj.name LIKE ? OR obj.email LIKE ?)", key, key);
        }

        if (deptId > 0) {
            super.addQuery("obj.dept.id = ?", deptId);
        }
    }


}
