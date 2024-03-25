package com.example.tmdb.presentation.di.movie

import com.example.tmdb.presentation.Artist.ArtistActivity
import com.example.tmdb.presentation.Movie.MovieActivity
import dagger.Subcomponent
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}