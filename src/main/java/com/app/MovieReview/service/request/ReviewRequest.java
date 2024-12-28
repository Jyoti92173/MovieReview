package com.app.MovieReview.service.request;

import com.app.MovieReview.domain.Movie;
import com.app.MovieReview.domain.Review;

public class ReviewRequest {
    private String movieReview;

    private double rating;

    private Long movieId;

    public Review toReview(){
        if (movieId == null) {
            throw new IllegalArgumentException("movieId cannot be null");
        }

        // Create a new Movie object and set the movieId
        Movie movie = new Movie();
        movie.setId(movieId); 

        // Create a new Review object and set its fields
        Review review = new Review();
        review.setMovieReview(movieReview);
        review.setRating(rating);
        review.setMovie(movie);

        return review;

    }
}
