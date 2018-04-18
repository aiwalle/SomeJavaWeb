package com.liang.crm.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by liang on 2018/4/15.
 */
@Setter@Getter
public class EmployeeQueryObject extends QueryObject {
    private Boolean state;
    private String keyword;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;
}
