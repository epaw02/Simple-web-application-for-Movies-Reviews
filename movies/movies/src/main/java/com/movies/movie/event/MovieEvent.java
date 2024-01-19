package com.movies.movie.event;

import com.movies.movie.MovieEntity;
import com.movies.movie.dto.GetMoviesResponseDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Repository
public class MovieEvent {

    private final RestTemplate restTemplate;

    public MovieEvent(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void delete(UUID id) {
        restTemplate.delete("/api/movies/{id}", id);
    }

    public void create(UUID movieId){
        try {
            Map<String, UUID> requestBody = Collections.singletonMap("movieId", movieId);
            restTemplate.postForEntity
                    ("/api/movies", requestBody, Void.class);
        } catch (
    ResourceAccessException e) {
        // Nic nie rób w przypadku wystąpienia wyjątku
    }
    }

//    public void create(UUID uuid) {
//        MovieEntity book = MovieEntity.builder().build();
//        restTemplate.put("/api/movies/{id}",uuid, book);
//    }
}
