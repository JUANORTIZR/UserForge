package com.onekdev.UserForge.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomiciliaryRequest {
    private Long ID;
    private Long CompanyId;
    private String PlateNumber;
}
