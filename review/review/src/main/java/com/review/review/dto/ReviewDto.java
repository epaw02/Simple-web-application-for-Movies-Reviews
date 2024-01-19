package com.review.review.dto;

import com.review.review.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto implements Comparable<ReviewDto>{
    private UUID id;
    private String username;
    private LocalDateTime publicationDate;
    private Long movieId;
    private String comment;
    private Rating rating;

    @Override
    public String toString() {
        return "ReviewDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", publicationDate=" + publicationDate +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(ReviewDto o) {
        return this.username.compareTo(o.username);
    }
}