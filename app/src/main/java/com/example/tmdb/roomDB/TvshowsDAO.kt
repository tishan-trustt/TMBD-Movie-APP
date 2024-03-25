package com.example.tmdb.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.tv.TvShow
import com.example.tmdb.data.tv.TvShowList

@Dao
interface TvshowsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow:List<TvShow>)

    @Query("Delete from popular_tvShow")
    suspend fun deleteAllTvShows()

    @Query("Select * from popular_tvShow")
    suspend fun getTvShows():List<TvShow>
}