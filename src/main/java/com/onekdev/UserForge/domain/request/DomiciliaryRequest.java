package com.onekdev.UserForge.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomiciliaryRequest {
    private UUID CompanyId;
    private String PlateNumber;
    private String nickname;
    private String password;
    private String name;
    private String email;
    private String phone_number;

}
