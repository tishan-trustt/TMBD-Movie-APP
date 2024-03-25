package com.example.tmdb.data.repository.movie.Artist

import com.example.tmdb.data.artist.Artist
import com.example.tmdb.data.artist.ArtistList
import okhttp3.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists():retrofit2.Response<ArtistList>
}