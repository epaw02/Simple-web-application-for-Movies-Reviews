import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {ReviewForm} from "../../model/review-form";
import {ReviewService} from "../../service/review.service";
import {Movie} from "../../../movie/model/movie";
import {MovieService} from "../../../movie/service/movie.service";

@Component({
  selector: 'app-review-edit',
  templateUrl: './review-edit.component.html',
  styleUrls: ['./review-edit.component.css']
})
export class ReviewEditComponent implements OnInit {

  uuid: string | undefined;

  review: ReviewForm | undefined;

  original: ReviewForm | undefined;

  movieId: string | null=null;

  constructor(
    private reviewService: ReviewService,
    private movieService:MovieService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.fetchMovie()
    this.route.params.subscribe(params => {
      this.reviewService.getReview(params['uuid'])
        .subscribe(review => {
          this.uuid = review.id;
          this.review = {
            username: review.username,
            rating:review.rating,
            comment:review.comment,
            movie:this.movieId||''
          };
          this.original = {...this.review};
        });
    });
  }


  fetchMovie() {
    this.route.params.subscribe(params => {
      this.route.paramMap.subscribe(params => {
        let movieId = params.get('movieId');
        if(movieId) {
          this.movieService.getMovie(movieId)
            .subscribe((movie: Movie) => {
              if (movieId != null) {
                this.movieId = movieId;
              }
            });
        }
      });
  })
  }


  onSubmit(): void {
    this.reviewService.updateReview(this.uuid!, this.review!)
      .subscribe(() => {this.router.navigate([`/movies//${this.movieId}`])});
  }

}







