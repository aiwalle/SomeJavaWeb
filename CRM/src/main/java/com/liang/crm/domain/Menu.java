package com.liang.crm.domain;


import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter@Getter
@Alias("Menu")
public class Menu {
    private Long id;

    private String text;

    private String state;

    private Boolean checked;

    private String attributes;

    private List<Menu> children;

    private String resource;
}