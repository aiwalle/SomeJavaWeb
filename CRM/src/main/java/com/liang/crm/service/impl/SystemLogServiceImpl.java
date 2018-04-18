package com.liang.crm.service.impl;

import com.liang.crm.domain.SystemLog;
import com.liang.crm.mapper.SystemLogMapper;
import com.liang.crm.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liang on 2018/4/17.
 */
@Service
public class SystemLogServiceImpl implements ISystemLogService {
    @Autowired
    private SystemLogMapper dao;

    @Override
    public int save(SystemLog log) {
        return dao.insert(log);
    }
}
