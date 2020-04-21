package com.luckydan.springboot.exception;

/**
 * 运行时文件存储异常
 *
 * @author gl
 * @data 2019年8月26日 23点42分
 * @version 1.0.0
 */
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}