package com.app.MovieReview.domain;

import com.app.MovieReview.service.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieReview;

    private double rating;  // rating dedicated to each review.

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnore
    private Movie movie;// it will add foregion key in mysql table with <TABLE_NAME>_<ID_NAME> --> // movie_movie_id

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    public Review(Long id, String movieReview, double rating, Movie movie, Date createdDate, Date updatedDate) {
        this.id = id;
        this.movieReview = movieReview;
        this.rating = rating;
        this.movie = movie;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Review(String movieReview, double rating, Movie movie, Date createdDate, Date updatedDate) {
        this.movieReview = movieReview;
        this.rating = rating;
        this.movie = movie;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Double.compare(rating, review.rating) == 0 && Objects.equals(id, review.id) && Objects.equals(movieReview, review.movieReview) && Objects.equals(movie, review.movie) && Objects.equals(createdDate, review.createdDate) && Objects.equals(updatedDate, review.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movieReview, rating, movie, createdDate, updatedDate);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", movieReview='" + movieReview + '\'' +
                ", rating=" + rating +
                ", movie=" + movie +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }


    public ReviewResponse toReviewResponse(Review review) {
        var reviewResponse = new ReviewResponse(movieReview, rating);
        return reviewResponse;
    }


    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList) {
        List<ReviewResponse> responseList = new ArrayList<>();
        if (reviewList != null) {
            for (Review review : reviewList) {
                if (review != null) {
                    responseList.add(review.toReviewResponse(review));
                }
            }
        }
        return responseList;

    }
}

