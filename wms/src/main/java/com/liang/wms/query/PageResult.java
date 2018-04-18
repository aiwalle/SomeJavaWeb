package com.liang.wms.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 封装分页查询的结果
 * Created by liang on 2018/4/3.
 */
public class PageResult {
    private int totalCount;//结果总数 SQL查询

    private List result;//结果集 SQL查询

    private int currentPage = 1;//当前第几页 用户传入
    private int pageSize = 3;//每页最多显示的条数 用户传入


    private int totalPage;//总页数 计算
    private int prevPage;//上一页 计算
    private int nextPage;//下一页 计算

    public static PageResult empty(int pageSize) {
        return new PageResult(0, Collections.emptyList(),1,pageSize);
    }


    public PageResult(int totalCount, List result, int currentPage, int pageSize) {
        this.totalCount = totalCount;
        this.result = result;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;

        prevPage = currentPage - 1 > 0 ? currentPage - 1 : 0;
        nextPage = currentPage + 1 < totalPage ? currentPage + 1 : totalPage;

    }

    public int getTotalCount() {
        return totalCount;
    }

    public List getResult() {
        return result;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }





}
