package com.app.MovieReview.service.response;

import com.app.MovieReview.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;

    public MovieResponse(String title, Genre genre, Double rating, List<ReviewResponse> reviewResponse) {

    }
}
