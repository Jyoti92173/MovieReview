package com.app.MovieReview.dto;

import com.app.MovieReview.domain.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDTO {

    private Long id;
    private String movieReview;
    private Double rating;
    private Movie movie;

    public ReviewDTO(Long id, String movieReview, Double rating, Movie movie) {
        this.id = id;
        this.movieReview = movieReview;
        this.rating = rating;
        this.movie = movie;
    }

    public ReviewDTO(String movieReview, Double rating, Movie movie) {
        this.movieReview = movieReview;
        this.rating = rating;
        this.movie = movie;
    }

    public ReviewDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieReview() {
        return movieReview;
    }

    public void setMovieReview(String movieReview) {
        this.movieReview = movieReview;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return Objects.equals(id, reviewDTO.id) && Objects.equals(movieReview, reviewDTO.movieReview) && Objects.equals(rating, reviewDTO.rating) && Objects.equals(movie, reviewDTO.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieReview, rating, movie);
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id=" + id +
                ", movieReview='" + movieReview + '\'' +
                ", rating=" + rating +
                ", movie=" + movie +
                '}';
    }
}
