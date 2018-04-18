package com.liang.crm.page;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liang on 2018/4/17.
 */
@Getter@Setter
public class AjaxResult {
    private boolean success;
    private String msg;

    public AjaxResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public AjaxResult(String msg) {
        this.msg = msg;
    }
}
