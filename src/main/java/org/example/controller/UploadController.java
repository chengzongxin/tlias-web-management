package org.example.controller;

import org.example.mapper.ImageMapper;
import org.example.pojo.*;
import org.example.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

//@Slf4j
@RestController
public class UploadController {

    private static final String USER_HOME = System.getProperty("user.home");
    private static final String DOWNLOADS_DIR = USER_HOME + "/Downloads/";

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

        int size = (int) file.getSize();

        Image image = new Image();
        image.setUrl(url);
        image.setSize(size);
        image.setCreateTime(LocalDateTime.now());
        imageMapper.insert(image);
//        log.info("文件上传完成,文件访问的url: {}", url);
        return Result.success(url);
    }

    @GetMapping("imageList")
    public Result imageList() {
        List<Image> list = imageMapper.list();
//        PageBean pageBean = empService.page(page, pageSize, name,gender, begin, end);
        return Result.success(list);
    }

    @PostMapping("/localupload")
    public String localUpload(MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }
        try {
            byte[] bytes = file.getBytes();
            File uploadedFile = new File(DOWNLOADS_DIR + file.getOriginalFilename());
            file.transferTo(uploadedFile);
            return "File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed!";
        }
    }
}
