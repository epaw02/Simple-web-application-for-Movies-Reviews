package com.movies.movie.dto;


import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetMoviesResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Movie{
        private UUID id;
        private String title;
    }

    private List<Movie> movies;
}
