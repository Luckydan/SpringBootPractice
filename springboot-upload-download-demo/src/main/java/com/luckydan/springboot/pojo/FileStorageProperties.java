package com.luckydan.springboot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 通过@ConfigurationProperties 注解，自动将配置文件中的以file开头的配置项动态的绑定到实体类的属性上
 *
 * @author gl
 * @data 2019年8月26日 23点45分
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}