package com.onekdev.UserForge.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BusinessException extends RuntimeException{

    private String ClassName;
    private HttpStatus StatusCode;
    private String Reason;

    public BusinessException(String message, String className,String reason, HttpStatus statusCode) {
        super(message);
        this.ClassName = className;
        this.StatusCode = statusCode;
        this.Reason = reason;
    }
}
