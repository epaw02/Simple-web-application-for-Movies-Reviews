import { Component, OnInit } from '@angular/core';
import { MovieService } from "../../service/movie.service";
import { ActivatedRoute, Router } from "@angular/router";
import { MovieDetails } from "../../model/movie-details";
import {ReviewService} from "../../../review/service/review.service";
import {Reviews} from "../../../review/model/reviews";
import {Review} from "../../../review/model/review";

@Component({
  selector: 'app-movie-view',
  templateUrl: './movie-view.component.html',
  styleUrls: ['./movie-view.component.css']
})
export class MovieViewComponent implements OnInit {

  movie: MovieDetails | undefined;
  reviews:Reviews|undefined;

  constructor(private service: MovieService,
              private reviewService:ReviewService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getMovie(params['uuid']).subscribe(movie => {
        this.movie = movie;
        if (this.movie && this.movie.id) {
          this.getReviewsForMovie(this.movie.id);
        }
      });
    });
  }


  getReviewsForMovie(movieId: string): void {
    this.reviewService.getReviewsByMovie(movieId).subscribe(reviews => {
      this.reviews = reviews;
    });
  }

  onDelete(review: Review): void {
    this.reviewService.deleteReview(review.id).subscribe(() => this.ngOnInit());
  }


}
