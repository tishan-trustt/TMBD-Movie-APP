package com.example.tmdb.presentation.Artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.artist.Artist
import com.example.tmdb.domain.useCases.GetArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: GetArtistUseCase
):ViewModel() {

    fun getArtist() = liveData<List<Artist>?> {
        val artistList = getArtistUseCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData<List<Artist>?> {
        val artistList = updateArtistUseCase.execute()
        emit(artistList)
    }
}