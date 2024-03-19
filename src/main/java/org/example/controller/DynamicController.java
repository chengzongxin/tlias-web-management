package org.example.controller;

import org.example.pojo.Dynamic;
import org.example.pojo.Result;
import org.example.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Autowired
    DynamicService dynamicService;
    @PostMapping
    public Result insert(@RequestBody Dynamic dynamic)
    {
        dynamicService.insert(dynamic);
        return Result.success();
    }
}
