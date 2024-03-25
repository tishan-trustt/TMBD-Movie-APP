package com.example.tmdb.presentation.di.core

import com.example.tmdb.data.repository.movie.Artist.ArtistCachedDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistCachedDataSourceImpl
import com.example.tmdb.data.repository.movie.MovieCacheDataSource
import com.example.tmdb.data.repository.movie.MovieCachedDataSourceImpl
import com.example.tmdb.data.repository.movie.TVshow.TvShowCachedDataSource
import com.example.tmdb.data.repository.movie.TVshow.TvShowCachedDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CachedDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCachedDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCachedDataSource{
        return ArtistCachedDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCachedDataSource{
        return TvShowCachedDataSourceImpl()
    }
}