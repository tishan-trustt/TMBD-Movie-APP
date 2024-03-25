package com.example.tmdb.presentation.di.core

import com.example.tmdb.data.repository.movie.Artist.ArtistLocalDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistLocalDataSourceImpl
import com.example.tmdb.data.repository.movie.MovieLocalDataSource
import com.example.tmdb.data.repository.movie.MovieLocalDataSourceImpl
import com.example.tmdb.data.repository.movie.TVshow.TvShowLocalDataSource
import com.example.tmdb.data.repository.movie.TVshow.TvShowLocalDataSourceImpl
import com.example.tmdb.roomDB.ArtistDAO
import com.example.tmdb.roomDB.MovieDao
import com.example.tmdb.roomDB.TvshowsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDAO: ArtistDAO):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDAO)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao:TvshowsDAO):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}