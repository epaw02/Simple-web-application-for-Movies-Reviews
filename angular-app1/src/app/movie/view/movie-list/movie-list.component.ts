import { Component, OnInit } from '@angular/core';
import { Movies} from "../../model/movies";
import { Movie } from "../../model/movie";
import { MovieService } from "../../service/movie.service";

@Component({
    selector: 'app-movie-list',
    templateUrl: './movie-list.component.html',
    styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

    constructor(private service: MovieService) {
    }

    movies: Movies | undefined;

    ngOnInit(): void {
        this.service.getMovies().subscribe(movies => this.movies = movies);
    }

    onDelete(movie: Movie): void {
        this.service.deleteMovie(movie.id).subscribe(() => this.ngOnInit());
    }

}
