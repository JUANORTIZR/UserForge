package com.onekdev.UserForge.domain.response;

import com.onekdev.UserForge.domain.model.User;

import lombok.Getter;

@Getter
public class UserResponse {
    private Long ID;
    private String Rol;
    private String FirsName;
    private String LastName;
    private String FullName;

    public UserResponse(User user) {
        this.ID = user.getID();
        this.Rol = user.getRol();
        this.FirsName = user.getFirsName();
        this.LastName = user.getLastName();
        this.FullName = user.getFullName();
    }
}
