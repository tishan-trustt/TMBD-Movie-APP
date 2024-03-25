package com.example.tmdb.domain.useCases

import com.example.tmdb.data.artist.Artist
import com.example.tmdb.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}