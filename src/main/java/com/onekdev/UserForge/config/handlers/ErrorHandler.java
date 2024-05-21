package com.onekdev.UserForge.config.handlers;

import com.onekdev.UserForge.commons.BusinessException;
import com.onekdev.UserForge.domain.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleErrorObjectNotFound(BusinessException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setCode(ex.getStatusCode());
        errorResponse.setModuleName(ex.getClassName());
        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

}
