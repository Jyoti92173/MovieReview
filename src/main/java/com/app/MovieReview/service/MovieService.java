package com.app.MovieReview.service;

import com.app.MovieReview.domain.Genre;
import com.app.MovieReview.domain.Movie;
import com.app.MovieReview.domain.Review;
import com.app.MovieReview.dto.MovieDTO;
import com.app.MovieReview.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    public Movie addMovie(MovieDTO movieSaveDTO) {
        Movie movie = new Movie(movieSaveDTO.getId(),movieSaveDTO.getTitle(),movieSaveDTO.getGenre(),movieSaveDTO.getRating(),null);
        return movieRepository.save(movie);
    }

    public List<MovieDTO> findMovie(String title) {
        List<Movie> movies = movieRepository.findAllByTitle(title);
        if (Objects.nonNull(movies) && !movies.isEmpty()) {

            return movies.stream()
                    .map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getRating()))
                    .toList();
        }
        return List.of();
    }

    public List<MovieDTO> findMoviesByGenre(Genre genre) {
        List<Movie> movieList = movieRepository.findAllMoviesByGenre(genre);
        if(Objects.nonNull(movieList) && !movieList.isEmpty()){
            return movieList.stream().map(movie -> new MovieDTO(movie.getId(),movie.getTitle(),movie.getGenre(),movie.getRating()))
                    .toList();
        }
        return List.of();
    }
}
