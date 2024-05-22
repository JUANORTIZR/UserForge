package com.onekdev.UserForge.controller;

import com.onekdev.UserForge.domain.model.Review;
import com.onekdev.UserForge.domain.request.ReviewRequest;
import com.onekdev.UserForge.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Boolean> registry(@RequestBody ReviewRequest reviewRequest){
        return ResponseEntity.ok().body(reviewService.registerReview(reviewRequest));
    }

    @GetMapping
    public ResponseEntity<ArrayList<Review>> getByCompanyId(@RequestParam UUID ID){
        return ResponseEntity.ok().body(reviewService.getReviewsByCompany(ID));
    }
}
