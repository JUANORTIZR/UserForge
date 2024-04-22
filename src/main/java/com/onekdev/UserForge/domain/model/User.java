package com.onekdev.UserForge.domain.model;

import com.onekdev.UserForge.domain.request.UserRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long ID;
    private String Rol;
    private String FirsName;
    private String LastName;
    private String FullName;

    public User(UserRequest request) {
        this.Rol = request.getRol();
        this.FirsName = request.getFirsName();
        this.LastName = request.getLastName();
        this.FullName = request.getFullName().isBlank() ? request.getFirsName() + " " + request.getLastName() : request.getFullName();
    }
}
