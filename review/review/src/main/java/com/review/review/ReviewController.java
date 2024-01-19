package com.review.review;

import com.review.movie.MovieEntity;
import com.review.movie.MovieService;
import com.review.review.dto.GetReviewResponseDto;
import com.review.review.dto.GetReviewsResponseDto;
import com.review.review.dto.ReviewRequestDto;
import com.review.review.mapper.ReviewMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api")
class ReviewController {

    private final ReviewService reviewService;
    private final MovieService movieService;
    private final ReviewMapper reviewMapper;

    public ReviewController(ReviewService reviewService, MovieService movieService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.movieService = movieService;
        this.reviewMapper = reviewMapper;
    }

    //creating
    @PostMapping("/movies/{movieId}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public GetReviewResponseDto createReview(@PathVariable("movieId") UUID movieId,
                                             @RequestBody ReviewRequestDto requestDto){
       MovieEntity movie = movieService.getMovieById(movieId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
       ReviewEntity review=reviewService.createReview(reviewMapper.toEntity(movie, requestDto));
       return reviewMapper.toGetReviewDto(review);
    }


    //delete
    @DeleteMapping("/reviews/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("id") UUID id) {
        reviewService.getReviewById(id)
                .ifPresentOrElse(review -> reviewService.deleteReview(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    //get
    @GetMapping("/reviews/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetReviewResponseDto getReview(@PathVariable("id") UUID id) {
        ReviewEntity review = reviewService.getReviewById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return reviewMapper.toGetReviewDto(review);
    }

    //get collection
    @GetMapping("/reviews")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetReviewsResponseDto getReviewsList() {
        return reviewMapper.toGetReviewsDto(reviewService.getAllReviews());
    }

    //get movie's reviews collection
    @GetMapping("/movies/{movieId}/reviews")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetReviewsResponseDto getReviewsListByMovie(@PathVariable("movieId") UUID movieId) {
        MovieEntity movie = movieService.getMovieById(movieId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return reviewMapper.toGetReviewsDto(reviewService.getReviewByMovie(movie).stream().toList());
    }

    ///updating
    @PutMapping("/reviews/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetReviewResponseDto modifyReview(@PathVariable("id") UUID id, @RequestBody ReviewRequestDto requestDto){
        ReviewEntity review =reviewService.getReviewById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return reviewMapper.toGetReviewDto(reviewService.modifyReview(review, requestDto));
    }
}
