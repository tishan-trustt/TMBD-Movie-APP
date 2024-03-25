package com.example.tmdb.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies :List<Movie>)

    @Query("Delete from popular_movie")
    suspend fun deleteAllMovies()

    @Query("Select * from popular_movie")
    suspend fun getMovies(): List<Movie>
}