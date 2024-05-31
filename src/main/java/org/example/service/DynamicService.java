package org.example.service;

import org.example.pojo.Dynamic;

public interface DynamicService {
    void insert(Dynamic dynamic);

    Dynamic[] list();

    void update(Dynamic dynamic);
}
