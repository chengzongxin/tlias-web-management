package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Dept;
import org.example.pojo.Image;
import org.example.pojo.UploadImage;

@Mapper
public interface ImageMapper {
//    @Insert("insert into image_table (name, url, size, create_time) " +
//            "values (#{name}, #{url}, #{size}, #{createdTime});")
//    public void insert(UploadImage uploadImage);

//    void insert(UploadImage uploadImage);
    @Insert("insert into image_table (url) " +
            "values (#{url});")
    public void insert(String url);

    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime}) ")
    void add(Dept dept);

//    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime}) ")
//    void insert(Dept dept);
}
