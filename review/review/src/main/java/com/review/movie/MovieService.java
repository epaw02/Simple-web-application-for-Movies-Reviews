package com.review.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieEntity createMovie(UUID movieId) {
        MovieEntity newMovie = new MovieEntity(movieId, new HashSet<>());
        return movieRepository.save(newMovie);
    }

    public void deleteMovie(UUID movieId) {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            movieRepository.delete(movie.get());
        }
    }

    public Optional<MovieEntity> getMovieById(UUID id) {
        return movieRepository.findById(id);
    }
}