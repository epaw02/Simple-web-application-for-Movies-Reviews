package com.review.review.dto;

import com.review.review.Rating;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetReviewsResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Review {
        private UUID id;
        private String username;
        private Rating rate;
        private UUID movieId;
    }

    private List<Review> reviews;
}
