package com.review.review.mapper;


import com.review.movie.MovieEntity;
import com.review.review.ReviewEntity;
import com.review.review.dto.GetReviewResponseDto;
import com.review.review.dto.GetReviewsResponseDto;
import com.review.review.dto.ReviewRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewMapperImpl implements ReviewMapper{
    @Override
    public ReviewEntity toEntity(MovieEntity movie, ReviewRequestDto reviewRequestDto) {
        return ReviewEntity.builder()
                .username(reviewRequestDto.getUsername())
                .movie(movie)
                .comment(reviewRequestDto.getComment())
                .rating(reviewRequestDto.getRating())
                .build();
    }

    @Override
    public GetReviewResponseDto toGetReviewDto(ReviewEntity review) {
        return GetReviewResponseDto.builder()
                .id(review.getId())
                .username(review.getUsername())
                .publicationDate(review.getPublicationDate())
                .movieId(review.getMovie().getId())
                .comment(review.getComment())
                .rating(review.getRating())
                .build();
    }

    @Override
    public GetReviewsResponseDto toGetReviewsDto(List<ReviewEntity> reviewEntityList) {
        return GetReviewsResponseDto.builder()
                .reviews(reviewEntityList.stream()
                        .map(review->GetReviewsResponseDto.Review.builder()
                                .id(review.getId())
                                .username(review.getUsername())
                                .rate(review.getRating())
                                .movieId(review.getMovie().getId())
                                .build())
                        .toList())
                .build();
    }
}
