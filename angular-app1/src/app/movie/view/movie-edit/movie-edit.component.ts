import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../service/movie.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieForm } from '../../model/movie-form';


@Component({
  selector: 'app-movie-edit',
  templateUrl: './movie-edit.component.html',
  styleUrls: ['./movie-edit.component.css']
})
export class MovieEditComponent implements OnInit {

  uuid: string | undefined;

  movie: MovieForm | undefined;

  original: MovieForm | undefined;

  constructor(
    private movieService: MovieService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.movieService.getMovie(params['uuid'])
        .subscribe(movie => {
          this.uuid = movie.id;
          this.movie = {
            title: movie.title,
            country:movie.country,
            duration:movie.duration,
            year:movie.year
          };
          this.original = {...this.movie};
        });
    });
  }

  onSubmit(): void {
    this.movieService.updateMovie(this.uuid!, this.movie!)
      .subscribe(() => this.router.navigate(['/movies']));
  }

}
