package com.example.tmdb.domain.repository

import com.example.tmdb.data.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}