package com.example.tmdb.presentation.di

import com.example.tmdb.presentation.di.TvSHow.TvShowSubComponent
import com.example.tmdb.presentation.di.artist.ArtistSubComponent
import com.example.tmdb.presentation.di.movie.MovieSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}