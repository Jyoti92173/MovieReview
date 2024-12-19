package com.app.MovieReview.domain;

import jakarta.persistence.*;
import org.hibernate.Length;
import org.hibernate.annotations.NaturalId;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", length = 11)
    private Long id;

    @Column(name = "movie_title", length = 50)
    private String title;

    @Column(name = "genre", length = 40)
    private Genre genre;

    @Column(name = "rating", length = 11)
    private Double rating;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public Movie(Long id, String title, Genre genre, Double rating, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.reviews = reviews;
    }

    public Movie(String title, Genre genre, Double rating, List<Review> reviews) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.reviews = reviews;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && genre == movie.genre && Objects.equals(rating, movie.rating) && Objects.equals(reviews, movie.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, rating, reviews);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                ", reviews=" + reviews +
                '}';
    }

}
