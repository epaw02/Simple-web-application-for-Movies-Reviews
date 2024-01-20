package com.movies.movie;

import com.movies.movie.dto.GetMovieResponseDto;
import com.movies.movie.dto.GetMoviesResponseDto;
import com.movies.movie.dto.MovieRequestDto;
import com.movies.movie.mapper.MovieMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GetMovieResponseDto createMovie(@RequestBody MovieRequestDto movieRequestDto){
        MovieEntity movie=movieService.createMovie(movieMapper.toEntity(movieRequestDto));
        return movieMapper.toGetMovieDto(movie);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMovieResponseDto getMovie(@PathVariable UUID id){
        MovieEntity movie = movieService.getMovieById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return movieMapper.toGetMovieDto(movie);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMoviesResponseDto getMoviesList(){
        return movieMapper.toGetMoviesDto(movieService.getAllMovies());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable UUID id){
        movieService.getMovieById(id)
                .ifPresentOrElse(movie -> movieService.deleteMovie(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetMovieResponseDto modifyMovie(@PathVariable("id") UUID id, @RequestBody MovieRequestDto requestDto){
        MovieEntity movie =movieService.getMovieById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return movieMapper.toGetMovieDto(movieService.modifyMovie(movie, requestDto));
    }
}
