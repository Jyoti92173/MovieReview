package com.app.MovieReview.exception;

public class InvalidReviewException extends RuntimeException {
    public InvalidReviewException(String message) {
        super(message);
    }
}
//Created InvalidReviewException for handling invalid review data.
