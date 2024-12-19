package com.app.MovieReview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieReview;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnore
    private Movie movie;

    public Review(Long id, String movieReview, Double rating, Movie movie) {
        this.id = id;
        this.movieReview = movieReview;
        this.rating = rating;
        this.movie = movie;
    }

    public Review(String movieReview, Double rating, Movie movie) {
        this.movieReview = movieReview;
        this.rating = rating;
        this.movie = movie;
    }

    public Review() {
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
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(movieReview, review.movieReview) && Objects.equals(rating, review.rating) && Objects.equals(movie, review.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieReview, rating, movie);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", movieReview='" + movieReview + '\'' +
                ", rating=" + rating +
                ", movie=" + movie +
                '}';
    }
}
