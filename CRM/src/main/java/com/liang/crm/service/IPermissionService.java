package com.liang.crm.service;

import com.liang.crm.page.PageResult;
import com.liang.crm.query.PermissionQueryObject;
import com.liang.crm.query.QueryObject;

/**
 * Created by liang on 2018/4/17.
 */
public interface IPermissionService {

    PageResult selectByCondition(PermissionQueryObject qo);

    PageResult queryByRid(Long rid);
}
