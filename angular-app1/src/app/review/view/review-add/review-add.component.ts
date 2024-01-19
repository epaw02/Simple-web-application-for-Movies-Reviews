import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReviewService } from '../../service/review.service';
import { MovieService } from '../../../movie/service/movie.service';
import { ReviewForm } from '../../model/review-form';
import { Movie } from '../../../movie/model/movie';

@Component({
  selector: 'app-review-add',
  templateUrl: './review-add.component.html',
  styleUrls: ['./review-add.component.css']
})
export class ReviewAddComponent implements OnInit {

  review: ReviewForm = {
    username: '',
    rating: '',
    comment: '',
    movie: ''
  };

  constructor(
    private reviewService: ReviewService,
    private movieService: MovieService,
    private router: Router,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      let movieId = params.get('movieId');
      if(movieId) {
        this.movieService.getMovie(movieId)
          .subscribe((movie: Movie) => {
            if (movieId != null) {
              this.review.movie = movieId;
            }
          });
      }
    });
  }

  onSubmitReview(): void {
      this.reviewService.createReview(this.review.movie, this.review)
        .subscribe(() => this.router.navigate([`/movies//${this.review.movie}`]));
  }
}
