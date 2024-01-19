package com.review.review.dto;

import com.review.review.Rating;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetReviewResponseDto {
    private UUID id;
    private String username;
    private LocalDateTime publicationDate;
    private UUID movieId;
    private String comment;
    private Rating rating;
}
