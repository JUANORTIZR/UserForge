package com.onekdev.UserForge.domain.model;

import com.onekdev.UserForge.domain.request.CompanyRequest;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company extends User{

    private String Description;
    private String CompanyName;
    @Formula("(select avg(r.Rating) from review r where r.company_id = id)")
    private Double Rating;
    private Double AggregatePrice;
    private String Address;

    public Company(CompanyRequest company){
        super(company.getNickname());
        this.Description = company.getDescription();
        this.CompanyName = company.getCompanyName();
        this.AggregatePrice = company.getAgregatePrice();
        this.Address = company.getAddress();
    }


    @Override
    public void merge(User other) {
        Company company = (Company) other;
        this.Description = company.getDescription();
        this.CompanyName = company.getCompanyName();
        this.AggregatePrice = company.getAggregatePrice();
        this.Address = company.getAddress();
    }
}
