package com.onekdev.UserForge.service;

import com.onekdev.UserForge.commons.BusinessException;
import com.onekdev.UserForge.config.mappers.ReviewMapper;
import com.onekdev.UserForge.domain.model.Review;
import com.onekdev.UserForge.domain.request.ReviewRequest;
import com.onekdev.UserForge.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    private ReviewMapper mapper;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public boolean registerReview(ReviewRequest request){
        try {
            Review review = mapper.toReview(request);
            review.balancedRating();
            reviewRepository.save(review);
            return true;
        }catch (Exception e) {
            throw new BusinessException("No se pudo registrar la reseña", ReviewService.class.getName(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ArrayList<Review> getReviewsByCompany(UUID ID){
        try {
            return (ArrayList<Review>) reviewRepository.findByCompanyId(ID).orElseThrow(
                    ()->new BusinessException("Error al intentar consultar reviews por id de la compañia",
                    DomiciliaryService.class.getName(),
                    "Error con la libreria hibernate",
                    HttpStatus.INTERNAL_SERVER_ERROR));
        }catch (Exception e) {
            throw new BusinessException("No se pudo consultar las reseñas", ReviewService.class.getName(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
