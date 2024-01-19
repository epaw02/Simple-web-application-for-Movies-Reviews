package com.review.review;


import com.review.movie.MovieEntity;
import com.review.review.dto.ReviewRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewEntity createReview(ReviewEntity review) {
        review.setPublicationDate(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    public void deleteReview(UUID movieId) {
        reviewRepository.findById(movieId).ifPresent(reviewRepository::delete);
    }

    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<ReviewEntity> getReviewById(UUID id) {
        return reviewRepository.findById(id);
    }

    public Set<ReviewEntity> getReviewByMovie(MovieEntity movie) {
        return reviewRepository.findByMovie(movie);
    }

    public ReviewEntity modifyReview(ReviewEntity review, ReviewRequestDto requestDto) {
        review.setComment(requestDto.getComment());
        review.setRating(requestDto.getRating());
        review.setPublicationDate(LocalDateTime.now());
        review.setUsername(requestDto.getUsername());
        return reviewRepository.save(review);
    }
}
