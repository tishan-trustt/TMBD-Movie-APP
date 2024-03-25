package com.example.tmdb.presentation.di.core

import com.example.tmdb.presentation.di.TvSHow.TvShowSubComponent
import com.example.tmdb.presentation.di.artist.ArtistSubComponent
import com.example.tmdb.presentation.di.movie.MovieSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
NetModule::class,
DatabaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CachedDataModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}