package com.example.tmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdb.roomDB.ArtistDAO
import com.example.tmdb.roomDB.MovieDao
import com.example.tmdb.roomDB.TMDBDatabase
import com.example.tmdb.roomDB.TvshowsDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabse(context: Context):TMDBDatabase{
        return Room
            .databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDAO{
        return tmdbDatabase.artist()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase):TvshowsDAO{
        return tmdbDatabase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }
}