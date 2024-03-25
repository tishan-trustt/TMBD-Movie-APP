package com.example.tmdb.presentation.di.TvSHow

import com.example.tmdb.domain.useCases.GetMoviesUseCase
import com.example.tmdb.domain.useCases.GetTvSHowsUseCase
import com.example.tmdb.domain.useCases.UpdateMovieUseCase
import com.example.tmdb.domain.useCases.UpdateTvShowsUseCase
import com.example.tmdb.presentation.Movie.MovieViewModelFactory
import com.example.tmdb.presentation.Tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvSHowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvSHowsUseCase: GetTvSHowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ):TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvSHowsUseCase, updateTvShowsUseCase)
    }
}