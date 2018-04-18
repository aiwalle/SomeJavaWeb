package com.liang.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;


@Setter@Getter
@Alias("SystemLog")
public class SystemLog {
    private Long id;

    private Employee opuser;

    private Date optime;

    private String opip;

    private String function;

    private String params;

}