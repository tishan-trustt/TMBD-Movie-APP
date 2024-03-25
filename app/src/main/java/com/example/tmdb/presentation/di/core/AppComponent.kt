package com.example.tmdb.presentation.di.core

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
}