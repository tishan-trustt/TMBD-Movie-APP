package com.example.tmdb.presentation.di.TvSHow

import com.example.tmdb.presentation.Movie.MovieActivity
import com.example.tmdb.presentation.Tvshow.TvShowActivity
import dagger.Subcomponent
@TvSHowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}