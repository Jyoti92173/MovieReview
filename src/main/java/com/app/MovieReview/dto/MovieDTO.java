package com.app.MovieReview.dto;

import com.app.MovieReview.domain.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;
@JsonInclude(JsonInclude.Include.NON_NULL)

public class MovieDTO {
    private Long id;
    private String title;
    private Genre genre;
    private Double rating;

    public MovieDTO(Long id, String title, Genre genre, Double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public MovieDTO(String title, Genre genre, Double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public MovieDTO() {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(id, movieDTO.id) && Objects.equals(title, movieDTO.title) && genre == movieDTO.genre && Objects.equals(rating, movieDTO.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, rating);
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

}
