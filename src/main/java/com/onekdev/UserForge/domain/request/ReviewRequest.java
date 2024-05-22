package com.onekdev.UserForge.domain.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewRequest {
    private UUID companyId;
    private double Rating;
    private String Description;
}
