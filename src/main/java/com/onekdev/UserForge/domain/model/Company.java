package com.onekdev.UserForge.domain.model;

import com.onekdev.UserForge.domain.request.CompanyRequest;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends User{

    private String Description;
    private String CompanyName;
    private Double Rating;
    private Double AgregatePrice;
    private String Address;

    public Company(CompanyRequest company){
        super(company.getID());
        this.Description = company.getDescription();
        this.CompanyName = company.getCompanyName();
        this.AgregatePrice = company.getAgregatePrice();
        this.Address = company.getAddress();
    }
}
