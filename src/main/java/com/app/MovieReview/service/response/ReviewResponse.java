package com.app.MovieReview.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewResponse {
    private String review;
    private Double rating;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ReviewResponse(String movieReview, double rating) {
        this.review = movieReview; // Fixed typo in the field name
        this.rating = rating;

    }
}
