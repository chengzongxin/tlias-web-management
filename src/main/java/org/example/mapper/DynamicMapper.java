package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Dynamic;

@Mapper
public interface DynamicMapper {
    void insert(Dynamic dynamic);
}
