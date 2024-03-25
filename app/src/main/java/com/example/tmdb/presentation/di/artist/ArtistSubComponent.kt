package com.example.tmdb.presentation.di.artist

import com.example.tmdb.presentation.Artist.ArtistActivity
import dagger.Subcomponent
@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}