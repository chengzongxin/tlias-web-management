package org.example.service;

import org.example.pojo.Dept;
import org.example.pojo.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    List<Dept> selectAll();

    void delete(Integer id);

    void add(Dept dept);
}
