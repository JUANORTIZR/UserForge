package com.onekdev.UserForge.config.mappers;

import com.onekdev.UserForge.domain.model.Review;
import com.onekdev.UserForge.domain.request.ReviewRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper  {

    Review toReview(ReviewRequest request);
}
