package com.onekdev.UserForge.domain.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {
    private String Message;
    private HttpStatus Code;
    private String ModuleName;
    private String Reason;
}
