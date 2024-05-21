package com.onekdev.UserForge.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException{

    private String ClassName;
    private HttpStatus StatusCode;

    public BusinessException(String message, String className, HttpStatus statusCode) {
        super(message);
        this.ClassName = className;
        this.StatusCode = statusCode;
    }
}
