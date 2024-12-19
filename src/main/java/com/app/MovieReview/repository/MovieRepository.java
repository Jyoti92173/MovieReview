package com.app.MovieReview.repository;

import com.app.MovieReview.domain.Genre;
import com.app.MovieReview.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    List<Movie> findAllByTitle(String title);

    List<Movie> findAllMoviesByGenre(Genre genre);
}
