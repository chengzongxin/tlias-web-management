package org.example.controller;

import org.example.pojo.Emp;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result emps(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Integer gender,
                       @DateTimeFormat(pattern = "yyyy-dd-mm") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-dd-mm") LocalDate end) {
        PageBean pageBean = empService.page(page, pageSize, name,gender, begin, end);
        return Result.success(pageBean);
    }

    @PostMapping
    public Result insert(@RequestBody Emp emp) {
        System.out.println(emp);
        empService.insert(emp);
        return Result.success();
    }

    @PostMapping("/test")
    public Result test() {
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }

}
