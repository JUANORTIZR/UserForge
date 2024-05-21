package com.onekdev.UserForge.domain.response;

import com.onekdev.UserForge.domain.model.Company;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CompanyResponse {
    private UUID ID;
    private String Nickname;
    private String Description;
    private String CompanyName;
    private Double AgregatePrice;
    private String Address;
    private Double Rating;

    public CompanyResponse(Company company) {
        this.ID= company.getID();
        this.Nickname = company.getNickname();
        this.Description = company.getDescription();
        this.CompanyName = company.getCompanyName();
        this.AgregatePrice = company.getAggregatePrice();
        this.Address = company.getAddress();
        this.Rating = 0.0;
    }
}
