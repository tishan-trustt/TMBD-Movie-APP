package com.example.tmdb.data.repository.movie.Artist

import com.example.tmdb.data.artist.Artist
import com.example.tmdb.data.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB():List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}