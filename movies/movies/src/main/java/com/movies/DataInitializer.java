package com.movies;

import com.movies.movie.MovieEntity;
import com.movies.movie.MovieService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {

    private final MovieService movieService;

    public DataInitializer(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MovieEntity firstMovie = MovieEntity.builder()
                .id(UUID.fromString("2eae0113-6ad4-11ee-b962-0242ac121111"))
                .title("The Shining")
                .country("USA")
                .duration(146)
                .year(1980).build();


        MovieEntity secondMovie = MovieEntity.builder()
                .id(UUID.fromString("1eae0112-6ad4-11ee-b962-0242ac122223"))
                .title("Fight Club")
                .country("USA")
                .duration(139)
                .year(1999)
                .build();

        movieService.createMovie(firstMovie);
        movieService.createMovie(secondMovie);
    }
}
