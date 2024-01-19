package com.review.movie;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public MovieEntity createMovie(@RequestBody Map<String, UUID> requestBody){
        return movieService.createMovie(requestBody.get("movieId"));
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
}
