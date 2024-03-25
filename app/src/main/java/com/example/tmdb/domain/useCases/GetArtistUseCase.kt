package com.example.tmdb.domain.useCases

import com.example.tmdb.data.artist.Artist
import com.example.tmdb.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}