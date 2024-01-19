package com.review.review.mapper;

import com.review.movie.MovieEntity;
import com.review.review.ReviewEntity;
import com.review.review.dto.GetReviewResponseDto;
import com.review.review.dto.GetReviewsResponseDto;
import com.review.review.dto.ReviewRequestDto;

import java.util.List;

public interface ReviewMapper {
    public ReviewEntity toEntity(MovieEntity movie, ReviewRequestDto reviewRequestDto);
    public GetReviewResponseDto toGetReviewDto(ReviewEntity review);
    public GetReviewsResponseDto toGetReviewsDto(List<ReviewEntity> reviewEntityList);

}
