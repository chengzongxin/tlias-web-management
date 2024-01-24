package org.example.service;

import org.example.pojo.Emp;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    public List<Emp> selectAll();

    PageBean page(Integer page,
                  Integer pageSize,
                  String name,
                  Integer gender,
                  LocalDate begin,
                  LocalDate end);

    void insert(Emp emp);

    Emp getById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);

    void deleteByDeptId(Integer id);
}
