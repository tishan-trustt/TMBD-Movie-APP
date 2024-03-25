package com.example.tmdb.presentation.di.artist

import com.example.tmdb.domain.useCases.GetArtistUseCase
import com.example.tmdb.domain.useCases.UpdateArtistUseCase
import com.example.tmdb.presentation.Artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}