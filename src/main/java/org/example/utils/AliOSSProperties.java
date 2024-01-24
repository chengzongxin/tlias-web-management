package org.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")

/**
 * LTAI5tP8GcouxvDHVwcowNKV
 * SgGHUCKwDBskThle5dsUbdohkxescK
 */
public class AliOSSProperties {
    private String endpoint = "oss-cn-beijing.aliyuncs.com";
    private String accessKeyId = "LTAI5tP8GcouxvDHVwcowNKV";
    private String accessKeySecret = "SgGHUCKwDBskThle5dsUbdohkxescK";
    private String bucketName = "pic-file-bucket";
}
