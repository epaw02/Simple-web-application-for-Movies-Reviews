import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from "@angular/forms";
import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { NavComponent } from './components/nav/nav.component';
import { MainComponent } from './components/main/main.component';
import { ReviewService } from './review/service/review.service';
import { MovieService } from "./movie/service/movie.service";

import { ReviewViewComponent } from './review/view/review-view/review-view.component';
import {ReviewEditComponent} from "./review/view/review-edit/review-edit.component";
import {ReviewAddComponent} from "./review/view/review-add/review-add.component";

import { MovieListComponent } from './movie/view/movie-list/movie-list.component';
import {MovieViewComponent} from "./movie/view/movie-view/movie-view.component";
import {MovieEditComponent} from "./movie/view/movie-edit/movie-edit.component";
import {MovieAddComponent} from "./movie/view/movie-add/movie-add.component";

@NgModule({
    declarations: [
        AppComponent,
        FooterComponent,
        HeaderComponent,
        NavComponent,
        MainComponent,
        MovieListComponent,
        MovieViewComponent,
        MovieEditComponent,
        MovieAddComponent,
        ReviewViewComponent,
        ReviewAddComponent,
        ReviewEditComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule
    ],
    providers: [
        ReviewService,
        MovieService
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule {

}
