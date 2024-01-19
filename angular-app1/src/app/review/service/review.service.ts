import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Reviews } from "../model/reviews";
import { ReviewDetails } from "../model/review-details";
import { ReviewForm } from "../model/review-form";

@Injectable()
export class ReviewService {
    constructor(private http:HttpClient) {
    }

    //get review
    getReview(uuid: string): Observable<ReviewDetails>{
        return this.http.get<ReviewDetails>('/api/reviews/'+uuid)
    }

    getReviewsByMovie(movieId: string):Observable<Reviews>{
      return this.http.get<Reviews>('/api/movies/'+movieId +'/reviews');
    }

    //get all reviews
    getReviews(): Observable<Reviews>{
        return this.http.get<Reviews>('/api/reviews');
    }

    //delete review
    deleteReview(uuid: string):Observable<any>{
        return this.http.delete('/api/reviews/' +uuid)
    }

    //update
    updateReview(uuid:string, request:ReviewForm): Observable<any>{
        return this.http.put('/api/reviews/'+uuid, request)
    }

    //create
    createReview(movieId: string, request:ReviewForm):Observable<any>{
        return this.http.post('/api/movies/'+movieId+'/reviews',request)
    }
}
