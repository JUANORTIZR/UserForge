package com.onekdev.UserForge.domain.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequest {
    private Long ID;
    private String Rol;
    private String FirsName;
    private String LastName;
    private String FullName;
}
