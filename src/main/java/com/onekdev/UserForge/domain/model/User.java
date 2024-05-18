package com.onekdev.UserForge.domain.model;

import com.onekdev.UserForge.domain.request.UserRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Long ID;
    private String rol;
    private String FirsName;
    private String LastName;
    private String FullName;

    public User(UserRequest request) {
        this.ID = request.getID();
        this.rol = request.getRol();
        this.FirsName = request.getFirsName();
        this.LastName = request.getLastName();
        this.FullName = request.getFullName().isBlank() ? request.getFirsName() + " " + request.getLastName() : request.getFullName();
    }
}
