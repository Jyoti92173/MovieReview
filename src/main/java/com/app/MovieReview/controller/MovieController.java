package com.app.MovieReview.controller;

import com.app.MovieReview.domain.Genre;
import com.app.MovieReview.domain.Movie;
import com.app.MovieReview.dto.MovieDTO;
import com.app.MovieReview.service.MovieService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody  MovieDTO movieSaveDTO){
        try{
          return new ResponseEntity<>( movieService.addMovie(movieSaveDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error occurred while saving movie: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/title")
    public ResponseEntity<List<MovieDTO>> findMovie(@RequestParam  String title){
        try {
            List<MovieDTO> movies = movieService.findMovie(title);
            return ResponseEntity.ok(movies);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/genre")
    public ResponseEntity<List<MovieDTO>> findMovieByGenre(@RequestParam Genre genre){
        try{
            List<MovieDTO> movieDTOList = movieService.findMoviesByGenre(genre);
            return ResponseEntity.ok(movieDTOList);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
