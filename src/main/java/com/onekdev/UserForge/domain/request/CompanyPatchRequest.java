package com.onekdev.UserForge.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyPatchRequest {
    private String Description;
    private String CompanyName;
    private Double AgregatePrice;
    private String Address;
}
