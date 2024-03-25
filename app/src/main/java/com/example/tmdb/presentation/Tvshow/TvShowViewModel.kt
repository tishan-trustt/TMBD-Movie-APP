package com.example.tmdb.presentation.Tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.tv.TvShow
import com.example.tmdb.domain.useCases.GetTvSHowsUseCase
import com.example.tmdb.domain.useCases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvSHowsUseCase: GetTvSHowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModel() {


    fun getTvShows() = liveData<List<TvShow>?> {
        val tvShowList = getTvSHowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData<List<TvShow>?> {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }

}