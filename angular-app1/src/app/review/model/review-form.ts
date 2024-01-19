import {Movie} from "../../movie/model/movie";

export interface ReviewForm{
    username: string;
    rating:string;
    comment:string;
    movie:string;
}
