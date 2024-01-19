package com.movies.movie.mapper;



import com.movies.movie.MovieEntity;
import com.movies.movie.dto.GetMovieResponseDto;
import com.movies.movie.dto.GetMoviesResponseDto;
import com.movies.movie.dto.MovieRequestDto;

import java.util.List;

public interface MovieMapper {
   public MovieEntity toEntity(MovieRequestDto movieRequestDto);
   public GetMovieResponseDto toGetMovieDto(MovieEntity movie);
   public GetMoviesResponseDto toGetMoviesDto(List<MovieEntity> movieEntityList);
}
