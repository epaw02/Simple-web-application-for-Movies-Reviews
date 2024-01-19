package com.movies.movie.mapper;
import com.movies.movie.MovieEntity;
import com.movies.movie.dto.GetMoviesResponseDto;
import com.movies.movie.dto.GetMovieResponseDto;
import com.movies.movie.dto.MovieRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieMapperImpl implements MovieMapper{

    @Override
    public MovieEntity toEntity(MovieRequestDto movieRequestDto) {
        return MovieEntity.builder()
                .title(movieRequestDto.getTitle())
                .country(movieRequestDto.getCountry())
                .duration(movieRequestDto.getDuration())
                .year(movieRequestDto.getYear())
                .build();
    }

    @Override
    public GetMovieResponseDto toGetMovieDto(MovieEntity movie) {
        return GetMovieResponseDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .country(movie.getCountry())
                .duration(movie.getDuration())
                .year(movie.getYear())
                .build();
    }

    @Override
    public GetMoviesResponseDto toGetMoviesDto(List<MovieEntity> movieEntityList) {
        return GetMoviesResponseDto.builder()
                .movies(movieEntityList.stream()
                        .map(movie-> GetMoviesResponseDto.Movie.builder()
                                .id(movie.getId())
                                .title(movie.getTitle())
                                .build())
                        .toList())
                .build();
    }
}
