package com.movies.movie;

import com.movies.movie.dto.MovieRequestDto;
import com.movies.movie.event.MovieEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieEvent movieEvent;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieEvent movieEvent) {
        this.movieRepository = movieRepository;
        this.movieEvent = movieEvent;
    }

    public MovieEntity createMovie(MovieEntity movie) {
        MovieEntity newMovie= movieRepository.save(movie);
        movieEvent.create(newMovie.getId());
        return newMovie;
    }

    public void deleteMovie(UUID movieId) {
        Optional<MovieEntity> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            movieRepository.delete(movie.get());
            movieEvent.delete(movieId);
        }
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<MovieEntity> getMovieById(UUID id) {
        return movieRepository.findById(id);
    }

    public Optional<MovieEntity> getMovieByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public MovieEntity modifyMovie(MovieEntity movie, MovieRequestDto requestDto) {
        movie.setTitle(requestDto.getTitle());
        movie.setCountry(requestDto.getCountry());
        movie.setDuration(requestDto.getDuration());
        movie.setYear(requestDto.getYear());

        return movieRepository.save(movie);
    }
}
