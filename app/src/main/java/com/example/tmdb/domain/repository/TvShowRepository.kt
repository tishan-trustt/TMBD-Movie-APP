package com.example.tmdb.domain.repository

import com.example.tmdb.data.tv.TvShow

interface TvShowRepository {

    suspend fun getTvSHows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}