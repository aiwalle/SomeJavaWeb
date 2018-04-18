package com.liang.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liang on 2018/4/14.
 */
@Setter@Getter
public class QueryObject {
    private Integer page;
    private Integer rows;

    public Integer getStart() {
        return (this.page - 1) * this.rows;
    }


}
