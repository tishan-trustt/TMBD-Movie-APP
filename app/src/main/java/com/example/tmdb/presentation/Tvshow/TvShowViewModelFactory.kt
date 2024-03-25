package com.example.tmdb.presentation.Tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.domain.useCases.GetTvSHowsUseCase
import com.example.tmdb.domain.useCases.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvSHowsUseCase: GetTvSHowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvSHowsUseCase,updateTvShowsUseCase) as T
    }
}