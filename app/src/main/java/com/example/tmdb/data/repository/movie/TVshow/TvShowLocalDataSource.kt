package com.example.tmdb.data.repository.movie.TVshow

import com.example.tmdb.data.tv.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun updateTvShowtoDB(tvShow: List<TvShow>)
    suspend fun clearAll()
}