package com.onekdev.UserForge.domain.model;

import lombok.Data;

@Data
public class Domiciliary extends User{
    private Long CompanyId;
    private String PlateNumber;

    @Override
    public void merge(User other) {
        Domiciliary domiciliary = (Domiciliary) other;
        this.PlateNumber = domiciliary.getPlateNumber();
    }
}
