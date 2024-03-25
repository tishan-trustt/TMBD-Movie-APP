package com.example.tmdb.presentation.di.core

import com.example.tmdb.data.api.TMDBservice
import com.example.tmdb.data.repository.movie.Artist.ArtistRemoteDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistRemoteDataSourceImpl
import com.example.tmdb.data.repository.movie.MovieRemoteDataSource
import com.example.tmdb.data.repository.movie.MovieRemoteDataSourceImpl
import com.example.tmdb.data.repository.movie.TVshow.TvShowRemoteDataSource
import com.example.tmdb.data.repository.movie.TVshow.TvShowRemoteDataSourceImpl
import com.example.tmdb.roomDB.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdBservice: TMDBservice):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdBservice,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdBservice: TMDBservice):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdBservice,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdBservice: TMDBservice):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdBservice,apiKey)
    }
}