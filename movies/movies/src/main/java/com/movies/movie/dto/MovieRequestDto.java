package com.movies.movie.dto;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieRequestDto {
    private String title;
    private String country;
    private int duration;
    private int year;
}
