import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Movies} from "../model/movies";
import {MovieDetails} from "../model/movie-details";
import {MovieForm} from "../model/movie-form";

@Injectable()
export class MovieService {

  constructor(private http: HttpClient) {

  }

  //get all movies
  getMovies(): Observable<Movies> {
    return this.http.get<Movies>('/api/movies');
  }

  //get a movie
  getMovie(uuid: string): Observable<MovieDetails> {
    return this.http.get<MovieDetails>('/api/movies/' + uuid);
  }

  //delete movie
  deleteMovie(uuid: string): Observable<any> {
    return this.http.delete('/api/movies/' + uuid);
  }

  //create movie
  createMovie(request: MovieForm): Observable<any> {
    return this.http.post('/api/movies',request);
  }

  //update movie
  updateMovie(uuid: string, request: MovieForm): Observable<any>{
    return this.http.put('/api/movies/' + uuid, request);
  }

}
