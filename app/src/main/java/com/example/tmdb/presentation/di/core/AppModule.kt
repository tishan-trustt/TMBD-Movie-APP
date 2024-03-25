package com.example.tmdb.presentation.di.core

import android.content.Context
import dagger.Module

@Module
class AppModule(private val context: Context) {
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}