import {Component, OnInit} from '@angular/core';
import {ReviewService} from "../../service/review.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ReviewDetails} from "../../model/review-details";
import {MovieService} from "../../../movie/service/movie.service";
import {Movie} from "../../../movie/model/movie";

@Component({
  selector: 'app-review-view',
  templateUrl: './review-view.component.html',
  styleUrls: ['./review-view.component.css']
})
export class ReviewViewComponent implements OnInit {

  review: ReviewDetails={
    id:'',
    username:'',
    rating:'',
    comment:'',
    movie: {} as Movie
  };

  constructor(private service: ReviewService,
              private route: ActivatedRoute,
              private movieService: MovieService,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getReview(params['uuid'])
        .subscribe(character => this.review = character)
    });
    this.route.paramMap.subscribe(params => {
      let movieId = params.get('movieId');
      if (movieId) {
        this.movieService.getMovie(movieId)
          .subscribe((movie: Movie) => {
              this.review.movie = movie;
          })
      }
    });
  }
}
