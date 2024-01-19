import {Movie} from "../../movie/model/movie";

export interface ReviewDetails{
    id: string;
    username: string;
    rating:string;
    comment:string;
    movie:Movie;
}
