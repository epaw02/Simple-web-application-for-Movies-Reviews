import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../service/movie.service';
import { MovieForm } from '../../model/movie-form';
import {Router} from "@angular/router";


@Component({
  selector: 'app-movie-add',
  templateUrl: './movie-add.component.html',
  styleUrls: ['./movie-add.component.css']
})
export class MovieAddComponent implements OnInit {

  movie: MovieForm = {
    title: '',
    country: '',
    duration: 0,
    year: 0
  };

  constructor(
    private movieService: MovieService,
    private router: Router
  ) {
  }

  ngOnInit() {
  }

  onSubmit(): void {
    this.movieService.createMovie(this.movie)
      .subscribe(() => this.router.navigate(['/movies']));
  }

}
