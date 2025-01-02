package com.app.MovieReview.controller;

import com.app.MovieReview.domain.Movie;
import com.app.MovieReview.domain.Review;
import com.app.MovieReview.dto.ReviewDTO;
import com.app.MovieReview.exception.InvalidReviewException;
import com.app.MovieReview.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@Slf4j
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewSaveDTO) {
        try {
            // Validate input fields
            if (reviewSaveDTO.getMovieReview() == null || reviewSaveDTO.getMovieReview().isEmpty()) {
                throw new InvalidReviewException("Review text cannot be empty");
            }
            // Create the Review object
            Review review = new Review();
            review.setMovieReview(reviewSaveDTO.getMovieReview());
            review.setRating(reviewSaveDTO.getRating());
            review.setMovie(reviewSaveDTO.getMovie());

            Review savedReview = reviewService.addReview(review);
            return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while saving review: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/find")
    public ResponseEntity<List<ReviewDTO>> getReview(@RequestParam Long reviewId){
        try {
            List<ReviewDTO> review = reviewService.getReviewById(reviewId);
            if (review != null) {
                return ResponseEntity.ok(review);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
