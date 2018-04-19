package com.liang.crm.service.impl;

import com.liang.crm.domain.Menu;
import com.liang.crm.mapper.MenuMapper;
import com.liang.crm.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liang on 2018/4/19.
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper dao;

    public List<Menu> queryMenu() {
        return dao.selectRoot();
    }
}
