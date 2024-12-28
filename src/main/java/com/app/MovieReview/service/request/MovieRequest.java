package com.app.MovieReview.service.request;

import com.app.MovieReview.domain.Genre;
import com.app.MovieReview.domain.Movie;

import java.util.Objects;

public class MovieRequest {
    private String title;
    private Genre genre;

    public MovieRequest(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public MovieRequest() {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieRequest that = (MovieRequest) o;
        return Objects.equals(title, that.title) && genre == that.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre);
    }

    @Override
    public String toString() {
        return "MovieRequest{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }

    public Movie toMovie(){
        return new Movie(title, genre, 5.0);
    }
}
