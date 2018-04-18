package com.liang.wms.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * Created by liang on 2018/4/2.
 * 所有Action的基类，存放共同的代码结构
 */
public class BaseAction extends ActionSupport implements Preparable {

    public static final String LIST = "list";

    public void prepare() throws Exception {

    }

    // 把数据存放在context区域，提供给子类调用
    protected void putContext(String name, Object value){
        ActionContext.getContext().put(name, value);
    }
}
