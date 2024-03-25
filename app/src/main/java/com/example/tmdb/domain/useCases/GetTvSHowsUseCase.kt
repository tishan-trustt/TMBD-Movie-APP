package com.example.tmdb.domain.useCases

import com.example.tmdb.domain.repository.MovieRepository
import com.example.tmdb.domain.repository.TvShowRepository
import com.example.tmdb.data.tv.TvShow

class GetTvSHowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvSHows()
}