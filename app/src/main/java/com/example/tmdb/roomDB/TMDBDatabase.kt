package com.example.tmdb.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdb.data.artist.Artist
import com.example.tmdb.data.movie.Movie
import com.example.tmdb.data.tv.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 1)
abstract class TMDBDatabase:RoomDatabase() {
    abstract fun movieDao():MovieDao
    abstract fun tvShowDao():TvshowsDAO
    abstract fun artist():ArtistDAO

}