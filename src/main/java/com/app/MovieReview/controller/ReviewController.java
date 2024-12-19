package com.app.MovieReview.controller;

import com.app.MovieReview.domain.Review;
import com.app.MovieReview.dto.ReviewDTO;
import com.app.MovieReview.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @PostMapping("/save")
    public ResponseEntity<Review> saveReview(@RequestBody ReviewDTO reviewSaveDTO){
        try{
            return new ResponseEntity<>(reviewService.saveReview(reviewSaveDTO),HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while saving review: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
