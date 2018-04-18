package ssh.query;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 高级查询的基类
 * Created by liang on 2018/4/3.
 */
public class QueryObject {
    private List<String> conditions = new ArrayList<String>();

    private List<Object> params = new ArrayList<Object>();

    private int currentPage = 1;

    private int pageSize = 5;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    private boolean build = false;//是否已经拼接sql

    // 初始化操作：把查询条件拼接成SQL
    private void init() {
        if (!build) {
            this.customizedQuery();
            build = true;
        }
    }



    // 返回带有查询条件的HQL，如：WHERE (obj.name LIKE ? OR obj.email LIKE ?) AND obj.dept.id = ?
    public String getQuery() {
        init();
        if (conditions.size() == 0) {
            return "";
        }
        return " WHERE " + StringUtils.join(conditions, " AND ");
    }

    // 暴露给子类，在该方法中添加查询条件
    protected void customizedQuery() {

    }

    protected void addQuery(String condition, Object... args) {
        this.conditions.add(condition);
        this.params.addAll(Arrays.asList(args));
    }



    // 返回查询条件中占位符(?)对应的参数值
    public List<Object> geParameters() {
        init();
        return  this.params;
    }

    protected boolean hasLength(String str) {
        return str != null && !"".equals(str.trim());
    }


}
