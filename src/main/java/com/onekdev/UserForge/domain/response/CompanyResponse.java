package com.onekdev.UserForge.domain.response;

import com.onekdev.UserForge.domain.model.Company;
import com.onekdev.UserForge.domain.model.User;

import lombok.Getter;

@Getter
public class CompanyResponse {
    private Long ID;
    private String Description;
    private String CompanyName;
    private Double AgregatePrice;
    private String Address;
    private Double Rating;

    public CompanyResponse(Company company) {
        this.ID = company.getID();
        this.Description = company.getDescription();
        this.CompanyName = company.getCompanyName();
        this.AgregatePrice = company.getAgregatePrice();
        this.Address = company.getAddress();
        this.Rating = 0.0;
    }
}
