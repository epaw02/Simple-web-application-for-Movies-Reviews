package com.review.review.dto;



import com.review.review.Rating;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewRequestDto {
    private String username;
    private String comment;
    private Rating rating;
}
