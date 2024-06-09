package com.onekdev.UserForge.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Domiciliary extends User{


    private UUID companyId;
    private String name;
    private String PlateNumber;

    @Override
    public void merge(User other) {
        Domiciliary domiciliary = (Domiciliary) other;
        this.PlateNumber = domiciliary.getPlateNumber();
    }
}
