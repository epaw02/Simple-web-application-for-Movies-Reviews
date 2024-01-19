import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {MovieListComponent} from "./movie/view/movie-list/movie-list.component";
import {ReviewViewComponent} from "./review/view/review-view/review-view.component";
import {MovieViewComponent} from "./movie/view/movie-view/movie-view.component";
import {MovieEditComponent} from "./movie/view/movie-edit/movie-edit.component";
import {MovieAddComponent} from "./movie/view/movie-add/movie-add.component";
import {ReviewAddComponent} from "./review/view/review-add/review-add.component";
import {ReviewEditComponent} from "./review/view/review-edit/review-edit.component";

const routes: Routes = [
  {
    component: MovieListComponent,
    path: "movies"
  },
  {
    component: MovieViewComponent,
    path: "movies/:uuid"
  },
  {
    component: MovieEditComponent,
    path: "movies/:uuid/edit"
  },
  {
    component: MovieAddComponent,
    path: "movie"
  },
  {
    component: ReviewViewComponent,
    path: "movies/:movieId/reviews/:uuid"
  },
  {
    component:ReviewEditComponent,
    path: "movies/:movieId/reviews/:uuid/edit"
  },
  {
    component:ReviewAddComponent,
    path: "movies/:movieId/reviews"
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
