package com.example.tmdb.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.artist.Artist

@Dao
interface ArtistDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateArtist(artist:List<Artist>)

    @Query("Delete from popular_artist")
    suspend fun deleteAllArtist()

    @Query("Select * from popular_artist")
    suspend fun getArtist():List<Artist>
}