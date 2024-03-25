package com.example.tmdb.presentation.di

import com.example.tmdb.data.repository.movie.Artist.ArtistCachedDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistLocalDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistRemoteDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistRepositoryImpl
import com.example.tmdb.data.repository.movie.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.MovieRemoteDataSource
import com.example.tmdb.data.repository.movie.MovieRepositaryImpl
import com.example.tmdb.data.repository.movie.TVshow.TvShowCachedDataSource
import com.example.tmdb.data.repository.movie.TVshow.TvShowLocalDataSource
import com.example.tmdb.data.repository.movie.TVshow.TvShowRemoteDataSource
import com.example.tmdb.data.repository.movie.TVshow.TvshowRepositoryImpl
import com.example.tmdb.domain.repository.ArtistRepository
import com.example.tmdb.domain.repository.MovieRepository
import com.example.tmdb.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ):MovieRepository{
        return MovieRepositaryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }


    @Singleton
    @Provides
    fun provideTvSHowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCachedDataSource: TvShowCachedDataSource
    ):TvShowRepository{
        return TvshowRepositoryImpl(
            tvShowCachedDataSource ,
            tvShowLocalDataSource,
            tvShowRemoteDataSource

        )
    }



    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCachedDataSource: ArtistCachedDataSource
    ):ArtistRepository{
        return ArtistRepositoryImpl(
            artistCachedDataSource,
            artistLocalDataSource,
            artistRemoteDataSource
        )
    }
}