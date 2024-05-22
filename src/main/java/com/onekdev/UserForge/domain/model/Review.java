package com.onekdev.UserForge.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;
    private UUID companyId;
    private double Rating;
    private String Description;

    public void balancedRating(){
        if(this.getRating()>5.0) this.setRating(5.0);
        if(this.getRating()<0.0) this.setRating(0.0);
    }

}
