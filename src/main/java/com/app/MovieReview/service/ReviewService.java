package com.app.MovieReview.service;

import com.app.MovieReview.domain.Movie;
import com.app.MovieReview.domain.Review;
import com.app.MovieReview.dto.ReviewDTO;
import com.app.MovieReview.repository.MovieRepository;
import com.app.MovieReview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired

    private MovieRepository movieRepository;
    public Review saveReview(ReviewDTO reviewSaveDTO) {

        Movie movie = movieRepository.findById(reviewSaveDTO.getMovie().getId())
                .orElseThrow(() -> new RuntimeException("Movie not found with ID: " + reviewSaveDTO.getMovie().getId()));

        // Map ReviewDTO to Review entity
        Review review = new Review();
        review.setRating(reviewSaveDTO.getRating());
        review.setMovie(movie);

        Review savedReview = reviewRepository.save(review);

        // Update the movie's rating
        Double averageRating = reviewRepository.getReviewAverage(movie.getId());
        if (averageRating != null && !averageRating.equals(movie.getRating())) {
            movie.setRating(averageRating);
            movieRepository.save(movie); // Only save the movie if the rating has changed
        }

        return savedReview;
    }
}
