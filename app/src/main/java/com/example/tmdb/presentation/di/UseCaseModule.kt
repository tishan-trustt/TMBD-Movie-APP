package com.example.tmdb.presentation.di

import com.example.tmdb.domain.repository.ArtistRepository
import com.example.tmdb.domain.repository.MovieRepository
import com.example.tmdb.domain.repository.TvShowRepository
import com.example.tmdb.domain.useCases.GetArtistUseCase
import com.example.tmdb.domain.useCases.GetMoviesUseCase
import com.example.tmdb.domain.useCases.GetTvSHowsUseCase
import com.example.tmdb.domain.useCases.UpdateArtistUseCase
import com.example.tmdb.domain.useCases.UpdateMovieUseCase
import com.example.tmdb.domain.useCases.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun getMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun updateMovieUseCase(movieRepository: MovieRepository):UpdateMovieUseCase{
        return UpdateMovieUseCase(movieRepository)
    }




    @Provides
    fun getArtistUseCase(artistRepository: ArtistRepository):GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }
    @Provides
    fun updateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }





    @Provides
    fun getTvShowsUseCase(tvShowRepository: TvShowRepository):GetTvSHowsUseCase{
        return GetTvSHowsUseCase(tvShowRepository)
    }
    @Provides
    fun updateTvShowsUseCase(tvShowRepository: TvShowRepository):UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}