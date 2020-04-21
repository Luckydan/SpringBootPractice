package com.luckydan.springboot.pojo;
import lombok.Data;

/**
 * 文件上传响应结果类
 *
 * @author gl
 * @data 2019年8月26日 23点46分
 * @version 1.0.0
 */
@Data
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

	// Getters and Setters (Omitted for brevity)
}