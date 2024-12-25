package com.app.MovieReview.service;

import com.app.MovieReview.domain.Movie;
import com.app.MovieReview.domain.Review;
import com.app.MovieReview.dto.ReviewDTO;
import com.app.MovieReview.exception.MovieNotFoundException;
import com.app.MovieReview.repository.MovieRepository;
import com.app.MovieReview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<ReviewDTO> getReviewById(Long reviewId) {
        Optional<Review> review= reviewRepository.findById(reviewId);
        return review.map(Review->review.isPresent(reviewId)).orElse(null);
    }
}
