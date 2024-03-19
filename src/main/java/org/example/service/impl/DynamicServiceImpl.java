package org.example.service.impl;

import org.example.mapper.DynamicMapper;
import org.example.pojo.Dynamic;
import org.example.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Override
    public void insert(Dynamic dynamic) {
        dynamicMapper.insert(dynamic);
    }

    @Override
    public Dynamic[] list() {
        return dynamicMapper.list();
    }
}
