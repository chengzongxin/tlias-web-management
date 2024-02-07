package org.example.controller;

import org.example.mapper.ImageMapper;
import org.example.pojo.Dept;
import org.example.pojo.Image;
import org.example.pojo.Result;
import org.example.pojo.UploadImage;
import org.example.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

//@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @Autowired
    private ImageMapper imageMapper;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        System.out.println(image);
//        log.info("文件上传, 文件名: {}", image.getOriginalFilename());

        //调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(image);
//        log.info("文件上传完成,文件访问的url: {}", url);
        return Result.success(url);
    }

    @PostMapping("/upload/images")
    public Result uploadImages(MultipartFile file) throws Exception {
        // 这个file必须和前端的【file: （二进制）】命名一直，否则是null
        System.out.println(file);
//        log.info("文件上传, 文件名: {}", image.getOriginalFilename());

        //调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(file);
//        log.info("文件上传完成,文件访问的url: {}", url);
//        Image image = new Image(null,null,url,0,LocalDateTime.now());
//        UploadImage uploadImage = new UploadImage(null,null,url,0,LocalDateTime.now());
//        imageMapper.insert(uploadImage);
        imageMapper.insert(url);

//        Dept dept = new Dept(null,"666",null,null);
//        dept.setCreateTime(LocalDateTime.now());
//        dept.setUpdateTime(LocalDateTime.now());
//        imageMapper.add(dept);

        return Result.success(url);
    }
}
