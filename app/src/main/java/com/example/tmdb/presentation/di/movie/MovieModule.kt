package com.example.tmdb.presentation.di.movie

import com.example.tmdb.domain.useCases.GetArtistUseCase
import com.example.tmdb.domain.useCases.GetMoviesUseCase
import com.example.tmdb.domain.useCases.UpdateArtistUseCase
import com.example.tmdb.domain.useCases.UpdateMovieUseCase
import com.example.tmdb.presentation.Artist.ArtistViewModelFactory
import com.example.tmdb.presentation.Movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMovieUseCase)
    }
}