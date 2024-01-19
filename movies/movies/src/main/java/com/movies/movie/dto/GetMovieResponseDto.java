package com.movies.movie.dto;

import lombok.*;

import java.util.UUID;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetMovieResponseDto{
    private UUID id;
    private String title;
    private String country;
    private int duration;
    private int year;
}

